/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferchbo.fhbo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Proyea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    
    @NotNull
    @Size(min = 1, max = 100, message = "No cumple con la longitud")
    private String nombreP;
    
    @NotNull
    private String urlP;
    
    @NotNull
    private String descripP;
    
    private String imgP;
    
    //constructor

    public Proyea(String nombreP1, String urlP1, String descripP1, String imgP1) {
    }

    public Proyea(int Id, String nombreP, String urlP, String descripP, String imgP) {
        this.nombreP = nombreP;
        this.urlP = urlP;
        this.descripP = descripP;
        this.imgP = imgP;
    }
    
    //getters and setters

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getUrlP() {
        return urlP;
    }

    public void setUrlP(String urlP) {
        this.urlP = urlP;
    }

    public String getDescripP() {
        return descripP;
    }

    public void setDescripP(String descripP) {
        this.descripP = descripP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }
    
    
}
