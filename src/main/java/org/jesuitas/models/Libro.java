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
@Table(name = "libro")
public class Libro {
    @Id
    @Column(name="codigo")
    @NonNull private String codigo;
    @Column(name="titulo", nullable = false)
    @NonNull
    private String titulo;
    @Column(name="editorial", nullable = false)
    @NonNull
    private String editorial;
    @Column(name="anoEdicion", nullable = false)
    @NonNull
    private Integer anoEdicion;
    @Column(name="numeroPaginas", nullable = false)
    @NonNull
    private Integer numeroPaginas;

    @ToString.Exclude
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Prestamo> prestamos;
}
