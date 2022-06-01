package ual.hmis.sesion05.ejercicio6;

import java.util.Scanner;

public class cartaAlta {
	public static void main(String[] args) {
		Deck baraja = new Deck();
		Card cartaJugador;
		Card cartaBanca;
		Scanner entrada = new Scanner(System.in);
		int credito = 10;
		while (credito > 0) {
			System.out.println("Tiene un credito de: " + credito);
			System.out.println("Introduzca su apuesta (0 para dejar de jugar): ");
			int apuesta = entrada.nextInt();
			if (apuesta ==0) break;
			if (apuesta > credito) {
				System.out.println("No puedes apostar mas de lo que tienes");
			}
			else {
				System.out.println("Barajando...");
				baraja.shuffle();
				cartaJugador = baraja.dealCard();
				System.out.println("Tu carta es: " + cartaJugador.toString());
				cartaBanca = baraja.dealCard();
				System.out.println("La carta de la banca: " + cartaBanca.toString());
				
				if (cartaJugador.getValue() == cartaBanca.getValue()) {
					System.out.println("Ha habido un empate, se te devuelve lo apostado");
				}
				else if (cartaJugador.getValue() < cartaBanca.getValue()) {
					System.out.println("Has perdido");
					credito -= apuesta;
				}
				else {
					System.out.println("Has ganado");
					credito += apuesta;
				}	
			}
		}
		
		System.out.println("Te has quedado con: " + credito );
		entrada.close();
	}
}
