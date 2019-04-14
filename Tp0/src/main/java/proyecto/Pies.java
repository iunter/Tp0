package proyecto;

public class Pies extends Prenda{
	
	// ATRIBUTOS
	private String pie;

	// CONSTRUCTORES
	public Pies(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	
	public Pies(String nombre, String pie) {
		super(nombre);
		this.pie = pie;
	}

	public Pies() {
		// TODO Auto-generated constructor stub
	}

	// METODOS
	public String getPie() {
		return pie;
	}

	public void setPie(String pie) {
		if(pie.toUpperCase() == "IZQUIERDO" || pie.toUpperCase() == "DERECHO") {
			this.pie = pie;
		}else {
			throw new PieException("Pie incorrecto");
		}
	}
	
	
}
