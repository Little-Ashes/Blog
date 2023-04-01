package com.ggl.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    /**
     *
     * @param str
     * @return
     */
    public static String code(String str){
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bytesDigest = messageDigest.digest();
            int i;
            StringBuffer stringBuffer = new StringBuffer();
            for (int offset = 0; offset < bytesDigest.length ; offset++){
                i = bytesDigest[offset];
                if (i < 0){
                    i += 256;
                }
                if (i < 16){
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            //32位加密
            return stringBuffer.toString();
            //16位加密
            //return stringBuffer.toString().substring(8,24);
        }catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        System.out.println(code("Blog#123"));
    }
}
