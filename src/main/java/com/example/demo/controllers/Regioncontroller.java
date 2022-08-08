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
    //Возвращает общий размер участков в кад. квартале
    @GetMapping("/info/fullsize/{cq}")
    public Double getfullsizebycq(@PathVariable String cq){
        return repository.FullSizeByCq(cq);
    }
    //Возвращает средний размер участков в кад. квартале
    @GetMapping("/info/avgsize/{cq}")
    public Double getAverageSize(@PathVariable String cq){
        return repository.AvgSizeByCq(cq);
            }
     //Выводит список кад.кварталов расположенных по адрессу.
    @GetMapping("/info/{adress}")
    public List<String> all(@PathVariable String adress){
        return  repository.findByAdressLike(adress);
    }
}
