package proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	public List<Sugerencia> generarSugerencias(List<Prenda> prendas) {
		Pies pie = new Pies();
		Opcional op = new Opcional();
		List<Torso> pTorsos = new ArrayList<Torso>();
		List<Piernas> pPiernas = new ArrayList<Piernas>();
		List<Pies> pPies = new ArrayList<Pies>();
		List<Opcional> pOpcional = new ArrayList<Opcional>();
		
		if((pTorsos = (List<Torso>) listarPorPrenda(prendas, torso)).isEmpty()) {
			throw new SugerenciaException("Falta alguna prenda para el torso");
		}
		if((pPiernas = (List<Piernas>) listarPorPrenda(prendas, piernas)).isEmpty()) {
			throw new SugerenciaException("Falta alguna prenda para las piernas");
		}
		if((pPies = (List<Pies>) listarPorPrenda(prendas, pie)).isEmpty()) {
			throw new SugerenciaException("Falta alguna prenda para los pies");
		}
		pOpcional = (List<Opcional>) listarPorPrenda(prendas, op);
		//no hace tirar una excepcion por que justamente son opcionales
		
		
		
		List<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
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
