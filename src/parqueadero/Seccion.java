/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero;

/**
 *
 * @author Daniel y Cielo
 */
public class Seccion {
    private int seccion;
    private String[] carro;
//    private int[] avenue;
//    private int[] street;
    private int cantidadcarros;

    public Seccion(int seccion) {
        this.seccion = seccion;
        this.carro = new String[5];
//        this.avenue = new int[5];
//        this.street = new int[5];
        this.cantidadcarros = 0;
    }
    
    public boolean agregCarro(String placa){
        if(this.cantidadcarros < 5){
            this.carro[this.cantidadcarros] = placa;
//            this.street[this.cantidadcarros] = x;
//            this.avenue[this.cantidadcarros] = y;
            this.cantidadcarros++;
            return true;
        }
        else
            return false;
    }
    
    public String consSeccion(int seccion){
        String h = null;
        if(seccion == this.seccion){
            for(int i = 0; i < this.cantidadcarros; i++)
                h = (i+1) + this.carro[i];
        }
        else
            h = "No hay carros en esta seccion";
        return h;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }
    

    public String[] getCarro() {
        return carro;
    }

    public void setCarro(String[] carro) {
        this.carro = carro;
    }

    public int getCantidadcarros() {
        return cantidadcarros;
    }

    public void setCantidadcarros(int cantidadcarros) {
        this.cantidadcarros = cantidadcarros;
    }

    
}
