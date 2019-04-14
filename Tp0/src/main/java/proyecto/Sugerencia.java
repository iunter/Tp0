package proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sugerencia {
	
	// ATRIBUTOS
	private Torso torso = new Torso();
	private Piernas piernas = new Piernas();
	private List<Pies> pies = new ArrayList<Pies>();
	private List<Opcional> opcional = new ArrayList<Opcional>();
	
	// CONSTRUCTOR
	public Sugerencia(Torso torso, Piernas piernas, List<Pies> pies, List<Opcional> opcional) {
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

	private void setPies(List<Pies> pies) {
		this.pies = pies;
	}

	private void setOpcional(List<Opcional> opcional) {
		this.opcional = opcional;
	}
	
	public Torso getTorso() {
		return torso;
	}
	
	public Piernas getPiernas() {
		return piernas;
	}
	
	public List<Pies> getPies() {
		return pies;
	}
	
	public List<Opcional> getOpcional() {
		return opcional;
	}
	
	public List<Sugerencia> generarSugerencias(List<Prenda> prendas) {
		Pies pie = new Pies();
		Opcional op = new Opcional();
		List<Torso> pTorsos = (List<Torso>) listarPorPrenda(prendas, torso);
		List<Piernas> pPiernas = (List<Piernas>) listarPorPrenda(prendas, piernas);
		List<Pies> pPies = (List<Pies>) listarPorPrenda(prendas, pie);
		List<Opcional> pOpcional = (List<Opcional>) listarPorPrenda(prendas, op);
		
		List<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
		Sugerencia unaSugerencia = new Sugerencia();
		
		for (int i = 0; i < pTorsos.size(); i++) {
			unaSugerencia.setTorso(pTorsos.get(i));
			for(int j = 0; j < pPiernas.size(); j++) {
				unaSugerencia.setPiernas(pPiernas.get(j));
				for (int k = 0; k < pPies.size(); k++) {
					for (int l = 0; l < pOpcional.size(); l++) {
						
						sugerencias.add(unaSugerencia);
					}
				}
			}
		}
		
		return sugerencias;
	}
	
	// PARA LISTAR SEGUN QUE CLASE
	public List<? extends Prenda> listarPorPrenda(List<? extends Prenda> prendas, Prenda prenda){
		List<? extends Prenda> prendaFiltrada = prendas.stream()
				.filter(prenda.getClass()::isInstance)
				.map(prenda.getClass()::cast)
				.collect(Collectors.toList());
		return prendaFiltrada;
	}
	
}
