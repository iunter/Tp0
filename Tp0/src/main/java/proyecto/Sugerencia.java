package proyecto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

public class Sugerencia {
	
	// ATRIBUTOS
	private Torso torso = new Torso();
	private Piernas piernas = new Piernas();
	private Pies pies = new Pies();
	private Opcional opcional = new Opcional();
	
	// CONSTRUCTOR
	public Sugerencia(Torso torso, Piernas piernas, Pies pies, Opcional opcional) {
		super();
		this.torso = torso;
		this.piernas = piernas;
		this.pies = pies;
		this.opcional = opcional;
	}

	public Sugerencia() {
		// TODO Auto-generated constructor stub
	}

	// METODOS
	private void setTorso(Torso torso) {
		this.torso = torso;
	}

	private void setPiernas(Piernas piernas) {
		this.piernas = piernas;
	}

	private void setPies(Pies pies2) {
		this.pies = pies2;
	}

	private void setOpcional(Opcional opcional) {
		this.opcional = opcional;
	}
	
	public Torso getTorso() {
		return torso;
	}
	
	public Piernas getPiernas() {
		return piernas;
	}
	
	public Pies getPies() {
		return pies;
	}
	
	public Opcional getOpcional() {
		return opcional;
	}
	
	public Set<List<Prenda>> generarSugerencias(List<Prenda> prendas) {
		Pies pie = new Pies();
		Opcional op = new Opcional();
		Set<Torso> pTorsos = new HashSet<Torso>();
		Set<Piernas> pPiernas = new HashSet<Piernas>();
		Set<Pies> pPies = new HashSet<Pies>();
		Set<Opcional> pOpcional = new HashSet<Opcional>();
		
		if((pTorsos = (Set<Torso>) listarPorPrenda(prendas, torso)).isEmpty()) {
			throw new SugerenciaException("Falta alguna prenda para el torso");
		}
		if((pPiernas = (Set<Piernas>) listarPorPrenda(prendas, piernas)).isEmpty()) {
			throw new SugerenciaException("Falta alguna prenda para las piernas");
		}
		if((pPies = (Set<Pies>) listarPorPrenda(prendas, pie)).isEmpty()) {
			throw new SugerenciaException("Falta alguna prenda para los pies");
		}
		if((pOpcional = (Set<Opcional>) listarPorPrenda(prendas, op)).isEmpty()) {
			return Sets.cartesianProduct(pTorsos,pPiernas,pPies);
			/*no hace tirar una excepcion por que justamente son opcionales, pero al metodo
			 *cartesianProduct no le puedo pasar un set vacio.
			 */
		}else {
			return Sets.cartesianProduct(pTorsos,pPiernas,pPies,pOpcional);
		}
		
		
		
		
		/*List<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
		Sugerencia unaSugerencia = new Sugerencia();
			for (int i = 0; i < pTorsos.size(); i++) {
					unaSugerencia.setTorso(pTorsos.get(i));
				for(int j = 0; j < pPiernas.size(); j++) {
					unaSugerencia.setPiernas(pPiernas.get(j));
					for (int k = 0; k < pPies.size(); k++) {
						unaSugerencia.setPies(pPies.get(k));
						if(!pOpcional.isEmpty()) {
							for (int l = 0; l < pOpcional.size(); l++) {
								unaSugerencia.setOpcional(pOpcional.get(j));
								sugerencias.add(unaSugerencia);
							}
						}else {
							sugerencias.add(unaSugerencia);
						}
					}
				}
			}
			
		
		return sugerencias;*/
	}
	
	// PARA LISTAR SEGUN QUE CLASE
	public Set<? extends Prenda> listarPorPrenda(List<? extends Prenda> prendas, Prenda prenda){
		List<? extends Prenda> prendaFiltrada = prendas.stream()
				.filter(prenda.getClass()::isInstance)
				.map(prenda.getClass()::cast)
				.collect(Collectors.toList());
		Set devolverSet = new HashSet(prendaFiltrada);
		return devolverSet;
	}
	
}
