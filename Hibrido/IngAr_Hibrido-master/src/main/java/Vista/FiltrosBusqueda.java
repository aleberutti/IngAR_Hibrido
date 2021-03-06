
package Vista;

import Controlador.*;
import java.awt.event.KeyEvent;

public class FiltrosBusqueda extends javax.swing.JFrame {
    private MongoController mongocontroller;
    private FusekiController fusekicontroller;
    private ModelController modelcontroller;
    private TDBController tdbcontroller;
    /**
     * Creates new form FiltrosBusqueda2
     * @param mc
     * @param fc
     */
    public FiltrosBusqueda(MongoController mc, FusekiController fc, ModelController mo, TDBController t) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.mongocontroller = mc;
        this.fusekicontroller = fc;
        this.modelcontroller=mo;
        this.tdbcontroller=t;
    }

    private FiltrosBusqueda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        id = new javax.swing.JCheckBox();
        nombre = new javax.swing.JCheckBox();
        marca = new javax.swing.JCheckBox();
        modelo = new javax.swing.JCheckBox();
        tipo = new javax.swing.JCheckBox();
        buscar = new javax.swing.JButton();
        campoid = new javax.swing.JTextField();
        camponombre = new javax.swing.JTextField();
        campomarca = new javax.swing.JTextField();
        campomodelo = new javax.swing.JTextField();
        campotipo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(173, 199, 228));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 25)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jLabel1.setText("Buscar Por");

        jSeparator1.setBackground(java.awt.SystemColor.activeCaption);
        jSeparator1.setForeground(java.awt.SystemColor.activeCaption);

        id.setText("ID");
        id.setContentAreaFilled(false);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        nombre.setText("Nombre");
        nombre.setContentAreaFilled(false);
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        marca.setText("Marca");
        marca.setContentAreaFilled(false);
        marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaActionPerformed(evt);
            }
        });

        modelo.setText("Modelo");
        modelo.setContentAreaFilled(false);
        modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloActionPerformed(evt);
            }
        });

        tipo.setText("Tipo");
        tipo.setContentAreaFilled(false);
        tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Handler(evt);
            }
        });

        campoid.setEnabled(false);
        campoid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoidActionPerformed(evt);
            }
        });
        campoid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Handlercampoid(evt);
            }
        });

        camponombre.setEnabled(false);
        camponombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Handlercamponombre(evt);
            }
        });

        campomarca.setEnabled(false);
        campomarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Handlercampomarca(evt);
            }
        });

        campomodelo.setEnabled(false);
        campomodelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Handlercampomodelo(evt);
            }
        });

        campotipo.setEnabled(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left-arrow.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(tipo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(modelo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campomodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(nombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                    .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(marca)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campomarca, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(id)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoid, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campomarca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marca))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campomodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelo))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo))
                .addGap(46, 46, 46)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
        if(nombre.isSelected()){
            camponombre.setEnabled(true);
        }
        else{
            if(nombre.isEnabled()){
                camponombre.setEnabled(false);
                camponombre.setText(null);
            }
        }
    }//GEN-LAST:event_nombreActionPerformed

    private void marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaActionPerformed
        // TODO add your handling code here:
        if(marca.isSelected()){
            campomarca.setEnabled(true);
        }
        else{
            if(marca.isEnabled()){
                campomarca.setEnabled(false);
                campomarca.setText(null);
            }
        }
    }//GEN-LAST:event_marcaActionPerformed

    private void modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloActionPerformed
        // TODO add your handling code here:
        if(modelo.isSelected()){
            campomodelo.setEnabled(true);
        }
        else{
            if(modelo.isEnabled()){
                campomodelo.setEnabled(false);
                campomodelo.setText(null);
            }
        }
    }//GEN-LAST:event_modeloActionPerformed

    private void tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoActionPerformed
        // TODO add your handling code here:
        if(tipo.isSelected()){
            campotipo.setEnabled(true);
        }
        else{
            if(tipo.isEnabled()){
                campotipo.setEnabled(false);
                campotipo.setText(null);
            }
        }
    }//GEN-LAST:event_tipoActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
        if(id.isSelected()){
            campoid.setEnabled(true);
        }
        else{
            if(id.isEnabled()){
                campoid.setEnabled(false);
                campoid.setText(null);
            }
        }
    }//GEN-LAST:event_idActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Inicio i = new Inicio(mongocontroller, fusekicontroller, tdbcontroller, modelcontroller);
        i.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed

        String cid = campoid.getText();
        String cnombre = camponombre.getText();
        String cmarca = campomarca.getText();
        String cmodelo = campomodelo.getText();
        String cclase = campotipo.getText();
        
        //si el campo esta vacio lo seteo en null para poder pasarle algo al constructor mas abajo
        if(campoid.getText().isEmpty()){
            cid = null; 
        }

        if(camponombre.getText().isEmpty()){
            cnombre = null;
        }
        
        if(campomarca.getText().isEmpty()){
            cmarca = null;
        }
        
        if(campomodelo.getText().isEmpty()){
            cmodelo = null;
        }
        
        if(campotipo.getText().isEmpty()){
            cclase = null;
        }
        
        ResultadosBusqueda rb = new ResultadosBusqueda(mongocontroller, fusekicontroller, modelcontroller, tdbcontroller, cid, cnombre, cmarca, cmodelo, cclase);
        rb.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buscarActionPerformed

    private void Handler(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Handler
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.buscar.requestFocus();
            this.buscar.doClick();
        }
    }//GEN-LAST:event_Handler

    private void campoidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoidActionPerformed

    private void Handlercampoid(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Handlercampoid
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.buscar.requestFocus();
            this.buscar.doClick();
        }
    }//GEN-LAST:event_Handlercampoid

    private void Handlercamponombre(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Handlercamponombre
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.buscar.requestFocus();
            this.buscar.doClick();
        }
    }//GEN-LAST:event_Handlercamponombre

    private void Handlercampomarca(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Handlercampomarca
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.buscar.requestFocus();
            this.buscar.doClick();
        }
    }//GEN-LAST:event_Handlercampomarca

    private void Handlercampomodelo(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Handlercampomodelo
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.buscar.requestFocus();
            this.buscar.doClick();
        }
    }//GEN-LAST:event_Handlercampomodelo

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JTextField campoid;
    private javax.swing.JTextField campomarca;
    private javax.swing.JTextField campomodelo;
    private javax.swing.JTextField camponombre;
    private javax.swing.JTextField campotipo;
    private javax.swing.JCheckBox id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox marca;
    private javax.swing.JCheckBox modelo;
    private javax.swing.JCheckBox nombre;
    private javax.swing.JCheckBox tipo;
    // End of variables declaration//GEN-END:variables
}
