package com.example.demo.controllers;


import com.example.demo.moduls.Region;
import com.example.demo.repositories.RegionRepository;
import com.example.demo.services.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/regions")
@ResponseBody
public class Regioncontroller {
    private final RegionRepository repository;
    private final RegionService regionService;

    @GetMapping("/info/fullsize/{cq}")
    public Double getfullsizebycq(@PathVariable String cq){
        return repository.FullSizeByCq(cq);
    }
    @GetMapping("/info/avgsize/{cq}")
    public Double getAverageSize(@PathVariable String cq){
        return repository.AvgSizeByCq(cq);
            }
 /*   @GetMapping("/info/{adress}")
    public List<Region> all(String adress){
        return repository.findAllByAdress(adress);
    }
*/

    @PostMapping("/create")
    public String createRegions(Region region){

        regionService.saveRegion(region);
        return "redirect:/";
    }



}
