/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferchbo.fhbo.Controller;

import com.ferchbo.fhbo.Dto.Dtohyskills;
import com.ferchbo.fhbo.Entity.hyskills;
import com.ferchbo.fhbo.Security.Controller.Mensaje;
import com.ferchbo.fhbo.Service.Shyskills;
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
@RequestMapping("/hyskills")
@CrossOrigin(origins = "https://fhbofrontend.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://localhost:4200")
public class Chyskills {

    @Autowired
    Shyskills shys;

    @GetMapping("/lista")
    public ResponseEntity<List<hyskills>> list() {
        List<hyskills> list = shys.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<hyskills> getById(@PathVariable("id") int id) {
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        hyskills hyskills = shys.getOne(id).get();
        return new ResponseEntity(hyskills, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el ID
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        shys.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad Eliminada"), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Dtohyskills dtohys) {

        if (StringUtils.isBlank(dtohys.getNomS())) {
            return new ResponseEntity(new Mensaje("El nombre de Habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (shys.existsByNomS(dtohys.getNomS())) {
            return new ResponseEntity(new Mensaje("Esa Habilidad existe"), HttpStatus.BAD_REQUEST);
        }

        hyskills hyskills = new hyskills(dtohys.getNomS(), dtohys.getPorS());
        shys.save(hyskills);
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Dtohyskills dtohys) {
        //Validamos si existe el ID
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de Educacion
        if (shys.existsByNomS(dtohys.getNomS()) && shys.getByNomS(dtohys.getNomS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohys.getNomS())) {
            return new ResponseEntity(new Mensaje("El nombre de Habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        hyskills hyskills = shys.getOne(id).get();
        hyskills.setNomS(dtohys.getNomS());
        hyskills.setPorS(dtohys.getPorS());
        shys.save(hyskills);
        return new ResponseEntity(new Mensaje("Habilidades actualizadas"), HttpStatus.OK);
    }

}
