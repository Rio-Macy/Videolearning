package com.duyi.video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @author sujuntao
 */
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    // 密码找回
    // 指定用户email 根据email找回
    // 生成token的参数
    // email + 时间(时间戳) + 服务器秘钥（123！@#随机生成） md5 = token
    // url?token=xxx&email=xx&t=xxx
    // email, subject, url

    public void send(String email, String url) throws Exception {

        String subject = "重置密码";
        // 收件人
        String address = email;
        System.out.println("address:" + address);
        // 邮件内容（html格式）
        String text = "<h1>http://localhost:8888/</h1>";
        text += "<a href="+ url + ">点击修改密码</a>";
        // 发件人
        String from = "1423957197@qq.com";

        // QQ发送邮件配置
        Properties prop = new Properties();
        prop.setProperty("mail.smtp.host", "smtp.126.com");
        prop.setProperty("mail.smtp.auth", "true"); //开启认证
        prop.setProperty("mail.debug", "true");//启用调试
        prop.setProperty("mail.smtp.timeout", "1000");//设置链接超时
        prop.setProperty("mail.smtp.port", Integer.toString(465));//设置端口
        prop.setProperty("mail.smtp.socketFactory.port", Integer.toString(465));//设置ssl端口
        prop.setProperty("mail.smtp.socketFactory.fallback", "false");
        prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 1 邮件的账户
                // 2 邮件的授权码
                return new PasswordAuthentication("1423957197@qq.com", "jimamcsjsczfjgig");
            }
        });

        //通过会话,得到一个邮件,用于发送
        Message mMessageHelper = new MimeMessage(session);
        mMessageHelper.setFrom(new InternetAddress(from));
        //设置收件人,to为收件人,cc为抄送,bcc为密送
        mMessageHelper.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
        mMessageHelper.setSubject(subject);

        Multipart mainPart = new MimeMultipart();
        // 创建一个包含HTML内容的MimeBodyPart
        BodyPart html = new MimeBodyPart();
        // 设置HTML内容
        html.setContent(text, "text/html; charset=utf-8");
        mainPart.addBodyPart(html);
        // 将MiniMultipart对象设置为邮件内容
        mMessageHelper.setContent(mainPart);

        Transport.send(mMessageHelper);
    }
}
