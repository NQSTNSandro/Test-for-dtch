package com.example.demo.repositories;

import com.example.demo.moduls.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {
    List<Region> findByCq(String cq);
    List<Region> findAllByCq(String cq);
    List<Region> findAllSizeByCq(String cq);
}
