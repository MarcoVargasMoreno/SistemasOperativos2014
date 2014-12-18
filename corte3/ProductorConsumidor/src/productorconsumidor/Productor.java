
package productorconsumidor;

// esta clase va a implementar la clase runnable , que es el hilo para llenar de 

import java.util.logging.Level;
import java.util.logging.Logger;

// la lista de Productor a la lista Buffer
public class Productor implements Runnable{
    private Pantalla miPantalla;
    private Buffer miBuffer;
    
    public Productor(Pantalla miPantalla, Buffer miBuffer){
        this.miBuffer=miBuffer;
        this.miPantalla=miPantalla;
        
    }
    
    public void run(){
        //Mientras haya un elemento en la lista productor
        while(miPantalla.modelodeproductor.getSize()>0){
            
            synchronized(miBuffer){
            //pasarlo al buffer.  Pasa el ultimo elemento de la lista productor a la lista buffer
                //para ejecutar  esta linea se debe sincronizar la lista para que no haya concurrencia
            miBuffer.agregar(miPantalla.modelodeproductor.remove(miPantalla.modelodeproductor.getSize()-1));
            miBuffer.notify();
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
