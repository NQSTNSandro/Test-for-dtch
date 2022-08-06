package com.example.demo.services;

import com.example.demo.api.Apiegrn;
import com.example.demo.moduls.Cadastralquarters;
import com.example.demo.repositories.CadastralquartersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@ComponentScan("com.example.demo.api")
public class CadastralquartersService {
    private final CadastralquartersRepository cadastralquartersRepository;

    private final Apiegrn apiegrn;
    public List<Cadastralquarters> listCq(String cq){
        List<Cadastralquarters> cadastralquarters= cadastralquartersRepository.findAll();
        if (cq != null) cadastralquartersRepository.findByCq(cq);
        return cadastralquartersRepository.findAll();
    }


    public  void  saveCq(Cadastralquarters cadastralquarters){
        log.info("Saving new{}",cadastralquarters);
        cadastralquarters.setCq(apiegrn.getCq());
        cadastralquartersRepository.save(cadastralquarters);

    }
}
