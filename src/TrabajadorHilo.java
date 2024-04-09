import java.util.Random;

public class TrabajadorHilo extends Thread {
    private String nombre;
    private Random rand = new Random();

    public TrabajadorHilo(String nombre) {
        this.nombre = nombre;
    }

    public static void main(String[] args) {
    	//creo las dos instancias de los trabajadores 
        TrabajadorHilo trabajador1 = new TrabajadorHilo("Paquito2");
        TrabajadorHilo trabajador2 = new TrabajadorHilo("Juanito");

        trabajador1.start();
        trabajador2.start();
    }
	
	public void run() {
		for (int i = 0; i < 6; i++) {
            System.out.println("Estoy en el paso " + i + " - " + nombre);
            try {
            	//hago que espere entre 1 y 1000 milisegundos, para eso uso un random combiando con un sleep.
                Thread.sleep((rand.nextInt(1000) + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " he terminado de trabajar");
    }

}
