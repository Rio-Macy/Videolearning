package com.duyi.video.dto;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.duyi.video.entity.User;
import com.duyi.video.util.Constants;
import com.duyi.video.util.VideoUtil;

import javax.servlet.http.HttpServletRequest;

/**
 *  UserToken的属性的作用
 * @author sujuntao
 */
public class UserToken {

    // c （token）--> web
    // 如何验证token是否合法？
    // 1 email
    // 2 date
    // 如何token合法，登录，（email用户信息）

    // 服务器要保存token对应用户的信息UserToken

    private User user;
    private String nowString;
    private String userAgent;
    private String ip;
    private String token;

    public UserToken(HttpServletRequest request, User user) {

        this.userAgent = request.getHeader("User-Agent");
        this.ip = VideoUtil.getIPAddress(request);
        this.nowString = DateUtil.now();
        this.user = user;
        buildToken();
    }

    private void buildToken() {

        StringBuilder builder = new StringBuilder();

        builder.append(nowString);
        builder.append(user.getEmail());
        builder.append(userAgent);
        builder.append(ip);
        builder.append(Constants.SERVER_SEC_KEY);

        String token = DigestUtil.md5Hex(builder.toString());

        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public String getNowString() {
        return nowString;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getIp() {
        return ip;
    }

    public String getToken() {
        return token;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNowString(String nowString) {
        this.nowString = nowString;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
