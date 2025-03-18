package org.example;
public class Main {
    public static void main(String[] args) {
        Trucks truck = new Trucks("Volvo",1990,"red", 4, 20, 12);
        truck.weight();
        truck.description();
        System.out.println(truck.getCounter());
        truck.setKolvokoles(16);
        System.out.println(truck.getKolvokoles());
        Motocycle vq = new Motocycle();
        vq.lulka = true;
        vq.setLulka(true);
    }
}
