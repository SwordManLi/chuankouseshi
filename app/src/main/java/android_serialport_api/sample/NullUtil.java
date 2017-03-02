package android_serialport_api.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by beikongguocai on 2016/12/21.
 */
public class NullUtil {

    /**
     * 判断字符串是否为空
     * @param args
     * @return
     */
    public static boolean isNullorEmpty(String...args){
        if (args==null){
            return true;
        }
        if (args.length==0){
            return true;
        }

        for (String arg : args){
            if (arg==null)return true;
            if (arg.trim().length()==0)return true;
        }
        return false;
    }

    /**
     * 判断字符串长度和是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNumber = pattern.matcher(str);
        if (!isNumber.matches()){
            return false;
        }
        if (str.length()>1){
            return false;
        }else if (str.length()==0){
            return false;
        }
        return true;
    }
}
