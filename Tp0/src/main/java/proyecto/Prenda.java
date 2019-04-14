package proyecto;

public class Prenda {
	
	// ATRIBUTOS
	private String nombre;
	
	// CONSTRUCTORES
		public Prenda(String nombre) {
			super();
			this.nombre = nombre;
		}
	
	public Prenda() {
			// TODO Auto-generated constructor stub
		}

	// METODOS
	public String getDescripcion() {
		return nombre;
	}
	public void setDescripcion(String newNombre) {
		this.nombre = newNombre;
	}
	
	
	
}
