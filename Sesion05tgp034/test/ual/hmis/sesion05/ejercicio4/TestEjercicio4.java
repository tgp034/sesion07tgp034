package ual.hmis.sesion05.ejercicio4;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ual.hmis.sesion05.ejercicio4.Ejercicio4;

class TestEjercicio4 {

		@ParameterizedTest (name = "{index} => calificacion")
		@CsvSource({"-10,Error en la nota","0,Suspenso","5,Aprobado",
		"7,Notable", "9,Sobresaliente","10,Matricula","11,Error en la nota"})
		void testCalificacion(Float nota, String expected) {
			//Arrange
			Ejercicio4 e4 = new Ejercicio4();
			//Act
			String calificacion = e4.calificacion(nota);
			//Assert
			assertEquals(expected,calificacion);
		}
		
//		@ParameterizedTest (name = "{index} => calificaciones")
//		@CsvSource({"[-1;4.9;5.9;8.9;9.9;10;654]",
//				 "[Error en la nota; Suspenso; Aprobado; Notable; Sobresaliente; Matricula; Error en la nota]"})
//		void testCalificaciones(ArrayList<Float> notas, ArrayList<String> expected) {
//			//Arrange
//			Ejercicio4 e4 = new Ejercicio4();
//			//Act
//			e4.calculaCalificaciones(notas);
//			//Assert
//			assertEquals(expected,e4.calificaciones);
//		}
	}