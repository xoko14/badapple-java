package com;

import java.io.IOException;

import java.util.zip.GZIPInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class GZipBytes {
    private byte[] bytes;

    GZipBytes(InputStream file) {
        try {
            //compBytes = FileUtils.readFileToByteArray(file);
            //ByteArrayInputStream bin = new ByteArrayInputStream(compBytes);
            GZIPInputStream gzipper = new GZIPInputStream(file);

            byte[] buffer = new byte[1024];
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            int len;
            while ((len = gzipper.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }

            gzipper.close();
            out.close();
            bytes = out.toByteArray();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public byte getByte(int byteNum){
        return bytes[byteNum];
    }

    public int getLength(){
        return bytes.length;
    }
}
