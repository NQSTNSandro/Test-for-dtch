package com.example.demo.controllers;


import com.example.demo.moduls.Region;
import com.example.demo.services.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class Regioncontroller {
    private final RegionService regionService;

    @GetMapping("regions/")
    public String regions(@RequestParam(name="cq",required = false) String cq, Model model){
        model.addAttribute("regions", regionService.listRegions(cq));
        return "page";
    }
    @PostMapping("regions/create")
    public String createRegions(Region region){
        regionService.saveRegion(region);
        return "redirect:/";
    }



}
