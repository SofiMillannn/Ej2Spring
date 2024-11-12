package examenej2.ej2.service;

import examenej2.ej2.dao.AsociacionRepository;
import examenej2.ej2.entity.Asociacion;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AsociacionService {
    @Autowired
    private AsociacionRepository entrenadorRepository;
    public List<Asociacion> list(){
        return entrenadorRepository.findAll();
    }
    public Optional<Asociacion> getById(Long id){
        return entrenadorRepository.findById(id);
    }
    public Optional<Asociacion> getByNombre(String nombre){
        return entrenadorRepository.findByNombre(nombre);
    }
    
    public void save(Asociacion entrenador){
        entrenadorRepository.save(entrenador);
    }
    public  void delete(Long id){
        entrenadorRepository.deleteById(id);
    }
    public boolean existsByIdDorsal(long id){
        return entrenadorRepository.existsById(id);
        
    }  
    public boolean existsByNombre(String nombre){
        return entrenadorRepository.existsByNombre(nombre);
        
    }
    
}
