package com.example.demo.controllers;


import com.example.demo.moduls.OKS;
import com.example.demo.repositories.OKSRepository;
import com.example.demo.services.OKSService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/oks")
@ResponseBody
public class OKSController {

    private final OKSRepository repository;
    private final OKSService oksService;

    @GetMapping("/{cq}")
        public int getCQbyOks(@PathVariable String cq){
        return repository.findAllByCq(cq).size();
    }


    @PostMapping("oks/create")
    public String createOks(OKS oks){
        oksService.saveOks(oks);
        return "redirect:/";
    }

}
