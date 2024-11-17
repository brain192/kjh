package com.test.test.Controller;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.test.service.User1Service;
import com.test.test.vo.User1VO;

import java.util.List;

@Controller
public class User1Controller {

    @Autowired
    private User1Service service;

    @GetMapping("/user1/list")
    public String list(Model model) {
        List<User1VO> users = service.selectUser1s();
        model.addAttribute("users", users);
        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String register() {
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1VO vo) {
        service.insertUser1(vo);
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(String uid, Model model) {
        User1VO user = service.selectUser1(uid);
        model.addAttribute("user", user);
        return "/user1/modify";
    }
    @PostMapping("/user1/modify")
    public String modify(User1VO vo) {
        service.updateUser1(vo);
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/delete")
    public String delete(String uid) {
        service.deleteUser1(uid);
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/login")
    public String login() {
        return "/user1/login";
    }

    @PostMapping("/user1/login")
    public String login(String uid, String pass, HttpSession session) {

        User1VO user = service.selectUser1(uid, pass);

        if(user != null) {
            // 회원이 맞을 경우
            session.setAttribute("sessUser", user);
            return "redirect:/user1/loginSuccess";

        }else {
            // 회원이 아닌 경우
            return "redirect:/user1/login?success=100";
        }
    }

    @GetMapping("/user1/loginSuccess")
    public String loginSuccess() {
        return "/user1/loginSuccess";
    }


    @GetMapping("/user1/logout")
    public String logout() {
        return "redirect:/user1/login?success=200";
    }
}