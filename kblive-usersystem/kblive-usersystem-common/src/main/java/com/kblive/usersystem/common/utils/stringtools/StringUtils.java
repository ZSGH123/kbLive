package com.kblive.usersystem.common.utils.stringtools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * title: StringUtils
 * projectName kbLive
 * description: string
 * author 2671242147@qq.com
 * date 2019-08-03 14:01
 ***/
public  class StringUtils extends org.apache.commons.lang.StringUtils{
    private StringUtils() {
    }

    public static boolean isEmpty(String value) {
        int strLen;
        if (value != null && (strLen = value.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(value.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isNumeric(Object obj) {
        if (obj == null) {
            return false;
        } else {
            char[] chars = obj.toString().toCharArray();
            int length = chars.length;
            if (length < 1) {
                return false;
            } else {
                int i = 0;
                if (length > 1 && chars[0] == '-') {
                    i = 1;
                }

                while (i < length) {
                    if (!Character.isDigit(chars[i])) {
                        return false;
                    }

                    ++i;
                }

                return true;
            }
        }
    }

    public static boolean areNotEmpty(String... values) {
        boolean result = true;
        if (values != null && values.length != 0) {
            String[] var5 = values;
            int var4 = values.length;

            for (int var3 = 0; var3 < var4; ++var3) {
                String value = var5[var3];
                result &= !isEmpty(value);
            }
        } else {
            result = false;
        }

        return result;
    }

    public static String unicodeToChinese(String unicode) {
        StringBuilder out = new StringBuilder();
        if (!isEmpty(unicode)) {
            for (int i = 0; i < unicode.length(); ++i) {
                out.append(unicode.charAt(i));
            }
        }

        return out.toString();
    }

    public static String toUnderlineStyle(String name) {
        StringBuilder newName = new StringBuilder();

        for (int i = 0; i < name.length(); ++i) {
            char c = name.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i > 0) {
                    newName.append("_");
                }

                newName.append(Character.toLowerCase(c));
            } else {
                newName.append(c);
            }
        }

        return newName.toString();
    }

    public static String convertString(byte[] data, int offset, int length) {
        if (data == null) {
            return null;
        } else {
            try {
                return new String(data, offset, length, "UTF-8");
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }
        }
    }

    public static byte[] convertBytes(String data) {
        if (data == null) {
            return null;
        } else {
            try {
                return data.getBytes("UTF-8");
            } catch (Exception var2) {
                throw new RuntimeException(var2);
            }
        }
    }

    /**
     * 处理in查询使用的条件，整理数据，去除空，判断是否超过上限
     *
     * @param str   str
     * @param limit 上限
     * @return String
     */
    public static String divisionStr(String str, int limit) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        str = str.replaceAll("，", ",");
        String[] strArray = str.split(",");
        Set<String> set = new HashSet<>();
        for (String s : strArray) {
            if (StringUtils.isNotBlank(s)) {
                set.add(s.trim());
            }
        }
        if (limit > 0 && set.size() > limit) {
            throw new IllegalArgumentException("以逗号分割的多个有效条件超过上限" + limit + "个");
        }
        return StringUtils.join(set, ",");
    }

    /**
     * 揽件分割
     *
     * @param str   str
     * @param limit 上限
     * @return String
     */
    public static String divisionPickTradeStr(String str, int limit) throws Exception {
        String result;
        try {
            result = divisionStr(str, limit);
        } catch (Exception e) {
            throw new Exception("批量生成快递码最多支持" + limit + "笔订单，请重新勾选。");
        }
        return result;
    }

    public static String hideMobile(String phone) {
        if (StringUtils.isBlank(phone)) {
            return phone;
        }
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    public static String hideName(String name) {
        if (StringUtils.isBlank(name)) {
            return name;
        }
        return name.replaceAll("([\\d\\D]{1})(.*)", "$1**");
    }

    public static String hideIdCard(String idCard) {
        if (StringUtils.isBlank(idCard)) {
            return idCard;
        }
        return idCard.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1*****$2");
    }

    /**
     * emoji表情替换
     *
     * @param source  原字符串
     * @param slipStr emoji表情替换成的字符串
     * @return 过滤后的字符串
     */
    public static String filterEmoji(String source, String slipStr) {
        if (StringUtils.isNotBlank(source)) {
            return source.replaceAll("[^\\u0000-\\uFFFF]", slipStr);
        } else {
            return source;
        }
    }

    public static String filterEmoji(String source) {
        if (StringUtils.isNotBlank(source)) {
            return source.replaceAll("[^\\u0000-\\uFFFF]", "");
        } else {
            return source;
        }
    }

    /**
     * 对象的String类型字段都进行emoji处理
     *
     * @param object 对象
     */
    public static void filterEmojiObject(Object object) {
        if (object == null) {
            return;
        }
        Field[] fields = object.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
        try {
            for (Field field : fields) { // 遍历所有属性
                String name = field.getName(); // 获取属性的名字
                name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                String type = field.getGenericType().toString(); // 获取属性的类型

                if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                    Method m = object.getClass().getMethod("get" + name);
                    String value = (String) m.invoke(object); // 调用getter方法获取属性值
                    //.....处理开始........
                    value = filterEmoji(value, "");//执行处理方法
                    //.....处理结束........
                    m = object.getClass().getMethod("set" + name, String.class);
                    m.invoke(object, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 是否为数字型字符串，包括浮点
     *
     * @param str str
     * @return boolean
     */
    public static boolean isNumber(String str) {
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }
}