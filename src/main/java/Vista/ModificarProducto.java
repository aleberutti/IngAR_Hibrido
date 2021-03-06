
package Vista;


import Controlador.*;
import java.util.Iterator;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.bson.Document;


public class ModificarProducto extends javax.swing.JFrame {
    private MongoController mc;
    private FusekiController fc;
    private ModelController modelcontroller;
    private TDBController tdb;
    private Document datos;
    /**
     * Creates new form ModificarProducto
     * @param m
     * @param f
     * @param mo
     * @param t
     * @param d
     */
    public ModificarProducto(MongoController m, FusekiController f, ModelController mo, TDBController t, Document d) {
        initComponents();
        this.mc = m;
        this.fc = f;
        this.datos = d;
        this.modelcontroller=mo;
        this.tdb=t;
        this.setearCampos(datos);
        this.setLocationRelativeTo(null);
        
        
        //Cambia lo que esta en el text area y el text field cuando selecciona valores en la lista
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                propiedad.setText(lista.getSelectedValue().toUpperCase());
                campopropiedad.setText(datos.get(lista.getSelectedValue().toLowerCase()).toString());
            }
        });

    }

    private ModificarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void setearCampos(Document doc){
        this.propiedad.setText("");
        this.campoid.setText(doc.get("_id").toString());
        
        //Obtengo las propiedades
        Set<String> propiedades = doc.keySet();
        
        //Saco las categorias porque no se pueden modificar
        for(int i=0; i<propiedades.size(); i++){
            if(propiedades.contains("categoria 1")){
                propiedades.remove("categoria 1");
            }
            if(propiedades.contains("categoria 2")){
                propiedades.remove("categoria 2");
            }
            if(propiedades.contains("categoria 3")){
                propiedades.remove("categoria 3");
            }
        }
        
        Iterator it = propiedades.iterator();
        
        DefaultListModel modelo = new DefaultListModel();
        
        //Para saltear el id porque no se puede modificar
        it.next();
        
        while(it.hasNext()){
            String prop = it.next().toString().toUpperCase();
            modelo.addElement(prop);
        }
        
        lista.setModel(modelo);
    }
   
    private void getCamposModificados(){
        //Si un campo esta vacio, se elimina la propiedad del documento
        //Si no esta vacio, se reemplaza por el valor en el campo
        Document datos_viejo = datos;
        
        if(!campopropiedad.getText().isEmpty()){
            datos.replace(lista.getSelectedValue().toLowerCase(), campopropiedad.getText());
        }
        else{
            datos.remove(lista.getSelectedValue().toLowerCase());
        }
        
        if(mc.modificarDoc(datos, datos_viejo)!=0){
            JOptionPane.showMessageDialog(this, "Se han guardado los cambios", "Exito",  JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        guardar = new javax.swing.JButton();
        campoid = new javax.swing.JTextField();
        id = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        propiedad = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        campopropiedad = new javax.swing.JTextArea();
        atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(173, 199, 228));

        titulo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 25)); // NOI18N
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settings.png"))); // NOI18N
        titulo.setText(" Modificar Producto");

        jSeparator3.setBackground(new java.awt.Color(121, 159, 200));

        guardar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        campoid.setEditable(false);
        campoid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoidActionPerformed(evt);
            }
        });

        id.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        id.setText("ID:");

        cancelar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaevento(evt);
            }
        });
        jScrollPane6.setViewportView(lista);

        propiedad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        campopropiedad.setColumns(20);
        campopropiedad.setRows(5);
        jScrollPane7.setViewportView(campopropiedad);

        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left-arrow.png"))); // NOI18N
        atras.setBorderPainted(false);
        atras.setContentAreaFilled(false);
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(id)
                        .addGap(18, 18, 18)
                        .addComponent(campoid))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(propiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(38, 38, 38))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(atras)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atras)
                .addGap(11, 11, 11)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(propiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        this.getCamposModificados();
    }//GEN-LAST:event_guardarActionPerformed

    private void campoidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoidActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        int seleccion = JOptionPane.showOptionDialog(this, "No se guardaran los datos \n ¿Está seguro que desea cancelar?", "",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            null,    // null para icono por defecto.
            new Object[] { "Si", "No" },   // null para YES, NO y CANCEL
            "Si");
        if (seleccion==0){
            Inicio i = new Inicio(mc, fc, tdb, modelcontroller);
            this.setVisible(false);
            i.setVisible(true);
        }
    }//GEN-LAST:event_cancelarActionPerformed

    private void listaevento(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaevento

    }//GEN-LAST:event_listaevento

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // TODO add your handling code here:
        int seleccion = JOptionPane.showOptionDialog(this, "¿Está seguro que desea volver? \n No se guardaran los datos", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            null,    // null para icono por defecto.
            new Object[] { "Si", "No" },   // null para YES, NO y CANCEL
            "Si");
        if (seleccion==0){
            ResultadosBusqueda rb = new ResultadosBusqueda(mc, fc, modelcontroller, tdb, datos.get("_id").toString(), datos.get("nombre").toString(), datos.get("marca").toString(), datos.get("modelo").toString(), datos.get("tipo").toString());
            rb.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_atrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JTextField campoid;
    private javax.swing.JTextArea campopropiedad;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel id;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JList<String> lista;
    private javax.swing.JLabel propiedad;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}