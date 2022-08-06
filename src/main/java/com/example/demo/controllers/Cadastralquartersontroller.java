package com.example.demo.controllers;

import com.example.demo.moduls.Cadastralquarters;
import com.example.demo.services.CadastralquartersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class Cadastralquartersontroller {
    private final CadastralquartersService cadastralquartersService;
    @GetMapping("/")
    public String cadastralquarters(@RequestParam(name = "cq",required = false)String cq, Model model) {
        model.addAttribute("cq", cadastralquartersService.listCq(cq));
        return "page";
    }

    @PostMapping("cq/create")
    private String createCq(Cadastralquarters cadastralquarters){

        cadastralquartersService.saveCq(cadastralquarters);
        return "redirect:/";
    }

}
