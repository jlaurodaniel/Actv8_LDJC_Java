package com.example.actv8;

public class Main {

    public static void main(String[] args) {
	Deck Baraja = new Deck();
	Baraja.init();
	Baraja.shuffle();
	Baraja.head();
	Baraja.pick();
	Baraja.hand();
    }
}
