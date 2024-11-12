package examenej2.ej2.service;

import examenej2.ej2.dao.EntrenadorRepository;
import examenej2.ej2.entity.Entrenador;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntrenadorService {
    @Autowired
    private EntrenadorRepository entrenadorRepository;
    public List<Entrenador> list(){
        return entrenadorRepository.findAll();
    }
    public Optional<Entrenador> getById(Long dorsal){
        return entrenadorRepository.findById(dorsal);
    }
    public Optional<Entrenador> getByNombre(String nombre){
        return entrenadorRepository.findByNombre(nombre);
    }

    public void save(Entrenador entrenador){
        entrenadorRepository.save(entrenador);
    }
    public  void delete(Long dorsal){
        entrenadorRepository.deleteById(dorsal);
    }
    public boolean existsByIdDorsal(long dorsal){
        return entrenadorRepository.existsById(dorsal);

    }
    public boolean existsByNombreDorsal(String nombre){
        return entrenadorRepository.existsByNombre(nombre);

    }

}
