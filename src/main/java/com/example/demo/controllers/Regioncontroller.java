package com.example.demo.controllers;


import com.example.demo.repositories.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/regions")
@ResponseBody
public class Regioncontroller {
    private final RegionRepository repository;
    @GetMapping("/info/fullsize/{cq}")
    public Double getfullsizebycq(@PathVariable String cq){
        return repository.FullSizeByCq(cq);
    }
    @GetMapping("/info/avgsize/{cq}")
    public Double getAverageSize(@PathVariable String cq){
        return repository.AvgSizeByCq(cq);
            }
    @GetMapping("/info/{adress}")
    public List<String> all(@PathVariable String adress){
        return  repository.findByAdressLike(adress);
    }
}
