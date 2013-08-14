/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import guiservices.HtmlTableRenderer;
import guiservices.MessageProvider;
import checker.Checker;
import guiservices.PlatformSetup;
import guiservices.Website;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class FileCheckGui extends javax.swing.JFrame {
    
    private AssignmentsModel assignmentsModel; 
    private ReportTableModel reportTableModel; 
    private Checker checker;
    private File selectedFile; 
    private SummaryTableModel summaryTableModel; 

    /**
     * Creates new form FileCheckGUI
     */
    public FileCheckGui() {
        
        initComponents();
        
        // Set up the assignments listing 
        this.assignmentsModel = new AssignmentsModel(); 
        this.assignmentsTable.setModel(assignmentsModel);
        this.refreshAssignmentsList();
        
        // Set up the summary table model
        this.summaryTableModel = new SummaryTableModel(); 
        this.summaryTable.setModel(summaryTableModel);
        
        // Set up the report
        this.reportTableModel = new ReportTableModel(summaryTableModel); 
        this.reportTable.setModel(reportTableModel);
        this.reportTableModel.clear();
        
        // Set up the checker
        this.checker = new Checker(); 
        this.checker.setReport(reportTableModel);
        
        // Do platform-specific GUI setup
        PlatformSetup.detectAndSetupPlatform("FileCheck");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openFileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        assignmentsTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        reportTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        summaryTable = new javax.swing.JTable();
        runChecksToolbarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        openFileToolbarButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        loadAssignmentsMenuItem = new javax.swing.JMenu();
        refreshAssignmentsMenuItem = new javax.swing.JMenuItem();
        openFileMenuItem = new javax.swing.JMenuItem();
        runChecksMenuItem = new javax.swing.JMenuItem();
        clearOutputMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        copySummaryButton = new javax.swing.JMenuItem();
        copyDetailedReportButton = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        visitDeveloperWebsiteMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FileCheck");

        assignmentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        assignmentsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(assignmentsTable);

        reportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(reportTable);

        summaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(summaryTable);

        runChecksToolbarButton.setText("Run Checks");
        runChecksToolbarButton.setFocusable(false);
        runChecksToolbarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        runChecksToolbarButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        runChecksToolbarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runChecksToolbarButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabel1.setText("1. Choose assignment");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabel2.setText("3. Run checks");

        openFileToolbarButton.setText("Select file...");
        openFileToolbarButton.setFocusable(false);
        openFileToolbarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openFileToolbarButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        openFileToolbarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileToolbarButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabel3.setText("2. Select file");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabel4.setText("Detailed report");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabel5.setText("Test outcome");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabel6.setText("Summary report");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setOpaque(true);

        loadAssignmentsMenuItem.setText("File");

        refreshAssignmentsMenuItem.setText("Refresh assignments list");
        refreshAssignmentsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshAssignmentsMenuItemActionPerformed(evt);
            }
        });
        loadAssignmentsMenuItem.add(refreshAssignmentsMenuItem);

        openFileMenuItem.setText("Open JAR/ZIP file");
        openFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileMenuItemActionPerformed(evt);
            }
        });
        loadAssignmentsMenuItem.add(openFileMenuItem);

        runChecksMenuItem.setText("Run checks");
        runChecksMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runChecksMenuItemActionPerformed(evt);
            }
        });
        loadAssignmentsMenuItem.add(runChecksMenuItem);

        clearOutputMenuItem.setText("Clear output display");
        clearOutputMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearOutputMenuItemActionPerformed(evt);
            }
        });
        loadAssignmentsMenuItem.add(clearOutputMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        loadAssignmentsMenuItem.add(exitMenuItem);

        jMenuBar1.add(loadAssignmentsMenuItem);

        jMenu2.setText("Edit");

        copySummaryButton.setText("Copy summary to clipboard");
        copySummaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copySummaryButtonActionPerformed(evt);
            }
        });
        jMenu2.add(copySummaryButton);

        copyDetailedReportButton.setText("Copy detailed report to clipboard");
        copyDetailedReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyDetailedReportButtonActionPerformed(evt);
            }
        });
        jMenu2.add(copyDetailedReportButton);

        jMenuBar1.add(jMenu2);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        visitDeveloperWebsiteMenuItem.setText("Visit developer website");
        visitDeveloperWebsiteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitDeveloperWebsiteMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(visitDeveloperWebsiteMenuItem);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, runChecksToolbarButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, openFileToolbarButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(openFileToolbarButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(runChecksToolbarButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshAssignmentsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshAssignmentsMenuItemActionPerformed
        this.refreshAssignmentsList();
    }//GEN-LAST:event_refreshAssignmentsMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        MessageProvider.showAbout();
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void openFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileMenuItemActionPerformed
        this.openFile(); 
    }//GEN-LAST:event_openFileMenuItemActionPerformed

    private void runChecksMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runChecksMenuItemActionPerformed
        this.runChecker();
    }//GEN-LAST:event_runChecksMenuItemActionPerformed

    private void clearOutputMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearOutputMenuItemActionPerformed
        this.clearOutput();
    }//GEN-LAST:event_clearOutputMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openFileToolbarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileToolbarButtonActionPerformed
        this.openFile();
    }//GEN-LAST:event_openFileToolbarButtonActionPerformed

    private void runChecksToolbarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runChecksToolbarButtonActionPerformed
        this.runChecker();
    }//GEN-LAST:event_runChecksToolbarButtonActionPerformed

    private void visitDeveloperWebsiteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitDeveloperWebsiteMenuItemActionPerformed
        try
        {
            Website.visitDeveloperWebsite();
        } catch ( Exception e )
        {
            MessageProvider.showException(e);
        }
    }//GEN-LAST:event_visitDeveloperWebsiteMenuItemActionPerformed

    private void copySummaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copySummaryButtonActionPerformed
        
        try
        {
            HtmlTableRenderer htr = new HtmlTableRenderer();
            htr.copyTableToClipboard(summaryTableModel);
        } 
        catch (Exception e )
        {
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_copySummaryButtonActionPerformed

    private void copyDetailedReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyDetailedReportButtonActionPerformed
        
        try
        {
            HtmlTableRenderer htr = new HtmlTableRenderer();
            htr.copyTableToClipboard(reportTableModel);
        } 
        catch (Exception e )
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_copyDetailedReportButtonActionPerformed

    /**
     * Manually clear the report table
     */
    private void clearOutput()
    {
        this.reportTableModel.clear();
        this.jLabel7.setText("");
    }
    
    /**
     * Opens JAR/ZIP file by Swing box
     */
    private void openFile()
    {
        int returnVal = this.openFileChooser.showOpenDialog(this);
        
        if ( JFileChooser.APPROVE_OPTION == returnVal )
        {
            this.selectedFile = this.openFileChooser.getSelectedFile(); 
            
            this.openFileToolbarButton.setText("Selected file: " + this.selectedFile.getName());
        }
        
    }
    
    /**
     * Refreshes the assignments list
     */
    private void refreshAssignmentsList()
    {
        AssignmentsLoader al = new AssignmentsLoader( this.assignmentsModel );
        al.execute();
    }
    
    private void runChecker()
    {
        try {
            
            if ( ( this.assignmentsTable.getSelectedRowCount() == 1 ) && ( this.selectedFile != null ) )
            {
                this.jLabel7.setText("");
                CheckRunner cr = new CheckRunner(); 
                cr.setAssignment( this.assignmentsModel.getAssignmentAtIndex( this.assignmentsTable.getSelectedRow() ) );
                cr.setChecker(this.checker);
                cr.setFile(selectedFile);
                cr.setReportTableModel(reportTableModel);
                cr.setOutcomeDisplay(jLabel7);
                cr.execute();
                
            }
            else
            {
                MessageProvider.showWarning("Selection error", "Select an assignment and file and try again.");
            }
            
            
        }
        catch (Exception e)
        {
            MessageProvider.showException(e);
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
            java.util.logging.Logger.getLogger(FileCheckGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileCheckGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileCheckGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileCheckGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileCheckGui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JTable assignmentsTable;
    private javax.swing.JMenuItem clearOutputMenuItem;
    private javax.swing.JMenuItem copyDetailedReportButton;
    private javax.swing.JMenuItem copySummaryButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu loadAssignmentsMenuItem;
    private javax.swing.JFileChooser openFileChooser;
    private javax.swing.JMenuItem openFileMenuItem;
    private javax.swing.JButton openFileToolbarButton;
    private javax.swing.JMenuItem refreshAssignmentsMenuItem;
    private javax.swing.JTable reportTable;
    private javax.swing.JMenuItem runChecksMenuItem;
    private javax.swing.JButton runChecksToolbarButton;
    private javax.swing.JTable summaryTable;
    private javax.swing.JMenuItem visitDeveloperWebsiteMenuItem;
    // End of variables declaration//GEN-END:variables
}
