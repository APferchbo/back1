/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferchbo.fhbo.Controller;

import com.ferchbo.fhbo.Dto.Dtosyskills;
import com.ferchbo.fhbo.Entity.Syskills;
import com.ferchbo.fhbo.Security.Controller.Mensaje;
import com.ferchbo.fhbo.Service.Ssyskills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Syskills")
//@CrossOrigin(origins = "https://fhbofrontend.web.app ")
@CrossOrigin(origins = "http://localhost:4200")
public class Csyskills {

    @Autowired
    Ssyskills ssys;

    @GetMapping("/lista")
    public ResponseEntity<List<Syskills>> list() {
        List<Syskills> list = ssys.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Syskills> getById(@PathVariable("id") int id) {
        if (!ssys.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Syskills syskills = ssys.getOne(id).get();
        return new ResponseEntity(syskills, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el ID
        if (!ssys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        ssys.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad Eliminada"), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Dtosyskills dtosys) {

        if (StringUtils.isBlank(dtosys.getNomSS())) {
            return new ResponseEntity(new Mensaje("El nombre de Habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (ssys.existsByNomSS(dtosys.getNomSS())) {
            return new ResponseEntity(new Mensaje("Esa Habilidad existe"), HttpStatus.BAD_REQUEST);
        }

        Syskills syskills = new Syskills(dtosys.getNomSS(), dtosys.getPorSS(), dtosys.getImgSS());
        ssys.save(syskills);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Dtosyskills dtosys) {
        //Validamos si existe el ID
        if (!ssys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de Educacion
        if (ssys.existsByNomSS(dtosys.getNomSS()) && ssys.getByNomSS(dtosys.getNomSS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtosys.getNomSS())) {
            return new ResponseEntity(new Mensaje("El nombre de Habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Syskills syskills = ssys.getOne(id).get();
        syskills.setNomSS(dtosys.getNomSS());
        syskills.setPorSS(dtosys.getPorSS());
        ssys.save(syskills);
        return new ResponseEntity(new Mensaje("Habilidades actualizadas"), HttpStatus.OK);
    }

}