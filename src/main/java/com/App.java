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
        renderFrame(100);
        kbd.nextLine();
        for (int i = 0; i < video.getLength()/width*heigth; i++) {
            renderFrame(i);
            try {
                Thread.sleep(33);
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
                    frameS+=" ";
                else
                    frameS+="*";
            }
            frameS+="\n";
        }
        System.out.print(frameS);
    }
}
