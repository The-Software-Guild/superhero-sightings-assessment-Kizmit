/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.superherosightings.controllers;

import com.jdm.superherosightings.dao.SightingDao;
import com.jdm.superherosightings.entities.Power;
import com.jdm.superherosightings.entities.SuperPerson;
import com.jdm.superherosightings.service.ServiceLayer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */

@Controller
public class VillainController {
    @Autowired
    ServiceLayer service;
    
    @Autowired 
    SightingDao sightingDao;
    
    Set<ConstraintViolation<SuperPerson>> violations = new HashSet<>();
    
    @GetMapping("villains")
    public String displayVillains(Model model){
        model.addAttribute("errors", violations);
        List<SuperPerson> villains = service.getVillains();
        model.addAttribute("villains", villains);
        model.addAttribute("powers", service.getPowers());
        model.addAttribute("organizations", service.getOrganizations());
        return "villains";
    }

    @PostMapping("addVillain")
    public String addVillain(HttpServletRequest request){
        violations.clear();
        SuperPerson villain = service.createSuperPerson(request, true);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(villain);

        if(violations.isEmpty()) {
            service.addSuperPerson(villain);
        }
        return "redirect:/villains";
    }
    
    @GetMapping("deleteVillain")
    public String deleteVillain(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteSuperPersonById(id);
        return "redirect:/villains";
    }
    
    @GetMapping("editVillain")
    public String editVillain(HttpServletRequest request, Model model) {
        violations.clear();
        model.addAttribute("errors", violations);
        int id = Integer.parseInt(request.getParameter("id"));
        SuperPerson villain = service.getSuperPersonById(id);

        model.addAttribute("villain", villain);
        return "editVillain";
    }

    @PostMapping("editVillain")
    public String performEditVillain(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        SuperPerson villain = service.getSuperPersonById(id);
        villain = service.editSuperPerson(villain, request);
        
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(villain);
        
        if(violations.isEmpty()){
            service.updateSuperPerson(villain);
        }
        return "redirect:/villains";
    }    
    
}
