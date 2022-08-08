package com.example.demo.controllers;

import com.example.demo.moduls.Cadastralquarters;
import com.example.demo.moduls.OKS;
import com.example.demo.moduls.Region;
import com.example.demo.services.CadastralquartersService;
import com.example.demo.services.OKSService;
import com.example.demo.services.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SavingController {
    private final RegionService regionService;
    private final OKSService oksService;
    private final CadastralquartersService cadastralquartersService;
    //Собираю все в кучу и сохраняю.
    @PostMapping("save")
    public String createObj(Region region, OKS oks, Cadastralquarters cadastralquarters)
    {
        regionService.saveRegion(region);
        oksService.saveOks(oks);
        cadastralquartersService.saveCq(cadastralquarters);
        return "redirect:/";
    }
}
