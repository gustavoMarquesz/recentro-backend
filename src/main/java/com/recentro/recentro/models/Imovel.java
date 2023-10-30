package com.recentro.recentro.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @Column
    @NotNull
    private String endereco;

    public Imovel(String endereco){
        this.endereco = endereco;

    }
}
