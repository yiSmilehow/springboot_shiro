package com.shiroapache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /**
     * 未认证时访问的页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        // /templates/*.html
        return "login";
    }

    /**
     * 认证后访问的页面
     *
     * @return
     */
    @RequestMapping("/success")
    public String success() {
        // /templates/*.html
        return "success";
    }

    /**
     * 无权限的页面
     *
     * @return
     */
    @RequestMapping("/unauth")
    public String unauth() {
        // /templates/*.html
        return "unauth";
    }

    /**
     * 学生页面
     *
     * @return
     */
    @RequestMapping("/student")
    public String student() {
        // /templates/*.html
        return "student";
    }

    /**
     * 教师页面
     *
     * @return
     */
    @RequestMapping("/teacher")
    public String teacher() {
        // /templates/*.html
        return "teacher";
    }

    /**
     * 列表页面
     *
     * @return
     */
    @RequestMapping("/list")
    public String list() {
        // /templates/*.html
        return "list";
    }

}
