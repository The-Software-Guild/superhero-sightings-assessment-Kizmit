/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.superherosightings.controllers;

import com.jdm.superherosightings.dao.SightingDao;
import com.jdm.superherosightings.entities.Power;

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
public class PowerController {
    @Autowired
    ServiceLayer service;
    
    @Autowired 
    SightingDao sightingDao;
    
    Set<ConstraintViolation<Power>> violations = new HashSet<>();
    
    @GetMapping("powers")
    public String displayPowers(Model model){
        model.addAttribute("errors", violations);
        List<Power> powers = service.getPowers();
        model.addAttribute("powers", powers);
        return "powers";
    }
    

    @PostMapping("addPower")
    public String addPower(HttpServletRequest request){
        violations.clear();
        Power power = service.createPower(request);
        
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(power);

        if(violations.isEmpty()) {
            service.addPower(power);
        }
        return "redirect:/powers";
    }
    
    @GetMapping("deletePower")
    public String deletePower(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        service.deletePowerById(id);
        return "redirect:/powers";
    }
    
    @GetMapping("editPower")
    public String editPower(HttpServletRequest request, Model model) {
        model.addAttribute("errors", violations);
        
        int id = Integer.parseInt(request.getParameter("id"));
        Power power = service.getPowerById(id);

        model.addAttribute("power", power);
        return "editPower";
    }

    @PostMapping("editPower")
    public String performEditPower(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Power power = service.getPowerById(id);
        power = service.editPower(power, request);
        
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(power);
        
        if(violations.isEmpty()){
            service.updatePower(power);
        }
        return "redirect:/powers";
    }    
}
