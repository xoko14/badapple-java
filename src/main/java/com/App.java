package com;

import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

public class App {
    private static InputStream videoPath = App.class.getResourceAsStream("frames.bin.gz");
    private static GZipBytes video = new GZipBytes(videoPath);
    private static Scanner kbd = new Scanner(System.in);
    private static final int width = 96;
    private static final int heigth = 64;
    private static final int fps = 30;

    public static void main(String[] args) {
        long time1;
        long time2;
        System.out.print("CONSOLE CALIBRATION\n" + "Please, adjust your console settings to fit the picture.\n"
                + "Press intro to visualize the picture. After that, press intro again to start.\n");
        kbd.nextLine();
        renderFrame(410);
        kbd.nextLine();

        PlayAudio play = new PlayAudio();
        play.start();

        for (int i = 0; i < video.getLength() / (width * heigth); i++) {
            time1 = System.nanoTime();
            renderFrame(i);
            time2 = System.nanoTime();
            LockSupport.parkNanos(1000000000 / fps - (time2 - time1)); // fps (duration of frame in nanosec - time taken to render frame)
        }
    }

    private static void renderFrame(int frame) {
        int startbyte = frame * width * heigth;
        String frameS = "";
        for (int i = 0; i < heigth * width; i += width) {
            for (int j = startbyte + i; j < startbyte + width + i; j++) {
                if (video.getByte(j) == 0)
                    frameS += " ";// black
                else
                    frameS += "\u2588";// white (full block char)
            }
            frameS += "\n";
        }
        System.out.print(frameS);
    }

}
