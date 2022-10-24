package com.song.controller;

import com.song.utils.ImgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/img")
public class ImgController extends HttpServlet {

    @RequestMapping("/identify")
    protected void identifyImg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//创建测试类对象
        ImgUtil imgUtil = new ImgUtil();
//调用创建图片方法
        BufferedImage bufferedImage = imgUtil.getBufferedImage();
//        获取字符串
        String info = imgUtil.getInfo();

//        传入字符串和图片
        imgUtil.drawFont(info,bufferedImage);


        resp.setContentType("image/jpeg");

        ImageIO.write(bufferedImage,"jpeg",resp.getOutputStream());



    }
}
