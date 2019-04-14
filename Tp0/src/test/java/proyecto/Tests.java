package proyecto;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class Tests {

	@Test
	public void testListar() {
		List<Prenda> torso = new ArrayList<Prenda>();
		Torso t1 = new Torso("t1");
		Torso t2 = new Torso("t2");
		Piernas p = new Piernas("P");
		
		torso.add(t1);
		torso.add(t2);
		torso.add(p);
		
		Sugerencia sugerencia = new Sugerencia();
		
		assertTrue(sugerencia.listarPorPrenda(torso, t1).size() == 2);
	}
}
