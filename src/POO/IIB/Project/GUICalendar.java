package POO.IIB.Project;

import com.mindfusion.common.DateTime;
import com.mindfusion.drawing.Brush;
import com.mindfusion.drawing.Brushes;
import com.mindfusion.scheduling.CalendarAdapter;
import com.mindfusion.scheduling.ItemMouseEvent;
import com.mindfusion.scheduling.ResourceDateEvent;
import com.mindfusion.scheduling.model.Appointment;
import com.mindfusion.scheduling.model.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author bTeam
 */
 

public class GUICalendar extends javax.swing.JFrame {
//Variables de locales del Reloj
    Reloj miHora;
    String horaComparada;    
    String parametroHora;
    public ArrayList<String> arrHora = new ArrayList<>();
    public ArrayList<String> nombre = new ArrayList<>();
    public ArrayList<String> descripcion = new ArrayList<>();
    public ArrayList<String> fecha = new ArrayList<>(); 
    public ArrayList<String> categoria = new ArrayList<>();


//Inicializo el componente tabla
    DefaultTableModel dtmTabla;
    Evento miEvento; 
    GUIEventDetail guiEvent; 
    pnlTabla panelTable; 
    public GUICalendar() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        //RELOJ
        //mi clase reloj se extiende del hilo
        //con el constructor que resibe el atributo de tipo JLabel
        //utilizo el hilo de tipo reloj para no consumir tantos recursos de la GUI
        Reloj hilo = new Reloj(lblReloj);
        
        //VALIDADOR para verificar si son solo letras
         lblMensajeError.setVisible(false);
        calendar.setEnabled(false);

       guiEvent = new GUIEventDetail(); 
        panelTable = new pnlTabla(); 
                pnlAcademia.setVisible(false);
        //iniciliazo el hilo del Reloj
         hilo.start();
         
        //Modelo de la tabla
        dtmTabla = new DefaultTableModel(); 
        dtmTabla.addColumn("Nombre");
        dtmTabla.addColumn("Descripcion");
        dtmTabla.addColumn("Fecha");
        dtmTabla.addColumn("Hora Inicio/Fin");
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
                      miEvento = new Academia(txtNombreEvento.getText(),txtDescripcion.getText(), txtDetalles.getText(), txtNombreMateria.getText(), txtLink.getText()); 
                      pnlAcademia.setVisible(true);
                      }
                    if(cmbCategoria.getSelectedIndex()==1){
                      miEvento = new Recordatorio(txtNombreEvento.getText(),txtDescripcion.getText(), txtDetalles.getText()); 
                      pnlAcademia.setVisible(false);
                      
                    }
                    if(cmbCategoria.getSelectedIndex()==2){
                      miEvento = new Lista(txtNombreEvento.getText(),txtDescripcion.getText(), txtDetalles.getText()); 
                      pnlAcademia.setVisible(false);
                    }
                      //Parametros para crear evento
                      try{
                      item.setStartTime(e.getDate().addHours(Integer.parseInt((String)cmbHora.getSelectedItem())).addMinutes(Integer.parseInt((String)cmbMinutos.getSelectedItem())).addSeconds(Integer.parseInt((String)cmbSegundos.getSelectedItem())));
                      DateTime h = e.getDate().addHours(Integer.parseInt((String)cmbHora1.getSelectedItem())).addMinutes(Integer.parseInt((String)cmbMinutos1.getSelectedItem())).addSeconds(Integer.parseInt((String)cmbSegundos1.getSelectedItem()));
                      item.setEndTime(h);
                      }catch(NullPointerException npe){
                          
                      }
                      
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
                    //Parametro hora
                    parametroHora =(String)cmbHora.getSelectedItem() + ":" + (String)cmbMinutos.getSelectedItem()+ ":" + (String)cmbSegundos.getSelectedItem() ; 
                    dtmTabla.addRow(new Object[]{
                        miEvento.getNombre(),
                        miEvento.getDescripcion() ,
                        item.getStartTime().getDate(),
                        parametroHora,
                        miEvento.getClass().getSimpleName()

                    });
                    //Llena los datos en la tabla del menu.
                    
                   
                    
                    arrHora.add(parametroHora);
                    nombre.add(txtNombreEvento.getText());
                    descripcion.add(txtDescripcion.getText());
                    fecha.add(item.getStartTime().getDate().toString());
                    categoria.add(miEvento.getClass().getSimpleName()); 
                    
                    panelTable.arrHora.add(parametroHora);
                    panelTable.nombre.add(txtNombreEvento.getText());
                    panelTable.descripcion.add(txtDescripcion.getText());
                    panelTable.fecha.add(item.getStartTime().getDate().toString());
                    panelTable.categoria.add(miEvento.getClass().getSimpleName()); 
                       
                    //Limpiar despues del click Datos Comunes
                    txtNombreEvento.setText(null);
                    txtDescripcion.setText(null);
                    txtDetalles.setText(null);
                    /*cmbHora.setSelectedIndex(-1); si limpio la hora no arroja la GUIEventDetail
                    cmbMinutos.setSelectedIndex(-1);
                    cmbSegundos.setSelectedIndex(-1);
                    cmbSegundos.setSelectedIndex(-1);*/
                    cmbHora1.setSelectedIndex(-1);
                    cmbMinutos1.setSelectedIndex(-1);
                    cmbSegundos1.setSelectedIndex(-1);
                    cmbCategoria.setSelectedIndex(-1);
                    btgColor.clearSelection();
                    

                    

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
        lblMensajeError = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        pnlGuiTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDate = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();
        pnlHoras = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblPunto1 = new javax.swing.JLabel();
        lblPunto2 = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox<>();
        cmbMinutos = new javax.swing.JComboBox<>();
        cmbSegundos = new javax.swing.JComboBox<>();
        lblPunto3 = new javax.swing.JLabel();
        lblPunto4 = new javax.swing.JLabel();
        cmbHora1 = new javax.swing.JComboBox<>();
        cmbMinutos1 = new javax.swing.JComboBox<>();
        cmbSegundos1 = new javax.swing.JComboBox<>();
        lblReloj = new javax.swing.JLabel();
        pnlAcademia = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtNombreMateria = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtLink = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        seeTable = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 50));

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
        pnlDatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pnlDatosKeyReleased(evt);
            }
        });

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

        txtDetalles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDetallesKeyReleased(evt);
            }
        });

        jLabel3.setText("Detalles del Evento");

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });

        jLabel1.setText("Nombre del Evento");

        jLabel2.setText("Descripcion del evento");

        lblMensajeError.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblMensajeError.setForeground(new java.awt.Color(255, 0, 51));
        lblMensajeError.setText("Ingresar solo letras");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDetalles, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)))))
                    .addComponent(lblMensajeError, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addGap(0, 83, Short.MAX_VALUE))
                    .addComponent(txtNombreEvento, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblMensajeError)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(txtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(txtDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Academia", "Recordatorio", "Lista" }));
        cmbCategoria.setSelectedIndex(-1);
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        pnlGuiTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Eventos Creados"));

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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlGuiTablaLayout.setVerticalGroup(
            pnlGuiTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblCategoria.setText("Elija la categoria de su evento:");

        pnlHoras.setBorder(javax.swing.BorderFactory.createTitledBorder("Hora de inicio y fin"));

        jLabel5.setText("Hora de inicio");

        jLabel6.setText("Hora de fin");

        lblPunto1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPunto1.setText(":");

        lblPunto2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPunto2.setText(":");

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        cmbHora.setSelectedIndex(21);

        cmbMinutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", " " }));
        cmbMinutos.setSelectedIndex(3);
        cmbMinutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMinutosActionPerformed(evt);
            }
        });

        cmbSegundos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", " " }));
        cmbSegundos.setSelectedIndex(3);

        lblPunto3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPunto3.setText(":");

        lblPunto4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPunto4.setText(":");

        cmbHora1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        cmbHora1.setSelectedIndex(22);

        cmbMinutos1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", " " }));
        cmbMinutos1.setSelectedIndex(4);

        cmbSegundos1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", " " }));
        cmbSegundos1.setSelectedIndex(5);

        javax.swing.GroupLayout pnlHorasLayout = new javax.swing.GroupLayout(pnlHoras);
        pnlHoras.setLayout(pnlHorasLayout);
        pnlHorasLayout.setHorizontalGroup(
            pnlHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHorasLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHorasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHorasLayout.createSequentialGroup()
                        .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(pnlHorasLayout.createSequentialGroup()
                                .addComponent(lblPunto1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPunto2)
                                .addGap(2, 2, 2)
                                .addComponent(cmbSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHorasLayout.createSequentialGroup()
                        .addComponent(cmbHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPunto3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMinutos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPunto4)
                        .addGap(2, 2, 2)
                        .addComponent(cmbSegundos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        pnlHorasLayout.setVerticalGroup(
            pnlHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHorasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(14, 14, 14)
                .addGroup(pnlHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPunto1)
                    .addComponent(lblPunto2)
                    .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPunto3)
                    .addComponent(lblPunto4)
                    .addComponent(cmbHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMinutos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSegundos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        lblReloj.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblReloj.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblRelojPropertyChange(evt);
            }
        });

        pnlAcademia.setBorder(javax.swing.BorderFactory.createTitledBorder("Academia"));

        jLabel7.setText("Nombre de materia");

        jLabel8.setText("Link de la reunion");

        javax.swing.GroupLayout pnlAcademiaLayout = new javax.swing.GroupLayout(pnlAcademia);
        pnlAcademia.setLayout(pnlAcademiaLayout);
        pnlAcademiaLayout.setHorizontalGroup(
            pnlAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcademiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreMateria)
                    .addComponent(txtLink, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pnlAcademiaLayout.setVerticalGroup(
            pnlAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcademiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNombreMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAcademiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 120, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCategoria)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(pnlColores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlAcademia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnlHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(pnlGuiTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar)
                    .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(pnlHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlAcademia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(chkPrueba))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlColores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pnlGuiTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void VisibilidadDatosComunes(boolean val){
        
        txtNombreEvento.setEnabled(val);
        txtDescripcion.setEnabled(val);
        txtDetalles.setEnabled(val);
        pnlDatos.setEnabled(val);
        cmbHora.setEnabled(val);
        cmbMinutos.setEnabled(val);
        cmbSegundos.setEnabled(val);
        cmbHora1.setEnabled(val);
        cmbMinutos1.setEnabled(val);
        cmbSegundos1.setEnabled(val);
        //Prueba esconder RBT
        //rbtAlta.setVisible(val);
        /*rbtAlta.setEnabled(val);
        rbtMedia.setEnabled(val);
        rbtBaja.setEnabled(val);*/
        //calendar.setEnabled(val);

        

    }
    
    private void chkPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPruebaActionPerformed
        
    }//GEN-LAST:event_chkPruebaActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        
        if(cmbCategoria.getSelectedIndex()==0){
            VisibilidadDatosComunes(true);
            pnlAcademia.setVisible(true);
            //Se debe declarar el constructor.
        }
        if(cmbCategoria.getSelectedIndex()==1){
            VisibilidadDatosComunes(true);
            pnlAcademia.setVisible(false);

        }
        if(cmbCategoria.getSelectedIndex()==2){
            VisibilidadDatosComunes(true);
            pnlAcademia.setVisible(false);

        }
            
        
    }//GEN-LAST:event_cmbCategoriaActionPerformed
    public void insivibleCalendar(boolean val){
        
        pnlDatos.setVisible(val);
        calendar.setVisible(val);
        pnlColores.setVisible(val);
        pnlGuiTabla.setVisible(val);
        cmbCategoria.setVisible(val);
        lblCategoria.setVisible(val); 
        pnlAcademia.setVisible(val);
        chkPrueba.setVisible(val);
        pnlHoras.setVisible(val);
       
    }
    private void seeTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeTableActionPerformed
        insivibleCalendar(false);
        btnRegresar.setVisible(true);
        panelTable.setVisible(true);
        panelTable.setSize(700, 500);
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

    private void lblRelojPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblRelojPropertyChange
        // TODO add your handling code here:\
        
        if(lblReloj.getText()!=""){
            String hora1=lblReloj.getText();
            int val = 0 ; 
            try{
               if(arrHora.contains(hora1)){
                    for(int i=0; i<arrHora.size(); i++){
                        if(arrHora.get(i).equals(hora1)){
                            System.out.println("ar: "+ arrHora.get(i));
                            val = i;
                        }
                    }
                guiEvent.lblNombreEvento.setText(nombre.get(val));
                guiEvent.txaDescripcion.setText(descripcion.get(val));
                guiEvent.setVisible(rootPaneCheckingEnabled);
                }
                }catch (NullPointerException npe) {    
                }
        }
    }//GEN-LAST:event_lblRelojPropertyChange
//VALIDADOR PARA QUE EL USUARIO SOLO REGISTRE PALABRAS
    private void pnlDatosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlDatosKeyReleased
        // TODO add your handling code here:
        if(Validador.verificarNombre(txtNombreEvento.getText()))
            lblMensajeError.setVisible(false);
        else
            lblMensajeError.setVisible(true);
    }//GEN-LAST:event_pnlDatosKeyReleased

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        // TODO add your handling code here:
        if(Validador.verificarDescripcion(txtDescripcion.getText()))
            lblMensajeError.setVisible(false);
        else
            lblMensajeError.setVisible(true);
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtDetallesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDetallesKeyReleased
        // TODO add your handling code here:
        if(Validador.verificarDetalles(txtDetalles.getText()))
            lblMensajeError.setVisible(false);
        else
            lblMensajeError.setVisible(true);
    }//GEN-LAST:event_txtDetallesKeyReleased

    private void cmbMinutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMinutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMinutosActionPerformed

    
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
                Brushes.Red, Brushes.Yellow, Brushes.GreenYellow
    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgColor;
    private javax.swing.JButton btnRegresar;
    private com.mindfusion.scheduling.awt.AwtCalendar calendar;
    private javax.swing.JCheckBox chkPrueba;
    private javax.swing.JComboBox<String> cmbCategoria;
    public javax.swing.JComboBox<String> cmbHora;
    public javax.swing.JComboBox<String> cmbHora1;
    public javax.swing.JComboBox<String> cmbMinutos;
    public javax.swing.JComboBox<String> cmbMinutos1;
    public javax.swing.JComboBox<String> cmbSegundos;
    public javax.swing.JComboBox<String> cmbSegundos1;
    private com.mindfusion.drawing.Color color1;
    private com.mindfusion.scheduling.model.CustomBrushes customBrushes1;
    private com.mindfusion.scheduling.DateStyle dateStyle1;
    private com.mindfusion.drawing.GradientBrush gradientBrush1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblMensajeError;
    private javax.swing.JLabel lblPunto1;
    private javax.swing.JLabel lblPunto2;
    private javax.swing.JLabel lblPunto3;
    private javax.swing.JLabel lblPunto4;
    private javax.swing.JLabel lblReloj;
    private javax.swing.JPanel pnlAcademia;
    private javax.swing.JPanel pnlColores;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlGuiTabla;
    private javax.swing.JPanel pnlHoras;
    private javax.swing.JRadioButton rbtAlta;
    private javax.swing.JRadioButton rbtBaja;
    private javax.swing.JRadioButton rbtMedia;
    private javax.swing.JMenuItem seeTable;
    public javax.swing.JTable tblDate;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDetalles;
    private javax.swing.JTextField txtLink;
    private javax.swing.JTextField txtNombreEvento;
    private javax.swing.JTextField txtNombreMateria;
    // End of variables declaration//GEN-END:variables
}
