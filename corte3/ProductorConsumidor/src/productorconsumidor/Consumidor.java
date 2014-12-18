package productorconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor implements Runnable{
    private Pantalla mipantalla;
    private Buffer mibuffer;
    public Consumidor(Pantalla miPantalla, Buffer miBuffer){
        this.mibuffer=miBuffer;
        this.mipantalla=miPantalla;
    }
    
    public void run(){
        //mientras haya un elemento en el buffer
        while(mibuffer.getSize()>0){
            //Pasar a la lista del consumidor
            synchronized(mibuffer){
                if(mibuffer.isEmpty())
                    try {
                        mibuffer.wait();
                    } 
                    catch (InterruptedException ex) {
                    }
                //si no esta vacio el buffer, pasa el elemento a la lista consumidor
                mipantalla.modelodeconsumidor.addElement(mibuffer.quitar());
                
            }
            try {
                Thread.sleep(800);
            } 
            catch (InterruptedException e) {
            }
            
        }
    }
}
