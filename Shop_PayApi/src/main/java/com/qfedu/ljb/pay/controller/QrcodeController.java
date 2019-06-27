package com.qfedu.ljb.pay.controller;

import com.qfedu.common.util.Base64Util;
import com.qfedu.common.util.EncryptionUtil;
import com.qfedu.ljb.pay.core.util.QrCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *@Author feri
 *@Date Created in 2019/6/27 10:22
 */
@Controller
public class QrcodeController {

//    public static Class<QrcodeController> clz;
    //生成二维码
    @GetMapping("qrcode/createqrcode.do")
    public void createQrcode(String msg, HttpServletResponse response) throws IOException {
        BufferedImage image=QrCodeUtil.createQrCode(msg,400);
        ImageIO.write(image,"png",response.getOutputStream());
    }
    //生成二维码
    @GetMapping("qrcode/payqrcode.do")
    public void payCode(String msg, HttpServletResponse response) throws IOException {
        String u=new String(Base64Util.base64Dec(msg));
        BufferedImage image=QrCodeUtil.createQrCode(u,400);
        ImageIO.write(image,"png",response.getOutputStream());
    }
}
