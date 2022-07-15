package com.sgp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgp.model.Patient;
import com.sgp.repository.PatientsRepository;

@Controller

public class PatientsController {
	@Autowired
	private PatientsRepository patientsRepository;

    @GetMapping(value = "/patient/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model, 
    		@RequestParam(name = "size", defaultValue = "5") int size,
    		@RequestParam(name = "keyword", defaultValue = "") String keyword) {
		Page<Patient> page=patientsRepository.findByNomContains(keyword, PageRequest.of(pageNumber, size));
		List<Patient> patientList=patientsRepository.findAll();

		
        int current = page.getNumber() +1;
        int begin = Math.max(1, current - 10);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("page", page);
		 model.addAttribute("list", patientList); 

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "patient/list";

    }	
    
	
    @GetMapping("/patient/add")
    public String add(Model model) {

        model.addAttribute("patient", new Patient());
        return "patient/form"; 
        } 

	
    @PostMapping(value = "patient/save")
    public String save(Patient patient, final RedirectAttributes ra) {

        @SuppressWarnings("unused")
        Patient save = patientsRepository.save(patient);
        ra.addFlashAttribute("successFlash", "Patient save avec succées.");
        return "redirect:/patient/1";

    }
    
 
	
	@GetMapping("/patient/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("patient", patientsRepository.getById(id));
        return "patient/edit"; 
		
		
	} 
	
	@PutMapping("/patient/update")
	public String updatePatient(
			@ModelAttribute("patient") Patient patient,
			Model model) {
		patientsRepository.save(patient);
		return "redirect:/patient/update";		
	}
	
	
	@GetMapping("/patient/delete/{id}")
	public String deletePatients(@PathVariable Long id) {
		patientsRepository.deleteById(id);
		return "redirect:/patient/1";
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
