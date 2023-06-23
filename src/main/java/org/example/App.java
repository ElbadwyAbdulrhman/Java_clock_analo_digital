package org.example;

import javax.swing.*;
import java.util.Date;

public class App {
    static CustomFrame f = null;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

        addClock();

    }

    static void addClock(){
        Thread th = new Thread( () ->{
            while (true){
                Date now = new Date();
                //String msg = now.toString();
                //System.out.println(msg);
                if (f != null){
                    f.setDate(now);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        th.start();
    }
    private static void createAndShowGUI() {
        f = new CustomFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(750,750);
        f.setVisible(true);
    }
}