package com.example.demo.moduls;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cadastralquarters")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cadastralquarters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "CQ")
    private String cq;


}
