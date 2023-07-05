package com.mht.stueaxm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Kirtico
 * @date 2023/7/5&16:47
 */
@Controller
public class ErrorPageController {
    @RequestMapping(value = "/error400Page")
    public String error400Page(Model model) {
        model.addAttribute("code", "400");
        model.addAttribute("msg", "服务器升级中，找不到页面啦");
        return "/error/400";
    }

    @RequestMapping(value = "/error401Page")
    public String error401Page(Model model) {
        model.addAttribute("code", "401");
        model.addAttribute("msg", "服务器升级中，找不到页面啦");
        return "/error/401";
    }

    @RequestMapping(value = "/error403Page")
    public String error403Page(Model model) {
        model.addAttribute("code", "403");
        model.addAttribute("msg", "服务器升级中，找不到页面啦");
        return "/error/403";
    }
    @RequestMapping(value = "/error404Page")
    public String error404Page(Model model) {
        model.addAttribute("code", "404");
        model.addAttribute("msg", "服务器升级中，找不到页面啦");
        return "/error/404";
    }
    @RequestMapping(value = "/error500Page")
    public String error500Page(Model model) {
        model.addAttribute("code", "500");
        model.addAttribute("msg", "服务器升级中，找不到页面啦");
        return "/error/500";
    }
    @RequestMapping(value = "/error503Page")
    public String error503Page(Model model) {
        model.addAttribute("code", "503");
        model.addAttribute("msg", "服务器升级中，找不到页面啦");
        return "/error/503";
    }
}
