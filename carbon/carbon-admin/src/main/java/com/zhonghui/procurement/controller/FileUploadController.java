package com.zhonghui.procurement.controller;

import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Api(tags = "采购管理系统-文件上传")
@RestController
@RequestMapping("/procurement")
public class FileUploadController {
    @Value("${zhonghui.profile}")
    private String path;

    /**
     * 文件上传
     */
    @ApiOperation("文件上传")
    @PostMapping("FileUpload")
    public BaseResult FileUpload(@RequestParam("file") MultipartFile file) {
        Map<Object, Object> map = new HashMap<>();
        UUID uuid = UUID.randomUUID();
        System.out.println();
        String fileName = uuid + file.getOriginalFilename();
        File dest = new File(new File(path).getAbsolutePath() + "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest); // 保存文件
            map.put("fileName", fileName);
            return BaseResult.success("上传成功", fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.error("上传失败");
        }
    }
}
