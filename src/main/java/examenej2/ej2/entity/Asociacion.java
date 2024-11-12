package examenej2.ej2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "asociacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asociacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "antiguedad")
    private int antiguedad;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asociacion")
    @JsonIgnore
    private List<Entrenador> entrenadores;




}
