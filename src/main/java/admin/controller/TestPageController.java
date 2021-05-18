package admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/test")
public class TestPageController {
    @GetMapping
    public String showTest(){
        return "test";
    }
    @PostMapping
    public String showTestPage(){
        return "test";
    }
}
