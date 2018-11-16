
package productorconsumidor;

import java.util.Random;

public class Productor implements Runnable
{
    //declaracion de mis variables
    private final Random aleatorio;
    private final Contenedor contenedor;
    private final int idproductor;
    private final int TIEMPOESPERA = 1500;

    /**
     * Constructor de la clase
     * parametro contenedor Contenedor común a los consumidores y el productor
     * parametro idproductor Identificador del productor
     */
    public Productor(Contenedor contenedor, int idproductor) 
    {
        //llamaa a mis datos contenedor e idproductor
        this.contenedor = contenedor;
        this.idproductor = idproductor;
        //asignacion a mi varible aleatorio como tipo randomico
        aleatorio = new Random();
    }

     /**
     * Implementación de la hebra
     */
    public void run() 
    {
        
        while(Boolean.TRUE)
        {
            //genera y asigan un numero aleatorio de 0 a 300
            int poner = aleatorio.nextInt(300);
            contenedor.put(poner);
            System.out.println("El productor " + idproductor + " pone: " + poner);//imprime el dato del productor
            
            try 
            {
                Thread.sleep(TIEMPOESPERA);//permite dormir el hilo por un tiempo de espera
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Productor " + idproductor + ": Error en run -> " + e.getMessage());//mensaje de excepcion
            }
        }
    }
}
