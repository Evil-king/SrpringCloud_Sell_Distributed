package com.hwq.product.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hwq
 * @date 2018/08/05
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String getMsg() {
        return "this is product' msg";
    }
}
