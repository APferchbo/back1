package com.ferchbo.fhbo.Service;

import com.ferchbo.fhbo.Entity.Persona;
import com.ferchbo.fhbo.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService {

    @Autowired
    IPersonaRepository ipR;

    public List<Persona> List() {
        return ipR.findAll();
    }
    public Optional<Persona> getOne(int id) {
        return ipR.findById(id);
    }
    public Optional<Persona> getByNombre(String nombre) {
        return ipR.findByNombre(nombre);
    }
    public void save(Persona per){
        ipR.save(per);
    }
    public void delete(int id){
        ipR.deleteById(id);
    }
    public boolean existsById(int id){
        return ipR.existsById(id);
    }
    public boolean existsByNombre(String nombre){
        return ipR.existsByNombre(nombre);
    }
}
