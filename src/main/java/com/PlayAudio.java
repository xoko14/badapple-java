package com;

import java.io.InputStream;

import javazoom.jl.player.advanced.AdvancedPlayer;

public class PlayAudio extends Thread {

    public void run(){
        try {
            InputStream file = getClass().getResourceAsStream("badapple.mp3");
            AdvancedPlayer player = new AdvancedPlayer(file);
            player.play();
        } catch (Exception e) {
        }
    }
  }
