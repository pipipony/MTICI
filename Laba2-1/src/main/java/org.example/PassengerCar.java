package org.example;
public abstract class PassengerCar extends Transport{
    private static int counter = 0;
    private static int places;
    private boolean mechanic;
    private boolean cabriolet;
    public PassengerCar(String stamp, int year, String color, int places, boolean mechanic, boolean cabriolet) {
        super(stamp, year, color);
        this.places = places;
        this.mechanic = mechanic;
        this.cabriolet = cabriolet;
        counter++;
    }

    public PassengerCar() {
        super("None", 0, "None");
    }

    @Override
    public void weight(){
        System.out.println(stamp+" весит до 3,5 тонн");
    }

    @Override
    public void description(){
        System.out.println("Какой у меня егковая машина!!!");
    }
    public static int getCounter(){
        return counter;
    }
    public static int getPlaces(){
        return places;
    }

    public static void setPlaces(int val){
        places = val;
    }
}

