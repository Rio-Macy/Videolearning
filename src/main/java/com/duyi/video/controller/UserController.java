package com.duyi.video.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.duyi.video.dto.ResponseResult;
import com.duyi.video.dto.UserToken;
import com.duyi.video.entity.User;
import com.duyi.video.exception.UserException;
import com.duyi.video.service.UserService;
import com.duyi.video.service.impl.MailSenderService;
import com.duyi.video.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.io.File;
import java.util.HashMap;

/**
 * 没有初始化的情况下不出错， 不能
 * 表单的财富提交
 *
 * @author sujuntao
 */
@Controller
public class UserController {

    static final int passLength = 6;
    static final String autoLoginNun = "1";

    @Autowired
    UserService userService;

    /**
     *  用户注册功能：需要邮箱（email），密码（password），验证码（vcode），session(保存后端生成的验证码)
     *   第一步：需要验证邮箱的格式是否正确，使用hutool工具类中的ReUtil.isMatch("正则表达式", "邮箱")方法，
     *   如果不符合正则结果，则抛出异常
     *   第二步：验证用户不能密码不能为空，用户密码长度不能小于6位数，如果不符合条件则抛出异常
     *   第三步：获取次此注册请求的验证码(SESSION_VCODE), session.getAttribute(Constants.SESSION_VCODE)
     *   判断验证码(SESSION_VCODE)是否为空,若为NULL则抛出异常
     *   第四步：将验证码（vcode）和验证码(SESSION_VCODE)进行比较，内容是否一致，否者抛出异常。
     *   第五步： 到此则证明数据正确无误，将邮箱（email）,密码（password）,装入User对象，放入regist(User user)进行注册,
     *   regist(User user)返回一个User对象，对结果进行判断是否为空，如果是则抛出异常
     *   第六步： 将注册成功的user保存到session, session.setAttribute(Constants.SESSION_LOGINUSER, user)
     *   最后重定向会首页： redirect:/;
     *
     * @param email
     * @param password
     * @param vcode
     * @param session
     * @return
     * @throws UserException
     */
    @RequestMapping("/regist")
    public String regist(String email, String password, String vcode,
                         HttpSession session) throws UserException {

        // 注册失败，返回错误页面
        if (!ReUtil.isMatch("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", email)) {
            throw new UserException("邮箱格式不正确");
        }
        if (StrUtil.isEmpty(password) || password.length() < 6) {
            throw new UserException("密码格式不正确");
        }
        String serverVcode = (String) session.getAttribute(Constants.SESSION_VCODE);
        if (StrUtil.isEmpty(serverVcode)) {
            throw new UserException("请求错误");
        }
        if (!serverVcode.equalsIgnoreCase(vcode)) {
            throw new UserException("验证码不正确");
        }
        // 提交数据到数据注册
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        User dbUser = userService.regist(user);

        if (dbUser == null) {

            throw new UserException("数据库错误");
        }

        // session保存用户信息，登录状态
        session.setAttribute(Constants.SESSION_LOGINUSER, user);
        // 注册成功，变成登录状态，重定向首页
        return "redirect:/";
    }

    @RequestMapping("/checkEmail")
    @ResponseBody
    public ResponseResult checkEmail(String email) {

        ResponseResult responseResult = new ResponseResult();

        User user = userService.checkEmail(email);

        if (user == null) {

            responseResult.setCode(1);
            responseResult.setMessage("OK!");

            return responseResult;
        }

        responseResult.setCode(-1);
        responseResult.setMessage("fail~");

        return responseResult;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session,
                         HttpServletRequest request,
                         HttpServletResponse response) {

        // 删除用户的session
        session.removeAttribute(Constants.SESSION_LOGINUSER);

        ServletContext servletContext = request.getServletContext();

        Cookie cookie = new Cookie(Constants.COOKIE_NAME_LOGIN_TOKEN, "invalid");
        cookie.setMaxAge(1);
        cookie.setPath("/");

        response.addCookie(cookie);

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            for (Cookie ck: cookies) {

                String cname = ck.getName();
                if (Constants.COOKIE_NAME_LOGIN_TOKEN.equalsIgnoreCase(cname)) {

                    HashMap<String, UserToken> userTokenHashMap = (HashMap<String, UserToken>) servletContext.getAttribute(Constants.CONTEXT_TOKEN_USER);
                    // 删除用户自动登陆的token
                    userTokenHashMap.remove(ck.getValue());
                }
            }

        }

        // 删除用户session
        return "redirect:/";
    }

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult checkLogin(String email, String password) {

        ResponseResult responseResult = new ResponseResult();

        User user = userService.login(email, password);
        if (user == null) {

            responseResult.setCode(0);
        }else {

            responseResult.setCode(1);
        }

        return responseResult;
    }
    @RequestMapping("/login")
    public String login(String email, String password, String autoLogin,
                        HttpSession session,
                        HttpServletRequest request,
                        HttpServletResponse response) throws UserException {

        if (!ReUtil.isMatch("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", email)) {

            throw new UserException("邮箱格式有问题！");
        }

        if (StrUtil.isEmpty(password) || password.length() < passLength) {

            throw new UserException("用户密码格式不对");
        }

        User user = userService.login(email, password);

        if (user == null) {

            throw new UserException("数据库错误！");
        }

        session.setAttribute(Constants.SESSION_LOGINUSER, user);

        if (!StrUtil.isEmpty(autoLogin) && autoLoginNun.equalsIgnoreCase(autoLogin)) {

            // token 生成规则
            //时间， 用户信息， IP, User-Agent
            UserToken userToken = new UserToken(request, user);

            String token = userToken.getToken();

            // 写入cookie, 返回客户端
            Cookie cookie = new Cookie(Constants.COOKIE_NAME_LOGIN_TOKEN, token);
            // 设置cookie的参数
            cookie.setPath("/");
            // 单位秒 24小时
            cookie.setMaxAge(60 * 60 * 24);

            // cookie放入响应，返回客户端
            response.addCookie(cookie);

            // 保存token--user信息到application (Redis最好)
            ServletContext app = request.getServletContext();

            // application --> n个用户登陆
            HashMap<String, UserToken> userTokenHashMap = new HashMap<>();

            // 保存所有用户登陆的key(token) -- value(userToken)
            userTokenHashMap.put(token, userToken);

            // 把map存入application
            app.setAttribute(Constants.CONTEXT_TOKEN_USER, userTokenHashMap);

        }

        return "redirect:/";
    }

    @RequestMapping("/findPwd")
    @ResponseBody
    public String findPwd(String email) throws Exception {

        // 发送email
        // 拼接URL (重置密码的请求)
        String resetUrl = "http://localhost:8888/resetPwdPage";

        // 生成找回密码的请求
        // 不能伪造，过期不能修改
        StringBuilder builder = new StringBuilder();

        builder.append(email);

        String nowStr = System.currentTimeMillis() + "";

        builder.append(nowStr);
        builder.append(Constants.SERVER_SEC_KEY);

        String resPwdToken = DigestUtil.md5Hex(builder.toString());

        // 第一段 凭着 第二段 时间 第三段 email
        String param = resPwdToken + "_" + nowStr + "_" + email;

        // base64
        String urlParam = Base64.encode(param);

        // 通过邮箱修改密码的新链接： "http://localhost:8888/resetPwdPage" + ?p=
        String url = resetUrl + "?p=" + urlParam;

        // email, url
        MailSenderService mailSenderService = new MailSenderService();
        mailSenderService.send(email, url);

        return "email send";
    }

    @RequestMapping("/resetPwdPage")
    public String resetPwdPage(String p, Model model) throws UserException {

        // 判断凭证是否合法  1.合法
        // 判断时间是否超时  2.超时

        String urlParam = Base64.decodeStr(p);
        String[] values = urlParam.split("_");

        String token = values[0];
        String time = values[1];
        String email = values[2];

        StringBuilder builder = new StringBuilder();
        builder.append(email);
        builder.append(time);
        builder.append(Constants.SERVER_SEC_KEY);

        String resetPwdToken = DigestUtil.md5Hex(builder.toString());

        if (!resetPwdToken.equals(token)) {

            throw new UserException("连接不合法");
        }

        Long now = System.currentTimeMillis();

        if ((now - Long.parseLong(time)) > (1000 * 300)) {

            throw new UserException("连接已经超时");
        }

        model.addAttribute("p", p);

        return "resetPwd";
    }

    @RequestMapping("/resetPwd")
    @ResponseBody
    public String resetPwd(String password, String p) throws UserException {


        // 判断凭证
        // 1是否合法
        // 2是否超时

        String urlParam = Base64.decodeStr(p);

        String[] values = urlParam.split("_");
        String token = values[0];
        String time = values[1];
        String email = values[2];

        StringBuilder builder = new StringBuilder();
        builder.append(email);
        builder.append(time);
        builder.append(Constants.SERVER_SEC_KEY);

        String resetPwdToken = DigestUtil.md5Hex(builder.toString());

        if (!resetPwdToken.equals(token)) {

            throw new UserException("连接不合法");
        }

        Long now = System.currentTimeMillis();

        if (now - Long.parseLong((time)) > (1000 * 300)) {

            throw new UserException("连接已经超时");
        }

        boolean suc = userService.resetPwd(email, password);

        return "reset password success";

    }

}
