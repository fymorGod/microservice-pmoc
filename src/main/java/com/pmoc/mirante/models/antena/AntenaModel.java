package com.pmoc.mirante.models.antena;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposAntena;
import com.pmoc.mirante.models.gerais.Gerais;
import com.pmoc.mirante.models.station.StationModel;
import com.pmoc.mirante.models.transmissor.TransmissorModel;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table(name = "antena")
@Entity
@Getter
@Setter
public class AntenaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Embedded
    private Gerais gerais;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 250)
    private Categories category;
    @Column(nullable = false, length = 250)
    private String gain;
    @Column(nullable = false, length = 100)
    private Double fendas;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 80)
    private TiposAntena tiposAntena;
    @Column(nullable = false, length = 120)
    private Double posicao_torre;
    @Column(nullable = false, length = 120)
    private String vr;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private StationModel station;

}
