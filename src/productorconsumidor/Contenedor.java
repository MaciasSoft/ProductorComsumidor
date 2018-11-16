
package productorconsumidor;

/**
 * Esta clase representa el contenedor donde se producirán los elementos que consumen los consumidores
 * @author Nelson
 */
public class Contenedor 
{
    private int contenido; //variable de tipo entero
    private boolean contenedorlleno = Boolean.FALSE;//variable de tipo booleano inicializa en falso o inactivo

    /**
     * Obtiene de forma concurrente o síncrona el elemento que hay en el contenedor
     * @return Contenido el contenedor
     */
    public synchronized int get()
    {
        //controla si el contenedor se encuentra lleno 
        while (!contenedorlleno)
        {
            try 
            {
                wait(); //bloquea o pone en espera la hebra
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());// mensaje de exepcion
            }
        }
        contenedorlleno = Boolean.FALSE;//Contenedorlleno se encuentra inactiva
        notify();//desbloquea una de las hebras que han sido bloqueadas al intentar acceder a un método sincronizado. 
        return contenido;//retorna el valor contenido
    }

    /**
     * Sección crítica del código y por lo tanto las hebras que accedan a dicho método deberán hacerlo de forma concurrente
     * Introduce de forma concurrente un elemento en el contenedor
     * parametro value Elemento a introducir en el contenedor
     */
    public synchronized void put(int value) 
    {
        //mientras el contenedor se encuentre lleno         
        while (contenedorlleno) 
        {
            try 
            {
                wait();//bloquea o pone en espera la hebra
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());// mensaje de exepcion
            }
        }
        contenido = value;// el contenedor sera igual al nuevo elemento
        contenedorlleno = Boolean.TRUE;//Contenedor se muestra lleno
        notify(); //desbloquea una de las hebras que han sido bloqueadas al intentar acceder a un método sincronizado
    }
}
