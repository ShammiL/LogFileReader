package com.company.FileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LogAppFileReader implements AppFileReader {

    private String path;

    public LogAppFileReader(String path) {

        this.path = path;
    }

    @Override
    public Object read() {

        Object logFileObj = null;
        try {
//            logFileObj = new FileReader(path);
            logFileObj = new FileInputStream(path); // create .log file to the path


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return logFileObj;
    }
}
