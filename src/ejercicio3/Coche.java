package ejercicio3;

import java.util.Random;

public class Coche extends Thread{
	
	private int lineaDeMeta = 1000;
	private int distanciaTotal = 0;
    private String nombre;
    private int distanciaRecorrida;
    private Object lock = new Object();

    public Coche(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }


	public static void main(String[] args) {
		

	}
	
	 public void run() {
	        while (distanciaRecorrida < lineaDeMeta) {
	            int distanciaAvance = new Random().nextInt(51) + 50; // Avance aleatorio entre 50 y 100
	            synchronized (lock) {
	                distanciaRecorrida += distanciaAvance;
	                distanciaTotal += distanciaAvance;
	                System.out.println(nombre + " ha avanzado " + distanciaAvance + " metros. Distancia total: " + distanciaTotal);

	                if (distanciaTotal >= 400) {
	                    System.out.println(nombre + " está descansando. Distancia total hasta ahora: " + distanciaTotal);
	                    try {
	                        Thread.sleep(new Random().nextInt(501) + 1000); // Descanso aleatorio entre 1000 y 1500 milisegundos
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                    System.out.println(nombre + " ha terminado de descansar. Continuando la carrera.");
	                    distanciaTotal = 0;
	                }
	            }
	        }
	        System.out.println(nombre + " ha llegado a la meta!");
	    }
	} 
	
	


