package com.recentro.recentro.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Licenciamento {


    private String nuProcesso;
    @Column
    private String nuLicenca;
    @Column
    private String ProcessoAberto2018;

    //@OneToMany (mappedBy = "Imovel")

}
