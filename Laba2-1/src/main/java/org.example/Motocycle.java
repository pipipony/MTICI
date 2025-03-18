package org.example;
public class Motocycle extends Transport{
    private static int counter = 0;
    protected static boolean lulka;
    private int dkolesa;
    private int mspeed;
    public Motocycle(String stamp, int year, String color, boolean lulka, int dkolesa, int mspeed) {
        super(stamp, year, color);
        this.lulka = lulka;
        this.dkolesa = dkolesa;
        this.mspeed = mspeed;
        counter++;
    }

    public Motocycle() {
        super("None", 0, "None");
    }

    @Override
    public void weight(){
        System.out.println(stamp+" весит до 650кг");
    }
    @Override
    public void description(){
        System.out.println("Какой у меня крутой мотоцикл!!!");
    }
    public static int getCounter(){
        return counter;
    }

    public static boolean getLulka(){
        return lulka;
    }

    public static void setLulka(boolean val){
        lulka = val;
    }
}
