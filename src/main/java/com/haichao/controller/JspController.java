package com.haichao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * jsp 的使用
 * 1.maven 引入
 * 2.解析器配置
 * 3.jsp 文件路径建立
 * 4.controller 编写
 */
@Controller
@RequestMapping("/jsp")
public class JspController {
    @RequestMapping("/hi")
    public String sayHello() {
        return "index";
    }
}
