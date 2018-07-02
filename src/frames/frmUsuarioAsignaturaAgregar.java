/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import clases.Asignatura;
import clases.ControladorAsignatura;
import clases.ControladorMetodologia;
import clases.ControladorUsuario;
import clases.ControladorUsuarioAsignatura;
import clases.ErrorPlanificacion;
import clases.Metodologia;
import clases.Usuario;
import clases.UsuarioAsignatura;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Enrique
 */
public class frmUsuarioAsignaturaAgregar extends javax.swing.JFrame {
    private DefaultComboBoxModel modeloComboAsignatura;
    private DefaultComboBoxModel modeloComboMetodologia;
    String ruta_archivo="";
    /**
     * Creates new form frmAsignaturaAgregar
     */
    public frmUsuarioAsignaturaAgregar() {
        initComponents();
        rellenoComboAsignatura();
        rellenoComboUsuario();
        this.setLocationRelativeTo(null);
    }
    
  
    
    //---------------------creacion de combo--------------------------------
    public void rellenoComboAsignatura(){
         cmbAsignatura.removeAll();
         modeloComboAsignatura=new DefaultComboBoxModel();
        modeloComboAsignatura.removeAllElements();
        
        
        Object[] opcion=new Object[7];
            ArrayList<Asignatura> uni=new ArrayList<>();
        try {
            uni = ControladorAsignatura.Buscar();
        } catch (ErrorPlanificacion ex) {
            Logger.getLogger(frmUnidadAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }
            Iterator iterador=uni.iterator();
            
            while(iterador.hasNext()){
                
                opcion[0]=iterador.next();
                
                modeloComboAsignatura.addElement(iterador.next());
                opcion[1]=iterador.next();
                opcion[2]=iterador.next();
                opcion[3]=iterador.next();
                opcion[4]=iterador.next();
                opcion[5]=iterador.next();
                
            }
            
            cmbAsignatura.setModel(modeloComboAsignatura);
           
        
     }  
    
    //---------------------creacion de comboMetodlogia--------------------------------
    public void rellenoComboUsuario(){
         cmbUsuario.removeAll();
         modeloComboMetodologia=new DefaultComboBoxModel();
        modeloComboMetodologia.removeAllElements();
       
        Object[] opcion=new Object[5];
            ArrayList<Usuario> uni=new ArrayList<>();
        try {
            uni = ControladorUsuario.Buscar();
        } catch (ErrorPlanificacion ex) {
            Logger.getLogger(frmUnidadAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }
            Iterator iterador=uni.iterator();
            
            while(iterador.hasNext()){
                
                opcion[0]=iterador.next();
                
                modeloComboMetodologia.addElement(iterador.next());
                opcion[1]=iterador.next();
                opcion[2]=iterador.next();
                opcion[3]=iterador.next();
                opcion[4]=iterador.next();
                
                
            }
            
            cmbUsuario.setModel(modeloComboMetodologia);
            
        
     }
    
    public void seleccionarPdf() {
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
        j.setFileFilter(fi);
        int se = j.showOpenDialog(this);
        if (se == 0) {
//            this.btnPdf.setText("" + j.getSelectedFile().getName());
            ruta_archivo = j.getSelectedFile().getAbsolutePath();

        } else {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblAgregar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCancelar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbAsignatura = new javax.swing.JComboBox<>();
        cmbUsuario = new javax.swing.JComboBox<>();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        lblAgregar.setText("Agregar");
        lblAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarMouseClicked(evt);
            }
        });
        getContentPane().add(lblAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        jLabel7.setText("Agregar Metodologia");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jLabel8.setText("Asignatura:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        lblCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar.png"))); // NOI18N
        lblCancelar.setText("Cancelar");
        lblCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(lblCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        cmbAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 180, -1));

        cmbUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 180, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseClicked
       
        
       
            try{
                UsuarioAsignatura meto=new UsuarioAsignatura();
                meto.setIdAsignatura(ControladorAsignatura.obtenerCodigo(cmbAsignatura.getSelectedItem().toString()));
                meto.setIdUsuario(ControladorUsuario.obtenerCodigo(cmbUsuario.getSelectedItem().toString()));
                
                ControladorUsuarioAsignatura.Agregar(meto);
                JOptionPane.showMessageDialog(null,"Todo se ejecuto con exito");
                
                } catch (ErrorPlanificacion ex) {
                    Logger.getLogger(frmUsuarioAsignaturaAgregar.class.getName()).log(Level.SEVERE, null, ex);
                }
             
            
    }//GEN-LAST:event_lblAgregarMouseClicked

    private void lblCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelarMouseClicked
        frmUsuarioAsignatura meto=new frmUsuarioAsignatura();
        meto.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblCancelarMouseClicked

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
            java.util.logging.Logger.getLogger(frmUsuarioAsignaturaAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUsuarioAsignaturaAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUsuarioAsignaturaAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUsuarioAsignaturaAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUsuarioAsignaturaAgregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbAsignatura;
    private javax.swing.JComboBox<String> cmbUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblCancelar;
    // End of variables declaration//GEN-END:variables
}
