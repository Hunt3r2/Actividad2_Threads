package ejercicio2;

public class ImpresoraNumeros {

	public static void main(String[] args) {
		

	}
	
	 private int numeroActual = 1;

	    public synchronized void imprimirNumero(boolean esPar) {
	        while ((esPar && getNumeroActual() % 2 == 0) || (!esPar && getNumeroActual() % 2 != 0)) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	        
	        System.out.println(Thread.currentThread().getName() + ": " + getNumeroActual());
	        setNumeroActual(getNumeroActual() + 1);
	        notify();
	    }

		public int getNumeroActual() {
			return numeroActual;
		}

		public void setNumeroActual(int numeroActual) {
			this.numeroActual = numeroActual;
		}

}
