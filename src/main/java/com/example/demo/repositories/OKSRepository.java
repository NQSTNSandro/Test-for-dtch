package com.example.demo.repositories;

import com.example.demo.moduls.OKS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OKSRepository extends JpaRepository<OKS,Long> {
    List<OKS> findByCq(String cq);
}
