package examenej2.ej2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "paloma")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paloma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dorsal")
    private Long dorsal;
    @Column(name = "apodo")
    private String apodo;
    @Column(name = "edad")
    private int edad;


    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonBackReference
    private Entrenador entrenador;



}
