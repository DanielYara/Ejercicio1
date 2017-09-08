/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parqueadero;
import becker.robots.*;

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
    private int[] x;
    private int[] y;

    public Parqueadero(String parqueadero) {
        this.parqueadero = parqueadero;
        this.seccion = new Seccion[3];
        for(int i = 0; i < 3; i++)
            this.seccion[i] = new Seccion(i+1);
        this.carro = new Carro[15];
        this.cantcarros = 0;
        this.placa = placa;
        this.x = new int[15];
        this.y = new int[15];
    }
    
    public void addCar(String placa, City b, int x, int y){
        if(this.cantcarros < 15){
            for (int i = 0; i < 3; i++) {
                if(this.seccion[i].agregCarro(placa, x, y) == true){
                    this.carro[cantcarros] = new Carro(placa);
                    this.x[cantcarros]=x;
                    this.y[cantcarros]=y;
                }
            }
        this.cantcarros++;
        } else
            this.placa = null;
    }
        
    public boolean quitCar(String placa, int seccion){
        boolean resp = false;
        for(int i = 0; i < 3; i++){
            if(this.seccion[i].sacarCarro(placa, seccion) == true)
                resp = true;
        }
        return resp;
    }
    
    public String searchSection(int seccion){
        String resultado = null;
        for(int i = 0; i < 3; i++){
            resultado = this.seccion[i].consSeccion(seccion);
        }
        return resultado;
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

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }
      
    
}
