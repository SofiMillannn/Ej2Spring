package examenej2.ej2.dao;

import examenej2.ej2.entity.Asociacion;
import examenej2.ej2.entity.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;


@RepositoryRestResource
public interface AsociacionRepository extends JpaRepository<Asociacion,Long> {

    Optional<Asociacion> findByNombre(String nombre);


    boolean existsByNombre(String nombre);
}
