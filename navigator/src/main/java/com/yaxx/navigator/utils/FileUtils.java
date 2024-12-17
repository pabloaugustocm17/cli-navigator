package com.yaxx.navigator.utils;

import java.io.File;

public class FileUtils
{
    public static boolean isFileExist(String path){
        return new File(path).exists();
    }
}
