package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.MemberRegisterService;
import com.example.dto.RegisterRequest;

@Controller
public class WebController {
    @Autowired
    private MemberRegisterService memberRegisterService;
    
    @RequestMapping("/register/step1")
    public String handleStep1() {   return "register/step1";  }
   
    @PostMapping("/register/step2")
    public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
        if (!agree) { 
            return "register/step1";
        }
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register/step2";
    }
    
    
    @GetMapping("/register/step2")
    public String handleStep2Get() {  return "redirect:/register/step1"; }

    
    @PostMapping("/register/step3")
    public String handleStep3(RegisterRequest regReq,Model model) {
        try {
              memberRegisterService.regist(regReq);
              System.out.print("회원가입 완료");
              
              model.addAttribute("result","회원가입이 완료되었습니다.");
           
              return "/register/step3";
        } catch (Exception ex) {

        	System.out.print(ex);
            
        	System.out.print("회원가입 실패");
            model.addAttribute("result","중복된 이메일 입니다.");
            System.out.print("result");
        	return "/register/step3";
        }
    }
    @GetMapping("/register/error")
    public String handleErrorGet() {  return "/register/error"; }
 

}
