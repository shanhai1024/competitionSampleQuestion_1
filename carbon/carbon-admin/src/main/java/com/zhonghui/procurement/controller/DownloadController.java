package com.zhonghui.procurement.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@RestController
@Api(tags = "采购管理系统-文件下载")
@CrossOrigin
@RequestMapping("/procurement")
public class DownloadController {

    @Value("${zhonghui.profile}")
    public String path;

    @ApiOperation("文件下载")
    @GetMapping(value = "/downloadFile")
    public void downloads(HttpServletResponse response, String fileName) {
        try {
            // 1、设置response 响应头
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));


            // 解决特殊跨域问题
            String origin = response.getHeader("Origin");
            if (origin == null) {
                response.addHeader("Access-Control-Allow-Origin", "*");
            } else {
                response.addHeader("Access-Control-Allow-Origin", origin);
            }

            File file = new File(path, fileName);
            // 2、 读取文件--输入流
            InputStream input = new FileInputStream(file);
            // 3、 写出文件--输出流
            OutputStream out = response.getOutputStream();
            byte[] buff = new byte[1024];
            int index = 0;
            // 4、执行 写出操作
            while ((index = input.read(buff)) != -1) {
                out.write(buff, 0, index);
                out.flush();
            }
            out.close();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件下载执行异常");
        }
    }
}
