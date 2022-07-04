package com.ivan.controller;


import com.ivan.service.WebSocketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/websocket")
public class WebSocketController {

    @GetMapping("/sendMessage")
    public void sendMessage() {
        while (true) {
            WebSocketService.sendMessage("001", "hello socket");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}