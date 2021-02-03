package com;

import java.io.File;
import java.util.Scanner;

public class App {
    private static File videoPath = new File("./video/frames.bin.gz");
    private static GZipBytes video = new GZipBytes(videoPath);
    private static Scanner kbd = new Scanner(System.in);
    private static final int width = 96;
    private static final int heigth = 64;

    public static void main(String[] args) {
        System.out.print("CONSOLE CALIBRATION\n"+
                         "Please, adjust your console settings to fit the picture.\n"+
                         "Press intro to visualize the picture. After that, press intro again to start.\n");  
        kbd.nextLine();
        renderFrame(410);
        kbd.nextLine();
        for (int i = 0; i < video.getLength()/(width*heigth); i++) {
            renderFrame(i);
            try {
                Thread.sleep(1000/60);//fps
            } catch (InterruptedException e) {
            }
        }
    }

    private static void renderFrame(int frame) {
        int startbyte = frame * width * heigth;
        String frameS = "";
        for (int i = 0; i < heigth * width; i += width) {
            for (int j = startbyte + i; j < startbyte + width + i; j++) {
                if (video.getByte(j) == 0)
                    frameS+=" ";//black
                else
                    frameS+="\u2588";//white (full block char)
            }
            frameS+="\n";
        }
        System.out.print(frameS);
    }
}
