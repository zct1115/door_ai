package com.zct.door_ai.utils;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtil {

    /**
     * 文件上传的工具类
     * @param file 文件字节
     * @param filePath 文件路径
     * @param fileName 文件名
     * @throws Exception
     */
    public static void updateFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
