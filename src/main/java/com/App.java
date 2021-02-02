package com;

import java.io.File;

public class App 
{
    public static void main( String[] args )
    {
        GZipBytes video = new GZipBytes(new File("./video/frames.bin.gz"));
        System.out.println( "Hello World!" );
    }
}
