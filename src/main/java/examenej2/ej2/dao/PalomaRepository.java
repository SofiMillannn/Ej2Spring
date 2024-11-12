package examenej2.ej2.dao;

import examenej2.ej2.entity.Entrenador;
import examenej2.ej2.entity.Paloma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;


@RepositoryRestResource
public interface PalomaRepository extends JpaRepository<Paloma,Long> {

    Optional<Paloma> findByApodo(String apodo);


    boolean existsByApodo(String apodo);
}
