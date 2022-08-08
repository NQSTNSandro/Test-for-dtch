package com.example.demo.controllers;


import com.example.demo.repositories.OKSRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/oks")
@ResponseBody
public class OKSController {
    private final OKSRepository repository;
    //Возвращает кол-во окс в кад. квартале
    @GetMapping("/{cq}")
        public int getCQbyOks(@PathVariable String cq){
        return repository.findAllByCq(cq).size();
    }
}
