/*
 *  Copyright Peadar Grant.
 *  All rights reserved.
 */

package com.peadargrant.filecheckweb.controllers;

import com.peadargrant.filecheck.assignments.Assignments;
import com.peadargrant.filecheck.gui.AssignmentsProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Peadar Grant
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    
    public static final String assignmentsUrl = "http://grantp.comp.dkit.ie/filecheck/assignments/assignments.xml";
    
    @RequestMapping(method = RequestMethod.GET)
    public String checkForm(
            @RequestParam(required=false) String preselect, 
            ModelMap model
    ) throws Exception
    {
        AssignmentsProvider assignmentsProvider = new AssignmentsProvider();
        Assignments assignments = assignmentsProvider.customLibrary(assignmentsUrl);
        model.addAttribute("assignments", assignments.getAssignment());
        model.addAttribute("preselect", preselect);
        
        // Check form
        return "checkForm";
    }
    
}
