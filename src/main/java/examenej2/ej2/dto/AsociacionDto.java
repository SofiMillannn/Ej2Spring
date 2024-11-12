package examenej2.ej2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
public class AsociacionDto {
    @NotBlank
    private String nombre;
    private int antiguedad;

}
