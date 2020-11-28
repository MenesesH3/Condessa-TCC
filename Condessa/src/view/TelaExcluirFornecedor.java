/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Database;

/**
 *
 * @author Vinícius
 */
public class TelaExcluirFornecedor extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    boolean clicou = false;
    
    public void listarFornecedor(){
    
     
        String sql="select nome from fornecedor";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            while(rs.next()){
                Ed_forn.addItem(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao listar fornecedor");
            Logger.getLogger(TelaExcluirFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
    public int pegarIdFornecedor() throws SQLException{
        String sql = "select id from fornecedor where nome = '" + Ed_forn.getSelectedItem().toString() + "'";
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            while(rs.next()){
                return rs.getInt("id");
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "erro pegar id fornecedor");
            Logger.getLogger(TelaExcluirFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
     public void MostrarFornecedor() throws SQLException{
        String sql = "select * from fornecedor where id = '" + pegarIdFornecedor() + "'";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            while(rs.next()){
                ex_noforn.setText(rs.getString("nome"));
                ex_cnpj.setText(""+rs.getInt("cnpj"));
                ex_cidforn.setText(rs.getString("cidade"));
                ex_con.setText(""+rs.getInt("contato"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaExcluirFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void DeleteFornecedor() throws SQLException{
        String sql = "delete from fornecedor where id = '" + pegarIdFornecedor() + "'";
        try {
            pst = conexao.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso");
            pst.close();
            conexao.close();
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fornecedor não pode ser excluído");
            Logger.getLogger(TelaExcluirFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Creates new form TelaExcluirCliente
     */
    public TelaExcluirFornecedor() throws ClassNotFoundException {
        initComponents();
        conexao = Database.conector();
        listarFornecedor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ex_cnpj = new javax.swing.JLabel();
        ex_cidforn = new javax.swing.JLabel();
        ex_con = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ex_noforn = new javax.swing.JLabel();
        Ed_forn = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Excluir fornecedor");

        jLabel1.setText("Nome:");

        ex_cnpj.setText("-");

        ex_cidforn.setText("-");

        ex_con.setText("-");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Escolha o fornecedor para excluir");

        jLabel2.setText("Cidade: ");

        jLabel3.setText("CNPJ :");

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Telefone para contato: ");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ex_noforn.setText("-");

        jButton3.setText("Pesquisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ex_con, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ex_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ex_noforn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ex_cidforn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Ed_forn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ed_forn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ex_noforn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ex_cnpj))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ex_cidforn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ex_con))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(378, 360));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(ex_noforn.getText().equals("-")){
            JOptionPane.showMessageDialog(null, "Pesquise o Fornecedor");
        }else{
        int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este fornecedor?", "Atenção",JOptionPane.YES_NO_OPTION);
        if(confirmar==JOptionPane.YES_OPTION){
            try {
                DeleteFornecedor();
            } catch (SQLException ex) {
                Logger.getLogger(TelaExcluirMateriaPrima.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
    }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
            try {
                MostrarFornecedor();
            } catch (SQLException ex) {
                Logger.getLogger(TelaEditarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaExcluirFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExcluirFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExcluirFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExcluirFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaExcluirFornecedor().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaExcluirFornecedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Ed_forn;
    private javax.swing.JLabel ex_cidforn;
    private javax.swing.JLabel ex_cnpj;
    private javax.swing.JLabel ex_con;
    private javax.swing.JLabel ex_noforn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
