package ejercicio2;

public class ImpresionNumeros implements Runnable {
    private ImpresoraNumeros impresora;
    private boolean esImpar;

    public ImpresionNumeros(ImpresoraNumeros impresora, boolean esImpar) {
        this.impresora = impresora;
        this.esImpar = esImpar;
    }

    @Override
    public void run() {
    	//para que solo imprima hasta el 10
        while (impresora.getNumeroActual() < 10) {
            impresora.imprimirNumero(esImpar);
        }
    }
    
    public static void main(String[] args) {
        ImpresoraNumeros impresora = new ImpresoraNumeros();
        //creo los hilos, en el impar pongo el boolean es true, y le pongo el nombre; y en el par, le pongo falso, y le pongo nombre
        Thread hiloImpar = new Thread(new ImpresionNumeros(impresora, true), "Hilo Impar");
        Thread hiloPar = new Thread(new ImpresionNumeros(impresora, false), "Hilo Par");
        
        hiloImpar.start();
        hiloPar.start();
        
    }
    
}




