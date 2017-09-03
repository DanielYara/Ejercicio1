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
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City sim = new City();
        Seccion seccion[] = new Seccion[3];
        crearParqueadero(sim);
        zonaTemporal(sim);
        Scanner k = new Scanner(System.in); int h = 0;
        Robot Auto = new Robot(sim, 5, 10, Direction.WEST);
        String placa = null;
        
      
        System.out.println("Bienvenido. Escoja una opción");
        int continuar = 1, opcion = 0;
        do{                
            System.out.println("1. Ingresar Vehiculo");
            System.out.println("2. Sacar Vehiculo");
            System.out.println("3. Mostrar Sección");
            System.out.println("4. Generar ingresos");
            opcion = k.nextInt();
            if(opcion == 1){
                System.out.println("Ingrese las placas del vehiculo");
                placa = k.next();
                int i = 1;
                boolean resultado = seccion[i-1].addCarro(sim, placa, i);
                if(resultado == true){
                    System.out.println("El carro fue parqueado.");  
                    fecha();
                } else if(resultado == false && i < 3){
                    i++;
                    seccion[i-1].addCarro(sim, placa, i);
                    fecha();
                } else
                    System.out.println("No hay cupos disponibles.");
            }
            else if (opcion == 2){
                System.out.println("Ingrese las placas del vehiculo: ");
                placa = k.next();
                //
            } 
            System.out.println("Presione un número diferente a 1 para salir.");
            continuar = k.nextInt();
            } while (continuar == 1);
        /*do{
            int i = 0;
            System.out.println("Ingrese las placas del vehiculo");
            if(i < 5){
               pl = k.next();
               placa.add(i, pl) = new Thing(Ejercicio1, 1+i, 1);
            }
            else if(i > 5 || i > 10){
               placa.add(i, pl) = new Thing(Ejercicio1, 1+i, 2);
            }
            else if(i > 10 || i < 15){
               placa.add(i, pl) = new Thing(Ejercicio1, 1+i, 3);  
            }
            i++;
        } while(placa.size() < 15);
    }*/
    }
    
public static void crearParqueadero(City name) {
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 5; i++) {
                Wall paredVertical = new Wall(name, 1 + i, 1 + k, Direction.WEST);
            }
        }
        for (int h = 0; h < 3; h++) {
            Wall paredNorte = new Wall(name, 1, 1 + h, Direction.NORTH);
        }
    }

    public static void zonaTemporal(City name) {
        for (int i = 0; i < 5; i++) {
            Wall zonatemporal = new Wall(name, 5, 5+i, Direction.NORTH);
        }
        Wall zonaTemporal1 = new Wall(name, 5, 5, Direction.WEST);
        Wall zonaTemporal2 = new Wall(name, 5, 9, Direction.EAST);
    }
    
    public static void fecha(){
        Calendar cal = new GregorianCalendar();
        int hora = 0, minutos = 0, segundos = 0;
        hora = cal.get(Calendar.HOUR_OF_DAY);
        minutos = cal.get(Calendar.MINUTE);
        segundos = cal.get(Calendar.SECOND);
        String hr = "La hora de ingreso es " + hora + ":" + minutos + ":" + segundos; 
    }

}
