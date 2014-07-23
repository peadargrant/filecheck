/* 
 * Copyright (C) 2014 Peadar Grant
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.peadargrant.filecheck.app.gui;

import com.peadargrant.filecheck.core.resultmodels.ReportTableModel;
import com.peadargrant.filecheck.core.resultmodels.SummaryTableModel;
import com.peadargrant.filecheck.app.guiservices.HtmlTableRenderer;
import com.peadargrant.filecheck.app.guiservices.MessageProvider;
import com.peadargrant.filecheck.core.checker.Checker;
import com.peadargrant.filecheck.app.guiservices.ClipboardUtils;
import com.peadargrant.filecheck.app.guiservices.VersionProvider;
import com.peadargrant.filecheck.app.guiservices.Website;
import java.awt.Color;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

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
    private ReportCellRenderer reportCellRenderer;
    private ReportCellRenderer summaryCellRenderer;
    private DefaultTableCellRenderer dcr;
    private Boolean testInProgress = false;

    public JLabel getOutcomeDisplay() {
        return outcomeDisplay;
    }

    public ReportTableModel getReportTableModel() {
        return reportTableModel;
    }

    public Checker getChecker() {
        return checker;
    }

    public File getSelectedFile() {
        return selectedFile;
    }
    
    

    /**
     * True if a test is in progress
     * @return 
     */
    public Boolean isTestInProgress() {
        return testInProgress;
    }
    
    /**
     * Set test in progress and update GUI
     * 
     * @param testInProgress true if a test is now in progress
     */
    public void setTestInProgress(Boolean testInProgress) {
        this.testInProgress = testInProgress;
        this.setupRunChecksButton();
    }
    
    
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
        this.summaryCellRenderer = new ReportCellRenderer();
        this.summaryCellRenderer.setTargetColumn(0);
        this.summaryCellRenderer.setTableModel(this.summaryTableModel); 

        
        // Set up the report
        this.reportTableModel = new ReportTableModel(summaryTableModel); 
        this.reportTable.setModel(reportTableModel);
        this.reportTableModel.clear();
        this.reportCellRenderer = new ReportCellRenderer();
        this.reportCellRenderer.setTableModel(this.reportTableModel);
        this.reportCellRenderer.setTargetColumn(3);

        
        // Set up the checker
        this.checker = new Checker(); 
        this.checker.setReport(reportTableModel);
               
        // Default cell renderer
        this.dcr = new DefaultTableCellRenderer(); 
        
        // GUI setup
        this.setupRunChecksButton();
        this.setColourMode();
        
        // Set title using version
        VersionProvider vp = new VersionProvider();
        this.setTitle("FileCheck (" + vp.getBuildVersion() + ")");
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
        savePdfReportFileChooser = new javax.swing.JFileChooser();
        saveHtmlReportFileChooser = new javax.swing.JFileChooser();
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
        outcomeDisplay = new javax.swing.JLabel();
        loadButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        sourceUrl = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        loadAssignmentsMenuItem = new javax.swing.JMenu();
        openFileMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        runChecksMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        saveReportMenuItem = new javax.swing.JMenuItem();
        saveReportAsHtmlMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        copyFullReportMenuItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        copySummaryButton = new javax.swing.JMenuItem();
        copyDetailedReportButton = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        clearOutputMenuItem = new javax.swing.JMenuItem();
        colorDisplaysMenuItem = new javax.swing.JCheckBoxMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        visitDeveloperWebsiteMenuItem = new javax.swing.JMenuItem();

        openFileChooser.setAcceptAllFileFilterUsed(false);
        openFileChooser.setDialogTitle("Select JAR/ZIP file");
        openFileChooser.setFileFilter(new FileNameExtensionFilter("JAR, ZIP, WAR or EAR file","jar","zip","war","ear"));

        savePdfReportFileChooser.setAcceptAllFileFilterUsed(false);
        savePdfReportFileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        savePdfReportFileChooser.setDialogTitle("Save report as...");
        savePdfReportFileChooser.setFileFilter(new FileNameExtensionFilter("PDF documents", "pdf"));

        saveHtmlReportFileChooser.setAcceptAllFileFilterUsed(false);
        saveHtmlReportFileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        saveHtmlReportFileChooser.setDialogTitle("Save report as...");
        saveHtmlReportFileChooser.setFileFilter(new FileNameExtensionFilter("HTML documents", "html"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FileCheck");

        assignmentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        assignmentsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        assignmentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assignmentsTableMouseClicked(evt);
            }
        });
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

        outcomeDisplay.setBackground(new java.awt.Color(0, 0, 0));
        outcomeDisplay.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        outcomeDisplay.setForeground(new java.awt.Color(255, 255, 255));
        outcomeDisplay.setOpaque(true);

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Source URL:");

        sourceUrl.setText("http://grantp.comp.dkit.ie/filecheck/assignments/assignments.xml");
        sourceUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceUrlActionPerformed(evt);
            }
        });

        loadAssignmentsMenuItem.setText("File");

        openFileMenuItem.setText("Open JAR/ZIP file");
        openFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileMenuItemActionPerformed(evt);
            }
        });
        loadAssignmentsMenuItem.add(openFileMenuItem);
        loadAssignmentsMenuItem.add(jSeparator1);

        runChecksMenuItem.setText("Run checks");
        runChecksMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runChecksMenuItemActionPerformed(evt);
            }
        });
        loadAssignmentsMenuItem.add(runChecksMenuItem);
        loadAssignmentsMenuItem.add(jSeparator3);

        saveReportMenuItem.setText("Save report as PDF");
        saveReportMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveReportMenuItemActionPerformed(evt);
            }
        });
        loadAssignmentsMenuItem.add(saveReportMenuItem);

        saveReportAsHtmlMenuItem.setText("Save report as HTML");
        saveReportAsHtmlMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveReportAsHtmlMenuItemActionPerformed(evt);
            }
        });
        loadAssignmentsMenuItem.add(saveReportAsHtmlMenuItem);
        loadAssignmentsMenuItem.add(jSeparator2);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        loadAssignmentsMenuItem.add(exitMenuItem);

        jMenuBar1.add(loadAssignmentsMenuItem);

        jMenu2.setText("Edit");

        copyFullReportMenuItem.setText("Copy full report to clipboard");
        copyFullReportMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyFullReportMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(copyFullReportMenuItem);
        jMenu2.add(jSeparator4);

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

        viewMenu.setText("View");

        clearOutputMenuItem.setText("Clear output display");
        clearOutputMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearOutputMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(clearOutputMenuItem);

        colorDisplaysMenuItem.setSelected(true);
        colorDisplaysMenuItem.setText("Colour displays");
        colorDisplaysMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorDisplaysMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(colorDisplaysMenuItem);

        jMenuBar1.add(viewMenu);

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
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(runChecksToolbarButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(openFileToolbarButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(outcomeDisplay, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                            .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(sourceUrl)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(loadButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(loadButton)
                    .add(jLabel7)
                    .add(sourceUrl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
                        .add(outcomeDisplay, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void assignmentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignmentsTableMouseClicked
        this.setupRunChecksButton();
    }//GEN-LAST:event_assignmentsTableMouseClicked
   
    /**
     * Sets the table cell colouring and outcome display on/off
     */
    private void setColourMode()
    {
        if ( colorDisplaysMenuItem.isSelected() )
        {
            this.summaryTable.setDefaultRenderer(Object.class, this.summaryCellRenderer);
            this.reportTable.setDefaultRenderer(Object.class, this.reportCellRenderer);
            if ( null!=this.summaryTableModel.getFinalOutcome() )
            {
                this.outcomeDisplay.setBackground(this.summaryTableModel.getFinalOutcome().getSaturatedColor());
            }
        }
        else
        {
            this.summaryTable.setDefaultRenderer(Object.class, this.dcr);
            this.reportTable.setDefaultRenderer(Object.class, this.dcr);
            this.outcomeDisplay.setBackground(Color.BLACK); 
        }
        this.summaryTableModel.fireTableDataChanged();
        this.reportTableModel.fireTableDataChanged();
    }
    
    private void colorDisplaysMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorDisplaysMenuItemActionPerformed
        this.setColourMode();
    }//GEN-LAST:event_colorDisplaysMenuItemActionPerformed

    private void copyFullReport()
    {
        try
        {
            HtmlTableRenderer htr = new HtmlTableRenderer();
            
            StringBuilder sb = new StringBuilder(); 
            
            sb.append("<p>FILE PATH: ");
            sb.append(this.selectedFile.getCanonicalPath());
            sb.append( "</p>");
            
            sb.append("<p>CHECK OUTCOME: ");
            sb.append(this.outcomeDisplay.getText());
            sb.append( "</p>");
            
            sb.append( htr.renderTableAsHtml( this.summaryTableModel ));
            
            sb.append( htr.renderTableAsHtml( this.reportTableModel) );
            
            ClipboardUtils.copyHtmlToClipboard(sb.toString());
        }
        catch ( Exception e )
        {
            MessageProvider.showException(e);
        }
        
        
    }
    
    private void copyFullReportMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyFullReportMenuItemActionPerformed
        this.copyFullReport();
    }//GEN-LAST:event_copyFullReportMenuItemActionPerformed

    private JasperPrint generateReport() 
    {
        JasperReport jasperReport;
        JasperPrint jasperPrint = null;
        try
        {
          InputStream reportStream = this.getClass().getResourceAsStream("report.xml");
          jasperReport = JasperCompileManager.compileReport( reportStream  );

          HashMap<String,Object> params = new HashMap<>();
          params.put("file", this.selectedFile);
          params.put("finalOutcome", summaryTableModel.getFinalOutcome() );
          params.put("assignmentTitle", this.reportTableModel.getAssignmentName() );
          String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
          params.put("timeStamp", timeStamp); 
          
          for ( int k = 0; k < this.reportTableModel.getColumnCount() ; k++ )
          {
              params.put("columnName"+k, this.reportTableModel.getColumnName(k));
          }
              
          jasperPrint = JasperFillManager.fillReport(
              jasperReport, params, new JRTableModelDataSource(reportTableModel));
          
          
       }
        catch (JRException e)
        {
          e.printStackTrace();
        }
        
        return jasperPrint;
    }
    
    private File chooseReportDestination(JFileChooser chooser)
    {
        File reportDestination = null;
        int returnVal = chooser.showSaveDialog(this);
        
        if ( JFileChooser.APPROVE_OPTION == returnVal )
        {
            reportDestination = chooser.getSelectedFile(); 
        }
        
        return reportDestination;
    }
    
    private void saveReportToPdf() throws Exception
    {
        JasperExportManager.exportReportToPdfFile(this.generateReport(), this.chooseReportDestination(this.savePdfReportFileChooser).getAbsolutePath()); 
    }
    
    private void saveReportToHtml() throws Exception
    {
        JasperExportManager.exportReportToHtmlFile(this.generateReport(), this.chooseReportDestination(this.saveHtmlReportFileChooser).getAbsolutePath()); 
    }
    
    private void saveReportMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveReportMenuItemActionPerformed
        try
        {
            this.saveReportToPdf();
        }
        catch ( Exception e )
        {
            MessageProvider.showException(e);
        }
    }//GEN-LAST:event_saveReportMenuItemActionPerformed

    private void saveReportAsHtmlMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveReportAsHtmlMenuItemActionPerformed
        try
        {
            this.saveReportToHtml();
        }
        catch ( Exception e )
        {
            MessageProvider.showException(e);
        }
    }//GEN-LAST:event_saveReportAsHtmlMenuItemActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        this.refreshAssignmentsList();
    }//GEN-LAST:event_loadButtonActionPerformed

    private void sourceUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sourceUrlActionPerformed

    /**
     * Decide on whether the run checks button should be enabled
     */
    private void setupRunChecksButton()
    {
        if( ( this.selectedFile==null ) || ( this.assignmentsTable.getSelectedRowCount()!=1 ) || ( this.testInProgress ) )
        {
            this.runChecksMenuItem.setEnabled(false);
            this.runChecksToolbarButton.setEnabled(false);
        }
        else
        {
            this.runChecksMenuItem.setEnabled(true);
            this.runChecksToolbarButton.setEnabled(true); 
        }
    }
    
    /**
     * Manually clear the report table
     */
    private void clearOutput()
    {
        this.reportTableModel.clear();
        this.outcomeDisplay.setText("");
        this.outcomeDisplay.setBackground(Color.BLACK);
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
        
        this.setupRunChecksButton();
        
    }
    
    /**
     * Refreshes the assignments list
     */
    private void refreshAssignmentsList()
    {
        AssignmentsLoader al = new AssignmentsLoader( this.assignmentsModel, sourceUrl.getText() );
        al.execute();
        this.assignmentsTable.requestFocusInWindow();
    }
    
    private void runChecker()
    {
        try {
            
            if ( ( this.assignmentsTable.getSelectedRowCount() == 1 ) && ( this.selectedFile != null ) )
            {
                this.setTestInProgress(true);
                this.outcomeDisplay.setBackground(Color.BLACK);
                this.outcomeDisplay.setText("Running checks...");
                CheckRunner cr = new CheckRunner(); 
                cr.setAssignment( this.assignmentsModel.getAssignmentAtIndex( this.assignmentsTable.getSelectedRow() ) );                cr.setColorEnabled(this.colorDisplaysMenuItem.isSelected());
                cr.setFileCheckGui(this);
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
    private javax.swing.JCheckBoxMenuItem colorDisplaysMenuItem;
    private javax.swing.JMenuItem copyDetailedReportButton;
    private javax.swing.JMenuItem copyFullReportMenuItem;
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
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenu loadAssignmentsMenuItem;
    private javax.swing.JButton loadButton;
    private javax.swing.JFileChooser openFileChooser;
    private javax.swing.JMenuItem openFileMenuItem;
    private javax.swing.JButton openFileToolbarButton;
    private javax.swing.JLabel outcomeDisplay;
    private javax.swing.JTable reportTable;
    private javax.swing.JMenuItem runChecksMenuItem;
    private javax.swing.JButton runChecksToolbarButton;
    private javax.swing.JFileChooser saveHtmlReportFileChooser;
    private javax.swing.JFileChooser savePdfReportFileChooser;
    private javax.swing.JMenuItem saveReportAsHtmlMenuItem;
    private javax.swing.JMenuItem saveReportMenuItem;
    private javax.swing.JTextField sourceUrl;
    private javax.swing.JTable summaryTable;
    private javax.swing.JMenu viewMenu;
    private javax.swing.JMenuItem visitDeveloperWebsiteMenuItem;
    // End of variables declaration//GEN-END:variables
}
