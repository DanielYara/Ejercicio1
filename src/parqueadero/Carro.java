/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero;
import becker.robots.*;
import java.util.*;

/**
 *
 * @author Daniel y Cielo
 */
public class Carro {
    private Calendar calendario = new GregorianCalendar();
    private String placa;
    private Thing h;
    private int hora;

    public Carro(String placa, Thing h) {
        this.placa = placa;
        this.h = h;
        this.hora = hora;
        this.calendario = calendario;
    }

    public Calendar getCalendario() {
        return calendario;
    }
    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Thing getH() {
        return h;
    }

    public void setH(Thing h) {
        this.h = h;
    }
    
    

    @Override
    public String toString() {
        return "Carro{" + "placa=" + placa + '}';
    }

    
    
    
}
