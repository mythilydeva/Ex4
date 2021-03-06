package com.example.sdcard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.os.Environment;
import android.util.Log;


public class FileOperations {
    public FileOperations() {

       }

    public Boolean write(String fname, String fcontent){
           try {

        	   File file= new File(Environment.getExternalStorageDirectory() + "D:/workspace_Android/SdCard/my.txt");
               // If file does not exists, then create it
               if (!file.exists()) {
                   file.createNewFile();
               }

               FileWriter fw = new FileWriter(file.getAbsoluteFile());
               BufferedWriter bw = new BufferedWriter(fw);
               bw.write(fcontent);
               bw.close();

               Log.d("Suceess","Sucess");
               return true;

           } catch (IOException e) {
               e.printStackTrace();
               return false;
           }

    }

    public String read(String fname){

        BufferedReader br = null;
        String response = null;

           try {

               StringBuffer output = new StringBuffer();
               File file= new File(Environment.getExternalStorageDirectory() + "");
               //String fpath = "D:/workspace_Android/SdCard/my.txt";
        	   
              // File file = new File(fpath);
               br = new BufferedReader(new FileReader(file));
               String line = "";
               while ((line = br.readLine()) != null) {
                   output.append(line +"n");
               }
               response = output.toString();

           } catch (IOException e) {
               e.printStackTrace();
               return null;

           }
           return response;

    }
}
