/*
 *  Copyright Peadar Grant.
 *  All rights reserved.
 */

package com.peadargrant.filecheckweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Peadar Grant
 */
@Controller
@RequestMapping("/")
public class IndexController {
    
    @RequestMapping(method=RequestMethod.GET)
    public String displayIndex()
    {
        return "index";
    }
    
}
