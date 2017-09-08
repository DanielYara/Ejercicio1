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
        Parqueadero parqueadero = new Parqueadero("L");
        crearParqueadero(sim);
        zonaTemporal(sim);
        Scanner k = new Scanner(System.in); 
        Robot Auto = new Robot(sim, 5, 10, Direction.WEST);
        
      
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
                    String placa1 = k.next();
                    if(parqueadero.getCantcarros() < 15){
                        int x = 1;
                            for(int y = 1; y <= 5; y++){
                                karelUbica1(Auto, placa1, sim, parqueadero, x, y);
                                parqueadero.addCar(placa1, sim, x, y);
                                System.out.println("El carro fue parqueado.");
                                System.err.println(fecha());
                                if(y == 5)
                                    x++;
                                else
                                    break;
                            }
                    } else
                        System.out.println("No hay cupos disponibles.");
                 
            } else if(opcion == 2){
                    System.out.println("Ingrese las placas del vehiculo: ");
                    String placa2 = k.next();
                    System.out.println("Ingrese la sección del vehiculo: ");
                    int z = k.nextInt();
                    int x1 = 0;
                    if(parqueadero.quitCar(placa2, z)){
                        System.out.println("El carro fue sacado exitosamente.");
                        System.out.println(Salida());
                        System.out.println("Su cobro es de ");
                    }else
                        System.out.println("El carro no se encuentra.");
                    
            } else if(opcion == 3){
                    System.out.println("Ingrese la sección a consultar(hasta 3): ");
                    int z1 = k.nextInt();
                    if(z1 > 0 && z1 < 4){
                        String cons = parqueadero.searchSection(z1);
                        System.out.println(cons);
                    } else
                        System.out.println("El número de seccion esta equivocado");
                    
            } else if(opcion == 4);
            else {
                System.out.println("Presione un número diferente a 1 para salir."); 
            }
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
    
    public static String fecha(){
        Calendar cal = new GregorianCalendar();
        int hora = 0, minutos = 0, segundos = 0;
        hora = cal.get(Calendar.HOUR_OF_DAY);
        minutos = cal.get(Calendar.MINUTE);
        segundos = cal.get(Calendar.SECOND);
        horaSalida(80, hora, minutos, segundos);
        String hr = "La hora de ingreso es " + hora + ":" + minutos + ":" + segundos; 
        return hr;
    }
    
    public static int[] karelUbica1(Robot Auto, String placa, City name, Parqueadero parqueadero, int x, int y){
        Thing s = new Thing(name, 6, 10);
            if (Auto.frontIsClear()) {
                Auto.move();
            } else {
                Auto.turnLeft();
            }
            Auto.move();
            Auto.pickThing();
            while (Auto.getDirection() != Direction.WEST) {
                Auto.turnLeft();
            }
            do {
                Auto.move();
                if (Auto.getAvenue() == (x)) {
                    while (Auto.getDirection() != Direction.NORTH) {
                        Auto.turnLeft();
                    }
                    Auto.move();
                }
            } while ((Auto.getStreet() != (y)));
            Auto.putThing();
            x = Auto.getStreet();
            y = Auto.getAvenue();
            while (Auto.getDirection() != Direction.SOUTH) {
                Auto.turnLeft();
            }
            do {
                Auto.move();
                if (Auto.getStreet() == 6) {
                    while (Auto.getDirection() != Direction.EAST) {
                        Auto.turnLeft();
                    }
                    Auto.move();
                }
            } while ((Auto.getAvenue() != 10));
            Auto.turnLeft();
            Auto.move();
            Auto.turnLeft();
            return new int[] {x, y};
        }
    
    public static String Salida(){
        Calendar cal = new GregorianCalendar();
        int hora = 0, minutos = 0, segundos = 0;
        hora = cal.get(Calendar.HOUR_OF_DAY);
        minutos = cal.get(Calendar.MINUTE);
        segundos = cal.get(Calendar.SECOND);
        String hr = "La hora de salida es es " + hora + ":" + minutos + ":" + segundos; 
        return hr;
    }
    
    public static int horaSalida(int cobro, int h, int m, int s){
        int total = 0, hora2 = 0, minutos2 = 0, segundos2 = 0;
        Calendar cal = new GregorianCalendar();
        int hora1 = 0, minutos1 = 0, segundos1 = 0;
        hora1 = cal.get(Calendar.HOUR_OF_DAY);
        minutos1 = cal.get(Calendar.MINUTE);
        segundos1 = cal.get(Calendar.SECOND);
        if((hora1 - h) <= 0){
            hora2 = ((hora1 + 24) - h);
        }
        if((minutos1 - m) <= 0){
            minutos2 = ((minutos1 + 60) - m);
        }
        if((segundos1 - s) <= 0){
            segundos2 = ((segundos1 + 60) - s); 
        }
        total = cobro*(hora2* 3600)*(minutos2)*(segundos2);
        return total;
    }
    
    }




