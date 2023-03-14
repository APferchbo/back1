
package com.ferchbo.fhbo.Service;

import com.ferchbo.fhbo.Entity.Syskills;
import com.ferchbo.fhbo.Repository.Rsyskills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Ssyskills {

    @Autowired

    Rsyskills rsys;

    public List<Syskills> List() {
        return rsys.findAll();
    }
    public Optional<Syskills> getOne(int id) {
        return rsys.findById(id);
    }
    public Optional<Syskills> getByNomSS(String nomSS) {
        return rsys.findByNomSS(nomSS);
    }
    public void save(Syskills skill){
        rsys.save(skill);
    }
    public void delete(int id){
        rsys.deleteById(id);
    }
    public boolean existsById(int id){
        return rsys.existsById(id);
    }
    public boolean existsByNomSS(String nomSS){
        return rsys.existsByNomSS(nomSS);
    }
    
}
