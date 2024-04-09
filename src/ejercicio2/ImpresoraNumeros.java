package ejercicio2;

public class ImpresoraNumeros {

	public static void main(String[] args) {
		

	}
	
	 private int numeroActual = 1;
	 //syncronized sirve para que 
	    public synchronized void imprimirNumero(boolean esPar) {
	    	//si es par o si es impar
	        while ((esPar && getNumeroActual() % 2 == 0) || (!esPar && getNumeroActual() % 2 != 0)) {
	            try {
	            	//que espere al otro hilo
	                wait();
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	        
	        System.out.println(Thread.currentThread().getName() + ": " + getNumeroActual());
	        //incremento el numero en 1
	        setNumeroActual(getNumeroActual() + 1);
	        //notifica al otro hilo cuando acabe 
	        notify();
	    }

		public int getNumeroActual() {
			return numeroActual;
		}

		public void setNumeroActual(int numeroActual) {
			this.numeroActual = numeroActual;
		}

}
