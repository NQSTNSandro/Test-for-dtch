package com.example.demo.services;

import com.example.demo.moduls.Apiegrn;
import com.example.demo.moduls.Region;
import com.example.demo.repositories.RegionRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.redcom.lib.integration.api.client.dadata.DaDataClient;
import ru.redcom.lib.integration.api.client.dadata.DaDataClientFactory;
import ru.redcom.lib.integration.api.client.dadata.DaDataException;
import ru.redcom.lib.integration.api.client.dadata.dto.Address;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;

    private static final String API_KEY="e95ad9803e084e983fb35708f21612d3370af2f0";
    private static final String SECRET_KEY = "4d32436251fbd76728fa04e0b175a9f3aab2c0e3";
    private final DaDataClient dadata= DaDataClientFactory.getInstance(API_KEY,SECRET_KEY);


    public List<Region> listRegions(String cq){
        List<Region> regions=regionRepository.findAll();
        if(cq!=null) regionRepository.findByCq(cq);
        return regionRepository.findAll();
    }

    public Address cleanAddress(final String source) throws DaDataException{
        final Address a=dadata.cleanAddress(source);
        System.out.println("cleaned address: "+a);
        return a;
    }
    public Double fullSize(String cq){
        Integer index=0;
        Double sum=0.0;
        while(index!=regionRepository.findAllByCq(cq).size()){
            sum+=regionRepository.findAllSizeByCq(cq).get(index).getSize();
            index++;
        }
        return sum;
    }
    public Double averageSize(String cq){
        return fullSize(cq)/regionRepository.findAllByCq(cq).size();
    }
    @SneakyThrows
    public void saveRegion(Region region) {
        Apiegrn apiegrn=new Apiegrn();

        log.info("Saving new{}", region);
        apiegrn.setLocation(cleanAddress(region.getAdress()).getResult());
        apiegrn.run();
        region.setAdress(cleanAddress(region.getAdress()).getResult());
        region.setCq(apiegrn.getCq());
        /*region.setSize(cleanAddress(region.getAdress()).getFlatArea().doubleValue());*/
        /*System.out.println(cleanAddress(region.getAdress()).getFlatArea().doubleValue());*/
        regionRepository.save(region);
    }

}
