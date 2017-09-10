/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parqueadero;
import java.util.*;

/**
 *
 * @author Daniel y Cielo
 */ 
public class Parqueadero {
    private String parqueadero;
    private Seccion[] seccion;
    private Carro[] carro;
    private int cantcarros;
    private String placa;

    public Parqueadero(String parqueadero) {
        this.parqueadero = parqueadero;
        this.seccion = new Seccion[3];
        for(int i = 0; i < 3; i++)
            this.seccion[i] = new Seccion(i+1);
        this.carro = new Carro[15];
        this.cantcarros = 0;
        this.placa = placa;
    }
    
    public void addCar(String placa, Calendar c){
        if(this.cantcarros < 15){
            for (int i = 0; i < 3; i++) {
                if(this.seccion[i].agregCarro(placa) == true){
                    this.carro[cantcarros] = new Carro(placa, c);
                }
            }
        this.cantcarros++;
        } else
            this.placa = null;
    }
    
    private String encontrarCarro(String placa){
        String str = new String();
        for(int i = 0; i < 3; i++){
            for(int k = 0; k < 5; k++){
                if(placa.equals(this.seccion[i].getCarro()[k])){
                    str = String.valueOf(i) + " " +  String.valueOf(k);
                }
            }
        }
        return str;
    }
    
    public boolean quitCar(String placa, int seccion){
        Seccion aux;
        boolean resp = false;
        String s = encontrarCarro(placa);
        String[] a = s.split(" ");
        int y = Integer.parseInt(a[0]);
        int x = Integer.parseInt(a[1]);
        if(s != null && this.seccion[y].getSeccion() == seccion){
           aux = this.seccion[y];
           if(x == 4 || aux.getCantidadcarros() == (x - 1))
               aux.getCarro()[x] = null;
           else{
               aux.getCarro()[x] = null;
               while((x+1) < aux.getCantidadcarros()){
                   aux.getCarro()[x+1] = aux.getCarro()[x];
               }
           }
           resp = true;
        }
        else
            resp = false;
        return resp;
    }
    
    
    public String searchSection(int seccion){
        String resultado = null;
        for(int i = 0; i < 3; i++){
            resultado = this.seccion[i].consSeccion(seccion);
        }
        return resultado;
    }
    
    public Calendar horaEntrada(String placa){
        Calendar dev = null;
        for(int i = 0; i < 15; i++){
            if(placa.equals(this.carro[i].getPlaca()))
                dev = this.carro[i].getCalendario();
        }
        return dev;
    }
    
    public Seccion[] getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion[] seccion) {
        this.seccion = seccion;
    }

    public int getCantcarros() {
        return cantcarros;
    }

    public void setCantcarros(int cantcarros) {
        this.cantcarros = cantcarros;
    }
    
    public Carro[] getCarro() {
        return carro;
    }

    public void setCarro(Carro[] carro) {
        this.carro = carro;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
}
