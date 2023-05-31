package com.pmoc.mirante.models.secao;

import com.pmoc.mirante.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "STATION")
@Entity
@Getter
@Setter
public class StationModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 130)
    private String latitude;
    @Column(nullable = false, length = 130)
    private String longitude;
    @Column(nullable = false, length = 100)
    private Double endereco;
    @Column(nullable = false, length = 250)
    private String link_grafana;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Status status;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
//    public Secao(SecaoDTO data) {
//        this.nome = data.nome();
//        this.endereco = data.endereco();
//        this.latitude = data.latitude();
//        this.longitude = data.longitude();
//        this.link_grafana = data.link_grafana();
//        this.status = data.status();
//    }
//    public void updateInfo(DataUpdatingSecao data) {
//        if(data.endereco() != null){
//            this.endereco = data.endereco();
//        }
//        if(data.nome() != null){
//            this.nome = data.nome();
//        }
//        if(data.link_grafana() != null){
//            this.link_grafana = data.link_grafana();
//        }
//        if(data.longitude() != null){
//            this.longitude = data.longitude();
//        }
//        if(data.latitude() != null){
//            this.latitude = data.latitude();
//        }
//        if(data.status() != null){
//            this.status = data.status();
//        }
//    }
}
