package com.pmoc.mirante.models.gerais;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Gerais {
    private String codigo;
    private String marca;
    private String modelo;

    public Gerais(DadosGerais gerais) {
        this.codigo = gerais.codigo();
        this.marca = gerais.marca();
        this.modelo = gerais.modelo();
    }
    public void updateInfo(DadosGerais dados) {
        if(dados.codigo() != null) {
            this.codigo = dados.codigo();
        }
        if(dados.marca() != null) {
            this.marca = dados.marca();
        }
        if(dados.modelo() != null) {
            this.modelo = dados.modelo();
        }
    }
}
