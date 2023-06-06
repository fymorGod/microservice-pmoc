package com.pmoc.mirante.models.dps;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.ClasseDPS;
import com.pmoc.mirante.models.gerais.Gerais;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "DPS")
@Entity
@Getter
@Setter
public class DPSModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Embedded
    private Gerais gerais;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private Categories category;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private ClasseDPS classe;
    @Column(nullable = false, length = 100)
    private int corrente_maxima;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
