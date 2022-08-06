package com.example.demo.moduls;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "OKS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OKS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "cq")
    private String cq;
}
