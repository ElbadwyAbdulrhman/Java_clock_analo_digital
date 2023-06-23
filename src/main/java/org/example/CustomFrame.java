package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class CustomFrame extends JFrame {
    Date date;
    private String msg = "";
    public void paint(Graphics g) {
        super.paint(g);
        int w = this.getWidth();
        int h = this.getHeight();
        int centerW = w / 2;
        int centerH = h / 2;
        int radius = 400;
        int seconds = this.date.getSeconds();
        int minutes = this.date.getMinutes();
        int hours = this.date.getHours();

        if (w < radius) {
            radius = w;
        } else if (h < radius) {
            radius = h;
        }

        int originW = centerW - radius / 2;
        int originH = centerH - radius / 2;
        double secondsAngle = (2 * Math.PI / 60) * seconds - Math.PI / 2;
        double minutesAngle = (2 * Math.PI / 60) * minutes - Math.PI / 2;
        double hoursAngle = (2 * Math.PI / 12) * hours - Math.PI / 2;

        int xSec = centerW + (int) (radius / 2 * Math.cos(secondsAngle));
        int ySec = centerH + (int) (radius / 2 * Math.sin(secondsAngle));

        int xMin = centerW + (int) (radius / 2.2 * Math.cos(minutesAngle));
        int yMin = centerH + (int) (radius / 2.2 * Math.sin(minutesAngle));

        int xHour = centerW + (int) (radius / 2.5 * Math.cos(hoursAngle));
        int yHour = centerH + (int) (radius / 2.5 * Math.sin(hoursAngle));

        g.drawOval(originW, originH, radius, radius);
        g.drawLine(centerW, centerH, xSec, ySec);
        g.drawLine(centerW, centerH, xMin, yMin);
        g.drawLine(centerW, centerH, xHour, yHour);

        g.drawString("Seconds: " + seconds, 200, 80);
    }


    public String getMsg() {
        return msg;

    }

    public void setDate(Date date) {
        this.msg = date.toString();
        this.date = date;
        SwingUtilities.invokeLater(() -> {
            this.repaint();
        });
    }
}