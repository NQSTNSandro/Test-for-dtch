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
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@ComponentScan("com.example.demo.api")

public class RegionService {
    private final RegionRepository regionRepository;
    ApiDadata apiDadata=new ApiDadata();
    private final Apiegrn apiegrn;
     private List<Region> createList(int size, List<String> cudnums,List<Double> sizes,List<String> addresses){
         List<Region> list = new ArrayList<>();
         for (int i = 0; i < size; i++) {
                 Region rgn = new Region();
                 rgn.setCudnum(cudnums.get(i));
                 rgn.setCq(cudnums.get(i).substring(0, 13));
                 rgn.setSize(sizes.get(i));
                 rgn.setAdress(addresses.get(i));
                 list.add(rgn);
             }
             return list;
     }
    @SneakyThrows
    public void saveRegion(Region region) {
        log.info("Saving new{}", region);
        region.setAdress(apiDadata.cleanAddress(region.getAdress()).getResult());
        apiegrn.run(region.getAdress());
        List<String> cudnums= apiegrn.getCudnums();
        List<Double> sizes = apiegrn.getSize();
        List<String> addresses=apiegrn.getAddresses();
        if(cudnums.size()>=3)
            regionRepository.saveAll(createList(3,cudnums,sizes,addresses));
            else
                regionRepository.saveAll(createList(cudnums.size(),cudnums,sizes,addresses));
    }

}
