package examenej2.ej2.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "entrenador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dorsal")
    private Long dorsal;
    @Column(name = "dorsal")
    private String nombre;
    @Column(name = "dorsal")
    private String apellidos;
    @Column(name = "dorsal")
    private String tempActivo;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private Paloma paloma;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "asociacion_id", nullable = false)
    private Asociacion asociacion;

}
