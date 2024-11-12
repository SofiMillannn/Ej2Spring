package examenej2.ej2.dao;

import examenej2.ej2.entity.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;


@RepositoryRestResource
public interface EntrenadorRepository extends JpaRepository<Entrenador,Long> {

    Optional<Entrenador> findByNombre(String nombre);


    boolean existsById(String nombre);
}
