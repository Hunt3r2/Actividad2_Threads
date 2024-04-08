
public class Trabajador {
	
	private String nombre;


	public static void main(String[] args) {
		Trabajador trabajador1 = new Trabajador("Paquito");
        Trabajador trabajador2 = new Trabajador("Juan");

        trabajador1.realizarTarea();
        trabajador2.realizarTarea();
	}
	
	public Trabajador(String nombre) {
		this.nombre = nombre;
	}
	
	public void realizarTarea() {
		
		for (int i = 0; i <= 6;i++) {
			System.out.println("Estoy en el paso: " + i);
		}
		System.out.println(nombre + " he terminado de trabajar");
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
