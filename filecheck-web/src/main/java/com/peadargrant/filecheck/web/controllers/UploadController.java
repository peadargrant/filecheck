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
package com.peadargrant.filecheck.web.controllers;

import com.peadargrant.filecheck.core.assignments.Assignments;
import com.peadargrant.filecheck.core.provider.AssignmentsProvider;
import com.peadargrant.filecheck.web.support.ServerEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/")
public class UploadController {
    
    @Autowired private ServerEnvironment serverEnvironment;
    
    @RequestMapping(method = RequestMethod.GET)
    public String checkForm(
            @RequestParam(required=false) String preselect, 
            ModelMap model
    ) throws Exception
    {
        String assignmentsUrl = serverEnvironment.getPropertyAsString("assignmentsUrl");
        model.addAttribute("assignmentsUrl", assignmentsUrl);
        
        AssignmentsProvider assignmentsProvider = new AssignmentsProvider();
        Assignments assignments = assignmentsProvider.customLibrary(assignmentsUrl);
        
        model.addAttribute("assignments", assignments.getAssignment());
        model.addAttribute("preselect", preselect);
        
        // Check form
        return "checkForm";
    }
    
}
