package com.example.demo.repositories;

import com.example.demo.moduls.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {
    @Query(value = "select cudnum from Regions where adress like CONCAT('%',:adress,'%')")
    List<String> findByAdressLike(String adress);
    @Query(value = "SELECT avg(size) from Regions where cq=:cq")
    Double AvgSizeByCq(String cq);
    @Query(value = "select sum(size) from Regions where cq=:cq")
    Double FullSizeByCq(String cq);


}
