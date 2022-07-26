package com.portfolio.ger.Security.Controller;

import lombok.Getter;
import lombok.Setter;

//Getter y Setter
@Getter @Setter
public class Mensaje {
    private String mensaje;

    //Constructor
    public Mensaje() {
    }

    public Mensaje( String mensaje) {
        this.mensaje = mensaje;
    }
    
}
