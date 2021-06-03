package admin.controller;

import admin.dao.domain.Corporation;
import admin.service.CorporationServiceImpl;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/corporation")
public class CorporationController {
    private CorporationServiceImpl corporationService;
    @Autowired
    public void setCorporationService(CorporationServiceImpl service){
        this.corporationService = service;

    }

    @GetMapping
    public String showCorporations(Model model){
        List<Corporation>allCorps = corporationService.findAll();
        model.addAttribute("allCorps", allCorps);
        return "CorporationManagement";
    }

    @PostMapping
    public String showCorporation(Model model){
        List<Corporation>allCorps = corporationService.findAll();
        model.addAttribute("allCorps", allCorps);
        return "CorporationManagement";
    }
}
