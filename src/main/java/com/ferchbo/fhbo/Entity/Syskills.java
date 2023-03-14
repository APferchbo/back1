
package com.ferchbo.fhbo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Syskills {
    
   @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nomSS;
    private int porSS;
    private String imgSS;
    
    
    //Contructores

    public Syskills() {
    }

    public Syskills(String nomSS, int porSS, String imgSS) {
        this.nomSS = nomSS;
        this.porSS = porSS;
        this.imgSS = imgSS;
    }

// Getters and getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomSS() {
        return nomSS;
    }

    public void setNomSS(String nomSS) {
        this.nomSS = nomSS;
    }

    public int getPorSS() {
        return porSS;
    }

    public void setPorSS(int porSS) {
        this.porSS = porSS;
    }

    public String getImgSS() {
        return imgSS;
    }

    public void setImgSS(String imgSS) {
        this.imgSS = imgSS;
    }
    
    
}
