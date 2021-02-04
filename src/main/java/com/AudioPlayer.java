package com;

import java.io.FileInputStream;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.File;

public class AudioPlayer extends Thread {

    File file;

    AudioPlayer(File fileIn){
        file = fileIn;
    }

    public void play(){
        try {
            FileInputStream in = new FileInputStream(file);
            AdvancedPlayer player = new AdvancedPlayer(in);
            player.play();
        } catch (Exception e) {
        }
    }
  }
