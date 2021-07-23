package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TablesController {

    final
    UserService userService;

    public TablesController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/table")
    public String tables(Model model){
        List list = userService.list();
        model.addAttribute("users",list);
        return "tables";
    }

    @GetMapping("/addForm")
    public String toAdd(){
        return "addForm";
    }

    @PostMapping("/addForm")
    public String addUser(User user){
        userService.save(user);
        return "redirect:/table";
    }
    @GetMapping("/update{id}")
    public String updateUser(@PathVariable("id") Integer id,Model model){
        User user = userService.getById(id);
        model.addAttribute("users",user);
        return "updateForm";
    }

    @PostMapping("/updateSave")
    public String updateSave(User user){
        userService.updateById(user);
        return "redirect:/table";
    }

    @GetMapping("/delete{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.removeById(id);
        return "redirect:/table";
    }
}
