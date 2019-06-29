package com.kblive.usersystem.common.utils.md5tools;

import java.util.ArrayList;
import java.util.List;

/**
 * md5加密
 * @author 钟强
 * 创建时间：2019-03-15
 * 修改时间：
 */
public class MD5Util {
	/**
	 * 获取MD5密文
	 * @param source
	 * @return
	 */
    public static String getMD5(String source) {
    	if(source==null||source.equals("")) return null;
        return getMD5(source.getBytes());
    }

    private static String getMD5(byte[] source) {
        String s = null;
        char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
                             '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte tmp[];
            synchronized (MD5Util.class) {
                md.update(source);
                tmp = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
            }
            // 用字节表示就是 16 个字节
            char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
            // 所以表示成 16 进制需要 32 个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
                // 转换成 16 进制字符的转换
                byte byte0 = tmp[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
                // >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            s = new String(str); // 换后的结果转换为字符串

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    
    public static void  main(String[] str) {
    	//E10ADC3949BA59ABBE56E057F20F883E
    	//E10ADC3949BA59ABBE56E057F20F883E
		System.out.print(getMD5("Zk12345678"));

        List<String> a=new ArrayList<>();
        a.add("eqeqr");
        a.add("qwqe");

        List<String> b=new ArrayList<>();
        b.add("eqeqr");
        b.add("qwqe");

        a.addAll(b);
        
        System.out.println(a);

	}
}
