
public class TrabajadorHilo extends Thread {
    private String nombre;

    public TrabajadorHilo(String nombre) {
        this.nombre = nombre;
    }

    public static void main(String[] args) {
        TrabajadorHilo hilo1 = new TrabajadorHilo("Juan");
        TrabajadorHilo hilo2 = new TrabajadorHilo("María");

        hilo1.start();
        hilo2.start();
    }
	
	public void run() {
		for (int i = 0; i < 6; i++) {
            System.out.println("Estoy en el paso " + i + " - " + nombre);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " he terminado de trabajar");
    }

}
