package br.com.view;

import java.sql.Timestamp;


import br.com.control.CidadeControl;
import br.com.dao.CidadeDAO;
import br.com.model.CidadeForm;
import br.com.util.Util;

/**
 *
 * @version Thiago de Lima Gonçalves RA: 100838359
 * 
 * 
 */
public class InserirCidadeGUI extends javax.swing.JFrame {

   
	private static final long serialVersionUID = 6898114385324004989L;
	/**
     * Creates new form InserirCidadeGUI
     */
    public InserirCidadeGUI() {
        initComponents();
        jtfCodigoAtor.setText(CidadeDAO.ultimoAtor().toString());
        jtfModificacao.setText(new Timestamp(System.currentTimeMillis()).toString());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfPrimeiroNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfUltimoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfModificacao = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtfCodigoAtor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cidade:");

        jLabel2.setText("ID do pais: ");

        jLabel3.setText("Modificação: ");

        jtfModificacao.setColumns(20);
        jtfModificacao.setEditable(false);
        jtfModificacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        btnSalvar.setText("Salvar");
        btnSalvar.setPreferredSize(new java.awt.Dimension(75, 23));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Código Ator:");

        jtfCodigoAtor.setEditable(false);
        jtfCodigoAtor.setPreferredSize(new java.awt.Dimension(70, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfPrimeiroNome)
                        .addComponent(jtfUltimoNome)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                            .addComponent(btnCancelar))
                        .addComponent(jtfModificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfCodigoAtor, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfCodigoAtor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfPrimeiroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfUltimoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfModificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    		
	        String primeiroNome = jtfPrimeiroNome.getText();
	        Integer ultimoNome = Integer.parseInt(jtfUltimoNome.getText());
	        String ultimaAtualizacao = jtfModificacao.getText();
	        
	        CidadeForm cidadeForm = new CidadeForm();
	        cidadeForm.setCidade(primeiroNome);
	        cidadeForm.setPais_id(ultimoNome);
			cidadeForm.setUltima_atualizacao(Util.formatarData(ultimaAtualizacao));
		
			CidadeControl.addCidade(cidadeForm);

    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        EditarRemoverCidadeGUI.atualizaTabela();
        this.dispose();
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
    	this.dispose();
    }
    
   
 // Variables declaration - do not modify
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jtfCodigoAtor;
    private javax.swing.JFormattedTextField jtfModificacao;
    private javax.swing.JTextField jtfPrimeiroNome;
    private javax.swing.JTextField jtfUltimoNome;
    // End of variables declaration
}
