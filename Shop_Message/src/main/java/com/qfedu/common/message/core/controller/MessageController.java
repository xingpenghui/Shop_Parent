package com.qfedu.common.message.core.controller;

import com.qfedu.common.message.core.entity.Message;
import com.qfedu.common.message.core.service.MessageService;
import com.qfedu.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 *@Author feri
 *@Date Created in 2019/6/13 13:10
 */
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping("/message/page.do")
    public R all(int page,int count){
        return messageService.page(page, count);
    }
    @PostMapping("/message/sendmsg.do")
    public R sendMsg(@RequestBody Message message, HttpServletRequest request){
        return messageService.sendMessage(message,request.getRemoteAddr());
    }
    @GetMapping("/message/checkcode.do")
    public R check(String phone,int code){
        return messageService.checkCode(phone, code);
    }
}