package kr.inhatc.spring.diy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DIYController {
	// 오픈레이어 연결 
    @GetMapping("/diy/openDIY")
    public String openDIY(Model model) {
        return "/diy/openDIY";
    }
}
