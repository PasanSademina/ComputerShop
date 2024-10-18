/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Pasan
 */
public class inventory extends javax.swing.JFrame {

    DecimalFormat df = new DecimalFormat("0.00");

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

   
    //stock
   
   

   
    

    

    //supplier
    public void loadSuppliers() {
        try {
            ResultSet rs = MySQL.executeSearch("SELECT * FROM `supplier` "
                    + "INNER JOIN `company_branch` ON `supplier`.`company_branch_id`=`company_branch`.`id` "
                    + "INNER JOIN `company_branch_address` ON `company_branch_address`.`id`=`company_branch`.`company_branch_address_id` "
                    + "INNER JOIN `city` ON `city`.`id`= `company_branch_address`.`city_id` "
                    + "ORDER BY `supplier`.`mobile` ASC");
            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("supplier.mobile"));
                v.add(rs.getString("supplier.fname"));
                // v.add(rs.getString("supplier.contact_number"));
                v.add(rs.getString("supplier.email"));
                v.add(rs.getString("company_branch.name"));
                v.add(rs.getString("company_branch.branch_contact_number"));
                String address = rs.getString("company_branch_address.line1") + "," + rs.getString("company_branch_address.line2") + "," + rs.getString("city.name");
                v.add(address);
                dtm.addRow(v);
            }

            jTable4.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void regcomp() {
        try {
            ResultSet rs = MySQL.executeSearch("SELECT * FROM `company`");
            DefaultListModel ls = new DefaultListModel();
            while (rs.next()) {
                ls.addElement("O " + rs.getString("name"));

            }

            jList2.setModel(ls);
            jList2.setFixedCellHeight(32);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //supplier

    //company
    public void loadCities() {
        try {
            ResultSet rs = MySQL.executeSearch("SELECT * FROM `city`");

            Vector v = new Vector();
            v.add("Select City");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox5.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadSuppliers2() {
        try {
            ResultSet rs = MySQL.executeSearch("SELECT * FROM `supplier` INNER JOIN `company_branch` ON `supplier`.`company_branch_id`=`company_branch`.`id` INNER JOIN `company_branch_address` ON `company_branch_address`.`id`=`company_branch`.`company_branch_address_id` INNER JOIN `company` ON `company`.`id` = `company_branch`.`company_id` INNER JOIN `city` ON `city`.`id`= `company_branch_address`.`city_id` ORDER BY `supplier`.`mobile` ASC");
            DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("supplier.mobile"));
                v.add(rs.getString("supplier.fname"));
                //v.add(rs.getString("supplier.contact_number"));
                v.add(rs.getString("supplier.email"));
                v.add(rs.getString("company.name"));
                v.add(rs.getString("company_branch.name"));
                v.add(rs.getString("company_branch.branch_contact_number"));
                String address = rs.getString("company_branch_address.line1") + "," + rs.getString("company_branch_address.line2") + "," + rs.getString("city.name");
                v.add(address);
                dtm.addRow(v);
            }

            jTable5.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCompanies() {
        try {
            ResultSet rs = MySQL.executeSearch("SELECT * FROM `company` ORDER BY `id` ASC");
            DefaultTableModel dtm = (DefaultTableModel) jCtable.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("contact_number"));
                dtm.addRow(v);
            }
            jCtable.setModel(dtm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCompSuppliers() {
        try {
            ResultSet rs = MySQL.executeSearch("SELECT * FROM `company_branch`  INNER JOIN `company_branch_address` ON `company_branch_address`.`id`=`company_branch`.`company_branch_address_id` INNER JOIN `company` ON `company`.`id` = `company_branch`.`company_id` INNER JOIN `city` ON `city`.`id`= `company_branch_address`.`city_id` ORDER BY `company_branch`.`id` ASC");
            DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();

                v.add(rs.getString("company.name"));
                v.add(rs.getString("company_branch.name"));
                v.add(rs.getString("company_branch.branch_contact_number"));
                String address = rs.getString("company_branch_address.line1") + "," + rs.getString("company_branch_address.line2") + "," + rs.getString("city.name");
                v.add(address);
                dtm.addRow(v);
            }

            jTable5.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //company

    public inventory() {
        initComponents();
        
        loadSuppliers();
        regcomp();
        loadCompanies();
        loadCompSuppliers();
        loadCities();
        //loadSuppliers2();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        pnlCard5 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel69 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        pnlCard7 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel92 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jCtable = new javax.swing.JTable();
        jcompany = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel97 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel98 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jCid = new javax.swing.JLabel();
        jCname = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        pnlCard5.setBackground(java.awt.Color.white);

        jPanel21.setBackground(java.awt.Color.white);

        jList2.setFont(new java.awt.Font("Comic Sans MS", 1, 15)); // NOI18N
        jScrollPane6.setViewportView(jList2);

        jLabel69.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("Registered Companies");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane6)))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6)
                .addContainerGap())
        );

        jTable4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Contact Number", "Supplier Name", "Email", "Branch Name", "Branch Contact Number", "Branch Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable4MouseEntered(evt);
            }
        });
        jScrollPane5.setViewportView(jTable4);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jButton32.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton32.setText(" Add Suppllier");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton33.setText(" Refresh");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton30.setText("Search");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jTextField8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        javax.swing.GroupLayout pnlCard5Layout = new javax.swing.GroupLayout(pnlCard5);
        pnlCard5.setLayout(pnlCard5Layout);
        pnlCard5Layout.setHorizontalGroup(
            pnlCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard5Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(pnlCard5Layout.createSequentialGroup()
                        .addGroup(pnlCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCard5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jSeparator8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard5Layout.createSequentialGroup()
                                .addComponent(jTextField8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnlCard5Layout.setVerticalGroup(
            pnlCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCard5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCard5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlCard5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pnlCard7.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 3, true)), "Company & Branch Registrtion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 18))); // NOI18N

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jLabel90.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel90.setText("Company Name");

        jLabel91.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel91.setText("Company Contact Number");

        jTextField9.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N

        jButton6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jButton6.setText("Add Company");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel92.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("Company Registration");

        jCtable.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jCtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company ID", "Name", "Contact Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jCtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCtableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jCtable);

        jcompany.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jcompany)))
            .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel92)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel90)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel91)
                    .addComponent(jcompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        jLabel86.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel86.setText("Branch Name");

        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField18KeyTyped(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel87.setText("Branch Contact Number");

        jLabel88.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel88.setText("Company ID :");

        jLabel93.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel93.setText("Company Name :");

        jLabel95.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel95.setText("Address Line 01");

        jLabel96.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel96.setText("Address Line 02");

        jLabel97.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel97.setText("City");

        jButton13.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jButton13.setText("Create New Branch");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel98.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("Branch Registration");

        jCid.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jCid.setText("None");

        jCname.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jCname.setText("None");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator5)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel87)
                            .addComponent(jLabel86))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField18)
                            .addComponent(jTextField17)))
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel96, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel95, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel97))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField20)
                            .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel88)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jSeparator7))
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCid, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel93)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCname, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel98)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel86)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel87)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(jLabel88)
                    .addComponent(jCid)
                    .addComponent(jCname))
                .addGap(18, 18, 18)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel97)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Company Name", "Branch Name", "Branch Contact Number", "Branch Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable5MouseEntered(evt);
            }
        });
        jScrollPane9.setViewportView(jTable5);

        javax.swing.GroupLayout pnlCard7Layout = new javax.swing.GroupLayout(pnlCard7);
        pnlCard7.setLayout(pnlCard7Layout);
        pnlCard7Layout.setHorizontalGroup(
            pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard7Layout.createSequentialGroup()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        pnlCard7Layout.setVerticalGroup(
            pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCard7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCard7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new java.awt.GridLayout(3, 1, 10, 10));

        jButton5.setText("Dashboard");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);

        jButton3.setText("Supplier");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setText("Company");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 629));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(1037, 575));
        jPanel2.setLayout(new java.awt.CardLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 0, 1060, 629));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(jPanel5);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(jPanel6);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(jPanel2);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseEntered

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        Supplier_reg sr = new Supplier_reg(this, true);
        sr.setVisible(true);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        loadSuppliers();
        jTextField8.setText("");
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        try {
            ResultSet rs = MySQL.executeSearch("SELECT * FROM `supplier` "
                    + "INNER JOIN `company_branch` ON `supplier`.`company_branch_id`=`company_branch`.`id` "
                    + "INNER JOIN `company_branch_address` ON `company_branch_address`.`id`=`company_branch`.`company_branch_address_id` "
                    + "INNER JOIN `city` ON `city`.`id`= `company_branch_address`.`city_id` "
                    + "WHERE `supplier`.`fname` LIKE '%" + jTextField8.getText() + "%' OR `company_branch`.`name` "
                    + "LIKE '%" + jTextField8.getText() + "%' ORDER BY `supplier`.`mobile` ASC");
            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("supplier.mobile"));
                v.add(rs.getString("supplier.fname"));
                // v.add(rs.getString("supplier.contact_number"));
                v.add(rs.getString("supplier.email"));
                v.add(rs.getString("company_branch.name"));
                v.add(rs.getString("company_branch.branch_contact_number"));
                String address = rs.getString("company_branch_address.line1") + "," + rs.getString("company_branch_address.line2") + "," + rs.getString("city.name");
                v.add(address);
                dtm.addRow(v);
            }

            jTable4.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        String name = jTextField9.getText();
        String contact_number = jcompany.getText();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select company name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (contact_number.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid contact number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet rs = MySQL.executeSearch("SELECT * FROM `company` WHERE `name`='" + name + "' AND `contact_number`='" + contact_number + "'");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Company already exists", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    MySQL.executeIUD("INSERT INTO `company` (`name`,`contact_number`) VALUES ('" + name + "','" + contact_number + "')");
                    jTextField9.setText("");
                    jcompany.setText("");
                    jTextField9.grabFocus();
                    loadCompanies();
                    JOptionPane.showMessageDialog(this, "New company added", "Success", JOptionPane.INFORMATION_MESSAGE);

                    jTextField9.setText("");
                    jcompany.setText("");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jCtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCtableMouseClicked
        if (evt.getClickCount() == 2) {
            int r = jCtable.getSelectedRow();

            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Please select a company", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                String id = jCtable.getValueAt(r, 0).toString();
                String name = jCtable.getValueAt(r, 1).toString();

                jCid.setText(id);
                jCname.setText(name);

            }
        }
    }//GEN-LAST:event_jCtableMouseClicked

    private void jTextField18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyTyped

        String mobile = jTextField18.getText();
        String text = mobile + evt.getKeyChar();

        if (mobile.length() == 10) {
            evt.consume();
        } else {
            if (!Pattern.compile("[0-9]+").matcher(text).matches()) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_jTextField18KeyTyped

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        String name = jTextField17.getText();
        String contact_number = jTextField18.getText();
        String company = jCname.getText();  // Assuming this is the company name
        String address_line_01 = jTextField19.getText();
        String address_line_02 = jTextField20.getText();
        String city = jComboBox5.getSelectedItem().toString();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter branch name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("0[0-9]{9}").matcher(contact_number).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid contact number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (company.equals("None")) {
            JOptionPane.showMessageDialog(this, "Please select company from table", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (address_line_01.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address line 01", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (address_line_02.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address line 02", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (city.equals("Select City")) {
            JOptionPane.showMessageDialog(this, "Please select city", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                // Fetch city_id from the city table
                ResultSet rs1 = MySQL.executeSearch("SELECT id FROM `city` WHERE `name`='" + city + "'");
                if (rs1.next()) {
                    String city_id = rs1.getString("id");

                    // Fetch company_id based on company name
                    ResultSet rsCompany = MySQL.executeSearch("SELECT id FROM `company` WHERE `name`='" + company + "'");
                    if (rsCompany.next()) {
                        String company_id = rsCompany.getString("id");

                        // Check if address is already used
                        ResultSet rsx = MySQL.executeSearch("SELECT * FROM `company_branch_address` WHERE `line1`='" + address_line_01 + "' AND `line2`='" + address_line_02 + "' AND `city_id`= '" + city_id + "' ;");

                        if (rsx.next()) {
                            JOptionPane.showMessageDialog(this, "Address already used", "Warning", JOptionPane.WARNING_MESSAGE);
                        } else {
                            // Insert the new branch address
                            MySQL.executeIUD("INSERT INTO `company_branch_address` (`line1`,`line2`,`city_id`) VALUES ('" + address_line_01 + "','" + address_line_02 + "','" + city_id + "')");

                            // Get the newly inserted address ID
                            ResultSet rs = MySQL.executeSearch("SELECT LAST_INSERT_ID()");
                            if (rs.next()) {
                                String address_id = rs.getString(1);

                                // Insert the new company branch
                                MySQL.executeIUD("INSERT INTO `company_branch` (`company_id`,`branch_contact_number`,`name`,`company_branch_address_id`) VALUES ('" + company_id + "','" + contact_number + "','" + name + "','" + address_id + "')");

                                // Reset fields after successful insertion
                                jTextField17.setText("");
                                jTextField18.setText("");
                                jCname.setText("None");
                                jTextField19.setText("");
                                jTextField20.setText("");
                                jComboBox5.setSelectedIndex(0);

                                jTextField17.grabFocus();

                                JOptionPane.showMessageDialog(this, "New Branch Created", "Success", JOptionPane.INFORMATION_MESSAGE);
                                loadCompSuppliers();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Selected company does not exist in the database", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "City not found", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTable5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable5MouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatLightFlatIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    public javax.swing.JLabel jCid;
    public javax.swing.JLabel jCname;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JTable jCtable;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jcompany;
    private javax.swing.JPanel pnlCard5;
    private javax.swing.JPanel pnlCard7;
    // End of variables declaration//GEN-END:variables
}
