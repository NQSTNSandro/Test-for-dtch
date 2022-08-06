package com.example.demo.services;

import com.example.demo.api.Apiegrn;
import com.example.demo.moduls.OKS;
import com.example.demo.repositories.OKSRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@ComponentScan("com.example.demo.api")

public class OKSService {
    private final OKSRepository oksRepository;

    private final Apiegrn apiegrn;

    public void saveOks(OKS oks){
        log.info("Saving new{}",oks);
        oks.setCq(apiegrn.getCq());
        oksRepository.save(oks);
    }
}
