package com.pmoc.mirante.models.torre;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposTorre;
import com.pmoc.mirante.models.gerais.Gerais;
import com.pmoc.mirante.models.station.StationModel;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "torre")
@Entity
@Getter
@Setter
public class TorreModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Embedded
    private Gerais gerais;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 250)
    private Categories category;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 250)
    private TiposTorre tipos_estrutura;
    @Column(nullable = false)
    private Boolean aterramento;
    @Column(nullable = false, length = 250)
    private Double altura;
    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private StationModel station;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
