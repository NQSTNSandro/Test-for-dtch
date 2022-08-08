package com.example.demo.moduls;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity(name = "Regions")
@Table(name = "Regions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="size")
    private Double size;
    @Column(name="cq")
    private String cq;
    @Column(name="adress",unique = true)
    private String adress;
    @Column(name="cudnum")
    private String cudnum;
}
