package com.ferchbo.fhbo.Controller;

import com.ferchbo.fhbo.Dto.DtoPersona;
import com.ferchbo.fhbo.Entity.Persona;
import com.ferchbo.fhbo.Security.Controller.Mensaje;
import com.ferchbo.fhbo.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
//@CrossOrigin(origins = "https://fhbofrontend.web.app ")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    ImpPersonaService iPService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = iPService.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!iPService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona per = iPService.getOne(id).get();
        return new ResponseEntity(per, HttpStatus.OK);
    }

   /* @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el ID
        if (!iPService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        iPService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion Eliminada"), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtoper) {

        if (StringUtils.isBlank(dtoper.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (iPService.existsByNombre(dtoper.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa Educacion existe"), HttpStatus.BAD_REQUEST);
        }

        Persona per = new Persona( dtoper.getNombre(), dtoper.getApellido());
        iPService.save(per);
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);

    }*/

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoper) {
        //Validamos si existe el ID
        if (!iPService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de Educacion
        if (iPService.existsByNombre(dtoper.getNombre()) && iPService.getByNombre(dtoper.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoper.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona per = iPService.getOne(id).get();
        
        per.setNombre(dtoper.getNombre());
        per.setApellido(dtoper.getApellido());
        per.setDescrip(dtoper.getDescrip());
        per.setImg(dtoper.getImg());
        iPService.save(per);
        return new ResponseEntity(new Mensaje("Persona Actualizada"), HttpStatus.OK);
    }
}
