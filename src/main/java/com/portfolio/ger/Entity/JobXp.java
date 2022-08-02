package com.portfolio.ger.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//Getter and Setters 
 @Getter @Setter
 
//Clase entidad con declaracion de variables
@Entity
public class JobXp {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    private String puestoE;
    private String anoE;
    private String empresaE;
    private String descripcionE;
            
    //Constructores

    public JobXp() {
    }

    public JobXp(String puestoE, String añoE, String empresaE, String descripcionE) {
        this.puestoE = puestoE;
        this.anoE = añoE;
        this.empresaE = empresaE;
        this.descripcionE = descripcionE;
    }

}
