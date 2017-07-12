package com.dwb.ruyou.tvhall.utils;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;

/**
 * Created by Slayer on 2017/6/7.
 */

public class DownloadFile {
    private ResponseBody responseBody;

    public DownloadFile(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }

    public  boolean downFile(File file){
        InputStream inputStream=null;
         OutputStream outputStream=null;

        try {
            inputStream=responseBody.byteStream();
            outputStream=new FileOutputStream(file);

            byte[] bytes=new byte[1024*4];
            long fileSize=responseBody.contentLength();
            long fileDownLoadSize=0;
            int read=0;
            try {
                while ((read=inputStream.read(bytes))>0){
                    fileDownLoadSize+=read;
                    outputStream.write(bytes,0,read);
                    Log.e("url", "file download: ---" + fileDownLoadSize + "--- of ---" + fileSize);

                }
                outputStream.flush();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;

    }
}
