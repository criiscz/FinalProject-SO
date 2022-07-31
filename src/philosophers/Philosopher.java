// Clase Activa: Thread
package philosophers;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import logics.Principal;
import utilities.Log;
import views.ControlGUI;

/**
 * Hilo Filósofo: se ejecuta de manera concurrente gestionados por monitores ,
 * La finalidad del programa es crear un algoritmo que permita que los filósofos coman y piensen,
 * para ello, el problema se resuelve que siempre haya un filósofo como mínimo comiendo,
 * lo ideal que haya dos. 
 * El algoritmo tiene un recurso compartido {@link DinningRoomPorter} el cual deja pasar a
 * n-1 filósofos y después otro recurso {@link Fork} que es necesario tener por duplicado para
 * que cada filósofo pueda comer. Además el algoritmo se completa creando una regla en la que si un
 * filósofo no consigue el segundo tenedor en x tiempo aleatorio, éste debe abandonar su turno de comida,
 * salir y ponerse a la cola.
 * 
 */
public class Philosopher extends Thread {
    // Variable para generar números aleatorios:
    private Random random = new Random();
    // Variable para la ID del Filósofo:
    private int id;
    // Variables para los tenedores:
    private Fork left, right;
    // Variable para el comensal:
    private DinningRoomPorter diner;
    // Variables para los elementos gráficos:
    private JLabel jLabel_F, jLabel_T_right, jLabel_T_left;
    private Log log; // Para escribir en el Log
    private JTextField jTextField_C; // Contador de comidas
    // Variable pública y estática para que se pueda detener el método run() de esta clase:
    public static boolean finish = false;
    
    /**
     * Esta clase pone en marcha los hilos Filósofos
     * Método run() del Thread
     * 
     * @param id ID del Filósofo
     * @param right Tenedor
     * @param left Tenedor
     * @param diner Turno para comer
     * @param jLabel_F Elementos gráficos
     * @param jLabel_T_right Elementos gráficos
     * @param jLabel_T_left Elementos gráficos
     * @param log Para escribir en el Log
     * @param jTextField_C Contador de comidas
     */
    public Philosopher(int id, Fork right, Fork left, DinningRoomPorter diner, JLabel jLabel_F, 
            JLabel jLabel_T_right, JLabel jLabel_T_left,
            Log log,
            JTextField jTextField_C){
        // Se asignan los valores recibidos a las variables
        this.id = id;
        this.right = right;
        this.left = left;
        this.diner = diner;
        this.jLabel_F = jLabel_F;
        this.jLabel_T_right = jLabel_T_right;
        this.jLabel_T_left = jLabel_T_left;
        this.log = log; // Puede ser null y por consiguiente no escribir el log
        this.jTextField_C = jTextField_C;
    }
    
    /**
     * Método que se ejecuta indefinidamente, una por cada hilo creado en {@link Principal}
     */
    @Override
    public void run(){
        while(true){ // Se repite infinitamente While
            
            try { // try / catch
                // Obtener el comensal para poder comer:
                diner.takeDiner(id, log);
                    this.jLabel_F.setBackground(Color.PINK); // Componente gráfico
                // Obtener el Tenedor Derecho:
                right.takeFork(id, log);
                    this.jLabel_F.setBackground(Color.CYAN); // Componente gráfico
                    this.jLabel_T_right.setBackground(Color.BLUE); // Componente gráfico
                // Obtener el Tenedor Izquierdo:
                if (!left.takeLeftFork(id, log)){
                    // -----------------------------------------------------------------------------------------------------------------
                    // Si no se consigue el izquierdo: el filósofo tendra que volver a casilla de salida y volver a obtener el comensal:
                    System.out.println("El Filósofo " + (id+1) + " tendrá que soltar el tenedor " + (id+1) + " por exceso de tiempo y salir a pensar.");
                    // Siempre se valora si el log es distinto a null, si lo es se ecribe en la interface gráfica:
                    if (ControlGUI.getjTextArea_Log()!=null) log.wirteLog(" El Filósofo " + (id+1) + " tendrá que soltar el tenedor " + (id+1) + " por exceso de tiempo y salir a pensar.");
                    // Como no ha conseguido el Tenedor izquierdo suelta el derecho
                    right.dropFork(id, log);
                        this.jLabel_T_right.setBackground(Color.LIGHT_GRAY); // Componente gráfico
                    // Como no ha conseguido el Tenedor izquierdo suelta el comensal
                    diner.dropDiner(id, log);
                    // Y ahora el Filósofo piensa *********************
                    System.out.println("El Filósofo " + (id+1) + " está pensando.");
                    if (ControlGUI.getjTextArea_Log()!=null) log.wirteLog(" El Filósofo " + (id+1) + " está pensando.");
                    try {
                        // El tiempo que tarda el filósofo en pensar, entre 100 y 1000 milisegundos:
                        Philosopher.sleep(random.nextInt(1000) + 100);
                    } catch (InterruptedException ex) {
                        System.out.println("Error. Descripción: " + ex.toString());
                        if (ControlGUI.getjTextArea_Log()!=null) log.wirteLog("\n\n Error. Descripción: " + ex.toString() + "\n\n");
                    }
                    // Fin de Ahora el Filósofo piensa *********************
                    continue; // Se vuelve a poner en la casilla de salida y volver a obtener el comensal.
                    // -----------------------------------------------------------------------------------------------------------------
                }
                    // Si ha conseguido el Tenedor Izquierdo. El filósofo sigue adelante:
                    this.jLabel_T_left.setBackground(Color.BLUE); // Componente gráfico
                    // Y ahora el Filósofo come =========================================================================================
                        this.jLabel_F.setBackground(Color.ORANGE); // Componente gráfico
                        this.jLabel_F.setForeground(Color.BLUE); // Componente gráfico
                    jTextField_C.setText(" " + (++ControlGUI.filoCount[id])); // Su contador de comidas incrementa una unidad.
                    System.out.println("El Filósofo " + (id+1) + " está comiendo.");
                    if (ControlGUI.getjTextArea_Log()!=null) log.wirteLog(" El Filósofo " + (id+1) + " está comiendo.");
                    // Simular el tiempo que tarda el filósofo en comer, entre 0.5 y 1 segundos:
                    try {
                        sleep(random.nextInt(1000) + 500);
                    } catch (InterruptedException ex) {
                        System.out.println("Error. Descripción: " + ex.toString());
                        if (ControlGUI.getjTextArea_Log()!=null) log.wirteLog("\n\n Error. Descripción: " + ex.toString() + "\n\n");
                    } // Fin de Simular el tiempo que tarda el filósofo en comer, entre 0.5 y 1 segundos // Fin de Simular el tiempo que tarda el filósofo en comer, entre 0.5 y 1 segundos
                        this.jLabel_F.setBackground(Color.WHITE); // Componente gráfico
                        this.jLabel_F.setForeground(Color.BLACK); // Componente gráfico
                    // Fin de Ahora el Filósofo come ====================================================================================
                // Suelta el Tenedor izquierdo:
                left.dropFork(id, log);
                    this.jLabel_T_left.setBackground(Color.LIGHT_GRAY); // Componente gráfico
                // Suelta el Tenedor derecho:
                right.dropFork(id, log);
                    this.jLabel_T_right.setBackground(Color.LIGHT_GRAY); // Componente gráfico
                // Suelta el comensal:
                diner.dropDiner(id, log);
                // Ahora el Filósofo piensa *********************************************************************************************
                System.out.println("El Filósofo " + (id+1) + " está pensando.");
                if (ControlGUI.getjTextArea_Log()!=null) log.wirteLog(" El Filósofo " + (id+1) + " está pensando.");
                // El tiempo que tarda el filósofo en pensar, entre 100 y 1000 milisegundos:
                try {
                    Philosopher.sleep(random.nextInt(1000) + 100);
                } catch (InterruptedException ex) {
                    System.out.println("Error. Descripción: " + ex.toString());
                    if (ControlGUI.getjTextArea_Log()!=null) log.wirteLog("\n\n Error. Descripción: " + ex.toString() + "\n\n");
                }
                // Fin de Ahora el Filósofo piensa **************************************************************************************
                // Fin de Ahora el Filósofo piensa **************************************************************************************
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                System.err.println("Se ha producido un error. Descripción: " + ex.toString());
                try {
                    if (ControlGUI.getjTextArea_Log()!=null) log.wirteLog("\n\n Se ha producido un error. Descripción: " + ex.toString() + "\n\n");
                } catch (InterruptedException ex1) {
                    Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } // Fin del try / catch // Fin del try / catch // Fin del try / catch // Fin del try / catch
            
            if(finish){ // Si se ha pulsado el botón en la interface de 'Pausar' (public static boolean finalizado = true):
               break; // Se sale
            }
            
        }  // Fin de Se repite infinitamente While

        // Se ha pulsado el botón de la interface 'Pausar' (public static boolean finalizado = true):
        System.out.println("La cena ha terminado para todos: El Filósofo " + (id+1) +" se ha puesto a pensar.\n\nPulsar Iniciar para continuar.\n\n");
        try {
            if (ControlGUI.getjTextArea_Log()!=null) log.wirteLog(" La cena ha terminado para todos: El Filósofo " + (id+1) +" se ha puesto a pensar.\n\n Pulsar Iniciar para continuar.\n\n");
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
