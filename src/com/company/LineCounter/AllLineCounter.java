package com.company.LineCounter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AllLineCounter implements LineCounter {

    private FileInputStream fileInputStream;



    public AllLineCounter(Object fileInputStream) {

        this.fileInputStream = (FileInputStream) fileInputStream;
    }

    public int read(String word) {
        //read line by line and detects errors

        int counter = 0;

        try{


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            String strLn;

            while ((strLn = bufferedReader.readLine()) != null)   {

//                System.out.println (strLn);
                String firstWord = getFirstWord(strLn);
//                System.out.println(firstWord);

                if (word.equals(firstWord)){
                    counter ++;
                }
            }
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return counter;
    }

    private String getFirstWord(String text) {

        int index = text.indexOf(' ');

        if (index > -1) { // Check if there is more than one word.

            return text.substring(0, index).trim(); // Extract first word.

        } else {

            return text; // Text is the first word itself.
        }
    }
}
