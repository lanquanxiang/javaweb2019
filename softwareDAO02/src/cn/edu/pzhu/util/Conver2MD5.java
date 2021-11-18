package cn.edu.pzhu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Conver2MD5 {

	public static String getSHA256(String str) {
        String reStr = null;
        try {
        	//初始化信息摘要
        	MessageDigest md = MessageDigest.getInstance("SHA-256");
        	//使用字节数组对信息摘要进行更新
            md.update(str.getBytes());
            //对信息摘要进行填充
            byte ss[] = md.digest();
            //将信息摘要之后的字节数组转换为十六进制的字符串
            reStr = bytes2String(ss);
        } catch (NoSuchAlgorithmException e) {
        	e.printStackTrace();
        }
        return reStr;
    }
	
	public static String getMD5(String str) {
        String reStr = null;
        try {
        	MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte ss[] = md.digest();
            reStr = bytes2String(ss);
        } catch (NoSuchAlgorithmException e) {
        	e.printStackTrace();
        }
        return reStr;
    }
	
	public static String getSHA(String str) {
        String reStr = null;
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            sha.update(str.getBytes());
            byte ss[] = sha.digest();
            reStr = bytes2String(ss);
        } catch (NoSuchAlgorithmException e) {

        }
        return reStr;

    }
    private static String bytes2String(byte[] aa) {
        String hash = "";
        for (int i = 0; i < aa.length; i++) {
            int temp;
            System.out.print(aa[i] + "  ");
            if (aa[i] < 0)		
                temp = 256 + aa[i];
            else
                temp = aa[i];
            if (temp < 16)
                hash += "0";
            System.out.print(temp + "  ");            
            hash += Integer.toString(temp, 16);
        }
        hash = hash.toUpperCase();
        return hash;
    }
}
