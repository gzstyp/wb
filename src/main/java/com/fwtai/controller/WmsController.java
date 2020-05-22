package com.fwtai.controller;

import com.fwtai.config.WebSocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import static com.fwtai.config.WebSocketServer.webSocketMap;

@RestController
@RequestMapping("wms")
public class WmsController{

    @Resource
    private WebSocketServer webSocketServer;

    // http://127.0.0.1:84/wms/task
    @GetMapping(value = {"task"})
    public void page(){
        final ConcurrentHashMap<String,WebSocketServer> map = webSocketMap;
        for(final String userId : map.keySet()){
            try{
                webSocketServer.sendInfo1("userId",userId);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}