
package views;

import philosophers.Philosopher;
import java.awt.Color;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import logics.Principal;

/**
 * Esta clase contiene la interface gráfica de la aplicación
 * Hereda de {@link GenericView}
 * Contiene todos los elementos gráficos del programa y los botones
 * que ejecutan el programa.
 * 
 */
public class ControlView extends GenericView {

    /**
     * Creates new form Vista10Control
     */
    public ControlView() {
        super("La Cena de los Filósofos", "icono.png");
        initComponents();
        
        //Botón Finalizar:
        this.jButton_Finalizar.setEnabled(false);
        
        // Campo de Log y de Info:
        this.jTextArea_Log.setText("\n Información:"
                + "\n\n El problema de La Cena de los Filósofos es un clásico de las Ciencias"
                + "\n de la Computación propuesto por Edsger Dijkstra en 1965, para representar"
                + "\n el problema de la sincronización de procesos en un Sistema Operativo."
                + "\n\n\n Enunciado del problema:"
                + "\n\n Cinco filósofos se sientan alrededor de una mesa y pasan su vida cenando"
                + "\n y pensando. Cada filósofo tiene un plato de fideos y un tenedor a la derecha"
                + "\n de su plato. Para comer los fideos son necesarios dos tenedores y cada filósofo"
                + "\n sólo puede tomar los que están a su derecha e izquierda. Si cualquier filósofo"
                + "\n toma un tenedor y el otro está ocupado, se quedará esperando, con el tenedor en"
                + "\n la mano, hasta que pueda tomar el otro tenedor, para luego empezar a comer."
                + "\n\n Si dos filósofos adyacentes intentan tomar el mismo tenedor a una vez, se"
                + "\n produce una condición de carrera: ambos compiten por tomar el mismo tenedor, y"
                + "\n uno de ellos se queda sin comer."
                + "\n\n Si todos los filósofos toman el tenedor que está a su derecha al mismo tiempo,"
                + "\n entonces todos se quedarán esperando eternamente, porque alguien debe liberar"
                + "\n el tenedor que les falta. Nadie lo hará porque todos se encuentran en la misma"
                + "\n situación (esperando que alguno deje sus tenedores). Entonces los filósofos se"
                + "\n morirán de hambre."
                + "\n Este bloqueo mutuo se denomina interbloqueo o deadlock."
                + "\n El problema consiste en encontrar un algoritmo que permita que"
                + "\n los filósofos nunca se mueran de hambre."
                + "\n\n\n Solución:"
                + "\n\n He planteado un algoritmo que corrige los conflitos en la cola de los tenedores:"
                + "\n Cada vez que un filósofo tiene un tenedor espera un tiempo aleatorio para"
                + "\n conseguir el segundo tenedor. Si en ese tiempo no queda libre el segundo tenedor,"
                + "\n suelta el que tiene y vuelve a ponerse en cola para sus dos tenedores. Si un"
                + "\n filósofo A suelta un tenedor (porque ha comido o porque ha esperado demasiado"
                + "\n tiempo con el tenedor en la mano) pero todavía desea comer, vuelve a ponerse en"
                + "\n cola para ese tenedor. Si el filósofo adyacente B está ya en esa cola de tenedor"
                + "\n (tiene hambre) lo toma y si no vuelve a cogerlo A. Es importante que el tiempo"
                + "\n de espera sea aleatorio o se mantendrá el bloqueo del sistema."
                + "\n Además hay que crea turnos para las comensales: Un portero para el comedor."
                + "\n Se indica a los filósofos que abandonen la mesa cuando no tengan hambre y que"
                + "\n no regresen a ella hasta que vuelvan a estar hambrientos. La misión del portero"
                + "\n es controlar el número de filósofos en la sala,"
                + "\n limitando su número a n-1, pues si hay n-1 comensales seguro que al menos uno"
                + "\n puede comer con los dos tenedores."
                + "\n\n\n De esta manera he conseguido un programa en el que la mayor parte del tiempo"
                + "\n hay dos Filósofos, comiendo y su ejecución se prolonga infinitamente.\n\n\n"
                + "\n Pulsa en Iniciar o si quieres antes puedes Crear un log\n\n\n");
        
        //Contador

        // Contadores de Comida:
        this.jTextField_Cont01.setText(" 0");
        this.jTextField_Cont02.setText(" 0");
        this.jTextField_Cont03.setText(" 0");
        this.jTextField_Cont04.setText(" 0");
        this.jTextField_Cont05.setText(" 0");
        this.jTextField_Cont7.setText(" 0");
        this.jTextField_Cont8.setText(" 0");
        this.jTextField_Cont9.setText(" 0");
        this.jTextField_Cont10.setText(" 0");
        this.jTextField_Cont11.setText(" 0");
        this.jTextField_Cont6.setText("");
        
        // Filósofos Configuración inicial:
        this.jLabel_Filo01.setOpaque(true);
        this.jLabel_Filo01.setBackground(Color.WHITE);
        this.jLabel_Filo02.setOpaque(true);
        this.jLabel_Filo02.setBackground(Color.WHITE);
        this.jLabel_Filo03.setOpaque(true);
        this.jLabel_Filo03.setBackground(Color.WHITE);
        this.jLabel_Filo04.setOpaque(true);
        this.jLabel_Filo04.setBackground(Color.WHITE);
        this.jLabel_Filo05.setOpaque(true);
        this.jLabel_Filo05.setBackground(Color.WHITE);
        this.jLabel_Filo7.setOpaque(true);
        this.jLabel_Filo7.setBackground(Color.WHITE);
        this.jLabel_Filo8.setOpaque(true);
        this.jLabel_Filo8.setBackground(Color.WHITE);
        this.jLabel_Filo9.setOpaque(true);
        this.jLabel_Filo9.setBackground(Color.WHITE);
        this.jLabel_Filo10.setOpaque(true);
        this.jLabel_Filo10.setBackground(Color.WHITE);
        this.jLabel_Filo11.setOpaque(true);
        this.jLabel_Filo11.setBackground(Color.WHITE);
        
        // Tenedores Configuración inicial:
        this.jLabel_Ten01.setText("  1  ");
        this.jLabel_Ten01.setOpaque(true);
        this.jLabel_Ten01.setBackground(Color.LIGHT_GRAY);
        this.jLabel_Ten01.setForeground(Color.WHITE);
        
        this.jLabel_Ten02.setText("  2  ");
        this.jLabel_Ten02.setOpaque(true);
        this.jLabel_Ten02.setBackground(Color.LIGHT_GRAY);
        this.jLabel_Ten02.setForeground(Color.WHITE);
        
        this.jLabel_Ten03.setText("  3  ");
        this.jLabel_Ten03.setOpaque(true);
        this.jLabel_Ten03.setBackground(Color.LIGHT_GRAY);
        this.jLabel_Ten03.setForeground(Color.WHITE);
        
        this.jLabel_Ten04.setText("  4  ");
        this.jLabel_Ten04.setOpaque(true);
        this.jLabel_Ten04.setBackground(Color.LIGHT_GRAY);
        this.jLabel_Ten04.setForeground(Color.WHITE);
        
        this.jLabel_Ten05.setText("  5  ");
        this.jLabel_Ten05.setOpaque(true);
        this.jLabel_Ten05.setBackground(Color.LIGHT_GRAY);
        this.jLabel_Ten05.setForeground(Color.WHITE);

        this.jLabel_Ten6.setText("  6  ");
        this.jLabel_Ten6.setOpaque(true);
        this.jLabel_Ten6.setBackground(Color.LIGHT_GRAY);
        this.jLabel_Ten6.setForeground(Color.WHITE);

        this.jLabel_Ten7.setText("  7  ");
        this.jLabel_Ten7.setOpaque(true);
        this.jLabel_Ten7.setBackground(Color.LIGHT_GRAY);
        this.jLabel_Ten7.setForeground(Color.WHITE);

        this.jLabel_Ten8.setText("  8  ");
        this.jLabel_Ten8.setOpaque(true);
        this.jLabel_Ten8.setBackground(Color.LIGHT_GRAY);
        this.jLabel_Ten8.setForeground(Color.WHITE);

        this.jLabel_Ten9.setText("  9  ");
        this.jLabel_Ten9.setOpaque(true);
        this.jLabel_Ten9.setBackground(Color.LIGHT_GRAY);
        this.jLabel_Ten9.setForeground(Color.WHITE);

        this.jLabel_Ten10.setText("  10  ");
        this.jLabel_Ten10.setOpaque(true);
        this.jLabel_Ten10.setBackground(Color.LIGHT_GRAY);
        this.jLabel_Ten10.setForeground(Color.WHITE);
        
        // Leyenda de colores:
        this.jLabel_est01.setText("    ");
        this.jLabel_est01.setOpaque(true);
        this.jLabel_est01.setBackground(Color.PINK);
        
        this.jLabel_est02.setText("    ");
        this.jLabel_est02.setOpaque(true);
        this.jLabel_est02.setBackground(Color.CYAN);
        
        this.jLabel_est03.setText("    ");
        this.jLabel_est03.setOpaque(true);
        this.jLabel_est03.setBackground(Color.ORANGE);
        
        this.jLabel_est04.setText("    ");
        this.jLabel_est04.setOpaque(true);
        this.jLabel_est04.setBackground(Color.WHITE);
        
        this.jLabel_est05.setText("    ");
        this.jLabel_est05.setOpaque(true);
        this.jLabel_est05.setBackground(Color.BLUE);
        
        this.jLabel_est06.setText("    ");
        this.jLabel_est06.setOpaque(true);
        this.jLabel_est06.setBackground(Color.LIGHT_GRAY);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_Filo01 = new javax.swing.JLabel();
        jLabel_Filo02 = new javax.swing.JLabel();
        jLabel_Filo03 = new javax.swing.JLabel();
        jLabel_Filo04 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel_est01 = new javax.swing.JLabel();
        jLabel_est02 = new javax.swing.JLabel();
        jLabel_est03 = new javax.swing.JLabel();
        jLabel_est05 = new javax.swing.JLabel();
        jLabel_est06 = new javax.swing.JLabel();
        jLabel_est04 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel_Ten01 = new javax.swing.JLabel();
        jLabel_Ten02 = new javax.swing.JLabel();
        jLabel_Ten03 = new javax.swing.JLabel();
        jLabel_Ten04 = new javax.swing.JLabel();
        jLabel_Ten05 = new javax.swing.JLabel();
        jLabel_Filo7 = new javax.swing.JLabel();
        jLabel_Filo05 = new javax.swing.JLabel();
        jLabel_Ten6 = new javax.swing.JLabel();
        jLabel_Filo8 = new javax.swing.JLabel();
        jLabel_Ten7 = new javax.swing.JLabel();
        jLabel_Filo9 = new javax.swing.JLabel();
        jLabel_Ten8 = new javax.swing.JLabel();
        jLabel_Filo10 = new javax.swing.JLabel();
        jLabel_Ten9 = new javax.swing.JLabel();
        jLabel_Filo11 = new javax.swing.JLabel();
        jLabel_Ten10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton_Iniciar = new javax.swing.JButton();
        jButton_Finalizar = new javax.swing.JButton();
        jCheckBox_Log = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton_Reset = new javax.swing.JButton();
        jTextField_Cont6 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Log = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Cont01 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Cont02 = new javax.swing.JTextField();
        jTextField_Cont03 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_Cont04 = new javax.swing.JTextField();
        jTextField_Cont05 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField_Cont7 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField_Cont8 = new javax.swing.JTextField();
        jTextField_Cont9 = new javax.swing.JTextField();
        jTextField_Cont10 = new javax.swing.JTextField();
        jTextField_Cont11 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(" La Cena de los Filósofos "));

        jLabel_Filo01.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Filo01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Filo01.setText("Filósofo 01");
        jLabel_Filo01.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        jLabel_Filo02.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Filo02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Filo02.setText("Filósofo 02");
        jLabel_Filo02.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));

        jLabel_Filo03.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Filo03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Filo03.setText("Filósofo 03");
        jLabel_Filo03.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        jLabel_Filo04.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Filo04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Filo04.setText("Filósofo 04");
        jLabel_Filo04.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));

        jPanel5.setBackground(new java.awt.Color(250, 250, 250));

        jPanel6.setBackground(new java.awt.Color(250, 250, 250));

        jLabel_est01.setText("jLabel1");

        jLabel_est02.setText("jLabel1");

        jLabel_est03.setText("jLabel1");

        jLabel_est05.setText("jLabel1");

        jLabel_est06.setText("jLabel1");

        jLabel_est04.setText("jLabel1");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_est01, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_est02, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_est03)
                            .addComponent(jLabel_est05)
                            .addComponent(jLabel_est06)
                            .addComponent(jLabel_est04))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_est01, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_est02, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_est03, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_est04, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel_est05, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_est06, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBackground(new java.awt.Color(250, 250, 250));

        jLabel6.setText("Filósofo entra a comer");

        jLabel7.setText("Filósofo tiene un tenedor");

        jLabel8.setText("Filósofo está comiendo");

        jLabel9.setText("Tenedor ocupado");

        jLabel10.setText("Tenedor libre");

        jLabel12.setText("Filósofo está pensando");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel11.setBackground(new java.awt.Color(250, 250, 250));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Código de colores:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel_Ten01.setText("jLabel1");

        jLabel_Ten02.setText("jLabel2");

        jLabel_Ten03.setText("jLabel3");

        jLabel_Ten04.setText("jLabel4");

        jLabel_Ten05.setText("jLabel5");

        jLabel_Filo7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Filo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Filo7.setText("Filósofo 06");
        jLabel_Filo7.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));

        jLabel_Filo05.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Filo05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Filo05.setText("Filósofo 05");
        jLabel_Filo05.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        jLabel_Ten6.setText("jLabel6");

        jLabel_Filo8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Filo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Filo8.setText("Filósofo 07");
        jLabel_Filo8.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));

        jLabel_Ten7.setText("jLabel7");

        jLabel_Filo9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Filo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Filo9.setText("Filósofo 08");
        jLabel_Filo9.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));

        jLabel_Ten8.setText("jLabel8");

        jLabel_Filo10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Filo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Filo10.setText("Filósofo 09");
        jLabel_Filo10.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));

        jLabel_Ten9.setText("jLabel10");

        jLabel_Filo11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Filo11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Filo11.setText("Filósofo 10");
        jLabel_Filo11.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));

        jLabel_Ten10.setText("jLabel9");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_Filo02, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_Filo04, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Ten01)
                            .addComponent(jLabel_Ten02))
                        .addGap(96, 96, 96)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Ten04)
                            .addComponent(jLabel_Ten03)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_Filo01, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_Filo03, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Filo05, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Filo7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel_Filo9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_Filo11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel_Filo8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_Filo10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel_Ten6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_Ten8))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel_Ten05)
                                .addGap(93, 93, 93)
                                .addComponent(jLabel_Ten7)))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Ten10)
                            .addComponent(jLabel_Ten9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Filo01, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Filo03, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Filo05, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Filo8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Filo10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Ten01)
                            .addComponent(jLabel_Ten03))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Ten02)
                            .addComponent(jLabel_Ten04)
                            .addComponent(jLabel_Ten6)
                            .addComponent(jLabel_Ten8)
                            .addComponent(jLabel_Ten9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Filo02, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Filo04, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Filo7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Filo9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Filo11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Ten05)
                            .addComponent(jLabel_Ten7)
                            .addComponent(jLabel_Ten10))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(" Controles "));

        jButton_Iniciar.setText("Iniciar");
        jButton_Iniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IniciarActionPerformed(evt);
            }
        });

        jButton_Finalizar.setText("Pausar");
        jButton_Finalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FinalizarActionPerformed(evt);
            }
        });

        jCheckBox_Log.setText("Crear un  log");
        jCheckBox_Log.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox_LogItemStateChanged(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton_Reset.setText("Reset");
        jButton_Reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ResetActionPerformed(evt);
            }
        });

        jTextField_Cont6.setText("jTextField1");

        jLabel19.setText("Ingrese una cantidad entre 3 a 10 filosofos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox_Log)
                .addGap(86, 86, 86)
                .addComponent(jButton_Iniciar)
                .addGap(18, 18, 18)
                .addComponent(jButton_Finalizar)
                .addGap(66, 66, 66)
                .addComponent(jButton_Reset)
                .addGap(101, 101, 101)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField_Cont6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Iniciar)
                    .addComponent(jButton_Finalizar)
                    .addComponent(jCheckBox_Log)
                    .addComponent(jButton_Reset)
                    .addComponent(jButton1)
                    .addComponent(jTextField_Cont6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(250, 250, 250));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(" Log "));

        jTextArea_Log.setColumns(20);
        jTextArea_Log.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Log);

        jPanel8.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setText("Cuántas veces han comido:");

        jLabel2.setText("Filósofo 1:");

        jTextField_Cont01.setText("jTextField1");

        jLabel3.setText("Filósofo 2:");

        jTextField_Cont02.setText("jTextField1");

        jTextField_Cont03.setText("jTextField1");

        jLabel4.setText("Filósofo 3:");

        jLabel5.setText("Filósofo 4:");

        jTextField_Cont04.setText("jTextField1");

        jTextField_Cont05.setText("jTextField1");

        jLabel13.setText("Filósofo 5:");

        jLabel14.setText("Filósofo 6:");

        jTextField_Cont7.setText("jTextField1");

        jLabel15.setText("Filósofo 7:");

        jLabel16.setText("Filósofo 8:");

        jLabel17.setText("Filósofo 9:");

        jLabel18.setText("Filósofo 10:");

        jTextField_Cont8.setText("jTextField1");

        jTextField_Cont9.setText("jTextField1");

        jTextField_Cont10.setText("jTextField1");

        jTextField_Cont11.setText("jTextField1");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Cont01, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Cont02)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Cont7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Cont8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Cont03, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_Cont9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Cont05, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_Cont11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Cont04, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_Cont10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_Cont01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField_Cont7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_Cont02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField_Cont8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_Cont03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField_Cont9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_Cont04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField_Cont10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Cont05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel18)
                    .addComponent(jTextField_Cont11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Dispara la ejecución del programa
     * @param evt Recibe el evento de hacer click sobre el botón
     */
    private void jButton_IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IniciarActionPerformed
        Philosopher.finish = false; // Para poder pausar o reiniciar.
        
        // Para que no cree un Log si el Checkbox no está selecionado:
        if (!jCheckBox_Log.isSelected()) jTextArea_Log = null;
        
        // Clase que contiene todos los objetos de la interface y que sera pasada por parámetro a la clase principal
        ControlGUI clase10Control = new ControlGUI(jLabel_Filo01, jLabel_Filo02, jLabel_Filo03, jLabel_Filo04, jLabel_Filo05, jLabel_Filo7, jLabel_Filo8,jLabel_Filo9,jLabel_Filo10,jLabel_Filo11,
            jLabel_Ten01, jLabel_Ten02, jLabel_Ten03, jLabel_Ten04, jLabel_Ten05, jLabel_Ten6,jLabel_Ten7,jLabel_Ten8,jLabel_Ten9,jLabel_Ten10,
            jTextArea_Log,
            jTextField_Cont01, jTextField_Cont02, jTextField_Cont03, jTextField_Cont04, jTextField_Cont05, jTextField_Cont7,jTextField_Cont8,jTextField_Cont9,jTextField_Cont10,jTextField_Cont11, jTextField_Cont6); 
        
        // Clase Principal con la lógica del programa:
        // Recibe por parámetro la clase Clase10Control que contiene todos los elemntos de la interface
        Principal principal = new Principal(clase10Control, validaInt(jTextField_Cont6.getText()));
        this.jButton_Finalizar.setEnabled(true);
        this.jButton_Iniciar.setEnabled(false);
        this.jCheckBox_Log.setEnabled(false);
    }//GEN-LAST:event_jButton_IniciarActionPerformed
    /**
     * Dispara la pausa de la ejecución
     * @param evt Recibe el evento de hacer click sobre el botón
     */
    private void jButton_FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FinalizarActionPerformed
        Philosopher.finish = true;
        try {
            sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println("Error. Descripción: " + ex.toString());
        }
        this.jButton_Iniciar.setEnabled(true);
        this.jButton_Finalizar.setEnabled(false);
    }//GEN-LAST:event_jButton_FinalizarActionPerformed

    private void jCheckBox_LogItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox_LogItemStateChanged
        if (jCheckBox_Log.isSelected()) {
            this.jTextArea_Log.append("\n\n Atención:"
                    + "\n Acabas de seleccionar crear un log en esta pantalla. Tienes que tener en cuenta"
                    + "\n que los diferentes procesos tienen que escribir lo que hacen antes de continuar"
                    + "\n con lo cual puede relentizar la ejecución del programa, ya que todos tiene que usar"
                    + "\n este mismo recurso."
                    + "\n Utiliza el Log sólo para fines de comprobación.\n\n"
                    + "\n Pulsa en Iniciar\n\n\n");
            this.jTextArea_Log.setCaretPosition(this.jTextArea_Log.getDocument().getLength());
        }
        if (!jCheckBox_Log.isSelected()) {
            this.jTextArea_Log.append("\n\n Atención:"
                    + "\n Acabas de deseleccionar crear un log en esta pantalla. Esta es la mejor"
                    + "\n forma de ejecutar el programa. El algoritmo se desarrolla íntegro, sin la escritura"
                    + "\n de todos los procesos."
                    + "\n Se debe usar el Log sólo para fines de comprobación.\n\n"
                    + "\n Pulsa en Iniciar");
            this.jTextArea_Log.setCaretPosition(this.jTextArea_Log.getDocument().getLength());
        }
    }//GEN-LAST:event_jCheckBox_LogItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ResetActionPerformed
        Philosopher.finish = true;
        try {
            sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println("Error. Descripción: " + ex.toString());
        }
        this.dispose();
        JFrame v10control=new ControlView();
    }//GEN-LAST:event_jButton_ResetActionPerformed


public int validaInt(String number){
    int result = 0; //Valor default.
    try{
        if(number != null){
            result = Integer.parseInt(number);
        }
    }catch(NumberFormatException nfe){
        //*No es numerico!
    }
    return result;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Finalizar;
    private javax.swing.JButton jButton_Iniciar;
    private javax.swing.JButton jButton_Reset;
    private javax.swing.JCheckBox jCheckBox_Log;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Filo01;
    private javax.swing.JLabel jLabel_Filo02;
    private javax.swing.JLabel jLabel_Filo03;
    private javax.swing.JLabel jLabel_Filo04;
    private javax.swing.JLabel jLabel_Filo05;
    private javax.swing.JLabel jLabel_Filo10;
    private javax.swing.JLabel jLabel_Filo11;
    private javax.swing.JLabel jLabel_Filo7;
    private javax.swing.JLabel jLabel_Filo8;
    private javax.swing.JLabel jLabel_Filo9;
    private javax.swing.JLabel jLabel_Ten01;
    private javax.swing.JLabel jLabel_Ten02;
    private javax.swing.JLabel jLabel_Ten03;
    private javax.swing.JLabel jLabel_Ten04;
    private javax.swing.JLabel jLabel_Ten05;
    private javax.swing.JLabel jLabel_Ten10;
    private javax.swing.JLabel jLabel_Ten6;
    private javax.swing.JLabel jLabel_Ten7;
    private javax.swing.JLabel jLabel_Ten8;
    private javax.swing.JLabel jLabel_Ten9;
    private javax.swing.JLabel jLabel_est01;
    private javax.swing.JLabel jLabel_est02;
    private javax.swing.JLabel jLabel_est03;
    private javax.swing.JLabel jLabel_est04;
    private javax.swing.JLabel jLabel_est05;
    private javax.swing.JLabel jLabel_est06;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_Log;
    private javax.swing.JTextField jTextField_Cont01;
    private javax.swing.JTextField jTextField_Cont02;
    private javax.swing.JTextField jTextField_Cont03;
    private javax.swing.JTextField jTextField_Cont04;
    private javax.swing.JTextField jTextField_Cont05;
    private javax.swing.JTextField jTextField_Cont10;
    private javax.swing.JTextField jTextField_Cont11;
    private javax.swing.JTextField jTextField_Cont6;
    private javax.swing.JTextField jTextField_Cont7;
    private javax.swing.JTextField jTextField_Cont8;
    private javax.swing.JTextField jTextField_Cont9;
    // End of variables declaration//GEN-END:variables
}


