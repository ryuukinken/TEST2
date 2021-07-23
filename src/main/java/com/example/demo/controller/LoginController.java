package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("loginUsername") String loginName, @RequestParam("loginPassword") String password, Model model, HttpSession httpSession){
        if (!StringUtils.isEmpty(loginName) && "123456".equals(password)){

            httpSession.setAttribute("loginUser",loginName);

            return "redirect:/home";
        }else{
            model.addAttribute("msg","账号或密码错误，请重新登录");
            return  "index";
        }
    }

}
