package com.ferchbo.fhbo.Service;

import com.ferchbo.fhbo.Entity.Hyskills;
import com.ferchbo.fhbo.Repository.Rhyskills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Shyskills {

    @Autowired

    Rhyskills rhys;

    public List<Hyskills> List() {
        return rhys.findAll();
    }
    public Optional<Hyskills> getOne(int id) {
        return rhys.findById(id);
    }
    public Optional<Hyskills> getByNomSH(String nomSH) {
        return rhys.findByNomSH(nomSH);
    }
    public void save(Hyskills skill){
        rhys.save(skill);
    }
    public void delete(int id){
        rhys.deleteById(id);
    }
    public boolean existsById(int id){
        return rhys.existsById(id);
    }
    public boolean existsByNomSH(String nomSH){
        return rhys.existsByNomSH(nomSH);
    } 
}
