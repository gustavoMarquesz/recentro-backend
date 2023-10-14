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

    @Id
    private String nuProcesso;
    private String nuLicenca;
    private String ProcessoAberto2018;

}
