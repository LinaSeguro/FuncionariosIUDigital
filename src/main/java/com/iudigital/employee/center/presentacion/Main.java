package com.iudigital.employee.center.presentacion;

import com.iudigital.employee.center.domain.Funcionario;
import com.iudigital.employee.center.controller.FuncionarioController;
import com.iudigital.employee.center.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    private final FuncionarioController funcionarioController;
    private static final String[] COLUMNS = {"ID", "TIPO IDENTIFICACIÓN", "NÚMERO IDENTIFICACIÓN",
        "NOMBRES", "APELLIDOS", "ESTADO CIVIL", "SEXO", "DIRECCIÓN", "TELÉFONO", "FECHA NACIMIENTO"};
    private static final String SELECCIONE = "--SELECCIONE--";

    public Main() {
        initComponents();
        txtIdEdit.setEditable(false);
        funcionarioController = new FuncionarioController();
        listFuncionarios();
        addListener();
    }

    private void listFuncionarios() {
        cbxFuncionario.removeAllItems();
        Funcionario funcionarioCombo = new Funcionario();
        funcionarioCombo.setNombres(SELECCIONE);
        funcionarioCombo.setApellidos("");
        cbxFuncionario.addItem(funcionarioCombo);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblFunc.setModel(defaultTableModel);
        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionario();
            if (funcionarios.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(funcionarios.size());
            int row = 0;
            for (Funcionario funcionario : funcionarios) {
                defaultTableModel.setValueAt(funcionario.getId(), row, 0);
                defaultTableModel.setValueAt(funcionario.getTipoIdentificacion(), row, 1);
                defaultTableModel.setValueAt(funcionario.getNumeroIdentificacion(), row, 2);
                defaultTableModel.setValueAt(funcionario.getNombres(), row, 3);
                defaultTableModel.setValueAt(funcionario.getApellidos(), row, 4);
                defaultTableModel.setValueAt(funcionario.getEstadoCivil(), row, 5);
                defaultTableModel.setValueAt(funcionario.getSexo(), row, 6);
                defaultTableModel.setValueAt(funcionario.getDireccion(), row, 7);
                defaultTableModel.setValueAt(funcionario.getTelefono(), row, 8);
                defaultTableModel.setValueAt(funcionario.getFechaNacimiento(), row, 9);
                row++;

                cbxFuncionario.addItem(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addListener() {
        cbxFuncionario.addItemListener(event -> {
            Funcionario selectedFuncionario = (Funcionario) event.getItem();
            if (selectedFuncionario.getNombres().equals(SELECCIONE)) {
                txtIdEdit.setText("");
                txtIdTypeEdit.setText("");
                txtNumberEdit.setText("");
                txtNameEdit.setText("");
                txtLastEdit.setText("");
                txtStatusEdit.setText("");
                txtSexEdit.setText("");
                txtPhoneEdit.setText("");
                txtAddressEdit.setText("");
                dchBirthdateEdit.setDate(null);
            } else {
                txtIdEdit.setText(String.valueOf(selectedFuncionario.getId()));
                txtIdTypeEdit.setText(selectedFuncionario.getTipoIdentificacion());
                txtNumberEdit.setText(selectedFuncionario.getNumeroIdentificacion());
                txtNameEdit.setText(selectedFuncionario.getNombres());
                txtLastEdit.setText(selectedFuncionario.getApellidos());
                txtStatusEdit.setText(selectedFuncionario.getEstadoCivil());
                txtSexEdit.setText(String.valueOf(selectedFuncionario.getSexo()));
                txtPhoneEdit.setText(selectedFuncionario.getDireccion());
                txtAddressEdit.setText(selectedFuncionario.getTelefono());                
                dchBirthdateEdit.setDate(selectedFuncionario.getFechaNacimiento());
            }
        });
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanels = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPfunc = new javax.swing.JPanel();
        lblIdType = new javax.swing.JLabel();
        lblIdNumber = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblLast = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblSex = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblBirthdate = new javax.swing.JLabel();
        txtIdType = new javax.swing.JTextField();
        txtIdNumber = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtLast = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtSex = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        dchBirthdate = new com.toedter.calendar.JDateChooser();
        btnCreate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFunc = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblFuncionarios = new javax.swing.JLabel();
        cbxFuncionario = new javax.swing.JComboBox<>();
        lblIdEdit = new javax.swing.JLabel();
        lblIdTypeEdit = new javax.swing.JLabel();
        lblNumberEdit = new javax.swing.JLabel();
        lblNameEdit = new javax.swing.JLabel();
        lblLastEdit = new javax.swing.JLabel();
        lblStatusEdit = new javax.swing.JLabel();
        lblSexEdit = new javax.swing.JLabel();
        lblAddressEdit = new javax.swing.JLabel();
        lblPhoneEdit = new javax.swing.JLabel();
        lblBirthdateEdit = new javax.swing.JLabel();
        txtIdEdit = new javax.swing.JTextField();
        txtIdTypeEdit = new javax.swing.JTextField();
        txtNumberEdit = new javax.swing.JTextField();
        txtNameEdit = new javax.swing.JTextField();
        txtLastEdit = new javax.swing.JTextField();
        txtStatusEdit = new javax.swing.JTextField();
        txtSexEdit = new javax.swing.JTextField();
        txtPhoneEdit = new javax.swing.JTextField();
        txtAddressEdit = new javax.swing.JTextField();
        dchBirthdateEdit = new com.toedter.calendar.JDateChooser();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Action Comics", 0, 14)); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("GESTION DE FUNCIONARIOS IUDIGITAL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 25, -1, 30));

        jPfunc.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite los siguientes campos "));

        lblIdType.setText("Tipo de Identificación:");

        lblIdNumber.setText("Número de Identificación:");

        lblName.setText("Nombres:");

        lblLast.setText("Apellidos:");

        lblStatus.setText("Estado Civil:");

        lblSex.setText("Sexo (F/M):");

        lblAddress.setText("Dirección:");

        lblPhone.setText("Teléfono:");

        lblBirthdate.setText("Fecha de Nacimiento:");

        txtIdNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdNumberActionPerformed(evt);
            }
        });

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        txtSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexActionPerformed(evt);
            }
        });

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        btnCreate.setText("GUARDAR");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPfuncLayout = new javax.swing.GroupLayout(jPfunc);
        jPfunc.setLayout(jPfuncLayout);
        jPfuncLayout.setHorizontalGroup(
            jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPfuncLayout.createSequentialGroup()
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPfuncLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPfuncLayout.createSequentialGroup()
                                .addComponent(lblName)
                                .addGap(18, 18, 18)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPfuncLayout.createSequentialGroup()
                                    .addComponent(lblPhone)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPhone))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPfuncLayout.createSequentialGroup()
                                    .addComponent(lblAddress)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPfuncLayout.createSequentialGroup()
                                .addComponent(lblBirthdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dchBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPfuncLayout.createSequentialGroup()
                                    .addComponent(lblLast)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPfuncLayout.createSequentialGroup()
                                    .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblStatus)
                                        .addComponent(lblSex))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtStatus)
                                        .addGroup(jPfuncLayout.createSequentialGroup()
                                            .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))))
                            .addGroup(jPfuncLayout.createSequentialGroup()
                                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIdNumber)
                                    .addComponent(lblIdType))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txtIdType)))))
                    .addGroup(jPfuncLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnCreate)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPfuncLayout.setVerticalGroup(
            jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPfuncLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdType)
                    .addComponent(txtIdType, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdNumber)
                    .addComponent(txtIdNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLast))
                .addGap(18, 18, 18)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSex)
                    .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBirthdate)
                    .addComponent(dchBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnCreate)
                .addContainerGap())
        );

        tblFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblFunc);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPfunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPfunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanels.addTab("Crear Funcionario", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifique los siguientes campos"));

        lblFuncionarios.setText("FUNCIONARIOS");

        cbxFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFuncionarioActionPerformed(evt);
            }
        });

        lblIdEdit.setText("Id");

        lblIdTypeEdit.setText("Tipo de Identificación");

        lblNumberEdit.setText("Número de Identificación");

        lblNameEdit.setText("Nombres");

        lblLastEdit.setText("Apellidos");

        lblStatusEdit.setText("Estado Civil");

        lblSexEdit.setText("Sexo (F/M)");

        lblAddressEdit.setText("Dirección");

        lblPhoneEdit.setText("Teléfono");

        lblBirthdateEdit.setText("Fecha de Nacimiento");

        txtIdTypeEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTypeEditActionPerformed(evt);
            }
        });

        txtLastEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastEditActionPerformed(evt);
            }
        });

        txtSexEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexEditActionPerformed(evt);
            }
        });

        txtAddressEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressEditActionPerformed(evt);
            }
        });

        btnEdit.setText("ACTUALIZAR");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("ELIMINAR");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumberEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLastEdit)
                            .addComponent(lblNameEdit)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lblIdEdit))
                            .addComponent(lblIdTypeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNameEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(txtLastEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(txtNumberEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(txtIdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdTypeEdit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddressEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBirthdateEdit)
                            .addComponent(lblPhoneEdit)
                            .addComponent(lblSexEdit)
                            .addComponent(lblStatusEdit))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(btnEdit)
                        .addGap(57, 57, 57)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhoneEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStatusEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dchBirthdateEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddressEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(lblFuncionarios))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblFuncionarios)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdEdit)
                            .addComponent(lblStatusEdit)
                            .addComponent(txtStatusEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdTypeEdit)
                    .addComponent(txtIdTypeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexEdit)
                    .addComponent(txtSexEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumberEdit)
                    .addComponent(txtNumberEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneEdit)
                    .addComponent(txtPhoneEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameEdit)
                    .addComponent(txtNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddressEdit)
                    .addComponent(txtAddressEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLastEdit)
                        .addComponent(txtLastEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBirthdateEdit))
                    .addComponent(dchBirthdateEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanels.addTab("Actualizar Funcionario", jPanel2);

        getContentPane().add(jPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 930, 470));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo_IUD.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 200, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdNumberActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void cbxFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFuncionarioActionPerformed

    private void txtAddressEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressEditActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        if (txtIdEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario de la lista");
            txtIdEdit.requestFocus();
            return;
        }

        if (txtIdTypeEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el tipo de identificación");
            txtIdTypeEdit.requestFocus();
            return;
        }

        if (txtNumberEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese número de identificación");
            txtNumberEdit.requestFocus();
            return;
        }

        if (txtNameEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese nombres");
            txtNameEdit.requestFocus();
            return;
        }

        if (txtLastEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese apellidos");
            txtLastEdit.requestFocus();
            return;
        }

        if (txtStatusEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el estado civil");
            txtStatusEdit.requestFocus();
            return;
        }

        // Validación del sexo
        if (txtSexEdit.getText().trim().length() != 1) {
            JOptionPane.showMessageDialog(null, "El sexo debe ser un solo carácter ('M' para masculino o 'F' para femenino)");
            txtSexEdit.requestFocus();
            return;
        }

        char sexo = Character.toUpperCase(txtSexEdit.getText().charAt(0));
        if (sexo != 'M' && sexo != 'F') {
            JOptionPane.showMessageDialog(null, "El sexo debe ser 'M' para masculino o 'F' para femenino");
            txtSexEdit.requestFocus();
            return;
        }

        if (txtPhoneEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese número de teléfono");
            txtPhoneEdit.requestFocus();
            return;
        }

        if (txtAddressEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese dirección");
            txtAddressEdit.requestFocus();
            return;
        }

        if (dchBirthdateEdit.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Seleccione fecha de nacimiento");
            dchBirthdateEdit.requestFocus();
            return;
        }

        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(Integer.parseInt(txtIdEdit.getText().trim()));
            funcionario.setTipoIdentificacion(txtIdTypeEdit.getText().trim());
            funcionario.setNumeroIdentificacion(txtNumberEdit.getText().trim());
            funcionario.setNombres(txtNameEdit.getText().trim());
            funcionario.setApellidos(txtLastEdit.getText().trim());
            funcionario.setEstadoCivil(txtStatusEdit.getText().trim());
            funcionario.setSexo(sexo); // Usamos el valor validado del sexo aquí
            funcionario.setTelefono(txtPhoneEdit.getText().trim());
            funcionario.setDireccion(txtAddressEdit.getText().trim());
            funcionario.setFechaNacimiento(dchBirthdateEdit.getDate());

            funcionarioController.actualizarFuncionario(funcionario.getId(), funcionario);

            // Limpiar campos después de la actualización
            txtIdEdit.setText("");
            txtIdTypeEdit.setText("");
            txtNumberEdit.setText("");
            txtNameEdit.setText("");
            txtLastEdit.setText("");
            txtStatusEdit.setText("");
            txtSexEdit.setText("");
            txtPhoneEdit.setText("");
            txtAddressEdit.setText("");
            dchBirthdateEdit.setDate(null);

            // Actualizar la lista de funcionarios
            listFuncionarios();

            JOptionPane.showMessageDialog(null, "Se ha actualizado el funcionario exitosamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el funcionario");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (txtIdType.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite tipo de identificación");
            txtIdType.requestFocus();
            return;
        }

        if (txtIdNumber.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite número de identificación");
            txtIdNumber.requestFocus();
            return;
        }

        if (txtName.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite nombres");
            txtName.requestFocus();
            return;
        }

        if (txtLast.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite apellidos");
            txtLast.requestFocus();
            return;
        }

        if (txtStatus.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite estado civil");
            txtStatus.requestFocus();
            return;
        }

        // Validación del sexo
        if (txtSex.getText().trim().length() != 1) {
            JOptionPane.showMessageDialog(null, "El sexo debe ser un solo carácter ('M' para masculino o 'F' para femenino)");
            txtSex.requestFocus();
            return;
        }

        char sexo = Character.toUpperCase(txtSex.getText().charAt(0));
        if (sexo != 'M' && sexo != 'F') {
            JOptionPane.showMessageDialog(null, "El sexo debe ser 'M' para masculino o 'F' para femenino");
            txtSex.requestFocus();
            return;
        }

        if (txtPhone.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite teléfono");
            txtPhone.requestFocus();
            return;
        }

        if (txtAddress.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite dirección");
            txtAddress.requestFocus();
            return;
        }

        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setTipoIdentificacion(txtIdType.getText().trim());
            funcionario.setNumeroIdentificacion(txtIdNumber.getText().trim());
            funcionario.setNombres(txtName.getText().trim());
            funcionario.setApellidos(txtLast.getText().trim());
            funcionario.setEstadoCivil(txtStatus.getText().trim());
            funcionario.setSexo(sexo); // Usamos el valor validado del sexo aquí
            funcionario.setTelefono(txtPhone.getText().trim());
            funcionario.setDireccion(txtAddress.getText().trim());

            // Asigna la fecha de nacimiento desde el componente de calendario
            funcionario.setFechaNacimiento(dchBirthdate.getDate());

            funcionarioController.crearFuncionario(funcionario);

            // Limpiar los campos después de crear un nuevo funcionario
            txtIdType.setText("");
            txtIdNumber.setText("");
            txtName.setText("");
            txtLast.setText("");
            txtStatus.setText("");
            txtSex.setText("");
            txtPhone.setText("");
            txtAddress.setText("");
            dchBirthdate.setDate(null);

            // Actualiza la lista de funcionarios
            listFuncionarios();

            JOptionPane.showMessageDialog(null, "Funcionario creado con éxito");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo crear el funcionario");
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtIdEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario de la lista");
            txtIdEdit.requestFocus();
            return;
        }

        int opt = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el funcionario?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opt == 0) {

            try {
                funcionarioController.eliminarFuncionario(Integer.parseInt(txtIdEdit.getText()));
                txtIdTypeEdit.setText("");
                txtNumberEdit.setText("");
                txtNameEdit.setText("");
                txtLastEdit.setText("");
                txtStatusEdit.setText("");
                txtSexEdit.setText("");
                txtPhoneEdit.setText("");
                txtAddressEdit.setText("");
                dchBirthdateEdit.setDate(null);

                listFuncionarios();
                JOptionPane.showMessageDialog(null, "Se eliminó el funcionario correctamente");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el funcionario");
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSexEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSexEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSexEditActionPerformed

    private void txtSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSexActionPerformed

    private void txtIdTypeEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTypeEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTypeEditActionPerformed

    private void txtLastEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastEditActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<Funcionario> cbxFuncionario;
    private com.toedter.calendar.JDateChooser dchBirthdate;
    private com.toedter.calendar.JDateChooser dchBirthdateEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jPanels;
    private javax.swing.JPanel jPfunc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressEdit;
    private javax.swing.JLabel lblBirthdate;
    private javax.swing.JLabel lblBirthdateEdit;
    private javax.swing.JLabel lblFuncionarios;
    private javax.swing.JLabel lblIdEdit;
    private javax.swing.JLabel lblIdNumber;
    private javax.swing.JLabel lblIdType;
    private javax.swing.JLabel lblIdTypeEdit;
    private javax.swing.JLabel lblLast;
    private javax.swing.JLabel lblLastEdit;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameEdit;
    private javax.swing.JLabel lblNumberEdit;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhoneEdit;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblSexEdit;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatusEdit;
    private javax.swing.JTable tblFunc;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAddressEdit;
    private javax.swing.JTextField txtIdEdit;
    private javax.swing.JTextField txtIdNumber;
    private javax.swing.JTextField txtIdType;
    private javax.swing.JTextField txtIdTypeEdit;
    private javax.swing.JTextField txtLast;
    private javax.swing.JTextField txtLastEdit;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameEdit;
    private javax.swing.JTextField txtNumberEdit;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPhoneEdit;
    private javax.swing.JTextField txtSex;
    private javax.swing.JTextField txtSexEdit;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtStatusEdit;
    // End of variables declaration//GEN-END:variables
}
