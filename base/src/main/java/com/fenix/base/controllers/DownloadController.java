package com.fenix.base.controllers;

import com.fenix.base.DTO.UploadDTO;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class DownloadController {

    @RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
    @ResponseBody
    public void download(@RequestParam(name = "file", required = false) MultipartFile file, UploadDTO uploadDTO) {
        if (file.isEmpty()) {

        }
        if (uploadDTO == null) {

        }
    }

    @RequestMapping(value = "/downloadFile1", method = RequestMethod.GET)
    private String downloadFile(HttpServletResponse response) {
//        String downloadFilePath = "/root/fileSavePath/";//被下载的文件在服务器中的路径,
//        String fileName = "demo.xml";//被下载文件的名称
        String path = "http://b.hiphotos.baidu.com/image/pic/item/810a19d8bc3eb1352a3409c8ac1ea8d3fc1f44d5.jpg";

//        File file = new File(downloadFilePath);
//        if (file.exists()) {
        response.setContentType("application/force-download");// 设置强制下载不打开            
        response.addHeader("Content-Disposition", "attachment;fileName=abc.jpg");
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(path);
            bis = new BufferedInputStream(fis);
            OutputStream outputStream = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                outputStream.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            return "下载成功";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        }
        return "下载失败";
    }


    /**
     * 下载图片
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletRequest request, HttpServletResponse response) {
        String path = "http://b.hiphotos.baidu.com/image/pic/item/810a19d8bc3eb1352a3409c8ac1ea8d3fc1f44d5.jpg";

        //根据url获取输入流
        //URL url = new URL(zipUrl);
        //HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        //conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        //conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        //InputStream inputStream = conn.getInputStream();
        //-------------------------------------------

        //下载
        try {
            InputStream inputStream = new FileInputStream(new File(path));
            OutputStream outputStream = response.getOutputStream();
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=filename=dad.jpg");

            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadFile() throws IOException {
        String filename = "http://b.hiphotos.baidu.com/image/pic/item/810a19d8bc3eb1352a3409c8ac1ea8d3fc1f44d5.jpg";
        File file = new File(filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", String.format("attachment; filename={}", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object>
                responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
                MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;
    }

}
