package com.song.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImgUtil {
    private Random random = new Random();

    private Graphics2D graphics;

    //在内存中创建一张图片
    public BufferedImage getBufferedImage() {
        return new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
    }

    //操作图片
    public void drawFont(String data, BufferedImage image) {
        graphics = (Graphics2D) image.getGraphics();
        graphics.setBackground(Color.WHITE);
        graphics.fillRect(0, 0, 100, 30);
        int[] size = {18, 20, 22, 24};
        for (int i = 0; i < 4; i++) {
            graphics.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            graphics.setFont(new Font(null, Font.ITALIC, size[random.nextInt(size.length)]));
            graphics.drawString(data.substring(i, i + 1), 10 + i * 20, 22);

        }
        drawLine();
    }

    //获取随机字符串
    public String getInfo() {
        //除去容易混淆的字符
        char[] chars = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuffer buffer = new StringBuffer();
        //随机拿到4个字符
        for (int i = 0; i < 4; i++) {
            buffer.append(chars[random.nextInt(chars.length)]);
        }
        return buffer.toString();
    }

    //画干扰线
    private void drawLine() {
        //随机画4条线
        for (int i = 0; i < 4; i++) {
            int x1 = random.nextInt(100);
            int x2 = random.nextInt(100);
            int y1 = random.nextInt(30);
            int y2 = random.nextInt(30);
            //设置笔的粗细
            graphics.setStroke(new BasicStroke(1.0f));
            //设置颜色
            graphics.setColor(Color.lightGray);
            //画线
            graphics.drawLine(x1, y1, x2, y2);
        }
    }
}
