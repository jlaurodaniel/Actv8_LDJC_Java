package com.example.actv8;

public class Card {
    public  String palo;
    public String color;
    public String Valor;

    public Card (String palo,String color,String valor){
        this.palo=palo;
        this.color=color;
        this.Valor=valor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }
}
