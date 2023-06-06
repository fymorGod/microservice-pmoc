package com.pmoc.mirante.models.receptor;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;
import com.pmoc.mirante.models.parabolica.Parabolica;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "receptores")
@Entity(name = "Receptor")
@Getter
@Setter
public class ReceptorModel  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Embedded
    private Gerais gerais;
    @Column(nullable = false, length = 250)
    private int frequency;
    @Column(nullable = false, length = 250)
    private int symbol_rate;
    @ManyToOne
    @JoinColumn(name = "parabolica_id", nullable = false)
    private Parabolica parabolica;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 250)
    private Categories category;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
