/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.IIB.Project;

/**
 *
 * @author StevG
 */
public class GUIEventDetail extends javax.swing.JFrame {
//dasds
    /**
     * Creates new form GUIEventDetail
     */
    public GUIEventDetail() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreEvento = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblPuntos2 = new javax.swing.JLabel();
        lblPuntos3 = new javax.swing.JLabel();
        lblPuntos5 = new javax.swing.JLabel();
        lblTipoEvento = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pnlTiempo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblSegundoInicial = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblMinutoFinal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblSegundoFinal = new javax.swing.JLabel();
        lblHoraFinal = new javax.swing.JLabel();
        lblPuntos1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblHoraInicial = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        lblMinutoInicial = new javax.swing.JLabel();

        setLocation(new java.awt.Point(300, 200));

        lblNombreEvento.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Detalles del Evento");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nombre del evento");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Descripcion");

        lblDescripcion.setText("jLabel4");

        lblPuntos2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPuntos2.setText(":");

        lblPuntos3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPuntos3.setText(":");

        lblPuntos5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPuntos5.setText(":");

        lblTipoEvento.setText("jLabel1");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Tipo de evento");

        pnlTiempo.setBorder(javax.swing.BorderFactory.createTitledBorder("Hora de inicio y fin"));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText(":");

        lblSegundoInicial.setText("jLabel8");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Hora Final");

        lblMinutoFinal.setText("jLabel6");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText(":");

        lblSegundoFinal.setText("jLabel8");

        lblHoraFinal.setText("jLabel5");

        lblPuntos1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPuntos1.setText(":");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Hora Inicio");

        lblHoraInicial.setText("jLabel5");

        lblPuntos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPuntos.setText(":");

        lblMinutoInicial.setText("jLabel6");

        javax.swing.GroupLayout pnlTiempoLayout = new javax.swing.GroupLayout(pnlTiempo);
        pnlTiempo.setLayout(pnlTiempoLayout);
        pnlTiempoLayout.setHorizontalGroup(
            pnlTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTiempoLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(pnlTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addGroup(pnlTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlTiempoLayout.createSequentialGroup()
                        .addComponent(lblHoraFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPuntos1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMinutoFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSegundoFinal))
                    .addGroup(pnlTiempoLayout.createSequentialGroup()
                        .addComponent(lblHoraInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPuntos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMinutoInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSegundoInicial)))
                .addGap(6, 6, 6))
        );
        pnlTiempoLayout.setVerticalGroup(
            pnlTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTiempoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblHoraInicial)
                    .addComponent(lblPuntos)
                    .addComponent(lblMinutoInicial)
                    .addComponent(jLabel7)
                    .addComponent(lblSegundoInicial))
                .addGap(26, 26, 26)
                .addGroup(pnlTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblHoraFinal)
                    .addComponent(lblPuntos1)
                    .addComponent(lblMinutoFinal)
                    .addComponent(jLabel11)
                    .addComponent(lblSegundoFinal))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPuntos5)
                        .addGap(54, 54, 54)
                        .addComponent(lblTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPuntos2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPuntos3)
                                .addGap(44, 44, 44)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(lblNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(pnlTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoEvento)
                    .addComponent(jLabel15)
                    .addComponent(lblPuntos5))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEvento)
                    .addComponent(jLabel1)
                    .addComponent(lblPuntos2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblDescripcion)
                    .addComponent(lblPuntos3))
                .addGap(31, 31, 31)
                .addComponent(pnlTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GUIEventDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIEventDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIEventDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIEventDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIEventDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel lblDescripcion;
    public javax.swing.JLabel lblHoraFinal;
    public javax.swing.JLabel lblHoraInicial;
    public javax.swing.JLabel lblMinutoFinal;
    public javax.swing.JLabel lblMinutoInicial;
    public javax.swing.JLabel lblNombreEvento;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JLabel lblPuntos1;
    private javax.swing.JLabel lblPuntos2;
    private javax.swing.JLabel lblPuntos3;
    private javax.swing.JLabel lblPuntos5;
    public javax.swing.JLabel lblSegundoFinal;
    public javax.swing.JLabel lblSegundoInicial;
    public javax.swing.JLabel lblTipoEvento;
    public javax.swing.JPanel pnlTiempo;
    // End of variables declaration//GEN-END:variables
}
