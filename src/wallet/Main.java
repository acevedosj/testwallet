package wallet;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;


        Map<Integer,Coin> maps= new HashMap<>();
        maps.put(1,new Coin(50));
        maps.put(2,new Coin(100));
        maps.put(3,new Coin(200));
        maps.put(4,new Coin(500));
        maps.put(5,new Coin(1000));


        while (!salir) {

            Menu();

            try {


                opcion = sn.nextInt();
                switch (opcion) {
                    case 1, 2, 3,4,5 -> GuardarMonedas(opcion,maps);
                    case 6 -> CantidadMonedas(maps);
                    case 7 -> TotalMonedas(maps);
                    case 8 -> Denominacion(maps);
                    case 9 -> TotalDenominacion(maps);
                    case 10 -> salir = true;
                    default -> System.out.println("Solo números entre 1 y 10");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

    private static void Menu(){

        System.out.println("Menú Alcancia");
        System.out.println("1. Para insertar moneda de 50");
        System.out.println("2. Para insertar moneda de 100");
        System.out.println("3. Para insertar moneda de 200");
        System.out.println("4. Para insertar moneda de 500");
        System.out.println("5. Para insertar moneda de 1000");
        System.out.println("6. Para ver total monedas");
        System.out.println("7. Para ver total dinero");
        System.out.println("8. Para ver cantidad de monedas por denominación");
        System.out.println("9. Para ver cantidad de dinero por denominación");
        System.out.println("10. Salir");
        System.out.println("Escribe una de las opciones");

    }

    private static void MenuDenominacion(){

        System.out.println("Menú monedas por denominación");
        System.out.println("1. Para total moneda de 50");
        System.out.println("2. Para total moneda de 100");
        System.out.println("3. Para total moneda de 200");
        System.out.println("4. Para total moneda de 500");
        System.out.println("5. Para total moneda de 1000");
        System.out.println("6. Para total moneda general");
        System.out.println("7. Regresar al menú principal");
        System.out.println("Escribe una de las opciones");

    }

    private static void MenuTotalDenominacion(){

        System.out.println("Menú monedas por denominación");
        System.out.println("1. Para total dinero moneda de 50");
        System.out.println("2. Para total dinero moneda de 100");
        System.out.println("3. Para total dinero moneda de 200");
        System.out.println("4. Para total dinero moneda de 500");
        System.out.println("5. Para total dinero moneda de 1000");
        System.out.println("6. Para total dinero general");
        System.out.println("7. Regresar al menú principal");
        System.out.println("Escribe una de las opciones");

    }

    private static void Denominacion(Map<Integer,Coin> maps){

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {

            MenuDenominacion();

            try {
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1, 2, 3,4,5 -> DenominacionMonedas(opcion,maps);
                    case 6 -> ResumenDenominacionMonedas(maps);
                    case 7 -> salir = true;
                    default -> System.out.println("Solo números entre 1 y 7");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

    private static void TotalDenominacion(Map<Integer,Coin> maps){

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {

            MenuTotalDenominacion();

            try {
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1, 2, 3,4,5 -> TotalDenominacionMonedas(opcion,maps);
                    case 6 -> ResumenTotalDenominacionMonedas(maps);
                    case 7 -> salir = true;
                    default -> System.out.println("Solo números entre 1 y 7");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

    private static void DenominacionMonedas(int key,Map<Integer,Coin> maps){
        var coin = maps.get(key);
        System.out.println("La cantidad total de monedas de "+coin.getMultiplier() + " es "+coin.getQuantity());
    }

    private static void ResumenDenominacionMonedas(Map<Integer,Coin> maps){
        for (Map.Entry<Integer, Coin> item : maps.entrySet()) {
            var coin = item.getValue();
            System.out.println("La cantidad total de monedas de "+coin.getMultiplier() + " es "+coin.getQuantity());

        }
    }

    private static void TotalDenominacionMonedas(int key,Map<Integer,Coin> maps){
        var coin = maps.get(key);
        System.out.println("La cantidad total de dinero en monedas de "+coin.getMultiplier() + " es "+ coin.getAmount());
    }

    private static void ResumenTotalDenominacionMonedas(Map<Integer,Coin> maps){
        for (Map.Entry<Integer, Coin> item : maps.entrySet()) {
            var coin = item.getValue();
            System.out.println("La cantidad total de dinero en monedas de "+coin.getMultiplier() + " es "+ coin.getAmount());

        }
    }

    private static void GuardarMonedas(int key,Map<Integer,Coin> maps){
        var coin = maps.get(key);
        coin.setQuantity(1);
        maps.put(key, coin);

        System.out.println("Se inserto una moneda de: "+coin.getMultiplier());
    }

    private static void CantidadMonedas(Map<Integer,Coin> maps){

        int cantidadMonedas = 0;
        for (Map.Entry<Integer, Coin> item : maps.entrySet()) {
            var coin = item.getValue();
            cantidadMonedas = cantidadMonedas+coin.getQuantity();

        }

        System.out.println("La cantidad total de monedas es :"+cantidadMonedas);
    }

    private static void TotalMonedas(Map<Integer,Coin> maps){

        int totalMonedas = 0;
        for (Map.Entry<Integer, Coin> item : maps.entrySet()) {
            var coin = item.getValue();
            totalMonedas = totalMonedas+coin.getAmount();

        }

        System.out.println("La cantidad total de dinero en monedas es :"+totalMonedas);
    }
}
