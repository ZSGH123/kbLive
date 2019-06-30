package com.kblive.usersystem.common.utils.filetools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * title: ZipUtil
 * projectName kbLive
 * description: 解压文件工具
 * author 2671242147@qq.com
 * date 2019-06-29 14:59
 ***/
public class ZipUtil {

    public ZipUtil() {
    }

    /**
     * 压缩文件或者目录
     *
     * @param sourceFile 单个路径或者目录
     */
    public static void zipUnkownFile(File sourceFile, File targetZipFile) {
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(targetZipFile));
            if (sourceFile.isFile()) {
                zipSingleFile(sourceFile, out, "");
            } else {
                File[] list = sourceFile.listFiles();
                for (int i = 0; i < list.length; i++) {
                    compress(list[i], out, "");
                }
            }

            System.out.println("压缩完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 压缩文件夹里的文件
     * 起初不知道是文件还是文件夹--- 统一调用该方法
     *
     * @param file    文件或者目录
     * @param out     输出文件
     * @param basedir 文件对应的目录
     */
    private static void compress(File file, ZipOutputStream out, String basedir) {
        // 判断是目录还是文件
        if (file.isDirectory()) {
            zipDirectory(file, out, basedir);
        } else {
            zipSingleFile(file, out, basedir);
        }
    }

    /**
     * 压缩单个文件 source
     *
     * @param sourceFile 源文件
     * @param out        输出流
     * @param basedir    文件对应的目录
     */
    public static void zipSingleFile(File sourceFile, ZipOutputStream out, String basedir) {
        if (!sourceFile.exists()) {
            return;
        }
        byte[] buffer = new byte[1024];
        FileInputStream in = null;
        try {
            int len;
            in = new FileInputStream(sourceFile);
            out.putNextEntry(new ZipEntry(basedir + sourceFile.getName()));

            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.closeEntry();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 压缩单个文件
     *
     * @param sourceFile    源文件
     * @param targetZipFile 目标zip文件
     */
    public static void zipSingleFile(File sourceFile, File targetZipFile) {
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(targetZipFile));
            zipSingleFile(sourceFile, out, "");
            System.out.println("压缩完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 多文件压缩
     *
     * @param targetZipFile 压缩后的zip文件
     * @param sourceFiles   源文件数组
     */
    public static void zipMultipleFiles(File targetZipFile, File... sourceFiles) {
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(targetZipFile));
            for (File file : sourceFiles) {
                zipSingleFile(file, out, "");
            }
            System.out.println("压缩完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 压缩文件夹
     *
     * @param dir     目录
     * @param out     输出流
     * @param basedir 文件对应的目录
     */
    public static void zipDirectory(File dir, ZipOutputStream out, String basedir) {
        if (!dir.exists()) {
            return;
        }
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            //递归
            compress(files[i], out, basedir + dir.getName() + "/");
        }
    }

    /**
     * 删除文件
     * @param fileName 文件名称
     */
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    //测试
    public static void main(String[] args) {
        // 模板路径和输出流
        String templatePath = ZipUtil.class.getResource("/").getPath();
        System.out.println(templatePath);
        //zipSingleFile(new File(""),new File(""));

    }
}
