package ual.hmis.sesion05.ejercicio6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TestBaraja {

	@CsvSource({"1,0,A♠",
		"2,1,2♥",
		"3,2,3♦",
		"4,3,4♣",
		"5,0,5♠",
		"6,1,6♥",
		"7,2,7♦",
		"8,3,8♣",
		"9,0,9♠",
		"10,1,10♥",
		"11,2,J♦",
		"12,3,Q♣",
		"13,0,K♠",
		"14,4,¯\\_(ツ)_/¯¯\\_(ツ)_/¯"})
	@ParameterizedTest
	void testCard(int valor, int palo, String expected) {
		Card carta= new Card(valor,palo);
		assertEquals(carta.toString(), expected);
		
		if (carta.getValueAsString()=="A") {
			assertEquals(carta.getValue(), 1);
		}
		else if(carta.getValueAsString()=="J") {
			assertEquals(carta.getValue(), 11);
		}
		else if(carta.getValueAsString()=="Q") {
			assertEquals(carta.getValue(), 12);
		}
		else if(carta.getValueAsString()=="K") {
			assertEquals(carta.getValue(), 13);
		}
		else {
		assertEquals(carta.getValue(), valor);
		}
		
		if (carta.getSuitAsString()=="♠") {
			assertEquals(carta.getSuit(), 0);
		}
		else if(carta.getSuitAsString()=="♥") {
			assertEquals(carta.getSuit(), 1);
		}
		else if(carta.getSuitAsString()=="♦") {
			assertEquals(carta.getSuit(), 2);
		}
		else if(carta.getSuitAsString()=="♣") {
			assertEquals(carta.getSuit(), 3);
		}
	
	}
	
	@Test
	void testDeck() {
		Deck barajaOrdenada= new Deck();
		Deck barajaMezclada=new Deck();
		Deck barajaPrueba=new Deck();

		barajaMezclada.shuffle();
		
		System.out.println("Baraja Ordenada");
		System.out.println(barajaOrdenada.toString());
		System.out.println("Baraja Mezclada");
		System.out.println(barajaMezclada.toString());
		
		assertNotEquals(barajaOrdenada.dealCard().toString(), barajaMezclada.dealCard().toString());
		
		for(int i=0; i<=52.;i++) {
			assertEquals(barajaPrueba.cardsLeft(), 52-i);
			barajaPrueba.dealCard();
		}	
	}


}
