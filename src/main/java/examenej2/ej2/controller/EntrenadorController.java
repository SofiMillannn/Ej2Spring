package examenej2.ej2.controller;

import examenej2.ej2.dto.EntrenadorDto;
import examenej2.ej2.dto.Mensaje;
import examenej2.ej2.entity.Asociacion;
import examenej2.ej2.entity.Entrenador;
import examenej2.ej2.entity.Paloma;
import examenej2.ej2.service.AsociacionService;
import examenej2.ej2.service.EntrenadorService;
import examenej2.ej2.service.PalomaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/colombaire/entrenador")
@CrossOrigin("*")
public class EntrenadorController {
    @Autowired
    private EntrenadorService entrenadorService;
    @Autowired
    private AsociacionService asociacionService;
    @Autowired
    private PalomaService palomaService;
    @GetMapping("/listado")
    public ResponseEntity<List<Entrenador>> list() {
        List<Entrenador> entrenadores = entrenadorService.list();
        return new ResponseEntity<>(entrenadores, HttpStatus.OK);
    }
    @GetMapping("detalleDorsal/{dorsal}")
    public ResponseEntity<?> getByDorsal(@PathVariable("dorsal") long dorsal){
        if (!asociacionService.existsByIdDorsal(dorsal)){
            return new ResponseEntity<>(
                    new Mensaje("No existe un entrenador con ese id"),
                    HttpStatus.NOT_FOUND);


        }
        if (entrenadorService.getById(dorsal).isPresent()){
            Entrenador entrenador = entrenadorService.getById(dorsal).get();
            return new ResponseEntity<>(entrenador, HttpStatus.OK);
        }
        return new ResponseEntity<>(
                new Mensaje("No existe un entrenador con ese id."),
                HttpStatus.NOT_FOUND
        );
    }
    @GetMapping("detalleNombre/{nombre}")
    public ResponseEntity<?> getByDorsal(@PathVariable("nombre") String nombre){
        if (!asociacionService.existsByNombre(nombre)){
            return new ResponseEntity<>(
                    new Mensaje("No existe un entrenador con ese id"),
                    HttpStatus.NOT_FOUND);


        }
        if (entrenadorService.getByNombre(nombre).isPresent()){
            Entrenador entrenador = entrenadorService.getByNombre(nombre).get();
            return new ResponseEntity<>(entrenador, HttpStatus.OK);
        }
        return new ResponseEntity<>(
                new Mensaje("No existe un entrenador con ese id."),
                HttpStatus.NOT_FOUND);
    }
    @PostMapping("/crear")
    public ResponseEntity<?> crear(
            @RequestBody EntrenadorDto entrenadorDto
            ){
        if (StringUtils.isBlank(entrenadorDto.getNombre())){
            new ResponseEntity<>(
                    new Mensaje("El nombre del entrenador es obligatorio"),
                    HttpStatus.BAD_REQUEST
            );
        }
        if (entrenadorService.existsByNombreDorsal(entrenadorDto.getNombre())){
            new ResponseEntity<>(
                    new Mensaje("El nombre del entrenador ya existe"),
                    HttpStatus.BAD_REQUEST
            );
        }
        Entrenador entrenador = new Entrenador();
        entrenador.setNombre(entrenadorDto.getNombre());
        entrenador.setApellidos(entrenadorDto.getApellido());
        entrenador.setTempActivo(entrenadorDto.getTempActivo());
        if (palomaService.existsByApodoDorsal(entrenadorDto.getPaloma().getApodo())){
            new ResponseEntity<>(
                    new Mensaje("El apodo de la paloma ya existe"),
                    HttpStatus.BAD_REQUEST
            );
        }
        //Relacion 1 a 1
        Paloma paloma = new Paloma();
        paloma.setApodo(entrenadorDto.getPaloma().getApodo());
        paloma.setEdad(entrenadorDto.getPaloma().getEdad());
        paloma.setEntrenador(entrenador);
        entrenador.setPaloma(paloma);
        //Relacion 1 a N
        Asociacion asociacion;
        if (asociacionService.getByNombre(entrenadorDto.getAsociacion().getNombre()).isPresent()){
            asociacion = asociacionService.getByNombre(
                    entrenadorDto.getAsociacion().getNombre()).get();

        }else {
            asociacion = new Asociacion();
            if (StringUtils.isBlank(entrenadorDto.getAsociacion().getNombre())){
                return new ResponseEntity<>(
                        new Mensaje("El nombre de la asociacion es obligatorio"),HttpStatus.BAD_REQUEST);
            }
            asociacion.setNombre(
                    entrenadorDto.getAsociacion().getNombre()
            );
            asociacion.setAntiguedad(
                    entrenadorDto.getAsociacion().getAntiguedad()
            );
            asociacion.setEntrenadores(new ArrayList<>());
        }
        asociacion.getEntrenadores().add(entrenador);
        entrenador.setAsociacion(asociacion);
        asociacionService.save(asociacion);
        return new ResponseEntity<>(
                new Mensaje("Entrenador creado."), (HttpStatus.CREATED)
        );
    }
    @DeleteMapping("/borrar/{dorsal}")
    public ResponseEntity<?> delete(
            @PathVariable("dorsal") long dorsal){
        return new ResponseEntity<>(
                new Mensaje("Entrenador borrado"),
                HttpStatus.OK
        );
    }
    
}
