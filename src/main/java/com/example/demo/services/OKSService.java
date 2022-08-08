package com.example.demo.services;

import com.example.demo.api.Apiegrn;
import com.example.demo.moduls.OKS;
import com.example.demo.repositories.OKSRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@ComponentScan("com.example.demo.api")

public class OKSService {
    private final OKSRepository oksRepository;

    private final Apiegrn apiegrn;
    private List<OKS> createList(int size,List<String> cudnums){
        List<OKS> list=new ArrayList<>();
        for(int i=0;i<size;i++){
            OKS obj = new OKS();
            obj.setCudnum(cudnums.get(i));
            obj.setCq(cudnums.get(i).substring(0, 13));
            list.add(obj);
        }
        return list;
    }

    public void saveOks(OKS oks) {
        log.info("Saving new{}", oks);
        List<String> cudnums = apiegrn.getCudnums();
        if (cudnums.size() >= 3) {
            oksRepository.saveAll(createList(3, cudnums));
        } else
            oksRepository.saveAll(createList(cudnums.size(),cudnums));
    }
}
