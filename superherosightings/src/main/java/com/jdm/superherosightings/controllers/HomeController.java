/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.superherosightings.controllers;

import com.jdm.superherosightings.dao.SightingDao;
import com.jdm.superherosightings.entities.Sighting;
import com.jdm.superherosightings.service.ServiceLayer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
@Controller
public class HomeController {
    @Autowired
    ServiceLayer service;
    
    @Autowired 
    SightingDao sightingDao;
    
    Set<ConstraintViolation<Sighting>> violations = new HashSet<>();
    
    @GetMapping("home")
    public String displayHome(Model model){
        model.addAttribute("errors", violations);
        List<Sighting> sightings = service.getSightingsPreview();
        model.addAttribute("sightings", sightings);
        return "home";
    }
}
