package com.pmoc.mirante.models.transmissor;

import com.pmoc.mirante.models.antena.AntenaModel;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;
import com.pmoc.mirante.models.receptor.ReceptorModel;
import com.pmoc.mirante.models.station.StationModel;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "transmissor")
@Entity
@Getter
@Setter
public class TransmissorModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Embedded
    private Gerais gerais;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 130)
    private Categories category;
    @Column(nullable = false, length = 130)
    private Double programmed;
    @Column(nullable = false, length = 130)
    private Double canal_fisico;
    @Column(nullable = false, length = 130)
    private Double canal_virtual;

    @OneToOne(cascade = CascadeType.ALL)
    private ReceptorModel receptor;
    @ManyToOne
    @JoinColumn(name = "antena_id", nullable = false)
    private AntenaModel antena;
    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private StationModel station;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
