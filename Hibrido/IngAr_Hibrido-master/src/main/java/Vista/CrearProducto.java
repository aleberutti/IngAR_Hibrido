/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.FusekiController;
import Controlador.ModelController;
import Controlador.MongoController;
import Controlador.TDBController;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.bson.Document;


public class CrearProducto extends javax.swing.JFrame {
    private MongoController mongocontroller;
    private FusekiController fusekicontroller;
    private ModelController modelcontroller;
    private TDBController tdb;
    private Document datos;
    private boolean activarComentarios;
    
    /**
     * Creates new form CrearProducto
     * @param m
     * @param f
     * @param mo
     * @param t
     */
    @SuppressWarnings("empty-statement")
    public CrearProducto(MongoController m, FusekiController f, ModelController mo, TDBController t) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.modelcontroller=mo;
        this.mongocontroller=m;
        this.fusekicontroller=f;
        this.tdb=t;
        datos = new Document();

        setearCampos();
                
        this.lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                propiedad.setText(lista.getSelectedValue().toUpperCase());
                //Si ya presiono aceptar alguna vez, entonces hay algo guardado dentro del documento datos
                //Entonces si hay algo guardado, se tiene que mostrra la info relacionada con la caracteristica
                //Esta es la solucion precaria que encontre por el momento
                setearArea();
            }
        });    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        propiedad = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        campopropiedad = new javax.swing.JTextArea();
        atras = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        titulo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 25)); // NOI18N
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        titulo.setText(" Agregar Producto");

        jSeparator3.setBackground(new java.awt.Color(153, 153, 153));

        guardar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        guardar.setText("Guardar Producto");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

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

        aceptar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(atras)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(titulo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(propiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(guardar)
                                .addGap(18, 18, 18)
                                .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(104, 104, 104)))))
                .addGap(74, 74, 74))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(propiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        verificarArea();
    }//GEN-LAST:event_aceptarActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // TODO add your handling code here:
        int seleccion = JOptionPane.showOptionDialog(this, "¿Está seguro que desea volver? \n No se guardaran los datos", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            null,    // null para icono por defecto.
            new Object[] { "Si", "No" },   // null para YES, NO y CANCEL
            "Si");
        if (seleccion==0){
            Inicio i = new Inicio(mongocontroller, fusekicontroller, tdb, modelcontroller);
            i.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_atrasActionPerformed

    private void listaevento(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaevento

    }//GEN-LAST:event_listaevento

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        int seleccion = JOptionPane.showOptionDialog(this, "No se guardaran los datos \n ¿Está seguro que desea cancelar?", "",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            null,    // null para icono por defecto.
            new Object[] { "Si", "No" },   // null para YES, NO y CANCEL
            "Si");
        if (seleccion==0){
            Inicio i = new Inicio(mongocontroller, fusekicontroller, tdb, modelcontroller);
            this.setVisible(false);
            i.setVisible(true);
        }
    }//GEN-LAST:event_cancelarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        //Agrego el documento nuevo a mongo
        mongocontroller.agregarDoc(datos);
        
        JOptionPane.showMessageDialog(this, "Se han guardado los cambios", "Exito",  JOptionPane.INFORMATION_MESSAGE);
        Inicio i = new Inicio(mongocontroller, fusekicontroller, tdb, modelcontroller);
        this.setVisible(false);
        i.setVisible(true);
    }//GEN-LAST:event_guardarActionPerformed

    private void setearCampos(){
        ExtendedIterator <?extends OntProperty> it= this.modelcontroller.getProperties();
        
        DefaultListModel modelo = new DefaultListModel();
        
        //Agrego la propiedad a la lista porque no me lo levanta de fuseki
        modelo.addElement("ID");
        
        while(it.hasNext()){
            String prop = it.next().getLabel(null);
            modelo.addElement(prop);  
        }

        //Se agrega uno que diga Nombre
        modelo.addElement("Nombre");
        //Saco el name(0..1) para que no quede tan feo
        modelo.removeElement("name (0..1)");
        //Saco las categorias porque si pone una combinacion de categorias que no se cubrireron, no se sae instancia de que clase es
        modelo.removeElement("Categorías");
       
        lista.setModel(modelo);
    }
    
    private void verificarArea(){
        if(!this.campopropiedad.getText().isEmpty()){
        //Agrego al documento la propiedad con el valor que haya escrito en el campo. 
        //La propiedad en minuscula porque asi estan escritas en mongo

            if(datos.containsKey(lista.getSelectedValue().toLowerCase())){
                //Si ya existia la propiedad la reemplazo 
                datos.replace(lista.getSelectedValue().toLowerCase(), campopropiedad.getText());
            }
                          
            else{
                if(lista.getSelectedValue() == "ID"){
                    if(mongocontroller.validarID(campopropiedad.getText())){
                        //Si no hay un documento con ese id
                        String uri = "http://www.ebusiness-unibw.org/ontologies/pcs2owl/gpc/";
                        datos.append("_id", uri+campopropiedad.getText()); 
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Ya existe un elemento con ese ID", "Error",  JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    datos.append(lista.getSelectedValue().toLowerCase(), campopropiedad.getText()); 
                }
               }

           }
        
        else{
            JOptionPane.showMessageDialog(this, "El campo no puede estar vacio", "Atencion",  JOptionPane.INFORMATION_MESSAGE);
        }

}
    
    
    private void setearArea(){
        if(datos.keySet().contains(lista.getSelectedValue().toLowerCase())){
            campopropiedad.setText((String) datos.get(lista.getSelectedValue().toLowerCase()));
        }
        else{
            campopropiedad.setText("");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton atras;
    private javax.swing.JTextArea campopropiedad;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JList<String> lista;
    private javax.swing.JLabel propiedad;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
