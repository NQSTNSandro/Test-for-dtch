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
    private Integer Okscount=0;
    @Column(name = "full_size")
    private Integer Fullsize=0;
    @Column(name = "average_size")
    private Integer Averagesize=0;
}
