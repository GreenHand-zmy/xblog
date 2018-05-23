package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    /**
     */
    public static String md5(String plainText) {
        byte[] secretBytes;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("找不到md5算法");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    public static void main(String[] args) {
//		String uname="zs";
//		String upwd="a123";
        if (md5("zsa12345").equals("a40e44b9678fdba0bfcd3ab7e2ca94be")) {
            System.out.println("密码正确！！");
        } else {
            System.out.println("密码错误！！");
        }
        //System.out.println(md5("zsa123"));
    }
}
