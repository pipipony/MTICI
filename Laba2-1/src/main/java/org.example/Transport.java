package org.example;
abstract public class Transport {
    protected String stamp;
    protected int year;
    protected String color;

    public Transport(String stamp, int year, String color){
        this.stamp = stamp;
        this.year = year;
        this.color = color;
    }

    public abstract void weight();

    public void description() {
        return;
    }

    public void outs(){
        System.out.println("Марка: "+stamp+", Год выпуска: "+year+", Цвет: "+color);
    }


}

