
package productorconsumidor;
/*
PRODCUTOR CONSUMIDOR
Tenemos un productor que va produciendo números de uno en uno 
y una serie de consumidores que irán consumiendo dichos números. 
El productor no podrá producir mas de un número y los consumidores
no podrán consumir nada si no se ha producido antes.
*/

public class ProductorConsumidor 
{
    //declaracion de variables e hilos
    private static Contenedor contenedor;
    private static Thread productor;
    private static Thread [] consumidores;
    private static final int CANTIDADCONSUMIDORES = 10;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)//metodo principal  
    {
        //asignacion de mis variables de tipos clase 
        contenedor = new Contenedor();
        productor = new Thread(new Productor(contenedor, 1));
        consumidores = new Thread[CANTIDADCONSUMIDORES];
        
        //bucle que permite realizar los procesos hasta sin exceder la cantidad de consumidores asignada en la varibles CANTIDADCONSUMIDORES
        for(int i = 0; i < CANTIDADCONSUMIDORES; i++)
        {
            consumidores[i] = new Thread(new Consumidor(contenedor, i));
            consumidores[i].start();//inicia el proceso en consumidores 
        }
        
        productor.start();//inicia proceso productor
    }
    
}
