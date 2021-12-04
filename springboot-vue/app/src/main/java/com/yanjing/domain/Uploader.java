package com.yanjing.domain;

import com.yanjing.util.FileUtil;
import com.yanjing.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author yanjing
 * @date 2021/11/25
 */
@Component
@Slf4j
public class Uploader {

    @Value("${file.baseurl}")
    private String fileBaseUrl;

    @Value("${file.folder}")
    private String fileFolder;

    private static final Logger logger = LoggerFactory.getLogger(Uploader.class);

    public String uploadImage(MultipartFile file) {

        System.out.println(fileBaseUrl);
        System.out.println(fileFolder);
        String fileName = StringUtil.randomString(8) + "." + FileUtil.extName(file);
        File imageFile = FileUtil.makeFile(fileFolder, fileName);
        try {
            file.transferTo(imageFile);
            return fileBaseUrl + imageFile.getName();
        } catch (IOException e) {

            logger.error(e.getMessage());
            return "";
        }
    }
}
