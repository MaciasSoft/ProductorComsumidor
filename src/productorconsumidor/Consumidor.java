
package productorconsumidor;//paquete de mi project
/**
 * Esta clase representa al consumidor
 * @author Nelson macias 
 */
public class Consumidor implements Runnable
{
    private final Contenedor contenedor; //creacion de variable de tipo contenedor 
    private final int idconsumidor; //creacion de variable tipo entero idconsumidor

    /**
     * Constructor de la clase
     * parametro contenedor Contenedor común a los consumidores y el productor
     * parametro idconsumidor Identificador del consumidor
     */
    public Consumidor(Contenedor contenedor, int idconsumidor) 
    {
        //llamada a mis datos contenedor e idconsumidor
        this.contenedor = contenedor;
        this.idconsumidor = idconsumidor;
    }

    
    /**
     * Implementación de la hebra
     */
    public void run() 
    {
        while(Boolean.TRUE)
        {
            System.out.println("El consumidor " + idconsumidor + " consume: " + contenedor.get());
        }
    }
}
