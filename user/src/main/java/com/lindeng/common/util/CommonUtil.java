package com.lindeng.common.util;

public class CommonUtil {

    public static int StringToInt(String str){
        try{
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            return 0;
        }
    }
}
