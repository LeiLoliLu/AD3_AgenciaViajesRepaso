package org.jesuitas.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="numero")
    @NonNull private Integer numero;
    @Column(name="estado", nullable = false)
    @NonNull
    private String estado;

    @ManyToOne
    @JoinColumn(name="codigo_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="codigo_viaje")
    private Viaje viaje;
}
