
package frames;

import clases.Asignatura;
import clases.ControladorAsignatura;
import clases.ControladorUsuario;
import clases.ErrorPlanificacion;
import clases.Usuario;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class frmUsuario extends javax.swing.JFrame {

    private DefaultTableModel modeloUsuario;
    
    
    /**
     * Creates new form frmAsignatura
     */
    public frmUsuario() {
        initComponents();
        rellenoTabla();
        frmModificar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.frmModificar.setLocationRelativeTo(null);
    }
    
    
    
    
    //---------------------creacion de tabla--------------------------------
    public void rellenoTabla(){
        String[] encabezadosTabla={"Código","Usuario","Nombre","Apellido","Edad"};
        modeloUsuario=new DefaultTableModel();
        ArrayList<Usuario> usuarios = new ArrayList();
        Object[] fila = new Object[5];
        
        try {
            usuarios = ControladorUsuario.Buscar();
            modeloUsuario.setColumnIdentifiers(encabezadosTabla);
            Iterator<Usuario> asig = usuarios.iterator();
        
            while (asig.hasNext()) {
                    
                    fila[0] = asig.next();
                    fila[1] = asig.next();
                    asig.next();
                    fila[2] = asig.next();
                    fila[3] = asig.next();
                    fila[4] = asig.next();
                    
                    modeloUsuario.addRow(fila);
                    tblUsuarios.setModel(modeloUsuario);
                }
            
        } catch (ErrorPlanificacion ex) {
            Logger.getLogger(frmUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmModificar = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAgregar1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblCancelar = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblAgregar = new javax.swing.JLabel();
        lblModificar = new javax.swing.JLabel();
        lblAtras = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();

        frmModificar.setMinimumSize(new java.awt.Dimension(600, 600));
        frmModificar.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Usuario:");
        frmModificar.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jLabel2.setText("Password:");
        frmModificar.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        jLabel3.setText("Nombre:");
        frmModificar.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        lblAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit.png"))); // NOI18N
        lblAgregar1.setText("Modificar");
        lblAgregar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregar1MouseClicked(evt);
            }
        });
        frmModificar.getContentPane().add(lblAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

        jLabel7.setText("Modificar Asignatura");
        frmModificar.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));
        frmModificar.getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 180, -1));
        frmModificar.getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 180, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        frmModificar.getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 180, -1));

        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });
        frmModificar.getContentPane().add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 180, -1));
        frmModificar.getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 90, -1));

        jLabel8.setText("Código:");
        frmModificar.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        lblCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar.png"))); // NOI18N
        lblCancelar.setText("Cancelar");
        lblCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelarMouseClicked(evt);
            }
        });
        frmModificar.getContentPane().add(lblCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, -1));

        jLabel10.setText("Edad:");
        frmModificar.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        jLabel11.setText("Apellidos:");
        frmModificar.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });
        frmModificar.getContentPane().add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 180, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        lblAgregar.setText("agregar");
        lblAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarMouseClicked(evt);
            }
        });
        getContentPane().add(lblAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        lblModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar.png"))); // NOI18N
        lblModificar.setText("modificar");
        lblModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificarMouseClicked(evt);
            }
        });
        getContentPane().add(lblModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, -1));

        lblAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/back.png"))); // NOI18N
        lblAtras.setText("atras");
        lblAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtrasMouseClicked(evt);
            }
        });
        getContentPane().add(lblAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel4.setText("USUARIOS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        lblEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete.png"))); // NOI18N
        lblEliminar.setText("eliminar");
        lblEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarMouseClicked(evt);
            }
        });
        getContentPane().add(lblEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, -1));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Usuario", "Nombre", "Apellidos", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(1).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(2).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(3).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 700, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseClicked
       frmUsuarioAgregar add=new frmUsuarioAgregar();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblAgregarMouseClicked

    private void lblModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarMouseClicked
        if(tblUsuarios.getSelectedRow()!=-1){
            try {
                int seleccion;
                frmModificar.setVisible(true);
                this.setVisible(false);
                
                seleccion = tblUsuarios.getSelectedRow();
                txtCodigo.setText(tblUsuarios.getValueAt(seleccion, 0).toString());
                txtUsuario.setText((tblUsuarios.getValueAt(seleccion, 1).toString()));
                txtPassword.setText(ControladorUsuario.obtenerPass(tblUsuarios.getValueAt(seleccion, 1).toString()));
                txtNombre.setText((tblUsuarios.getValueAt(seleccion, 2).toString()));
                txtApellidos.setText((tblUsuarios.getValueAt(seleccion, 3).toString()));
                txtEdad.setText((tblUsuarios.getValueAt(seleccion, 4).toString()));
            } catch (ErrorPlanificacion ex) {
                Logger.getLogger(frmUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_lblModificarMouseClicked

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        Usuario usu=new Usuario();
        if(tblUsuarios.getSelectedRow()!=-1){
            try {
                int seleccion;
                seleccion = tblUsuarios.getSelectedRow();
                usu.setIdUsuario(tblUsuarios.getValueAt(seleccion, 0).toString());
                ControladorUsuario.Eliminar(usu);
                JOptionPane.showMessageDialog(null, "La eliminacion fue correcta");
                modeloUsuario.removeRow(tblUsuarios.getSelectedRow());
            } catch (ErrorPlanificacion ex) {
                JOptionPane.showMessageDialog(null, "Elija una fila de la tabla");
            }
        }
    }//GEN-LAST:event_lblEliminarMouseClicked

    private void lblCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelarMouseClicked
        frmModificar.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_lblCancelarMouseClicked

    private void lblAgregar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregar1MouseClicked
        String codigo=txtCodigo.getText();
        String usuario=txtUsuario.getText();
        String password=txtPassword.getText();
        String nombre=txtNombre.getText();
        String apellidos=txtApellidos.getText();
        String edad=txtEdad.getText();

        if (codigo.isEmpty() && usuario.isEmpty() && password.isEmpty() && nombre.isEmpty() && apellidos.isEmpty() && edad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos por favor");
        }else{
            try {
                Usuario usu=new Usuario();
                
                usu.setIdUsuario(codigo);
                usu.setUsuario(usuario);
                usu.setPassword(password);
                usu.setNombre(nombre);
                usu.setApellido(apellidos);
                usu.setEdad(Integer.parseInt(edad));
                ControladorUsuario.Modificar(usu);
                JOptionPane.showMessageDialog(null, "Se modifico exitosamente!!");
            } catch (ErrorPlanificacion ex) {
                Logger.getLogger(frmUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lblAgregar1MouseClicked

    private void lblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMouseClicked
        frmMenu mostrar=new frmMenu();
        mostrar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblAtrasMouseClicked

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
        int c=(int) evt.getKeyChar();

        if ((c >=48 && c<=57) || (c==8) || (c== (char)KeyEvent.VK_BACK_SPACE) || (c== (char)KeyEvent.VK_ENTER)) {
            //No pasa nada
        }else{
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtEdadKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
         int c=(int) evt.getKeyChar();
        char mayu=evt.getKeyChar();

        if ((c>=65 && c<=90) || (c>=97 && c<=122)  || (c==32) || (c==8) || (c >=48 && c<=57) || (c== (char)KeyEvent.VK_BACK_SPACE) || (c== (char)KeyEvent.VK_ENTER)) {
            if (Character.isLowerCase(mayu)) {
                String cadena=(""+mayu).toUpperCase();
                mayu=cadena.charAt(0);
                evt.setKeyChar(mayu);
            }
        }else{
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
         int c=(int) evt.getKeyChar();
        char mayu=evt.getKeyChar();

        if ((c>=65 && c<=90) || (c>=97 && c<=122)  || (c==32) || (c==8) || (c >=48 && c<=57) || (c== (char)KeyEvent.VK_BACK_SPACE) || (c== (char)KeyEvent.VK_ENTER)) {
            if (Character.isLowerCase(mayu)) {
                String cadena=(""+mayu).toUpperCase();
                mayu=cadena.charAt(0);
                evt.setKeyChar(mayu);
            }
        }else{
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

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
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame frmModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblAgregar1;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblModificar;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
