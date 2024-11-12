package examenej2.ej2.service;

import examenej2.ej2.dao.PalomaRepository;
import examenej2.ej2.entity.Paloma;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PalomaService {
    @Autowired
    private PalomaRepository palomaRepository;
    public List<Paloma> list(){
        return palomaRepository.findAll();
    }
    public Optional<Paloma> getById(Long dorsal){
        return palomaRepository.findById(dorsal);
    }
    public Optional<Paloma> getByApodo(String apodo){
        return palomaRepository.findByApodo(apodo);
    }

    public void save(Paloma paloma){
        palomaRepository.save(paloma);
    }
    public  void delete(Long dorsal){
        palomaRepository.deleteById(dorsal);
    }
    public boolean existsByIdDorsal(long dorsal){
        return palomaRepository.existsById(dorsal);

    }
    public boolean existsByApodoDorsal(String apodo){
        return palomaRepository.existsByApodo(apodo);

    }

}
