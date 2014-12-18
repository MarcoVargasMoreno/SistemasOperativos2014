
package productorconsumidorbinario;


public class SemaforoBinario implements Runnable{
    private static Semaforo mutex = new Semaforo(1);
    private static Semaforo lleno = new Semaforo(0);
    private static Semaforo vacio = new Semaforo(20);
    static private int cont=0;
    private String nombreHilo;
    static int buffer[] = new int[20];
    static private int actual=0;
    
    public SemaforoBinario(String nombre){
        nombreHilo=nombre;
    }
    
    public void run(){
        do{
            int randy = (int)(Math.random()*100);
                if(((randy%2)==0) & (actual>0) ){ // Consumidor
                    lleno.esperar();
                    mutex.esperar();
                // zona critica
                    cont++;
                    actual--;
                        System.out.println(nombreHilo+"elimina buffer["+actual+"]="+buffer[actual]);
                        buffer[actual] = -1;
                // fin de la zona critica
                    mutex.señal();
                    vacio.señal();
                    try{
                    Thread.currentThread().sleep((int) (Math.random()*100));
                    }
                    catch (InterruptedException e) {
                    }
                }
                else{//productor
                    vacio.esperar();
                    mutex.esperar();
                // Zona critica
                    cont++;
                    buffer[actual]=randy;
                        System.out.println(nombreHilo+"añade buffer["+actual+"]="+buffer[actual]);
                        actual++;
                // fin zona critica
                    mutex.señal();
                    lleno.señal();
                    try {
                    Thread.currentThread().sleep((int) (Math.random() * 100));
                    } 
                    catch (InterruptedException e) {
                    }
                }
        }
        while(cont<10);
    }
    
    public static void main(String[] args) {
       /* for(int i=0; i<10;i++){
            buffer[i]=-1;
        }*/
        Thread T1= new Thread(new SemaforoBinario("T1"));
        Thread T2= new Thread(new SemaforoBinario("T2"));
        
        T1.start();
        T2.start();
    }
    
}
