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

import com.sgp.model.Bilan;
import com.sgp.repository.BilanRepository;
@Controller
public class BilanController {
	
	
	
	
	
	
	
	
	
	
@Autowired
	
	private BilanRepository bilanRepository;
		
		   @GetMapping(value = "/bilan/list")
		    public String list( Model model) {
			
				List<Bilan> bilanList=bilanRepository.findAll();
		       
				 model.addAttribute("list", bilanList); 

		    
		        return "dossierMedical/listbilan";

		    }
		   @GetMapping("/Bilan/add")
		    public String add(Model model) {

		        model.addAttribute("bilan", new Bilan());
		        return "dossierMedical/bilan"; 
		        } 
		    @PostMapping(value = "/bilan/save")
		    public String save( Bilan bilan, final RedirectAttributes ra) {

		        @SuppressWarnings("unused")
		    Bilan save = bilanRepository.save(bilan);
		        ra.addFlashAttribute("successFlash", "Bilan ajouter avec succés.");
		        return "redirect:/bilan/list";

		    }
		    
			@GetMapping("/bilan/edit/{id}")
			public String edit(@PathVariable Long id, Model model) {
				model.addAttribute("bilan", bilanRepository.getById(id));
				return "dossierMedical/editBilan";
				
				
			} 

		@PutMapping("/bilan/update")
		public String updatebilan(
				@ModelAttribute("bilan") Bilan bilan,
				Model model) {
			bilanRepository.save(bilan);
			return "redirect:/bilan";		
		}
		
		
		@GetMapping("/bilan/delete/{id}")
		public String deletebilan(@PathVariable Long id) {
			bilanRepository.deleteById(id);
			return "redirect:/bilan/1";
		
		
		}

}
