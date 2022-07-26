package com.portfolio.ger.Security.Controller;

public class Mensaje {
    private String mensaje;

    //Constructor
    public Mensaje() {
    }

    public Mensaje( String mensaje) {
        this.mensaje = mensaje;
    }
    
    //geter and seter

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
