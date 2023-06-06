package com.pmoc.mirante.models.cabo;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposCabo;
import com.pmoc.mirante.models.gerais.Gerais;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "CABO")
@Entity
@Getter
@Setter
public class CaboModel implements Serializable {
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
    private TiposCabo tipos_cabo;
    @Column(nullable = false)
    private Double tamanho;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
