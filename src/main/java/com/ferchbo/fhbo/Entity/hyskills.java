/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferchbo.fhbo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Hyskills {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nomSH;
    private int porSH;
    private String imgSH;
    
    //Contructores

    public Hyskills() {
    }

    public Hyskills(String nomSH, int porSH, String imgSH) {
        this.nomSH = nomSH;
        this.porSH = porSH;
        this.imgSH = imgSH;
    }

   

    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomSH() {
        return nomSH;
    }

    public void setNomSH(String nomSH) {
        this.nomSH = nomSH;
    }

    public int getPorSH() {
        return porSH;
    }

    public void setPorSH(int porSH) {
        this.porSH = porSH;
    }

    public String getImgSH() {
        return imgSH;
    }

    public void setImgSH(String imgSH) {
        this.imgSH = imgSH;
    }
    
    
}

