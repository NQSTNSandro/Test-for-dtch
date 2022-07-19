package com.example.demo.services;

import com.example.demo.moduls.Region;
import com.example.demo.repositories.RegionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;

    public List<Region> listRegions(String cq){
        List<Region> regions=regionRepository.findAll();
        if(cq!=null) regionRepository.findByCq(cq);
        return regionRepository.findAll();
    }
    public void saveRegion(Region region)
    {
        log.info("Saving new{}", region);
        regionRepository.save(region);
    }
}
