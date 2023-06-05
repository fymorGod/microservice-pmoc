package com.pmoc.mirante.models.station;

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

}
