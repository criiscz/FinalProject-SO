
package utilities;

import views.ControlGUI;
import views.ControlView;

/**
 * Esta clase escribe un log en la interface gráfica del programa {@link ControlView}
 * Recurso compratido por los hilos Filósofos,
 * Se crea una única instancia
 * 
 */
public class Log {
   /**
    * Este método es un monitor al cual van accediendo los hilos para escribir sus acciones
    * en el log del programa, este componente puede ser activado o no desde la interface gráfica.
    * 
    * @param log Mensaje que recibe el método para que sea añadido al componente gráfico en la interface
    * @throws InterruptedException Error y su descripción
    */
    public synchronized void wirteLog(String log) throws InterruptedException{
        ControlGUI.setjTextArea_Info(log);
    }
    
}
