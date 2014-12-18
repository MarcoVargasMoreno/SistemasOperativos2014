
package productorconsumidorbinario;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Semaforo {
    private int contador;
    
    public Semaforo(int n){
        contador=n;
    }
    
    public synchronized void esperar(){
        while(contador==0){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        contador --;
    }
    
    public synchronized void señal(){
        contador++;
        notify();
    }
}
