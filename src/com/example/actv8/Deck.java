package com.example.actv8;

import java.util.ArrayList;
import java.util.Stack;

public class Deck {
    public Stack<Card> baraja = new Stack<Card>();
    ArrayList<Card> Mano = new ArrayList<Card>();

    public void init(){
        crearPalo("Trebol","Negro");
        crearPalo("Diamante","Rojo");
        crearPalo("Corazon","Rojo");
        crearPalo("Pica","Negro");
    }

    public void shuffle(){
        for (int i=1;i<=52;i++){
            int firstPosition=getRandomBetween(0,51);
            int lastPosition=getRandomBetween(0,51);
            Card auxCard=baraja.get(firstPosition);
            baraja.set(firstPosition,baraja.get(lastPosition));
            baraja.set(lastPosition,auxCard);
        }
        System.out.println("Se mezcló el Deck...");
    }

    public Card head()throws IndexOutOfBoundsException{
        Card pick=baraja.remove(0);
        System.out.println("La primera carta es: Palo ["+pick.palo+"] "+"Color: ["+pick.color+"] Valor:["+pick.Valor+"]");
        System.out.println("Quedan "+baraja.size()+" numero de cartas en este Deck");
        return pick;
    }

    public void pick()throws IndexOutOfBoundsException{
        Card head=baraja.remove(getRandomBetween(0,baraja.size()-1));
        System.out.println("La carta es: Palo ["+head.palo+"] "+"Color: ["+head.color+"] Valor:["+head.Valor+"]");
        System.out.println("Quedan "+baraja.size()+" numero de cartas en este Deck");
    }

    public ArrayList<Card> hand()throws IndexOutOfBoundsException{
        Mano.clear();
        for (int i=1;i<=5;i++){
            Mano.add(baraja.remove(getRandomBetween(0,baraja.size()-1)));
        }
        System.out.println("Quedan "+baraja.size()+" numero de cartas en este Deck");
        return Mano;
    }

    private void crearPalo(String palo , String color){
        for (int i=1;i<=13;i++){
            if (i==1){
                //Creacion de  carta #1
                Card card  = new Card(palo,color,"As");
                //Añadir a la pila de cartas
                baraja.push(card);
            }else if (i>1 && i<11){
                //Creacion de  cartas 2 al 10
                Card card  = new Card(palo,color,String.valueOf(i));
                //Añadir a la pila de cartas
                baraja.push(card);
            }else if (i>10 && i<14){
                //Creacion de  cartas 11 al 13 (J,Q,K)
                switch (i){
                    case 11:
                        Card cardJ  = new Card(palo,color,"J");
                        //Añadir a la pila de cartas
                        baraja.push(cardJ);
                        break;
                    case 12:
                        Card cardQ  = new Card(palo,color,"Q");
                        //Añadir a la pila de cartas
                        baraja.push(cardQ);
                        break;
                    case 13:
                        Card cardK  = new Card(palo,color,"K");
                        //Añadir a la pila de cartas
                        baraja.push(cardK);
                        break;
                }
            }
        }
    }

    public int getRandomBetween(int min ,int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }

}
