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
public class Seccion {
    private int seccion;
    private Carro[] carros;
    private int cantidadcarros = 0;
    private Thing cosa;

    public Seccion(int seccion) {
        this.seccion = seccion;
        this.carros = new Carro[5];
        this.cosa = cosa;
    }
    
    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }
    
    public boolean addCarro(City n, String placa, int h){
        Carro carro = new Carro(placa, cosa);
        int d = 1;
        if(this.cantidadcarros < 5 || d < 6){
            this.cosa = new Thing(n, 1+d, h);
            d++;
            this.carros[this.cantidadcarros] = carro;
            this.cantidadcarros++;
            return true;
        }
        else
            return false;
    }
    
    //public Carro sacarAuto(String placa){
        
        
    //}

    public Carro[] getCarros() {
        return carros;
    }

    public void setCarros(Carro[] carros) {
        this.carros = carros;
    }

    public Thing getCosa() {
        return cosa;
    }

    public void setCosa(Thing cosa) {
        this.cosa = cosa;
    }

    
}
