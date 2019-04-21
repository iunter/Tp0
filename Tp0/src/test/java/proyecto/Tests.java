package proyecto;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class Tests {

	@Test
	public void testListarXTorso() {
		Sugerencia sugerencia = new Sugerencia();
		List<Prenda> prendas = new ArrayList<Prenda>();
		Torso t1 = new Torso("t1");
		Torso t2 = new Torso("t2");
		Piernas p = new Piernas("P");
		Piernas p2 = new Piernas("P2");
		Pies pies = new Pies("Zapatilla");
		Opcional op = new Opcional("op");
		Opcional op2 = new Opcional("op2");
		Opcional op3 = new Opcional("op3");
		
		prendas.addAll(Arrays.asList(t1,t2,p,p2,pies,op,op2,op3));
		//me deberia devolver solo las prendas de torso (para saber si filtra bien).
		assertTrue(sugerencia.listarPorPrenda(prendas, t1).size() == 2);
	}
	
	@Test
	public void testCrearSugerencias() {
		Sugerencia sugerencia = new Sugerencia();
		List<Prenda> prendas = new ArrayList<Prenda>();
		Torso t1 = new Torso("t1");
		Torso t2 = new Torso("t2");
		Piernas p = new Piernas("P");
		Piernas p2 = new Piernas("P2");
		Pies pies = new Pies("Zapatilla");
		Opcional op = new Opcional("op");
		Opcional op2 = new Opcional("op2");
		Opcional op3 = new Opcional("op3");
		
		prendas.addAll(Arrays.asList(t1,t2,p,p2,pies,op,op2,op3));
		
		// 2*2*1*3 = 12, tengo 12 sugerencias.
		assertTrue(sugerencia.generarSugerencias(prendas).size() == 12);
		
	}
	
	@Test(expected = SugerenciaException.class)
	public void testSinTorso() {
		Sugerencia sugerencia = new Sugerencia();
		List<Prenda> prendas = new ArrayList<Prenda>();
		Piernas p = new Piernas("P");
		Piernas p2 = new Piernas("P2");
		Pies pies = new Pies("Zapatilla");
		Opcional op = new Opcional("op");
		Opcional op2 = new Opcional("op2");
		Opcional op3 = new Opcional("op3");
		prendas.addAll(Arrays.asList(p,p2,pies,op,op2,op3));
		sugerencia.generarSugerencias(prendas);
		//Esto se deberia romper por que debe haber por lo menos una prenda del tipo torso.
	}
	@Test
	public void testSinOpcional() {
		Sugerencia sugerencia = new Sugerencia();
		List<Prenda> prendas = new ArrayList<Prenda>();
		Torso t1 = new Torso("t1");
		Torso t2 = new Torso("t2");
		Piernas p = new Piernas("P");
		Piernas p2 = new Piernas("P2");
		Pies pies = new Pies("Zapatilla");
		prendas.addAll(Arrays.asList(t1,t2,p,p2,pies));
		/*no deberia haber problema, el opcional no hace falta
		 * 2*2*1 = 4, tengo 4 sugerencias.
		 */
		assertTrue(sugerencia.generarSugerencias(prendas).size() == 4);
		
	}
	
}
