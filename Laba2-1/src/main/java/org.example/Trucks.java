package org.example;
public class Trucks extends Transport{
    private static int counter = 0;
    private static int height;
    private int length;
    private static int kolvokoles;
    public Trucks(String stamp, int year, String color, int height, int length, int kolvokoles) {
        super(stamp, year, color);
        this.height = height;
        this.length = length;
        this.kolvokoles = kolvokoles;
        counter++;
    }

    public Trucks() {
        super("None", 0, "None");
    }

    @Override
    public void weight(){
        System.out.println(stamp+" весит до 10 тонн");
    }

    @Override
    public void description(){
        System.out.println("Какой у меня грузовая машина!!!");
    }

    public static int getCounter(){
        return counter;
    }
    public static int getKolvokoles(){
        return kolvokoles;
    }

    public static void setKolvokoles(int val) {
        kolvokoles = val;
    }
}
