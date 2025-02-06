package org.jesuitas.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "catalogo")
public class Catalogo {
    @Id
    @Column(name="codigo")
    @NonNull private Integer codigo;
    @Column(name="destino", nullable = false)
    @NonNull
    private String destino;
    @Column(name="procedencia", nullable = false)
    @NonNull
    private String procedencia;
    @Column(name="temporada", nullable = false)
    @NonNull
    private String temporada;
    @Column(name="precio", nullable = false)
    @NonNull
    private float precio;



    @ToString.Exclude
    @OneToMany(mappedBy = "catalogo")
    private Set<Viaje> viajes;
}
