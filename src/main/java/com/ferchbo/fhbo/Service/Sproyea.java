/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferchbo.fhbo.Service;

import com.ferchbo.fhbo.Entity.Proyea;
import com.ferchbo.fhbo.Repository.Rproyea;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Sproyea {

    @Autowired
    Rproyea rpr;

    public List<Proyea> List() {
        return rpr.findAll();
    }
    public Optional<Proyea> getOne(int id) {
        return rpr.findById(id);
    }
    public Optional<Proyea> getByNombreP(String nombreP) {
        return rpr.findByNombreP(nombreP);
    }
    public void save(Proyea proy){
        rpr.save(proy);
    }
    public void delete(int id){
        rpr.deleteById(id);
    }
    public boolean existsById(int id){
        return rpr.existsById(id);
    }
    public boolean existsByNombreP(String nombreP){
        return rpr.existsByNombreP(nombreP);
    }

    public boolean existsByNombre(String nombreP) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
