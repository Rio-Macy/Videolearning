package com.duyi.video.controller;

import cn.hutool.core.util.RandomUtil;
import com.duyi.video.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.Servlet;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author sujuntao
 */
@Controller
public class VcodeController {

    /**
     * 数字二维码
      */
    static final char[] CODE_ARRAY = {'0', '1', '2', '3', '4', '5', '6', '7','8', '9'};
    /**
     * 生成随机数的次数
     */
    static final int RANDOM_NUMBER = 4;
    /**
     * 生成验证码,验证码保存到session
     */
    @RequestMapping("/vcode")
    public void vcode(HttpServletResponse response, HttpSession httpSession) {

        BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.createGraphics();
        graphics.setColor(Color.white);
        graphics.drawRect(0, 0, 80, 30);
        Font font = new Font("宋体", Font.BOLD, 25);
        graphics.setFont(font);

        // 存放验证码
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < RANDOM_NUMBER; i++) {

            int randomNumber = RandomUtil.randomInt(10);
            char vc = CODE_ARRAY[randomNumber];

            graphics.setColor(new Color(
                    RandomUtil.randomInt(255),
                    RandomUtil.randomInt(255),
                    RandomUtil.randomInt(255)
                    ));
            // 验证码图片
            graphics.drawString("" + vc, (i + 1) * 15, 25);

            stringBuilder.append(vc);
        }

        // 将验证码保存到Session上
        httpSession.setAttribute(Constants.SESSION_VCODE, stringBuilder.toString());

        response.setContentType("image/jpeg");
        //设置不缓存
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        //输出图片

        ServletOutputStream outputStream = null;

        try {

            outputStream = response.getOutputStream();
            ImageIO.write(image, "jpeg", outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
