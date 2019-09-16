package com.fenix.base.controllers;

import com.fenix.base.DTO.UploadDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件上传控制器
 */
@RestController
@Api(tags = "文件上传相关接口")
public class UploadController {

    private final String UPLOADED_FOLDER = "C:/upload/";

    @ApiOperation("文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String index(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "upload file required!";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            return "upload success";
        } catch (IOException e) {
            e.printStackTrace();
            return "upload failed";
        }
    }

    @ApiOperation("文件上传v2")
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String index(UploadDTO uploadDTO,@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "upload file required!";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            return uploadDTO.getName() + "upload success";
        } catch (IOException e) {
            e.printStackTrace();
            return "upload failed";
        }
    }
}
