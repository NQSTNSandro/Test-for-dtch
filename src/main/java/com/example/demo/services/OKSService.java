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

    public void saveOks(OKS oks){
        log.info("Saving new{}",oks);
        List<String> cudnums=new ArrayList<>();
        cudnums=apiegrn.getCudnums();
        if(cudnums.size()>=2|| apiegrn.getCudnums().size()<2){
        for(int i=0;i<3;i++) {
            OKS obj = new OKS();
            obj.setCudnum(cudnums.get(i));
            obj.setCq(cudnums.get(i).substring(0, 13));
            oksRepository.save(obj);
        } }
        }
    }
