/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferchbo.fhbo.Controller;

import com.ferchbo.fhbo.Dto.Dtoproyea;
import com.ferchbo.fhbo.Entity.Proyea;
import com.ferchbo.fhbo.Security.Controller.Mensaje;
import com.ferchbo.fhbo.Service.Sproyea;
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
@RequestMapping("/proyea")
@CrossOrigin(origins = "https://fhbofrontend.web.app , http://localhost:4200")
public class Cproyea {

    @Autowired
    Sproyea spro;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyea>> list() {
        List<Proyea> list = spro.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyea> getById(@PathVariable("id") int id) {
        if (!spro.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyea per = spro.getOne(id).get();
        return new ResponseEntity(per, HttpStatus.OK);
    }

   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el ID
        if (!spro.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        spro.delete(id);
        return new ResponseEntity(new Mensaje("Educacion Eliminada"), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Dtoproyea dtopro) {

        if (StringUtils.isBlank(dtopro.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (spro.existsByNombreP(dtopro.getNombreP())) {
            return new ResponseEntity(new Mensaje("Esa Educacion existe"), HttpStatus.BAD_REQUEST);
        }

        Proyea pro = new Proyea( dtopro.getNombreP(), dtopro.getUrlP(), dtopro.getDescripP(), dtopro.getImgP());
        spro.save(pro);
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Dtoproyea dtopro) {
        //Validamos si existe el ID
        if (!spro.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de Educacion
        if (spro.existsByNombre(dtopro.getNombreP()) && spro.getByNombreP(dtopro.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtopro.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyea pro = spro.getOne(id).get();
        
        pro.setNombreP(dtopro.getNombreP());
        pro.setUrlP(dtopro.getUrlP());
        pro.setDescripP(dtopro.getDescripP());
        pro.setImgP(dtopro.getImgP());
        spro.save(pro);
        return new ResponseEntity(new Mensaje("Proyea Actualizada"), HttpStatus.OK);
    }
}
