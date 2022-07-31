
package views;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Esta clase contiene todos los elementos de la Interface Gráfica para que
 * puedan ser manejados desde las otras clases del programa.
 * 
 *
 */
public class ControlGUI {
    // Se crean los arrays de elementos y los elementos:
    private JLabel[] jLabel_F = new JLabel[10];
    private JLabel[] jLabel_T = new JLabel[10];
    private static JTextArea jTextArea_Log;
    private JTextField[] jTextField_C = new JTextField[11];
    public static int[] filoCount = new int[10];

    /**
     * 
     * @param jLabel_Filo01 Filósofo
     * @param jLabel_Filo02 Filósofo
     * @param jLabel_Filo03 Filósofo
     * @param jLabel_Filo04 Filósofo
     * @param jLabel_Filo05 Filósofo
     * @param jLabel_Filo7 Filósofo
     * @param jLabel_Filo8 Filósofo
     * @param jLabel_Filo9 Filósofo
     * @param jLabel_Filo10 Filósofo
     * @param jLabel_Filo11 Filósofo
     * @param jLabel_Ten01 Tenedor
     * @param jLabel_Ten02 Tenedor
     * @param jLabel_Ten03 Tenedor
     * @param jLabel_Ten04 Tenedor
     * @param jLabel_Ten05 Tenedor
     * @param jLabel_Ten6 Tenedor
     * @param jLabel_Ten7 Tenedor
     * @param jLabel_Ten8 Tenedor
     * @param jLabel_Ten9 Tenedor
     * @param jLabel_Ten10 Tenedor
     * @param jTextArea_Log Area para el Log
     * @param jTextField_Cont01 Contadores
     * @param jTextField_Cont02 Contadores
     * @param jTextField_Cont03 Contadores
     * @param jTextField_Cont04 Contadores
     * @param jTextField_Cont05  Contadores
     * @param jTextField_Cont7  Contadores
     * @param jTextField_Cont8  Contadores
     * @param jTextField_Cont9  Contadores
     * @param jTextField_Cont10  Contadores
     * @param jTextField_Cont11  Contadores
     * @param jTextField_Cont6  Contadores
     */
    public ControlGUI(JLabel jLabel_Filo01, JLabel jLabel_Filo02, JLabel jLabel_Filo03, JLabel jLabel_Filo04, JLabel jLabel_Filo05, JLabel jLabel_Filo7,JLabel jLabel_Filo8,JLabel jLabel_Filo9,JLabel jLabel_Filo10,JLabel jLabel_Filo11,
            JLabel jLabel_Ten01, JLabel jLabel_Ten02, JLabel jLabel_Ten03, JLabel jLabel_Ten04, JLabel jLabel_Ten05, JLabel jLabel_Ten6, JLabel jLabel_Ten7,JLabel jLabel_Ten8,JLabel jLabel_Ten9,JLabel jLabel_Ten10,
            JTextArea jTextArea_Log,
            JTextField jTextField_Cont01, JTextField jTextField_Cont02, JTextField jTextField_Cont03, JTextField jTextField_Cont04, JTextField jTextField_Cont05,JTextField jTextField_Cont7,JTextField jTextField_Cont8,JTextField jTextField_Cont9,JTextField jTextField_Cont10,JTextField jTextField_Cont11, JTextField jTextField_Cont6) {

        // Se asignan los valores a las variables:
        this.jLabel_F[0] = jLabel_Filo01;
        this.jLabel_F[1] = jLabel_Filo02;
        this.jLabel_F[2] = jLabel_Filo03;
        this.jLabel_F[3] = jLabel_Filo04;
        this.jLabel_F[4] = jLabel_Filo05;
        this.jLabel_F[5] = jLabel_Filo7;
        this.jLabel_F[6] = jLabel_Filo8;
        this.jLabel_F[7] = jLabel_Filo9;
        this.jLabel_F[8] = jLabel_Filo10;
        this.jLabel_F[9] = jLabel_Filo11;
        
        this.jLabel_T[0] = jLabel_Ten01;
        this.jLabel_T[1] = jLabel_Ten02;
        this.jLabel_T[2] = jLabel_Ten03;
        this.jLabel_T[3] = jLabel_Ten04;
        this.jLabel_T[4] = jLabel_Ten05;
        this.jLabel_T[5] = jLabel_Ten6;
        this.jLabel_T[6] = jLabel_Ten7;
        this.jLabel_T[7] = jLabel_Ten8;
        this.jLabel_T[8] = jLabel_Ten9;
        this.jLabel_T[9] = jLabel_Ten10;
        
        this.jTextArea_Log = jTextArea_Log;
        
        this.jTextField_C[0] = jTextField_Cont01;
        this.jTextField_C[1] = jTextField_Cont02;
        this.jTextField_C[2] = jTextField_Cont03;
        this.jTextField_C[3] = jTextField_Cont04;
        this.jTextField_C[4] = jTextField_Cont05;
        this.jTextField_C[5] = jTextField_Cont7;
        this.jTextField_C[6] = jTextField_Cont8;
        this.jTextField_C[7] = jTextField_Cont9;
        this.jTextField_C[8] = jTextField_Cont10;
        this.jTextField_C[9] = jTextField_Cont11;
        this.jTextField_C[10] = jTextField_Cont6;


        ControlGUI.filoCount[0] = 0;
        ControlGUI.filoCount[1] = 0;
        ControlGUI.filoCount[2] = 0;
        ControlGUI.filoCount[3] = 0;
        ControlGUI.filoCount[4] = 0;
        ControlGUI.filoCount[5] = 0;
        ControlGUI.filoCount[6] = 0;
        ControlGUI.filoCount[7] = 0;
        ControlGUI.filoCount[8] = 0;
        ControlGUI.filoCount[9] = 0;
        
        /*for (int i : filoCount){
            Clase10Control.filoCount[i] = 0;
        }*/

    }

    // Getters: Se establecen los Getters para que puedan ser llamados desde el programa
    public JLabel[] getjLabel_F() {
        return jLabel_F;
    }
    
    public JLabel[] getjLabel_T() {
        return jLabel_T;
    }

    public JTextField[] getjTextField_C() {
        return jTextField_C;
    }

    
    public static JTextArea getjTextArea_Log() {
        return jTextArea_Log;
    }

    // Único Setters
    public static void setjTextArea_Info(String mensaje) {
        ControlGUI.jTextArea_Log.append(mensaje + "\n");
        ControlGUI.jTextArea_Log.setCaretPosition(ControlGUI.jTextArea_Log.getDocument().getLength()); 
    }
    
}
