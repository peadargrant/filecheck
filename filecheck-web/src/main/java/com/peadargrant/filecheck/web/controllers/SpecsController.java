package com.peadargrant.filecheck.web.controllers;

import com.peadargrant.filecheck.core.assignments.Assignment;
import com.peadargrant.filecheck.core.assignments.Assignments;
import com.peadargrant.filecheck.core.assignments.Check;
import com.peadargrant.filecheck.core.assignments.Content;
import com.peadargrant.filecheck.core.assignments.Pattern;
import com.peadargrant.filecheck.core.checker.CheckImplementation;
import com.peadargrant.filecheck.core.checker.CheckProvider;
import com.peadargrant.filecheck.core.provider.AssignmentsProvider;
import com.peadargrant.filecheck.web.support.ServerEnvironment;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Copyright (C) 2015 Peadar Grant
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
/**
 *
 * @author Peadar Grant
 */
@Controller
@RequestMapping("/specs")
public class SpecsController {
    
    @Autowired private ServerEnvironment serverEnvironment;
    
    @Autowired private HttpServletRequest request;
    
    @RequestMapping(method=RequestMethod.GET)
    public String showSpecs (
            @RequestParam(value="assignment", required=true) String assignmentCode,
            ModelMap model
    ) throws Exception {
        
        model.addAttribute("assignmentsUrl", serverEnvironment.getPropertyAsString("assignmentsUrl"));
        
        Assignment assignment = getAssignmentForCode(assignmentCode);
        model.addAttribute(assignment);
        
        CheckProvider checkProvider = new CheckProvider();
        HashMap<Check,CheckImplementation> checkDetails = new HashMap<>();
        for ( Content content : assignment.getContent() ) {
            for ( Check check : content.getCheck() ) {
                checkDetails.put(check, checkProvider.getImplementationForCheck(check));
            }
        }
        for ( Pattern pattern : assignment.getPattern()) {
            for ( Check check : pattern.getCheck() ) {
                checkDetails.put(check, checkProvider.getImplementationForCheck(check));
            }
        }
        model.addAttribute("checkDetails", checkDetails);
        
        return "specs";
    }
    
    private Assignment getAssignmentForCode(String code) throws Exception
    {
        String assignmentsUrl = serverEnvironment.getPropertyAsString("assignmentsUrl");
        
        AssignmentsProvider assignmentsProvider = new AssignmentsProvider();
        Assignments assignments = assignmentsProvider.customLibrary(assignmentsUrl);
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
