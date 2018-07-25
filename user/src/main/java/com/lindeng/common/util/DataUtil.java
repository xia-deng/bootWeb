package com.lindeng.common.util;

import java.time.Instant;

public class DataUtil {

    public static Long getNowSecond(){
        return Instant.now().getEpochSecond();
    }
}
