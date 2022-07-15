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
import com.sgp.model.DossierMedical;
import com.sgp.model.Irm;
import com.sgp.repository.DossierMedicalRepository;
import com.sgp.repository.IrmRepository;

@Controller

public class IrmController {
	
@Autowired
	
	private IrmRepository irmRepository;
@Autowired
DossierMedicalRepository dossierMedicalRepository;
@GetMapping(value = "/irm/list")
public String list(Model model) {
	
	List<Irm> irmList=irmRepository.findAll();
	
	 model.addAttribute("list", irmList); 
	
    return "dossierMedical/listIrm";

}
		   @GetMapping("/irm/add/{id}")
		   public String add(Model model) {
				List<DossierMedical> dList = dossierMedicalRepository.findAll();
				System.out.println(dList);
				
					model.addAttribute("dList",dList);

		        model.addAttribute("irm", new Irm());
		        return "dossierMedical/irm"; 
		   }
		    
		    
		    @PostMapping(value = "/irm/save")
		    public String save(Irm irm, final RedirectAttributes ra) {

		        @SuppressWarnings("unused")
		    Irm save =  irmRepository.save(irm);
		        ra.addFlashAttribute("successFlash", "Bilan ajouter avec succés.");
		        return "redirect:/irm/list";

		    }
			@GetMapping("/irm/edit/{id}")
			public String edit(@PathVariable Long id, Model model) {
				model.addAttribute("irm", irmRepository.getById(id));
				return "redirect:/irm";
				
				
			} 

		@PutMapping("/irm/update")
		public String updateirm(
				@ModelAttribute("irm") Irm irm,
				Model model) {
			irmRepository.save(irm);
			return "redirect:/irm";		
		}
		
		
		@GetMapping("/irm/delete/{id}")
		public String deleteirm(@PathVariable Long id) {
			irmRepository.deleteById(id);
			return "redirect:/irm/1";
		
		
		}

}

