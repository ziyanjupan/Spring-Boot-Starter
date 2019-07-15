package com.fenix.emailservice.controller;

import com.fenix.emailservice.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Author: xiaguangyong
 * @ClassName: QRCodeController
 * @Description: QRCode Controller
 * @Date: 2019/7/15 10:00
 * @Version: 1.0
 * @Modify:
 */
@RestController
@RequestMapping("/qrcode")
public class QRCodeController {
    @Autowired
    QRCodeService qrCodeService;

    @RequestMapping(value="/getQRCode")
    public String getQRCode() throws IOException {
        return qrCodeService.createQRCode("name:fenix",200,200);
    }
}