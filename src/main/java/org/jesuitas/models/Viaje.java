package org.jesuitas.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "viaje")
public class Viaje {
    @Id
    @Column(name="codigo")
    @NonNull private Integer codigo;
    @Column(name="nombre", nullable = false)
    @NonNull
    private String nombre;
    @Column(name="precio", nullable = false)
    @NonNull
    private Float precio;
    @Column(name="plazas", nullable = false)
    @NonNull
    private Integer plazas;
    @Column(name="fechaInicio", nullable = false)
    @NonNull
    private Date fechaInicio;
    @Column(name="fechaFin", nullable = false)
    @NonNull
    private Date fechaFin;



    @ToString.Exclude
    @OneToMany(mappedBy = "viaje")
    private Set<Reserva> reservas;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="codigo_catalogo")
    private Catalogo catalogo;

}
