package com.ferchbo.fhbo.Dto;

import javax.validation.constraints.NotBlank;


public class DtoPersona {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String descrip;
    @NotBlank
    private String img;

    //constructor

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String descrip, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descrip = descrip;
        this.img = img;
    }
    //GYS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    

}
