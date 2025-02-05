/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferchbo.fhbo.Controller;

import com.ferchbo.fhbo.Dto.DtoEducacion;
import com.ferchbo.fhbo.Entity.Educacion;
import com.ferchbo.fhbo.Security.Controller.Mensaje;
import com.ferchbo.fhbo.Service.SEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://apfer-97a3a.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el ID
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion Eliminada"), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoedu) {

        if (StringUtils.isBlank(dtoedu.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sEducacion.existsByNombreE(dtoedu.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa Educacion existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoedu.getNombreE(), dtoedu.getDescripcionE());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoedu) {
        //Validamos si existe el ID
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de Educacion
        if (sEducacion.existsByNombreE(dtoedu.getNombreE()) && sEducacion.getByNombreE(dtoedu.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoedu.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreE(dtoedu.getNombreE());
        educacion.setDescripcionE(dtoedu.getDescripcionE());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion Actualizada"), HttpStatus.OK);
    }
}
