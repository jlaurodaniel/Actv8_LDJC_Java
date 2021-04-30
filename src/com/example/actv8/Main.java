package com.example.actv8;

import javax.swing.*;

public class Main {
	private static int answer=-1;
	public static boolean playGame=true;
	public static Deck Baraja = new Deck();

    public static void main(String[] args) throws Exception {
	Baraja.init();
		ShowMenu();
    }
	public static void ShowMenu() throws Exception{
		while (playGame){
			try {
				if (answer==-1) {
					JOptionPane.showMessageDialog(null, "Bienvenido a jugar Poker!!", "Inicio de juego", 1);
					answer = Integer.parseInt(JOptionPane.showInputDialog("Escribe #1 para Mezclar Deck \n #2 para sacar carta \n #3 para carta al azar \n #4 genera una mano aleatoria \n #0 para salir dej juego"));
				}else {
					answer = Integer.parseInt(JOptionPane.showInputDialog("Escribe #1 para Mezclar Deck \n #2 para sacar carta \n #3 para carta al azar \n #4 genera una mano aleatoria \n #0 para salir dej juego"));
				}
			} catch (Exception e){
				JOptionPane.showMessageDialog(null,e.getMessage()+"\n  Escriba un mensaje correcto..","Opcion invalida!",3);
				answer= -1;
			}
			switch (answer){
				case 0:
					playGame=false;
					JOptionPane.showMessageDialog(null,"Juego Finalizado exitosamente..","Fin del poker",2);
					break;
				case 1:
					Baraja.shuffle();
					JOptionPane.showMessageDialog(null,"Revise resultados en consola","Mezclar Deck",1);
					break;
				case 2:
					try {
						Baraja.head();
						JOptionPane.showMessageDialog(null,"Revise resultados en consola","Primera carta",1);
					}catch (Exception e){
						JOptionPane.showMessageDialog(null,e.getMessage()+"\n Se agotaron las cartas",e.getMessage(),3);
						playGame=false;
					}
					break;
				case 3:
					try {
						Baraja.pick();
						JOptionPane.showMessageDialog(null,"Revise resultados en consola","Carta al azar",1);
					}catch (Exception e){
						JOptionPane.showMessageDialog(null,e.getMessage()+"\n Se agotaron las cartas",e.getMessage(),3);
						playGame=false;
					}
					break;
				case 4:
					try {
						Baraja.hand();
						JOptionPane.showMessageDialog(null,"Revise resultados en consola","Mano al azar",1);
					}catch (Exception e){
						JOptionPane.showMessageDialog(null,e.getMessage()+"\n Se agotaron las cartas",e.getMessage(),3);
						playGame=false;
					}
					break;
				default:
					JOptionPane.showMessageDialog(null,"Escriba un mensaje correcto..","Opcion invalida!",3);
					break;
			}
		}
	}
}
