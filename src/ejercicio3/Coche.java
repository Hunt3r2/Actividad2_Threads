package ejercicio3;

import java.util.Random;

public class Coche extends Thread{
	private static final int DESCANSO_DISTANCIA = 400;
	private int lineaDeMeta = 1000;
	private int distanciaTotal = 0;
	//me estaba dando problemas con las distancias, asi que decidí hacer un par de variables temporales
	private int distanciaParcial;
	private int distanciaDescanso = 0; 
    private String nombre;
    private int distanciaRecorrida;
    //utlizo un objeto para sincronizar los hilos
    private Object sincronizador = new Object();

    public Coche(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
        this.distanciaParcial = 0;
        this.distanciaDescanso = 0;
    }


	public static void main(String[] args) {
		

	}
	
	public void run() {
		 //hacemos que el bucle sigua hasta que el hilo llegue a la linea de meta
        Random random = new Random();
        while (distanciaRecorrida < lineaDeMeta) {
        	// esto es para que avance un numero aleatorio entre 50 y 100
            int distanciaAvance = random.nextInt(51) + 50;
            //hago que la distancia que avanza se sume a las distancias
            distanciaRecorrida += distanciaAvance;
            distanciaParcial += distanciaAvance;
            System.out.println(nombre + " ha avanzado " + distanciaAvance + " metros. Distancia recorrida: " + distanciaRecorrida);
            
            //si llega a 400 metros, que descanse
            if (distanciaParcial >= DESCANSO_DISTANCIA) {
                System.out.println(nombre + " está descansando. Distancia total hasta ahora: " + distanciaRecorrida);
                try {
                	// para que descanse un numero aleatorio entre 1000 y 1500 milisegundos
                    Thread.sleep(random.nextInt(501) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(nombre + " ha terminado de descansar. Continuando la carrera.");
                distanciaDescanso += distanciaParcial;
                //reinicio la distancia parcial para que no me salga que cada vez que se mueva, descanse
                distanciaParcial = 0;
            }
        }
        System.out.println(nombre + " ha llegado a la meta!");
    }
	} 
	
	


