package com.tutorial.demo.web;

import com.tutorial.demo.model.ChatClientModel;
import com.tutorial.demo.model.ServerResponseModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CharRoomController {

    @MessageMapping("/messageControl")
    @SendTo("topic/getResponse")
    public ServerResponseModel said(ChatClientModel responseMessage) throws
            InterruptedException {
        Thread.sleep(3000);
        ServerResponseModel responseModel = new ServerResponseModel();
        responseModel.setResponseMessage("歡迎來到, " + responseMessage.getClientname());
        return new ServerResponseModel();
    }

    @RequestMapping("chat-index")
    public String index() {

        return "chat-index";
    }
}
