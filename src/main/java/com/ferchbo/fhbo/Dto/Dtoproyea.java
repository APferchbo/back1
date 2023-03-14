
package com.ferchbo.fhbo.Dto;

import javax.validation.constraints.NotBlank;


public class Dtoproyea {
        
    @NotBlank
    private String nombreP;
    @NotBlank
    private String urlP;
    @NotBlank
    private String descripP;
    @NotBlank
    private String imgP;
    
    //constructor

    public Dtoproyea() {
    }

    public Dtoproyea(String nombreP, String urlP, String descripP, String imgP) {
        this.nombreP = nombreP;
        this.urlP = urlP;
        this.descripP = descripP;
        this.imgP = imgP;
    }
    
        
// Getters and setters 

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
