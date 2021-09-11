package POO.IIB.Project;

import com.mindfusion.common.DateTime;
import com.mindfusion.drawing.Brush;
import com.mindfusion.drawing.Brushes;
import com.mindfusion.scheduling.CalendarAdapter;
import com.mindfusion.scheduling.ItemMouseEvent;
import com.mindfusion.scheduling.ResourceDateEvent;
import com.mindfusion.scheduling.model.Appointment;
import com.mindfusion.scheduling.model.ItemEvent;
import com.mindfusion.scheduling.model.ItemList;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bTeam
 */
 

public class GUICalendar extends javax.swing.JFrame {
    //Inicializo el componente tabla
    DefaultTableModel dtmTabla;
    Evento miEvento; 
    GUIEventDetail guiEvent; 
    pnlTabla panelTable; 
    public GUICalendar() {
        initComponents();
        calendar.setEnabled(false);

        
       guiEvent = new GUIEventDetail(); 
                               panelTable = new pnlTabla(); 

        //Modelo de la tabla
        dtmTabla = new DefaultTableModel(); 
        dtmTabla.addColumn("Nombre");
        dtmTabla.addColumn("Descripcion");
        dtmTabla.addColumn("Fecha");
        dtmTabla.addColumn("Categoria");

        tblDate.setModel(dtmTabla);
        
        //Corregir el warning.
        
        calendar.setEnabled(false);
        VisibilidadDatosComunes(false);
        btnRegresar.setVisible(false);

                            
        //Se añade un Listener para que el objeto AwtCalendar esté a la escucha de una evento
        calendar.addCalendarListener(new CalendarAdapter(){
            
            /*
            Esta funcion recibe como argumento un objeto del tipo
            ResourceDateEvent, dicho evento tiene toda la información
            de la fecha y posicion del evento en el calendario.
            */
            @Override
            public void dateClick(ResourceDateEvent e) {
               
                //Objeto del tipo Appointment para crear eventos en el calendario
                Appointment item = new Appointment();
                
                
                //Encapsular datos
               
                    if(cmbCategoria.getSelectedIndex()==0){
                      miEvento = new Academia(txtNombreEvento.getText(),txtDescripcion.getText(), txtDetalles.getText(), "Metodos", "link"); 
                      //Se debe declarar el constructor.
                      }
                      if(cmbCategoria.getSelectedIndex()==1){
                          miEvento = new Recordatorio(txtNombreEvento.getText(),txtDescripcion.getText(), txtDetalles.getText()); 
                      }


                      //Parametros para crear evento
                      item.setStartTime(e.getDate().addHours(8).addMinutes(25).addSeconds(35));
                      DateTime h = e.getDate().addHours(17).addMinutes(25).addSeconds(35);

                      item.setEndTime(h);
                      item.setHeaderText(miEvento.getNombre());
                      item.setDescriptionText(miEvento.getDescripcion());
                      item.setDetails(miEvento.getDetalles());



                    //Permite seleccionar un color del evento.
                    if(rbtAlta.isSelected()){
                        item.getStyle().setBrush(brushes[0]);
                    }
                    if(rbtMedia.isSelected()){
                        item.getStyle().setBrush(brushes[1]);
                    }
                    if(rbtBaja.isSelected()){
                        item.getStyle().setBrush(brushes[2]);
                    }

                   //Aniade el item creado al objeto AwtCalendar.
                    calendar.getSchedule().getItems().add(item);

                    System.out.println("Valor: " + item.getStartTime() + item.getEndTime());
                    //Llena los datos en la tabla.
                    dtmTabla.addRow(new Object[]{
                        miEvento.getNombre(),
                        miEvento.getDescripcion() ,
                        item.getStartTime(),
                        miEvento.getClass().getSimpleName()

                    });
                    panelTable.miTabla.addRow(new Object []{
                        miEvento.getNombre(),
                        miEvento.getDescripcion() ,
                        item.getStartTime(),
                        miEvento.getClass().getSimpleName()
                    });
                       

            }
            
            
            //Listener al hacer click en un evento creado.
            @Override
            public void itemClick(ItemMouseEvent h){ 

                // Esta es la clave para convertir en un itemEvent que ya esta registrado con su id.
                ItemEvent actualItem = (ItemEvent)h; 
                
                /*
                //Acciones para ver la capacidad de hacer click en un evento
                System.out.println("ID: " + name.getItem().getId());
                ItemList y = calendar.getSchedule().getItems();
                System.out.println("Item List: " + calendar.getSchedule().getItems());
                System.out.println("tipo: " + name.getItem().getId().getClass());
                */   
                    
                //Ocultar eventos
                if(chkPrueba.isSelected()){
                    //Hacer items events no visibles
                    actualItem.getItem().setVisible(false);//No los elimina!
                }else{
                    //GUIDetalles del evento
                guiEvent.lblNombreEvento.setText(actualItem.getItem().getHeaderText());
                guiEvent.txaDescripcion.setText(actualItem.getItem().getDescriptionText());

                guiEvent.setVisible(rootPaneCheckingEnabled);
                }
                
                
            }
        });
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        color1 = new com.mindfusion.drawing.Color();
        customBrushes1 = new com.mindfusion.scheduling.model.CustomBrushes();
        dateStyle1 = new com.mindfusion.scheduling.DateStyle();
        gradientBrush1 = new com.mindfusion.drawing.GradientBrush();
        btgColor = new javax.swing.ButtonGroup();
        calendar = new com.mindfusion.scheduling.awt.AwtCalendar();
        chkPrueba = new javax.swing.JCheckBox();
        pnlColores = new javax.swing.JPanel();
        rbtAlta = new javax.swing.JRadioButton();
        rbtMedia = new javax.swing.JRadioButton();
        rbtBaja = new javax.swing.JRadioButton();
        pnlDatos = new javax.swing.JPanel();
        txtNombreEvento = new javax.swing.JTextField();
        txtDetalles = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        pnlGuiTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDate = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        seeTable = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 100));

        chkPrueba.setText("Eliminar evento");
        chkPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPruebaActionPerformed(evt);
            }
        });

        pnlColores.setBackground(new java.awt.Color(153, 153, 153));
        pnlColores.setBorder(javax.swing.BorderFactory.createTitledBorder("Prioridad"));
        pnlColores.setForeground(new java.awt.Color(102, 102, 102));

        btgColor.add(rbtAlta);
        rbtAlta.setForeground(new java.awt.Color(255, 0, 51));
        rbtAlta.setText("Alta");

        btgColor.add(rbtMedia);
        rbtMedia.setForeground(new java.awt.Color(255, 255, 0));
        rbtMedia.setText("Media");

        btgColor.add(rbtBaja);
        rbtBaja.setForeground(new java.awt.Color(51, 255, 0));
        rbtBaja.setText("Baja");

        javax.swing.GroupLayout pnlColoresLayout = new javax.swing.GroupLayout(pnlColores);
        pnlColores.setLayout(pnlColoresLayout);
        pnlColoresLayout.setHorizontalGroup(
            pnlColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        pnlColoresLayout.setVerticalGroup(
            pnlColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtMedia)
                .addGap(12, 12, 12)
                .addComponent(rbtBaja)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pnlDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos generales"));

        txtNombreEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEventoActionPerformed(evt);
            }
        });
        txtNombreEvento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreEventoKeyReleased(evt);
            }
        });

        jLabel3.setText("Detalles del Evento");

        jLabel1.setText("Nombre del Evento");

        jLabel2.setText("Descripcion del evento");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2))
                    .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDetalles, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(txtDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Academia", "Recordatorio" }));
        cmbCategoria.setSelectedIndex(-1);
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        tblDate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDate);

        javax.swing.GroupLayout pnlGuiTablaLayout = new javax.swing.GroupLayout(pnlGuiTabla);
        pnlGuiTabla.setLayout(pnlGuiTablaLayout);
        pnlGuiTablaLayout.setHorizontalGroup(
            pnlGuiTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGuiTablaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGuiTablaLayout.setVerticalGroup(
            pnlGuiTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGuiTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel4.setText("Elija la categoria de su evento:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hora de inicio y fin"));

        jLabel5.setText("Hora de inicio");

        jLabel6.setText("Hora de fin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(44, 44, 44)
                .addComponent(jLabel6)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jMenu1.setText("Eventos");

        seeTable.setText("Visualizar Tabla");
        seeTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeTableActionPerformed(evt);
            }
        });
        jMenu1.add(seeTable);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlGuiTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(90, 90, 90)
                                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnlColores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegresar)
                            .addComponent(chkPrueba))
                        .addGap(1, 1, 1)
                        .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGuiTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlColores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void VisibilidadDatosComunes(boolean val){
        
        txtNombreEvento.setEnabled(val);
        txtDescripcion.setEnabled(val);
        txtDetalles.setEnabled(val);
        pnlDatos.setEnabled(val);
        //calendar.setEnabled(val);

        

    }
    
    private void chkPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPruebaActionPerformed
        
    }//GEN-LAST:event_chkPruebaActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        if(cmbCategoria.getSelectedIndex()==0){
            VisibilidadDatosComunes(true);
            //Se debe declarar el constructor.
        }
        if(cmbCategoria.getSelectedIndex()==1){
            VisibilidadDatosComunes(true);

        }
            
        
    }//GEN-LAST:event_cmbCategoriaActionPerformed
    public void insivibleCalendar(boolean val){
        
        pnlDatos.setVisible(val);
        calendar.setVisible(val);
        pnlColores.setVisible(val);
        pnlGuiTabla.setVisible(val);
        cmbCategoria.setVisible(val);
       
    }
    private void seeTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeTableActionPerformed
        insivibleCalendar(false);
        btnRegresar.setVisible(true);
        panelTable.setVisible(true);
        panelTable.setSize(550, 300);
        panelTable.setLocation(300, 50);
        add(panelTable);
        revalidate();
        repaint();
        
    }//GEN-LAST:event_seeTableActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        panelTable.setVisible(false);
        insivibleCalendar(true);
        btnRegresar.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtNombreEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEventoActionPerformed
      
    }//GEN-LAST:event_txtNombreEventoActionPerformed

    private void txtNombreEventoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEventoKeyReleased
       if(txtNombreEvento.getText().trim().isEmpty()){
                calendar.setEnabled(false);
                JOptionPane.showMessageDialog(rootPane, "Los eventos deben tener un nombre para ser creados. \nSi desea eliminar un evento, seleccione eliminar y luego click en el evento.");
        }else{
            calendar.setEnabled(true);
       }
        
        
        
    }//GEN-LAST:event_txtNombreEventoKeyReleased

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUICalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUICalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUICalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUICalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUICalendar().setVisible(true);
            }
        });
    }
 
    
    //Array que aloja los colores que puede tener un evento
    Brush[] brushes = {
                Brushes.Red, Brushes.Yellow, Brushes.GreenYellow,
                Brushes.LightGreen, Brushes.LightGray, Brushes.LightPink,
                Brushes.LemonChiffon
    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgColor;
    private javax.swing.JButton btnRegresar;
    private com.mindfusion.scheduling.awt.AwtCalendar calendar;
    private javax.swing.JCheckBox chkPrueba;
    private javax.swing.JComboBox<String> cmbCategoria;
    private com.mindfusion.drawing.Color color1;
    private com.mindfusion.scheduling.model.CustomBrushes customBrushes1;
    private com.mindfusion.scheduling.DateStyle dateStyle1;
    private com.mindfusion.drawing.GradientBrush gradientBrush1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlColores;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlGuiTabla;
    private javax.swing.JRadioButton rbtAlta;
    private javax.swing.JRadioButton rbtBaja;
    private javax.swing.JRadioButton rbtMedia;
    private javax.swing.JMenuItem seeTable;
    public javax.swing.JTable tblDate;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDetalles;
    private javax.swing.JTextField txtNombreEvento;
    // End of variables declaration//GEN-END:variables
}
