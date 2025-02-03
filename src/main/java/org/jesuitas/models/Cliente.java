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
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name="codigo")
    @NonNull private Integer codigo;
    @Column(name="nombre", nullable = false)
    @NonNull
    private String nombre;
    @Column(name="tlf", nullable = false)
    @NonNull
    private String tlf;
    @Column(name="direccion", nullable = false)
    @NonNull
    private String direccion;


    @ToString.Exclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Reserva> reservas;
}
