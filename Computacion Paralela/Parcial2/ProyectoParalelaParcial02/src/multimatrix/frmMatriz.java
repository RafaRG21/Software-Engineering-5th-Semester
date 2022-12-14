/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package multimatrix;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Ruiz Gudiño 20110374
 */
public class frmMatriz extends javax.swing.JFrame {

    /**
     * Creates new form frmMatriz
     */
    public frmMatriz() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    //Dimensiones de las matrices
    int filasM1 = 0, filasM2 = 0, columnasM1 = 0, columnasM2 = 0;
    int[][] matriz1;
    int[][] matriz2;
    Random rand = new Random();
    //Matrices de los metodos
    MatrizSecuencial secuencial;
    int[][] resForkJoin;
    //Metodos
    private int[][] llenarMatriz(int[][] matriz, int filas, int columnas) {
        matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = rand.nextInt(99);
            }
        }
        return matriz;
    }

    private String imprimirMatriz(int[][] matriz) {
        String matrix = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
               
                matrix += String.valueOf(matriz[i][j]) + "\t";

            }
            matrix += "\n";
        }
        return matrix;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblGenerar1 = new javax.swing.JLabel();
        lblFilas01 = new javax.swing.JLabel();
        txtFilasM1 = new javax.swing.JTextField();
        lblColumnas01 = new javax.swing.JLabel();
        txtColumnasM1 = new javax.swing.JTextField();
        lblGenerar02 = new javax.swing.JLabel();
        lblFilas02 = new javax.swing.JLabel();
        lblColumnas02 = new javax.swing.JLabel();
        txtFilasM2 = new javax.swing.JTextField();
        txtColumnasM2 = new javax.swing.JTextField();
        btnGenerarMatriz1 = new javax.swing.JButton();
        btnGenerarMatriz2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMatriz1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMatriz2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAResultadoSecuencial = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAResultadoExecutorService = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAResultadoForkJoin = new javax.swing.JTextArea();
        btnSecuencial = new javax.swing.JButton();
        btnExecutorService = new javax.swing.JButton();
        btnForkJoin = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtfTiempoSecuencial = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtfTiempoExecutorService = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtfTiempoForkJoin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnImprimirSecuencial = new javax.swing.JButton();
        btnImprimirExecutorService = new javax.swing.JButton();
        btnImprimirForkJoin = new javax.swing.JButton();
        btnImprimirMatriz01 = new javax.swing.JButton();
        btnImprimirMatriz02 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(51, 0, 51));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Multiplicación de Matrices");

        lblGenerar1.setText("Generar Matriz 1");

        lblFilas01.setText("Filas");

        txtFilasM1.setMinimumSize(new java.awt.Dimension(50, 23));
        txtFilasM1.setPreferredSize(new java.awt.Dimension(50, 23));

        lblColumnas01.setText("Columnas");

        txtColumnasM1.setMinimumSize(new java.awt.Dimension(50, 20));
        txtColumnasM1.setPreferredSize(new java.awt.Dimension(50, 23));

        lblGenerar02.setText("Generar Matriz 2");

        lblFilas02.setText("Filas");

        lblColumnas02.setText("Columnas");

        txtFilasM2.setMinimumSize(new java.awt.Dimension(50, 20));
        txtFilasM2.setPreferredSize(new java.awt.Dimension(50, 23));

        txtColumnasM2.setMinimumSize(new java.awt.Dimension(50, 20));
        txtColumnasM2.setPreferredSize(new java.awt.Dimension(50, 23));

        btnGenerarMatriz1.setText("Generar Matriz 1");
        btnGenerarMatriz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarMatriz1ActionPerformed(evt);
            }
        });

        btnGenerarMatriz2.setText("Generar Matriz 2");
        btnGenerarMatriz2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarMatriz2ActionPerformed(evt);
            }
        });

        txtMatriz1.setEditable(false);
        txtMatriz1.setColumns(20);
        txtMatriz1.setRows(5);
        jScrollPane1.setViewportView(txtMatriz1);

        txtMatriz2.setEditable(false);
        txtMatriz2.setColumns(20);
        txtMatriz2.setRows(5);
        jScrollPane3.setViewportView(txtMatriz2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Matriz 1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Matriz 2");

        txtAResultadoSecuencial.setEditable(false);
        txtAResultadoSecuencial.setColumns(20);
        txtAResultadoSecuencial.setRows(5);
        jScrollPane2.setViewportView(txtAResultadoSecuencial);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Resultado Secuencial");

        txtAResultadoExecutorService.setEditable(false);
        txtAResultadoExecutorService.setColumns(20);
        txtAResultadoExecutorService.setRows(5);
        jScrollPane4.setViewportView(txtAResultadoExecutorService);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Resultado ForkJoin");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Resultado ExecutorService");

        txtAResultadoForkJoin.setEditable(false);
        txtAResultadoForkJoin.setColumns(20);
        txtAResultadoForkJoin.setRows(5);
        jScrollPane5.setViewportView(txtAResultadoForkJoin);

        btnSecuencial.setText("Secuencial");
        btnSecuencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecuencialActionPerformed(evt);
            }
        });

        btnExecutorService.setText("ExecutorService");
        btnExecutorService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecutorServiceActionPerformed(evt);
            }
        });

        btnForkJoin.setText("ForkJoin");
        btnForkJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForkJoinActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Multiplcar Matrices");

        jLabel7.setText("Secuencial");

        txtfTiempoSecuencial.setEditable(false);
        txtfTiempoSecuencial.setPreferredSize(new java.awt.Dimension(71, 28));

        jLabel8.setText("ExecutorService");

        txtfTiempoExecutorService.setEditable(false);
        txtfTiempoExecutorService.setPreferredSize(new java.awt.Dimension(71, 28));

        jLabel9.setText("ForkJoin");

        txtfTiempoForkJoin.setEditable(false);
        txtfTiempoForkJoin.setPreferredSize(new java.awt.Dimension(71, 28));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tiempo de Ejecución");

        btnImprimirSecuencial.setText("Imprimir");
        btnImprimirSecuencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirSecuencialActionPerformed(evt);
            }
        });

        btnImprimirExecutorService.setText("Imprimir");
        btnImprimirExecutorService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirExecutorServiceActionPerformed(evt);
            }
        });

        btnImprimirForkJoin.setText("Imprimir");
        btnImprimirForkJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirForkJoinActionPerformed(evt);
            }
        });

        btnImprimirMatriz01.setText("Imprimir Matriz 1");
        btnImprimirMatriz01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirMatriz01ActionPerformed(evt);
            }
        });

        btnImprimirMatriz02.setText("Imprimir Matriz 2");
        btnImprimirMatriz02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirMatriz02ActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(lblTitulo)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSecuencial)
                            .addComponent(btnExecutorService)
                            .addComponent(btnForkJoin))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnImprimirExecutorService)
                            .addComponent(btnImprimirSecuencial)
                            .addComponent(btnImprimirForkJoin)))
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblGenerar1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblFilas01)
                                    .addGap(43, 43, 43)
                                    .addComponent(txtFilasM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnGenerarMatriz1)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblColumnas01)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtColumnasM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnImprimirMatriz01))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnImprimirMatriz02)
                            .addComponent(lblGenerar02)
                            .addComponent(btnGenerarMatriz2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblColumnas02)
                                    .addComponent(lblFilas02))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFilasM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtColumnasM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addComponent(txtfTiempoForkJoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtfTiempoSecuencial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfTiempoExecutorService, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLimpiar))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitulo)
                            .addComponent(jLabel1))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGenerar1)
                            .addComponent(lblGenerar02))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFilas01)
                            .addComponent(lblFilas02)
                            .addComponent(txtFilasM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFilasM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtColumnasM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColumnas01)
                            .addComponent(lblColumnas02)
                            .addComponent(txtColumnasM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGenerarMatriz1)
                            .addComponent(btnGenerarMatriz2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnImprimirMatriz01)
                            .addComponent(btnImprimirMatriz02))
                        .addGap(56, 56, 56)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSecuencial)
                            .addComponent(btnImprimirSecuencial))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExecutorService)
                            .addComponent(btnImprimirExecutorService)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnForkJoin)
                            .addComponent(btnImprimirForkJoin))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel10)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtfTiempoSecuencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtfTiempoExecutorService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtfTiempoForkJoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane5)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarMatriz1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarMatriz1ActionPerformed
        if (this.txtFilasM1.getText().isEmpty() || this.txtColumnasM1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar datos en los dos campos");

        } else {
            filasM1 = Integer.parseInt(this.txtFilasM1.getText());
            columnasM1 = Integer.parseInt(this.txtColumnasM1.getText());
            matriz1 = new int[filasM1][columnasM1];
            matriz1 = llenarMatriz(matriz1, filasM1, columnasM1);
            this.txtFilasM2.setText(String.valueOf(columnasM1));
        }
    }//GEN-LAST:event_btnGenerarMatriz1ActionPerformed

    private void btnGenerarMatriz2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarMatriz2ActionPerformed
        if (this.txtFilasM2.getText().isEmpty() || this.txtColumnasM2.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Ingresar datos en los dos campos");

        } else if (columnasM1 != Integer.parseInt(this.txtFilasM2.getText())) {
            JOptionPane.showMessageDialog(null, "El numero de filas de la matriz 2 debe ser el mismo numero de columnas de la matriz 1");
        } else {
            filasM2 = Integer.parseInt(this.txtFilasM2.getText());
            columnasM2 = Integer.parseInt(this.txtColumnasM2.getText());
            matriz2 = new int[filasM2][columnasM2];
            matriz2 = llenarMatriz(matriz2, filasM2, columnasM2);
        }
    }//GEN-LAST:event_btnGenerarMatriz2ActionPerformed

    private void btnSecuencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecuencialActionPerformed
        //Secuencial
        long inicio = System.currentTimeMillis();
        secuencial = new MatrizSecuencial(matriz1,matriz2);
        long fin = System.currentTimeMillis() - inicio;
        this.txtfTiempoSecuencial.setText(String.valueOf(fin)+" ms");   
    }//GEN-LAST:event_btnSecuencialActionPerformed

    private void btnExecutorServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecutorServiceActionPerformed
        int numhilos = Runtime.getRuntime().availableProcessors();
        long inicio = System.currentTimeMillis();
        MatrizExecutorService.multiplicarExecutorService(matriz1, matriz2,numhilos);
        long tiempo = System.currentTimeMillis() - inicio;
        this.txtfTiempoExecutorService.setText(String.valueOf(tiempo)+" ms");
        
    }//GEN-LAST:event_btnExecutorServiceActionPerformed

    private void btnForkJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForkJoinActionPerformed
        int numHilos = Runtime.getRuntime().availableProcessors();
        int[][] res = new int[filasM1][columnasM2];
        resForkJoin = new int[filasM1][columnasM2];
        ForkJoinPool pool = new ForkJoinPool(numHilos);
        long inicio = System.currentTimeMillis();
        pool.invoke(new MatrizForkJoin(matriz1,matriz2,res));
        long time = System.currentTimeMillis() - inicio;
        resForkJoin = res;
        this.txtfTiempoForkJoin.setText(String.valueOf(time)+" ms");

    }//GEN-LAST:event_btnForkJoinActionPerformed

    private void btnImprimirSecuencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirSecuencialActionPerformed
        if (matriz1 == null || matriz2 == null)
            JOptionPane.showMessageDialog(null, "Generar matrices primero");
        else
            this.txtAResultadoSecuencial.setText(imprimirMatriz(secuencial.getMatrizresul()));
    }//GEN-LAST:event_btnImprimirSecuencialActionPerformed

    private void btnImprimirExecutorServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirExecutorServiceActionPerformed
        if (matriz1 == null || matriz2 == null)
            JOptionPane.showMessageDialog(null, "Generar matrices primero");
        else
            this.txtAResultadoExecutorService.setText(imprimirMatriz(MatrizExecutorService.getRes()));

    }//GEN-LAST:event_btnImprimirExecutorServiceActionPerformed

    private void btnImprimirForkJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirForkJoinActionPerformed
        if (matriz1 == null || matriz2 == null)
            JOptionPane.showMessageDialog(null, "Generar matrices primero");
        else
            this.txtAResultadoForkJoin.setText(imprimirMatriz(resForkJoin));
    }//GEN-LAST:event_btnImprimirForkJoinActionPerformed

    private void btnImprimirMatriz01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirMatriz01ActionPerformed
        if (matriz1 == null)
            JOptionPane.showMessageDialog(null, "Generar matriz 1 primero");
        else
            this.txtMatriz1.setText(imprimirMatriz(matriz1));

    }//GEN-LAST:event_btnImprimirMatriz01ActionPerformed

    private void btnImprimirMatriz02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirMatriz02ActionPerformed

        if (matriz2 == null)
            JOptionPane.showMessageDialog(null, "Generar matriz 1 primero");
        else
            this.txtMatriz2.setText(imprimirMatriz(matriz2));
    }//GEN-LAST:event_btnImprimirMatriz02ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        this.txtAResultadoExecutorService.setText("");
        this.txtAResultadoForkJoin.setText("");
        this.txtAResultadoSecuencial.setText("");
        this.txtColumnasM1.setText("");
        this.txtColumnasM2.setText("");
        this.txtFilasM1.setText("");
        this.txtFilasM2.setText("");
        this.txtMatriz1.setText("");
        this.txtMatriz2.setText("");
        this.txtfTiempoExecutorService.setText("");
        this.txtfTiempoForkJoin.setText("");
        this.txtfTiempoSecuencial.setText("");

    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(frmMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMatriz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExecutorService;
    private javax.swing.JButton btnForkJoin;
    private javax.swing.JButton btnGenerarMatriz1;
    private javax.swing.JButton btnGenerarMatriz2;
    private javax.swing.JButton btnImprimirExecutorService;
    private javax.swing.JButton btnImprimirForkJoin;
    private javax.swing.JButton btnImprimirMatriz01;
    private javax.swing.JButton btnImprimirMatriz02;
    private javax.swing.JButton btnImprimirSecuencial;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSecuencial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblColumnas01;
    private javax.swing.JLabel lblColumnas02;
    private javax.swing.JLabel lblFilas01;
    private javax.swing.JLabel lblFilas02;
    private javax.swing.JLabel lblGenerar02;
    private javax.swing.JLabel lblGenerar1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtAResultadoExecutorService;
    private javax.swing.JTextArea txtAResultadoForkJoin;
    private javax.swing.JTextArea txtAResultadoSecuencial;
    private javax.swing.JTextField txtColumnasM1;
    private javax.swing.JTextField txtColumnasM2;
    private javax.swing.JTextField txtFilasM1;
    private javax.swing.JTextField txtFilasM2;
    private javax.swing.JTextArea txtMatriz1;
    private javax.swing.JTextArea txtMatriz2;
    private javax.swing.JTextField txtfTiempoExecutorService;
    private javax.swing.JTextField txtfTiempoForkJoin;
    private javax.swing.JTextField txtfTiempoSecuencial;
    // End of variables declaration//GEN-END:variables
}
