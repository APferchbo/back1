package com.ferchbo.fhbo.Service;

import com.ferchbo.fhbo.Entity.hyskills;
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

    public List<hyskills> List() {
        return rhys.findAll();
    }
    public Optional<hyskills> getOne(int id) {
        return rhys.findById(id);
    }
    public Optional<hyskills> getByNomS(String nomS) {
        return rhys.findByNomS(nomS);
    }
    public void save(hyskills skill){
        rhys.save(skill);
    }
    public void delete(int id){
        rhys.deleteById(id);
    }
    public boolean existsById(int id){
        return rhys.existsById(id);
    }
    public boolean existsByNomS(String nomS){
        return rhys.existsByNomS(nomS);
    } 
}
