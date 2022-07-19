package com.example.demo.repositories;

import com.example.demo.moduls.Cadastralquarters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CadastralquartersRepository extends JpaRepository<Cadastralquarters, Long> {
    List<Cadastralquarters> findByCq(String cq);
}
