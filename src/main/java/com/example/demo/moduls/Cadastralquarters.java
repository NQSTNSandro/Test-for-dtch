package com.example.demo.moduls;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cadastralquarters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cadastralquarters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "CQ")
    private String cq;
    @Column(name = "oks_counter")
    private Integer Okscount;
    @Column(name = "full_size")
    private Double Fullsize;
    @Column(name = "average_size")
    private Double Averagesize;
}
