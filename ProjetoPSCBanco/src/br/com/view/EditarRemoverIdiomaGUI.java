package br.com.view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.control.IdiomaControl;
import br.com.model.IdiomaForm;


/**
 * 
 * @version Thiago de Lima Gon�alves RA: 100838359
 *
 */

public class EditarRemoverIdiomaGUI extends javax.swing.JFrame {
   
	private static final long serialVersionUID = 8659841930295103996L;
	/**
     * Creates new form EditarRemoverIdiomaGUI
     */
    public EditarRemoverIdiomaGUI() {
        initComponents();
        atualizaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbAtor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNovo.setText("Novo");
        btnNovo.setPreferredSize(new java.awt.Dimension(75, 23));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setPreferredSize(new java.awt.Dimension(75, 23));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jtbAtor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "C�digo", "Primeiro Nome", "�ltimo Nome", "Modifica��o"
            }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 4508303745989504562L;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            @SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbAtor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnRemover)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {
    	JFrame inserirAtorGUI = new InserirIdiomaGUI();
    	inserirAtorGUI.setVisible(true);
    }

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {
    	int linhaSelecionada = jtbAtor.getSelectedRow();
    	 
        if (linhaSelecionada >= 0){
        	Object codigoAtor = jtbAtor.getValueAt(linhaSelecionada, 0);
            JFrame alterarAtorGUI = new AlterarIdiomaGUI((Integer) codigoAtor);
            alterarAtorGUI.setVisible(true);
            
        }
        else{
            JOptionPane.showMessageDialog(this, 
            		"� necess�rio selecionar uma Cidade", "Cidade", JOptionPane.INFORMATION_MESSAGE);
        }  
    }
   
    
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {
    	int linhaSelecionada = jtbAtor.getSelectedRow();
        
    	 if (linhaSelecionada >= 0){
    		 Object codigoAtor = jtbAtor.getValueAt(linhaSelecionada, 0);
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja excluir o Ator?");
            if (resposta == JOptionPane.YES_OPTION){
            	IdiomaForm idiomaForm = new IdiomaForm();
            	idiomaForm.setIdioma_id((Integer) codigoAtor);
                IdiomaControl.removerIdioma(idiomaForm);

                atualizaTabela();
            }
        }
        else{
            JOptionPane.showMessageDialog(this, 
            		"� necess�rio selecionar uma Cidade", "Cidade", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void atualizaTabela(){
        
    	DefaultTableModel tabela = (DefaultTableModel) jtbAtor.getModel();
        tabela.setNumRows(0);

        List<IdiomaForm> atorList = IdiomaControl.getTodosIdiomas();

        for (int linha = 0; linha < atorList.size(); linha++) {
        	
        	IdiomaForm idiomaForm = atorList.get(linha);

            tabela.addRow(new Object[]{1});

            tabela.setValueAt(idiomaForm.getIdioma_id(), linha, 0);
            tabela.setValueAt(idiomaForm.getIdioma(), linha, 1);
            tabela.setValueAt(idiomaForm.getIdioma_id(), linha, 2);
            tabela.setValueAt(idiomaForm.getUltima_atualizacao(), linha, 3);
        }
    }
    
    // Variables declaration - do not modify
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jtbAtor;
    // End of variables declaration
}
