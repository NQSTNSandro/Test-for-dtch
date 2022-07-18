package com.example.demo.controllers;


import com.example.demo.moduls.OKS;
import com.example.demo.services.OKSService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class OKSController {
    private final OKSService oksService;
    @GetMapping("/")
    public String oks(@RequestParam(name = "cq",required = false) String cq, Model model){
        model.addAttribute("oks",oksService.listOks(cq));
        return "page";
    }
    @PostMapping("oks/create")
    public String createOks(OKS oks){
        oksService.saveOks(oks);
        return "redirect:/";
    }

}
