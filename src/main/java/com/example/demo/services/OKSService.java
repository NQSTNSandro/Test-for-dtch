package com.example.demo.services;

import com.example.demo.moduls.OKS;
import com.example.demo.repositories.OKSRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OKSService {
    private final OKSRepository oksRepository;

    public List<OKS> listOks(String cq) {
        List<OKS> oks = oksRepository.findAll();
        if (cq != null) oksRepository.findByCq(cq);
        return oksRepository.findAll();
    }
    public void saveOks(OKS oks){
        log.info("Saving new{}",oks);
        oksRepository.save(oks);
    }

}
