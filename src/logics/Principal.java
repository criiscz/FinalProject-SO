
package logics;

import utilities.Log;
import philosophers.Philosopher;
import philosophers.Fork;
import philosophers.DinningRoomPorter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import views.ControlGUI;
import views.ControlView;

/**
 * Esta clase genera las instancias de los hilos Filósofos {@link Philosopher} ,
 * Estos hilos se ejecutan de manera concurrente gestionados por monitores ,
 * La finalidad del programa es crear un algoritmo que permita que los filósofos coman y piensen,
 * para ello, el problema se resuelve que siempre haya un filósofo como mínimo comiendo,
 * lo ideal que haya dos. 
 * El algoritmo tiene un recurso compartido {@link DinningRoomPorter} el cual deja pasar a
 * n-1 filósofos y después otro recurso {@link Fork} que es necesario tener por duplicado para
 * que cada filósofo pueda comer. Además el algoritmo se completa creando una regla en la que si un
 * filósofo no consigue el segundo tenedor en x tiempo aleatorio, éste debe abandonar su turno de comida,
 * salir y ponerse a la cola.
 * Además si se selecciona crear un Log en el área de texto de la interface gráfica {@link ControlView}
 * todos los hilos de manera concurrente tendran que ir escribiendo en el log sus acciones, con lo cual 
 * puede relentizar un poco la ejecución del programa.
 * 
 * @author José Francisco Sánchez Portillo
 */
public class Principal {

    private int quantity;
    
    private JLabel[] jLabel_F = new JLabel[quantity];
    private JLabel[] jLabel_T = new JLabel[quantity];
    private JTextField[] jTextField_C = new JTextField[quantity];

    /**
     * Se generan las instancias de 5 de {@link Philosopher}, 5 {@link Fork}, 
     * una de {@link DinningRoomPorter}, una de {@link Log} y una de {@link ExceptionManager},
     * Y se ponen en funcionamiento los hilos filósofos.
     * 
     * @param clase10Control Contiene todos los elemnetos de la interface gráfica
     */
    public Principal(ControlGUI clase10Control, int quantity) { 
        this.jLabel_F = clase10Control.getjLabel_F();
        this.jLabel_T = clase10Control.getjLabel_T();
        this.jTextField_C = clase10Control.getjTextField_C();
        this.quantity = quantity;       
        
        // Se crea el Array para contener las 5 instancias de Tenedores:
        Fork[] tenedor = new Fork[this.quantity];
        // Se crea el Array para contener las 5 instancias de Filósofos:
        Philosopher[] filosofo = new Philosopher[this.quantity];
        // Se crea una sola instancia de Portero_del_Comedor:
        DinningRoomPorter comensal = new DinningRoomPorter();
        // Se crea una sola instancia de Log:
        Log log = new Log();
        // Se crea la instancia del manejeador de excepciones para los Thread:
        ExceptionManager manejador=new ExceptionManager(log);
        
        // Se crean las 5 instancias de Tenedores:
        for(int i=0; i<tenedor.length; i++){
            tenedor[i] = new Fork(i);
        }
        
        // Se crean las 5 instancias de Filósofos:
        for(int i=0; i<filosofo.length; i++){
            /* El filósofo coge el tenedor de la izquierda 
            *  y el de la derecha se contabiliza con el módulo(%)
            *  porque cuando llega a cuatro el siguiente es cero
            */
            // Ahora al filósofo se le pasa: un ID, un tenedor Dercho, un tenedor Izdo, el comensal, los componentes gráficos correspondientes y un log
            filosofo[i] = new Philosopher(i, tenedor[i], tenedor[(i+1)%quantity], comensal, jLabel_F[i], jLabel_T[i], jLabel_T[(i+1)%quantity], log, jTextField_C[i]);
        }
        
        // Se echa a andar todos los Filósofos:
        for(int i=0; i<filosofo.length; i++){
            filosofo[i].setUncaughtExceptionHandler(manejador);
            filosofo[i].start();
        }
    }

    
}
