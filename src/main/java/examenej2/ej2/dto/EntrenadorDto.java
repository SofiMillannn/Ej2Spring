package examenej2.ej2.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class EntrenadorDto {
    @NotBlank
    private String nombre;
    private String apellido;
    private int tempActivo;
    private PalomaDto paloma;
    private AsociacionDto asociacion;
}
