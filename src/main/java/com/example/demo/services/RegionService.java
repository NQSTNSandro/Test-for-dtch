package com.example.demo.services;

import com.example.demo.api.ApiDadata;
import com.example.demo.api.Apiegrn;
import com.example.demo.moduls.Region;
import com.example.demo.repositories.RegionRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@ComponentScan("com.example.demo.api")

public class RegionService {
    private final RegionRepository regionRepository;
    ApiDadata apiDadata=new ApiDadata();
    private final Apiegrn apiegrn;
    @SneakyThrows
    public void saveRegion(Region region) {
        log.info("Saving new{}", region);
        region.setAdress(apiDadata.cleanAddress(region.getAdress()).getResult());
        apiegrn.run(region.getAdress());
        region.setCq(apiegrn.getCq());
        region.setSize(apiegrn.getSize());
        regionRepository.save(region);
    }

}
