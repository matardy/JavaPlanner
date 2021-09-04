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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bTeam
 */
 //Branch IsaacDev

public class GUICalendar extends javax.swing.JFrame {
    //Inicializo el componente tabla
    DefaultTableModel dtmTabla;
   
    public GUICalendar() {
        initComponents();
       
        //Modelo de la tabla
        dtmTabla = new DefaultTableModel(); 
        dtmTabla.addColumn("Nombre");
        dtmTabla.addColumn("Descripcion");
        dtmTabla.addColumn("Fecha");
        tblDate.setModel(dtmTabla);
        
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
                
                //Parametros para crear evento
                item.setStartTime(e.getDate());
                DateTime h = e.getDate().addHours(5);
                item.setEndTime(h);
                item.setHeaderText(txtDato.getText());
                item.setDescriptionText(txtDescripcion.getText());
                
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
                

                //Llena los datos en la tabla.
                dtmTabla.addRow(new Object[]{
                    item.getHeaderText(), 
                    item.getDescriptionText(),
                    e.getDate().getDay()
                });

            }
            
            
            //Listener al hacer click en un evento creado.
            @Override
            public void itemClick(ItemMouseEvent h){ 

                // Esta es la clave para convertir en un itemEvent que ya esta registrado con su id.
                ItemEvent name = (ItemEvent)h; 
                
                //Acciones para ver la capacidad de hacer click en un evento
                System.out.println("ID: " + name.getItem().getId());
                ItemList y = calendar.getSchedule().getItems();
                System.out.println("Item List: " + calendar.getSchedule().getItems());
                System.out.println("tipo: " + name.getItem().getId().getClass());
                     
                    
                //Ocultar eventos
                if(chkPrueba.isSelected()){
                    //Hacer items events no visibles
                    name.getItem().setVisible(false);//No los elimina!
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
        txtDato = new javax.swing.JTextField();
        chkPrueba = new javax.swing.JCheckBox();
        txtDescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDate = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        calendarOff = new javax.swing.JCheckBox();
        pnlColores = new javax.swing.JPanel();
        rbtAlta = new javax.swing.JRadioButton();
        rbtMedia = new javax.swing.JRadioButton();
        rbtBaja = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chkPrueba.setText("Eliminar");

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

        jLabel1.setText("Nombre del Evento");

        jLabel2.setText("Descripcion del evento");

        calendarOff.setText("Deshabilitar");
        calendarOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarOffActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(pnlColores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 39, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(672, 672, 672)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txtDato, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(649, 649, 649)
                        .addComponent(calendarOff, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkPrueba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(pnlColores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(calendarOff)
                .addGap(311, 311, 311))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    
    //Desabilitar y habilitar el calendario con un boton
    private void calendarOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calendarOffActionPerformed
        if(calendarOff.isSelected()){
            calendar.setEnabled(false);
        }else{
            calendar.setEnabled(true);
        }
    }//GEN-LAST:event_calendarOffActionPerformed

    
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
    private com.mindfusion.scheduling.awt.AwtCalendar calendar;
    private javax.swing.JCheckBox calendarOff;
    private javax.swing.JCheckBox chkPrueba;
    private com.mindfusion.drawing.Color color1;
    private com.mindfusion.scheduling.model.CustomBrushes customBrushes1;
    private com.mindfusion.scheduling.DateStyle dateStyle1;
    private com.mindfusion.drawing.GradientBrush gradientBrush1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlColores;
    private javax.swing.JRadioButton rbtAlta;
    private javax.swing.JRadioButton rbtBaja;
    private javax.swing.JRadioButton rbtMedia;
    private javax.swing.JTable tblDate;
    private javax.swing.JTextField txtDato;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
