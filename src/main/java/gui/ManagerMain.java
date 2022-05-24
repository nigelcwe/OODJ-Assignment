/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import application.entities.GymSystem;
import domain.entities.Booking;
import domain.entities.Customer;
import domain.entities.Staff;
import domain.enums.FileSelection;
import domain.enums.Role;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author chanw
 */
public class ManagerMain extends javax.swing.JFrame {
    GymSystem gym = new GymSystem();

    /**
     * Creates new form ManagerMain
     */
    public ManagerMain() throws Exception {
        initComponents();
        refresh();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblIncompleteBookings = new javax.swing.JTable();
        btnDeleteBooking = new javax.swing.JButton();
        managerBookPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbBookingCustomer = new javax.swing.JComboBox<>();
        cmbBookingTrainer = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spinBookingHour = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spinBookingMinute = new javax.swing.JSpinner();
        btnBooking = new javax.swing.JButton();
        spinBookingDuration = new javax.swing.JSpinner();
        cmbBookingDay = new javax.swing.JComboBox<>();
        cmbBookingMonth = new javax.swing.JComboBox<>();
        cmbBookingYear = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRegistration = new javax.swing.JButton();
        btnEditDetails = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnGenerateReport = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbReportMonth = new javax.swing.JComboBox<>();
        cmbReportYear = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager Home");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Incomplete Bookings"));

        tblIncompleteBookings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Customer Name", "Trainer Name", "Booking Date", "Start Time", "End Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIncompleteBookings.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblIncompleteBookings.setName("tblIncompleteBooking"); // NOI18N
        jScrollPane2.setViewportView(tblIncompleteBookings);

        btnDeleteBooking.setText("Delete Selected Booking");
        btnDeleteBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                    .addComponent(btnDeleteBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        managerBookPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Training Booking"));

        jLabel2.setText("Customer:");

        cmbBookingCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name" }));
        cmbBookingCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBookingCustomerActionPerformed(evt);
            }
        });

        cmbBookingTrainer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name" }));

        jLabel3.setText("Trainer:");

        jLabel4.setText("Starting Time :");

        spinBookingHour.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));

        jLabel5.setText("Duration (hours):");

        spinBookingMinute.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 10));

        btnBooking.setText("Book");
        btnBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingActionPerformed(evt);
            }
        });

        spinBookingDuration.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));

        cmbBookingDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbBookingMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cmbBookingMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBookingMonthActionPerformed(evt);
            }
        });

        cmbBookingYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year", "2022" }));

        jLabel6.setText("Date: ");

        javax.swing.GroupLayout managerBookPanelLayout = new javax.swing.GroupLayout(managerBookPanel);
        managerBookPanel.setLayout(managerBookPanelLayout);
        managerBookPanelLayout.setHorizontalGroup(
            managerBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managerBookPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(managerBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(managerBookPanelLayout.createSequentialGroup()
                        .addGroup(managerBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(managerBookPanelLayout.createSequentialGroup()
                                .addGroup(managerBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(managerBookPanelLayout.createSequentialGroup()
                                        .addGroup(managerBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(managerBookPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(36, 36, 36)))
                        .addGroup(managerBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbBookingTrainer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinBookingDuration)
                            .addGroup(managerBookPanelLayout.createSequentialGroup()
                                .addComponent(spinBookingHour, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinBookingMinute))
                            .addGroup(managerBookPanelLayout.createSequentialGroup()
                                .addComponent(cmbBookingDay, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBookingMonth, 0, 139, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBookingYear, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbBookingCustomer, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        managerBookPanelLayout.setVerticalGroup(
            managerBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managerBookPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(managerBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBookingCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(managerBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbBookingTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(managerBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBookingDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBookingMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBookingYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(managerBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinBookingHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinBookingMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(managerBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinBookingDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Navigation"));

        btnRegistration.setText("Registration");
        btnRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrationActionPerformed(evt);
            }
        });

        btnEditDetails.setText("Edit Details");
        btnEditDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDetailsActionPerformed(evt);
            }
        });

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Report Generation"));
        jPanel3.setName(""); // NOI18N

        btnGenerateReport.setText("Generate Report");
        btnGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportActionPerformed(evt);
            }
        });

        jLabel7.setText("Date: ");

        cmbReportMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cmbReportMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbReportMonthActionPerformed(evt);
            }
        });

        cmbReportYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year", "2022" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerateReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(95, 95, 95)
                        .addComponent(cmbReportMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbReportYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbReportMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbReportYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(managerBookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(managerBookPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrationActionPerformed

    private void btnEditDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditDetailsActionPerformed

    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt)  {//GEN-FIRST:event_btnGenerateReportActionPerformed
        // TODO add your handling code here:
        try {
            LocalDateTime date = LocalDateTime.of(Integer.parseInt(String.valueOf(cmbReportYear.getSelectedItem())), cmbReportMonth.getSelectedIndex(), 1, 12, 0);
            gym.getReport().generateReport(date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(FileSelection.MonthlyReport.toString());
                Desktop.getDesktop().open(myFile);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGenerateReportActionPerformed

    private void cmbBookingMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBookingMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBookingMonthActionPerformed

    private void cmbBookingCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBookingCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBookingCustomerActionPerformed

    private void cmbReportMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbReportMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbReportMonthActionPerformed

    private void btnBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingActionPerformed
        // TODO add your handling code here:
        ArrayList<String[]> allCustomer = gym.getCustomer().getAllCustomer();
        ArrayList<String[]> allTrainer = gym.getStaff().getByRole(Role.Trainer);

        try {
            int customerId = -1;
            int trainerId = -1;
            for (String[] i : allCustomer) {
                Customer customerI = gym.getCustomer().getCustomer(i);
                if (customerI.getFullName().equals(cmbBookingCustomer.getSelectedItem().toString())) {
                    if (customerI.getBookingId() != -1) throw new Exception("Customer already has an active booking!");
                    customerId = customerI.getId();
                    break;
                }
            }

            for (String[] j : allTrainer) {
                Staff trainerJ = gym.getStaff().getStaff(j);
                if (trainerJ.getFullName().equals(cmbBookingTrainer.getSelectedItem().toString())) {
                    trainerId = trainerJ.getId();
                    break;
                }
            }

            if (customerId == -1) throw new Exception("Customer not found!");
            if (trainerId == -1) throw new Exception("Trainer not found!");
            LocalDateTime startTime = LocalDateTime.of(
                    Integer.parseInt(cmbBookingYear.getSelectedItem().toString()),
                    cmbBookingMonth.getSelectedIndex(),
                    Integer.parseInt(cmbBookingDay.getSelectedItem().toString()),
                    Integer.parseInt(spinBookingHour.getValue().toString()),
                    Integer.parseInt(spinBookingMinute.getValue().toString())
            );
            LocalDateTime endTime = startTime.plusHours(Integer.parseInt(spinBookingDuration.getValue().toString()));

            Booking newBooking = new Booking(
                    gym.getBooking().generateId(),
                    customerId,
                    trainerId,
                    LocalDateTime.now(),
                    startTime,
                    endTime,
                    40 * Integer.parseInt(spinBookingDuration.getValue().toString()),
                    false,
                    false,
                    "null"
            );

            int status = gym.getBooking().createBooking(newBooking);

            if (status == 0) {
                Customer customer = gym.getCustomer().getById(customerId);
                customer.setBookingId(newBooking.getId());
                gym.getCustomer().modifyCustomer(customer);
                JOptionPane.showMessageDialog(null, "Booking successfully created!", "Info", JOptionPane.INFORMATION_MESSAGE);
                refresh();
            } else throw new Exception("Booking was not created!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBookingActionPerformed

    private void btnDeleteBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBookingActionPerformed
        // TODO add your handling code here:
        int bookingId = Integer.parseInt(tblIncompleteBookings.getValueAt(tblIncompleteBookings.getSelectedRow(), 0).toString());

        try {
            Booking booking = gym.getBooking().getById(bookingId);
            int status = gym.getBooking().deleteBooking(booking);

            if (status == 0) {
                Customer customer = gym.getCustomer().getById(booking.getCustomerId());
                customer.setBookingId(-1);
                gym.getCustomer().modifyCustomer(customer);
                refresh();
                JOptionPane.showMessageDialog(null, "Booking successfully deleted!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            else throw new Exception("Booking was not deleted.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteBookingActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new LoginFrame().setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    public void clear() {
        DefaultTableModel tblModel = (DefaultTableModel) tblIncompleteBookings.getModel();

        try {
            while (tblIncompleteBookings.getRowCount() > 0) {
                tblModel.removeRow(0);
            }

            if (cmbBookingCustomer.getItemCount() > 1) {
                cmbBookingCustomer.removeAllItems();
                cmbBookingCustomer.addItem("Name");
            }

            if (cmbBookingTrainer.getItemCount() > 1) {
                cmbBookingTrainer.removeAllItems();
                cmbBookingTrainer.addItem("Name");
            }

            if (cmbBookingYear.getItemCount() > 2) {
                cmbBookingYear.removeAllItems();
                cmbBookingYear.addItem("Year");
                cmbBookingYear.addItem("2022");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refresh() {
        DefaultTableModel tblModel = (DefaultTableModel) tblIncompleteBookings.getModel();
        DefaultComboBoxModel cmbBookingCustomerModel = (DefaultComboBoxModel) cmbBookingCustomer.getModel();
        DefaultComboBoxModel cmbBookingTrainerModel = (DefaultComboBoxModel) cmbBookingTrainer.getModel();
        DefaultComboBoxModel cmbBookingYearModel = (DefaultComboBoxModel) cmbBookingYear.getModel();
        ArrayList<String[]> allCustomer = gym.getCustomer().getAllCustomer();
        ArrayList<String[]> allTrainer = gym.getStaff().getByRole(Role.Trainer);

        try {
            ArrayList<String[]> allIncompleteBooking = gym.getBooking().getIncomplete();
            clear();

            for (String[] i : allIncompleteBooking) {
                Booking bookingI = gym.getBooking().getBooking(i);
                Customer customerI = gym.getCustomer().getById(Integer.parseInt(i[1]));
                Staff trainerI = gym.getStaff().getById(Integer.parseInt(i[2]));
                String[] row = {
                        i[0],
                        customerI.getFullName(),
                        trainerI.getFullName(),
                        bookingI.getStartTime().toLocalDate().toString(),
                        bookingI.getStartTime().toLocalTime().toString(),
                        bookingI.getEndTime().toLocalTime().toString()
                };
                tblModel.addRow(row);
            }

            ArrayList<String> customerFullName = new ArrayList<>();
            for (String[] j : allCustomer) {
                Customer customerJ = gym.getCustomer().getCustomer(j);
                customerFullName.add(customerJ.getFullName());
            }
            cmbBookingCustomerModel.addAll(customerFullName);

            ArrayList<String> trainerFullName = new ArrayList<>();
            for (String[] k : allTrainer) {
                Staff trainerK = gym.getStaff().getStaff(k);
                trainerFullName.add(trainerK.getFullName());
            }
            cmbBookingTrainerModel.addAll(trainerFullName);

            ArrayList<Integer> bookingYear = new ArrayList<>();
            for (String[] l : allIncompleteBooking) {
                Booking bookingL = gym.getBooking().getBooking(l);
                if (bookingL.getStartTime().getYear() == Integer.parseInt(cmbBookingYearModel.getElementAt(1).toString()))
                    continue;
                if ((bookingYear.size() == 0) || (bookingYear.get(bookingYear.size() - 1) != bookingL.getStartTime().getYear())) {
                    bookingYear.add(bookingL.getStartTime().getYear());
                }
            }
            cmbBookingYearModel.addAll(bookingYear);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(ManagerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManagerMain().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBooking;
    private javax.swing.JButton btnDeleteBooking;
    private javax.swing.JButton btnEditDetails;
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnRegistration;
    private javax.swing.JComboBox<String> cmbBookingCustomer;
    private javax.swing.JComboBox<String> cmbBookingDay;
    private javax.swing.JComboBox<String> cmbBookingMonth;
    private javax.swing.JComboBox<String> cmbBookingTrainer;
    private javax.swing.JComboBox<String> cmbBookingYear;
    private javax.swing.JComboBox<String> cmbReportMonth;
    private javax.swing.JComboBox<String> cmbReportYear;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel managerBookPanel;
    private javax.swing.JSpinner spinBookingDuration;
    private javax.swing.JSpinner spinBookingHour;
    private javax.swing.JSpinner spinBookingMinute;
    private javax.swing.JTable tblIncompleteBookings;
    // End of variables declaration//GEN-END:variables
}
