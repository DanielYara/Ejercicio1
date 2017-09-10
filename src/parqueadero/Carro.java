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

    public Carro(String placa, Calendar calendario) {
        this.placa = placa;
        this.calendario = calendario;
    }
    

    public Calendar getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendar calendario) {
        this.calendario = calendario;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

//    
//
//    @Override
//    public String toString() {
//        return "Carro{" + "placa=" + placa + '}';
//    }

}