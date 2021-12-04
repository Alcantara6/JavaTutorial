package com.yanjing.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author yanjing
 * @date 2021/11/25
 */
public class FileUtil {

    public static File makeFile(String folder, String fileName) {

        File fileFolder = new File(folder);
        File file = new File(fileFolder, fileName);
        // 创建目录
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    public static String extName(MultipartFile file) {

        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        return originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
    }
}
