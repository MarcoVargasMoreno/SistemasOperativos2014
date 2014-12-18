
package productorconsumidor;

import javax.swing.DefaultListModel;


public class Buffer extends DefaultListModel{
    private int limite;
    // creo el constructor que le ingresa un entero, que es el limite de elementos del buffer
    public Buffer(int l){
        this.limite=l;
    }
    //Metodo que nos indica si el buffer esta lleno
    public boolean estalleno(){
        if(this.getSize()>=limite)
            return true;
        else 
            return false;
    }
    
    // metodo que añade elementos al buffer
    public void agregar(Object o){
        this.addElement(o);
    }
    
    // metodo que retorna un Object y extrae el ultimo elemento del buffer y regresarlo
    public Object quitar(){
        return this.remove(0);
    }
    
}
