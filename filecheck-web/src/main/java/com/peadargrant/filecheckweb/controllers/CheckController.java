/*
 *  Copyright Peadar Grant.
 *  All rights reserved.
 */
package com.peadargrant.filecheckweb.controllers;

import com.peadargrant.filecheck.core.assignments.Assignment;
import com.peadargrant.filecheck.core.assignments.Assignments;
import com.peadargrant.filecheck.core.checker.Checker;
import com.peadargrant.filecheck.core.checker.Outcome;
import com.peadargrant.filecheck.core.provider.AssignmentsProvider;
import com.peadargrant.filecheck.core.resultmodels.ReportTableModel;
import com.peadargrant.filecheck.core.resultmodels.SummaryTableModel;
import com.peadargrant.filecheckweb.reports.WebTableTransformer;
import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Peadar Grant
 */
@Controller
@RequestMapping("/check")
public class CheckController {

    public static final String assignmentsUrl = "http://grantp.comp.dkit.ie/filecheck/assignments/assignments.xml";

    @RequestMapping(method = RequestMethod.POST)
    public String performCheck(
            @RequestParam("assignment") String assignmentCode,
            @RequestParam("file") MultipartFile file,
            ModelMap model
    ) throws Exception {
        // bail out if the file is empty
        if (file.isEmpty()) {
            return "emptyFile";
        }

        // input stream from file 
        byte[] bytes = file.getBytes();
        String name = file.getOriginalFilename();

        // write to temp dir
        String filePath = System.getProperty("java.io.tmpdir")+"/"+name;
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
        stream.write(bytes);
        stream.close();
        
        // load file
        File inputFile = new File(filePath); 
        
        // get assignment
        Assignment assignment = this.getAssignmentForCode(assignmentCode);
        if ( assignment==null )
        {
            return "assignmentNotFound";
        }

        // GUI report table model
        SummaryTableModel summaryTableModel = new SummaryTableModel();
        ReportTableModel reportTableModel = new ReportTableModel(summaryTableModel); 
        
        // checker
        Checker checker = new Checker();
        checker.setReport(reportTableModel);
        checker.runChecks(inputFile, assignment);
        
        // details for output
        model.addAttribute("fileName", name);
        model.addAttribute("assignmentName", assignment.getTitle());
        
        // final outcome
        model.addAttribute("outcome",summaryTableModel.getFinalOutcome());
        Color finalOutcomeColor = summaryTableModel.getFinalOutcome().getSaturatedColor();
        model.addAttribute("colourr", finalOutcomeColor.getRed());
        model.addAttribute("colourg", finalOutcomeColor.getGreen());
        model.addAttribute("colourb", finalOutcomeColor.getBlue());
        
        // transformer for parsing tables
        WebTableTransformer transformer = new WebTableTransformer();
        
        // summary table headings
        List<String> summaryColumns = transformer.getColumnHeaders(summaryTableModel);
        model.addAttribute("summaryColumns", summaryColumns);
        
        // summary table
        ArrayList<HashMap<String,Integer>> summary = new ArrayList<>();
        for ( int k = 0; k < summaryTableModel.getRowCount() ; k++ )
        {
            HashMap summaryItem = new HashMap<>();
            summaryItem.put("outcome", summaryTableModel.getValueAt(k, 0));
            summaryItem.put("count", summaryTableModel.getValueAt(k, 1));
            Color colorForOutcome = ((Outcome) summaryTableModel.getValueAt(k, 0)).getColor();
            summaryItem.put("colourr", colorForOutcome.getRed());
            summaryItem.put("colourg", colorForOutcome.getGreen());
            summaryItem.put("colourb", colorForOutcome.getBlue());
            summary.add(summaryItem);
        }
        model.addAttribute("summary", summary);
        
        // detail table headings
        List<String> detailColumns = transformer.getColumnHeaders(reportTableModel);
        model.addAttribute("detailColumns", detailColumns);
        
        // detail report table
        ArrayList<HashMap<String,Integer>> detail = new ArrayList<>();
        for ( int k = 0; k < reportTableModel.getRowCount() ; k++ )
        {
            HashMap detailItem = new HashMap<>();
            detailItem.put("path", reportTableModel.getValueAt(k, 0));
            detailItem.put("description", reportTableModel.getValueAt(k, 1));
            detailItem.put("result", reportTableModel.getValueAt(k, 2));
            detailItem.put("outcome", reportTableModel.getValueAt(k, 3));
            Color colorForOutcome = ((Outcome) reportTableModel.getValueAt(k, 3)).getColor();
            detailItem.put("colourr", colorForOutcome.getRed());
            detailItem.put("colourg", colorForOutcome.getGreen());
            detailItem.put("colourb", colorForOutcome.getBlue());
            detail.add(detailItem);
        }
        model.addAttribute("detail", detail);
        
        // delete the uploaded file
        inputFile.delete();

        // Return results display
        return "checkResults";
    }
    
    private Assignment getAssignmentForCode(String code) throws Exception
    {
        AssignmentsProvider assignmentsProvider = new AssignmentsProvider();
        Assignments assignments = assignmentsProvider.customLibrary(UploadController.assignmentsUrl);
        List<Assignment> assignmentList = assignments.getAssignment();
        for ( Assignment assignment : assignmentList )
        {
            if ( assignment.getCode().equals(code) )
            {
                return assignment;
            }
        }
        return null;
    }
}
