package com.duyi.video.interceptor;

import cn.hutool.core.date.DateUtil;
import com.duyi.video.dto.UserToken;
import com.duyi.video.entity.User;
import com.duyi.video.util.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author sujuntao
 */
@Component
public class AutoLoginInterceptor implements HandlerInterceptor {

    public boolean perHandle(HttpServletRequest request, HttpServletResponse response) {

        // 获取cookie , 如果合法，未登陆，直接登陆，继续请求
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {

            return true;
        }

        for (Cookie cookie: cookies) {

            String cname = cookie.getName();

            System.out.println("cname:" + cname);
            if (Constants.COOKIE_NAME_LOGIN_TOKEN.equalsIgnoreCase(cname)) {

                // 拿到cookie的值
                String cToken = cookie.getValue();

                // 判断cookie的合法性
                // 根据用户的token获取userToken,如果拿不到，直接返回
                // 如果拿到，判断token值 (合法， 是否国企)
                ServletContext servletContext = request.getServletContext();

                // servletContext -- 所以人的登陆信息
                HashMap<String, UserToken> userTokenHashMap = (HashMap<String, UserToken>) servletContext.getAttribute(Constants.CONTEXT_TOKEN_USER);

                if (userTokenHashMap == null) {

                    return true;
                }

                Set<Map.Entry<String, UserToken>> entrySet = userTokenHashMap.entrySet();

                if (entrySet == null || entrySet.size() == 0) {
                    
                    return true;
                }

                for (Map.Entry<String, UserToken> entry: entrySet) {

                    String key = entry.getKey();

                    if (key.equalsIgnoreCase(cToken)) {

                        // 服务器由用户的信息
                        // 验证是否正确或者过期
                        UserToken userToken = entry.getValue();
                        // 判断是否过期
                        String loginNowString = userToken.getNowString();
                        // 用户登陆的时间戳
                        long nowDate = DateUtil.parseDateTime(loginNowString).getTime();
                        long nowTime = System.currentTimeMillis();

                        long timeout = nowTime - nowDate;

                        if (timeout > 60 * 60 * 24 * 1000) {

                            return true;
                        }

                        // 添加自动登陆
                        HttpSession session = request.getSession(true);
                        // 保存session
                        session.setAttribute(Constants.SESSION_LOGINUSER, userToken.getUser());

                        break;
                    }
                }
                break;
            }
        }

        // 其他情况，直接请求
        return true;
    }
}
