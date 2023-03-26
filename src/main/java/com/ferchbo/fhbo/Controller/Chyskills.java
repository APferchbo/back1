/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferchbo.fhbo.Controller;

import com.ferchbo.fhbo.Dto.Dtohyskills;
import com.ferchbo.fhbo.Entity.Hyskills;
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
//@CrossOrigin(origins = "https://fhbofrontend.web.app ")
@CrossOrigin(origins = "http://localhost:4200")
public class Chyskills {

    @Autowired
    Shyskills shys;

    @GetMapping("/lista")
    public ResponseEntity<List<Hyskills>> list() {
        List<Hyskills> list = shys.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Hyskills> getById(@PathVariable("id") int id) {
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Hyskills hyskills = shys.getOne(id).get();
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

        if (StringUtils.isBlank(dtohys.getNomSH())) {
            return new ResponseEntity(new Mensaje("El nombre de Habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (shys.existsByNomSH(dtohys.getNomSH())) {
            return new ResponseEntity(new Mensaje("Esa Habilidad existe"), HttpStatus.BAD_REQUEST);
        }

        Hyskills hyskills = new Hyskills(dtohys.getNomSH(), dtohys.getPorSH(), dtohys.getImg());
        shys.save(hyskills);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Dtohyskills dtohys) {
        //Validamos si existe el ID
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de Educacion
        if (shys.existsByNomSH(dtohys.getNomSH()) && shys.getByNomSH(dtohys.getNomSH()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohys.getNomSH())) {
            return new ResponseEntity(new Mensaje("El nombre de Habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Hyskills hyskills = shys.getOne(id).get();
        hyskills.setNomSH(dtohys.getNomSH());
        hyskills.setPorSH(dtohys.getPorSH());
        hyskills.setImg(dtohys.getImg());
        shys.save(hyskills);
        return new ResponseEntity(new Mensaje("Habilidades actualizadas"), HttpStatus.OK);
    }

}
