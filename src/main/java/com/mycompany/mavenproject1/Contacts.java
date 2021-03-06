/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import dao.PersonDao;
import dao.PhoneNumberDao;
import entity.Person;
import entity.PhoneNumbers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ирина
 */
public class Contacts extends javax.swing.JFrame {

    private boolean isClicked = false;
    private List<PhoneNumbers> phoneNumbers;
    private Person person;

    /**
     * Creates new form Contacts
     */
    public Contacts() {
        initComponents();
        initContactsTable();
        initPhoneNumbersTable();
    }

    private void initContactsTable() {

        contacts.setAutoCreateRowSorter(true);
        PersonDao personDao = null;
        List<Person> listPerson = null;

        String[] columnNames = {"Id",
            "Surname",
            "Name",
            "Patronymic",
            "Address",
            "Date"};

        try {
            personDao = new PersonDao();
            listPerson = personDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DefaultTableModel model = new DefaultTableModel();
        contacts.setModel(model);
        contacts.setRowSorter(new TableRowSorter(model));

        model.setColumnIdentifiers(columnNames);

        for (Person person : listPerson) {
            Object[] o = new Object[6];
            o[0] = person.getId();
            o[1] = person.getSurname();
            o[2] = person.getName();
            o[3] = person.getPatronymic();
            o[4] = person.getAddress();
            o[5] = person.getDate();
            model.addRow(o);
        }
    }

    private void initPhoneNumbersTable() {
        String[] columnNames = {
            "Phone number",
            "Phone type"
        };

        DefaultTableModel model = new DefaultTableModel();
        phoneNumbersTable.setModel(model);

        model.setColumnIdentifiers(columnNames);
        tablePanel.setVisible(false);
        contactInfoLabel.setVisible(false);
        phoneNumbersTable.setRowSelectionAllowed(true);
        phoneNumbersTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

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
        contacts = new javax.swing.JTable();
        refreshButton = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        create = new javax.swing.JButton();
        contactInfoLabel = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        phoneNumbersTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchByNameTF = new javax.swing.JTextField();
        searchByNumberTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        searchByAddressTF = new javax.swing.JTextField();
        searchByNameButton = new javax.swing.JButton();
        searchByNumberButton = new javax.swing.JButton();
        searchByAddressButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        searchBySurnameTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        searchByPatronymicTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Contacts");

        contacts.setModel(new javax.swing.table.DefaultTableModel(
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
        contacts.setName("Contacts"); // NOI18N
        contacts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(contacts);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        update.setText("Update contact");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Delete contact");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        create.setText("Create new contact");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        contactInfoLabel.setText("Info about contact");

        phoneNumbersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        phoneNumbersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phoneNumbersTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(phoneNumbersTable);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );

        jLabel1.setText("Search by name");

        jLabel3.setText("Search by phone number");

        searchByNameTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchByNameTFMouseClicked(evt);
            }
        });

        searchByNumberTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchByNumberTFMouseClicked(evt);
            }
        });

        jLabel4.setText("Search by address");

        searchByAddressTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchByAddressTFMouseClicked(evt);
            }
        });

        searchByNameButton.setText("Search");
        searchByNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByNameButtonActionPerformed(evt);
            }
        });

        searchByNumberButton.setText("Search");
        searchByNumberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByNumberButtonActionPerformed(evt);
            }
        });

        searchByAddressButton.setText("Search");
        searchByAddressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByAddressButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Search by surname");

        searchBySurnameTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBySurnameTFMouseClicked(evt);
            }
        });

        jLabel5.setText("Search by partonymic");

        searchByPatronymicTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchByPatronymicTFMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(create, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                            .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(contactInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(searchByPatronymicTF, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(searchBySurnameTF))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(searchByNameTF))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchByNumberTF)
                                    .addComponent(searchByAddressTF))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchByNameButton)
                            .addComponent(searchByNumberButton)
                            .addComponent(searchByAddressButton))
                        .addGap(141, 141, 141))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(create)
                            .addComponent(update))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(refreshButton)
                            .addComponent(delete))
                        .addGap(18, 18, 18)
                        .addComponent(contactInfoLabel)
                        .addGap(14, 14, 14)
                        .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBySurnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByNameButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByPatronymicTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByNumberButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByAddressButton))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        List<Person> listPerson = null;
        try (PersonDao personDao = new PersonDao()) {
            listPerson = personDao.getAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
        }
        setDataToContactsTable(listPerson);
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if (isClicked) {
            new UpdateContact(person, phoneNumbers).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Choose a contact.");
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        List<Integer> count = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) contacts.getModel();
        int[] selectedRows = contacts.getSelectedRows();
        for (int i = 0; i < selectedRows.length; i++) {
            count.add((Integer) model.getValueAt(selectedRows[i] - i, 0));
            model.removeRow(selectedRows[i] - i);
        }
        try (PersonDao personDao = new PersonDao()) {
            for (Integer i : count) {
                personDao.delete(i);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
        }

    }//GEN-LAST:event_deleteActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        new CreateContact().setVisible(true);
    }//GEN-LAST:event_createActionPerformed

    private void phoneNumbersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phoneNumbersTableMouseClicked

    }//GEN-LAST:event_phoneNumbersTableMouseClicked

    private void contactsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactsMouseClicked

        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        row = contacts.convertRowIndexToModel(row);

        int column = source.columnAtPoint(evt.getPoint());
        int personId = (int) contacts.getModel().getValueAt(row, 0);
        try (PhoneNumberDao phoneNumbersDao = new PhoneNumberDao()) {
            phoneNumbers = phoneNumbersDao.getByPersonId(personId);
            tablePanel.setVisible(true);
            contactInfoLabel.setVisible(true);
            contactInfoLabel.setText(source.getModel().getValueAt(row, 1) + " "
                    + source.getModel().getValueAt(row, 2) + " "
                    + source.getModel().getValueAt(row, 3) + " phone numbers");
            person = new Person();
            person.setId((Integer) source.getModel().getValueAt(row, 0));
            person.setName((String) source.getModel().getValueAt(row, 2));
            person.setSurname((String) source.getModel().getValueAt(row, 1));
            person.setPatronymic((String) source.getModel().getValueAt(row, 3));
            person.setAddress((String) source.getModel().getValueAt(row, 4));
            setDataToPhoneNumbersTable(phoneNumbers);
            isClicked = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_contactsMouseClicked

    private void searchByNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByNameButtonActionPerformed
        List<Person> listPerson = new ArrayList<>();
        List<PhoneNumbers> listPhoneNumbers = new ArrayList<>();
        String name = searchByNameTF.getText().toUpperCase();
        String surname = searchBySurnameTF.getText().toUpperCase();
        String patronymic = searchByPatronymicTF.getText().toUpperCase();
        try (PersonDao personDao = new PersonDao(); PhoneNumberDao phoneNumberDao = new PhoneNumberDao()) {
            listPerson = personDao.getPersonByFullName(surname, name, patronymic);
            if (!listPerson.isEmpty()) {
                int id = listPerson.get(0).getId();
                listPhoneNumbers = phoneNumberDao.getByPersonId(id);
                setDataToContactsTable(listPerson);
                setDataToPhoneNumbersTable(listPhoneNumbers);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Contact not found.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
        }

    }//GEN-LAST:event_searchByNameButtonActionPerformed

    private void searchByNumberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByNumberButtonActionPerformed
        List<Person> listPerson = new ArrayList<>();
        List<PhoneNumbers> listPhoneNumbers = new ArrayList<>();
        String number = searchByNumberTF.getText();
        try (PhoneNumberDao phoneNumber = new PhoneNumberDao(); PersonDao personDao = new PersonDao()) {
            int idPerson = phoneNumber.getAllByNumber(number).getIdPerson();
            if (idPerson != 0) {
                listPerson = personDao.getAllByIdPerson(idPerson);
                listPhoneNumbers = phoneNumber.getByPersonId(idPerson);
                setDataToContactsTable(listPerson);
                setDataToPhoneNumbersTable(listPhoneNumbers);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Contact not found.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchByNumberButtonActionPerformed

    private void searchByAddressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByAddressButtonActionPerformed
        List<Person> listPerson = new ArrayList<>();
        List<PhoneNumbers> listPhoneNumbers = new ArrayList<>();
        String address = searchByAddressTF.getText().toUpperCase();
        try (PersonDao personDao = new PersonDao(); PhoneNumberDao phoneNumberDao = new PhoneNumberDao()) {
            listPerson = personDao.getPersonByAddress(address);
            if (!listPerson.isEmpty()) {
                listPhoneNumbers = phoneNumberDao.getByPersonId(listPerson.get(0).getId());
                setDataToContactsTable(listPerson);
                setDataToPhoneNumbersTable(listPhoneNumbers);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Contact not found.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchByAddressButtonActionPerformed

    private void searchByNameTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchByNameTFMouseClicked
        searchByAddressTF.setText("");
        searchByNumberTF.setText("");
    }//GEN-LAST:event_searchByNameTFMouseClicked

    private void searchBySurnameTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBySurnameTFMouseClicked
        searchByAddressTF.setText("");
        searchByNumberTF.setText("");
    }//GEN-LAST:event_searchBySurnameTFMouseClicked

    private void searchByPatronymicTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchByPatronymicTFMouseClicked
        searchByAddressTF.setText("");
        searchByNumberTF.setText("");
    }//GEN-LAST:event_searchByPatronymicTFMouseClicked

    private void searchByNumberTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchByNumberTFMouseClicked
        searchBySurnameTF.setText("");
        searchByNameTF.setText("");
        searchByPatronymicTF.setText("");
        searchByAddressTF.setText("");
    }//GEN-LAST:event_searchByNumberTFMouseClicked

    private void searchByAddressTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchByAddressTFMouseClicked
        searchBySurnameTF.setText("");
        searchByNameTF.setText("");
        searchByPatronymicTF.setText("");
        searchByNumberTF.setText("");
    }//GEN-LAST:event_searchByAddressTFMouseClicked

    private void setDataToContactsTable(List<Person> listPerson) {
        DefaultTableModel model = (DefaultTableModel) contacts.getModel();
        model.setRowCount(0);
        for (Person person : listPerson) {
            Object[] o = new Object[6];
            o[0] = person.getId();
            o[1] = person.getSurname();
            o[2] = person.getName();
            o[3] = person.getPatronymic();
            o[4] = person.getAddress();
            o[5] = person.getDate();
            model.addRow(o);
        }
    }

    private void setDataToPhoneNumbersTable(List<PhoneNumbers> listPhoneNumbers) {
        DefaultTableModel model = (DefaultTableModel) phoneNumbersTable.getModel();
        model.setRowCount(0);
        tablePanel.setVisible(true);
        contactInfoLabel.setVisible(true);
        for (PhoneNumbers phoneNumbers : listPhoneNumbers) {
            Object[] o = new Object[2];
            o[0] = phoneNumbers.getNumber();
            o[1] = phoneNumbers.getType();
            model.addRow(o);
        }
    }

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
            java.util.logging.Logger.getLogger(Contacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contacts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contactInfoLabel;
    private javax.swing.JTable contacts;
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable phoneNumbersTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton searchByAddressButton;
    private javax.swing.JTextField searchByAddressTF;
    private javax.swing.JButton searchByNameButton;
    private javax.swing.JTextField searchByNameTF;
    private javax.swing.JButton searchByNumberButton;
    private javax.swing.JTextField searchByNumberTF;
    private javax.swing.JTextField searchByPatronymicTF;
    private javax.swing.JTextField searchBySurnameTF;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
