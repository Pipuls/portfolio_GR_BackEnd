package com.portfolio.ger.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tituloE;
    private String institucionE;
    private String lugarE;
    private String anoE;
   

    public Educacion() {
    }

    public Educacion(String tituloE, String institucionE, String lugarE, String anoE) {
        this.tituloE = tituloE;
        this.institucionE = institucionE;
        this.lugarE = lugarE;
        this.anoE = anoE;
   }

}
