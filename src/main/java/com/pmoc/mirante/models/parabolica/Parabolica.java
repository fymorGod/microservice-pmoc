package com.pmoc.mirante.models.parabolica;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;
import com.pmoc.mirante.models.receptor.ReceptorModel;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table(name = "PARABOLICA")
@Entity
@Getter
@Setter
public class Parabolica  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Embedded
    private Gerais gerais;
    @Column(nullable = false, length = 250)
    private Double diametro;
    @Column(nullable = false, length = 250)
    private String satelite;

    @OneToMany(mappedBy = "parabolica")
    private List<ReceptorModel> receptor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 250)
    private Categories category;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
