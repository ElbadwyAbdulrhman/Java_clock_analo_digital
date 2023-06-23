package org.example;

import javax.swing.*;
import java.awt.*;

public class DigitalClock extends JFrame {
    private int hours;
    private int minutes;
    private int seconds;

    private int padding = 20;

    public DigitalClock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

        setTitle("Digital Clock");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Timer timer = new Timer(1000, e -> {
            updateTime();
            repaint();
        });
        timer.start();
    }

    private void updateTime() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            minutes++;
            if (minutes >= 60) {
                minutes = 0;
                hours++;
                if (hours >= 24) {
                    hours = 0;
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int width = 450;
        int height = 450;

        int digitWidth = (width - 2 * padding) / 8;
        int digitHeight = height - 2 * padding;

        int xPos = padding;
        int yPos = 300;

        drawDigit(g, hours / 10, xPos, yPos, digitWidth, digitHeight);
        xPos += digitWidth + padding;
        drawDigit(g, hours % 10, xPos, yPos, digitWidth, digitHeight);
        xPos += digitWidth + padding;
        drawColon(g, xPos, yPos + digitHeight / 2 - 15, 30, 30);
        xPos += 40;
        drawDigit(g, minutes / 10, xPos, yPos, digitWidth, digitHeight);
        xPos += digitWidth + padding;
        drawDigit(g, minutes % 10, xPos, yPos, digitWidth, digitHeight);
        xPos += digitWidth + padding;
        drawColon(g, xPos, yPos + digitHeight / 2 - 15, 30, 30);
        xPos += 40;
        drawDigit(g, seconds / 10, xPos, yPos, digitWidth, digitHeight);
        xPos += digitWidth + padding;
        drawDigit(g, seconds % 10, xPos, yPos, digitWidth, digitHeight);
    }

    private void drawDigit(Graphics g, int digit, int xPos, int yPos, int digitWidth, int digitHeight) {
        int lineThickness = 6;

        switch (digit) {
            case 0:
                drawLine(g, xPos, yPos, xPos + digitWidth, yPos, lineThickness);
                drawLine(g, xPos, yPos, xPos, yPos + digitHeight, lineThickness);
                drawLine(g, xPos + digitWidth, yPos, xPos + digitWidth, yPos + digitHeight, lineThickness);
                drawLine(g, xPos, yPos + digitHeight, xPos + digitWidth, yPos + digitHeight, lineThickness);
                break;
            case 1:
                drawLine(g, xPos + digitWidth, yPos, xPos + digitWidth, yPos + digitHeight, lineThickness);
                break;
            case 2:
                drawLine(g, xPos, yPos, xPos + digitWidth, yPos, lineThickness);
                drawLine(g, xPos + digitWidth, yPos, xPos + digitWidth, yPos + digitHeight / 2, lineThickness);
                drawLine(g, xPos, yPos + digitHeight / 2, xPos + digitWidth, yPos + digitHeight / 2, lineThickness);
                drawLine(g, xPos, yPos + digitHeight / 2, xPos, yPos + digitHeight, lineThickness);
                drawLine(g, xPos, yPos + digitHeight, xPos + digitWidth, yPos + digitHeight, lineThickness);
                break;
            case 3:
                drawLine(g, xPos, yPos, xPos + digitWidth, yPos, lineThickness);
                drawLine(g, xPos + digitWidth, yPos, xPos + digitWidth, yPos + digitHeight, lineThickness);
                drawLine(g, xPos, yPos + digitHeight / 2, xPos + digitWidth, yPos + digitHeight / 2, lineThickness);
                drawLine(g, xPos, yPos + digitHeight, xPos + digitWidth, yPos + digitHeight, lineThickness);
                break;
            case 4:
                drawLine(g, xPos, yPos, xPos, yPos + digitHeight / 2, lineThickness);
                drawLine(g, xPos + digitWidth, yPos, xPos + digitWidth, yPos + digitHeight, lineThickness);
                drawLine(g, xPos, yPos + digitHeight / 2, xPos + digitWidth, yPos + digitHeight / 2, lineThickness);
                break;
            case 5:
                drawLine(g, xPos, yPos, xPos + digitWidth, yPos, lineThickness);
                drawLine(g, xPos, yPos, xPos, yPos + digitHeight / 2, lineThickness);
                drawLine(g, xPos, yPos + digitHeight / 2, xPos + digitWidth, yPos + digitHeight / 2, lineThickness);
                drawLine(g, xPos + digitWidth, yPos + digitHeight / 2, xPos + digitWidth, yPos + digitHeight, lineThickness);
                drawLine(g, xPos, yPos + digitHeight, xPos + digitWidth, yPos + digitHeight, lineThickness);
                break;
            case 6:
                drawLine(g, xPos, yPos, xPos + digitWidth, yPos, lineThickness);
                drawLine(g, xPos, yPos, xPos, yPos + digitHeight, lineThickness);
                drawLine(g, xPos, yPos + digitHeight / 2, xPos + digitWidth, yPos + digitHeight / 2, lineThickness);
                drawLine(g, xPos, yPos + digitHeight / 2, xPos, yPos + digitHeight, lineThickness);
                drawLine(g, xPos, yPos + digitHeight, xPos + digitWidth, yPos + digitHeight, lineThickness);
                drawLine(g, xPos + digitWidth, yPos + digitHeight / 2, xPos + digitWidth, yPos + digitHeight, lineThickness);
                break;

            case 7:
                drawLine(g, xPos, yPos, xPos + digitWidth, yPos, lineThickness);
                drawLine(g, xPos + digitWidth, yPos, xPos + digitWidth, yPos + digitHeight, lineThickness);
                break;
            case 8:
                drawLine(g, xPos, yPos, xPos + digitWidth, yPos, lineThickness);
                drawLine(g, xPos, yPos, xPos, yPos + digitHeight / 2, lineThickness);
                drawLine(g, xPos + digitWidth, yPos, xPos + digitWidth, yPos + digitHeight / 2, lineThickness);
                drawLine(g, xPos, yPos + digitHeight / 2, xPos + digitWidth, yPos + digitHeight / 2, lineThickness);
                drawLine(g, xPos, yPos + digitHeight / 2, xPos, yPos + digitHeight, lineThickness);
                drawLine(g, xPos, yPos + digitHeight, xPos + digitWidth, yPos + digitHeight, lineThickness);
                drawLine(g, xPos + digitWidth, yPos + digitHeight / 2, xPos + digitWidth, yPos + digitHeight, lineThickness);
                break;
            case 9:
                drawLine(g, xPos, yPos, xPos + digitWidth, yPos, lineThickness);
                drawLine(g, xPos, yPos, xPos, yPos + digitHeight / 2, lineThickness);
                drawLine(g, xPos + digitWidth, yPos, xPos + digitWidth, yPos + digitHeight / 2, lineThickness);
                drawLine(g, xPos, yPos + digitHeight / 2, xPos + digitWidth, yPos + digitHeight / 2, lineThickness);
                //drawLine(g, xPos, yPos + digitHeight / 2, xPos, yPos + digitHeight, lineThickness);
                drawLine(g, xPos, yPos + digitHeight, xPos + digitWidth, yPos + digitHeight, lineThickness);
                drawLine(g, xPos + digitWidth, yPos + digitHeight / 2, xPos + digitWidth, yPos + digitHeight, lineThickness);
                break;

        }
    }

    private void drawColon(Graphics g, int xPos, int yPos, int width, int height) {
        int lineThickness = 10;

        drawLine(g, xPos, yPos, xPos, yPos + height, lineThickness);
        drawLine(g, xPos + width, yPos, xPos + width, yPos + height, lineThickness);
    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2, int thickness) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawLine(x1, y1, x2, y2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DigitalClock clock = new DigitalClock(0, 0, 0); // Set initial time here (hours, minutes, seconds)
            clock.setVisible(true);
        });
    }
}

