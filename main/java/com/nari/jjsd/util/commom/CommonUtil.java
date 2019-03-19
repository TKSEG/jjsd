package com.nari.jjsd.util.commom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by yangbo on 2019/2/28.
 */
public class CommonUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getFlowTypeName(String typeCode){
        // 任务储备
        if(ConstUtil.TYPE_CODE_STORE_CODE.equals(typeCode)){
            return ConstUtil.TYPE_CODE_STORE;
        }else if(ConstUtil.TYPE_CODE_SELF_CODE.equals(typeCode)){
            // 任务自提
            return ConstUtil.TYPE_CODE_SELF;
        }else{
            return ConstUtil.TYPE_CODE_STORE;
        }
    }
    public static String getCurrentDate(){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }
}
