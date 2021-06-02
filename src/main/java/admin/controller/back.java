package admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/back")
public class back {
    @GetMapping
    public String showTest(){
        log.info("Transfer Station1:");
        return "new_template/back";
    }
    @PostMapping
    public String showTestPage(){
        log.info("Transfer Station2:");
        return "new_template/back";
    }


}

