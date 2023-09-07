package com.aws.spring_study.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @RestController = ResonseBody와 Controller를 합친것과 같다
@Controller
public class ViewsController {

    @ResponseBody // 데이터를 바로 응답
    @GetMapping("/student/register")
    public String studentRegister(Model model) {
       model.addAttribute("title", "학생 등록");
        return "student_register";
    }
}
