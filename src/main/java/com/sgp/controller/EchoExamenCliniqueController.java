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

import com.sgp.model.DossierMedical;
import com.sgp.model.EchoExamenClinique;
import com.sgp.repository.DossierMedicalRepository;
import com.sgp.repository.EchoExamenCliniqueRepository;


@Controller
public class EchoExamenCliniqueController {
	@Autowired
	
private EchoExamenCliniqueRepository echoExamenCliniqueRepository;
	@Autowired
	DossierMedicalRepository dossierMedicalRepository;
	   @GetMapping(value = "/echoExamenClinique/{pageNumber}")
	    public String list(@PathVariable Integer pageNumber, Model model, @RequestParam(name = "keyWord", defaultValue = "") String kw) {
			Page<EchoExamenClinique> page=echoExamenCliniqueRepository.findByechoCardiaque(kw, PageRequest.of(pageNumber, 10));
			List<EchoExamenClinique> echoExamenCliniqueList=echoExamenCliniqueRepository.findAll();
	        int current = page.getNumber() +1;
	        int begin = Math.max(1, current - 10);
	        int end = Math.min(begin + 10, page.getTotalPages());

	        model.addAttribute("page", page);
			 model.addAttribute("list",echoExamenCliniqueList); 

	        model.addAttribute("beginIndex", begin);
	        model.addAttribute("endIndex", end);
	        model.addAttribute("currentIndex", current);

	        return "dossierMedical/listecho";

	    }
	   @GetMapping("/echoExamenClinique/add")
	   public String add(Model model) {
			List<DossierMedical> dList = dossierMedicalRepository.findAll();
			System.out.println(dList);
			
				model.addAttribute("dList",dList);
	        model.addAttribute("echoExamenClinique", new EchoExamenClinique());
	        return "dossierMedical/echo"; 
	        } 

	    @PostMapping(value = "echoExamenClinique/save")
	    public String save(EchoExamenClinique echoExamenClinique, final RedirectAttributes ra) {

	        @SuppressWarnings("unused")
	        EchoExamenClinique save = echoExamenCliniqueRepository.save(echoExamenClinique);
	        ra.addFlashAttribute("successFlash", "EchoExamenClinique ajouter avec succés.");
	        return "redirect:/echoExamenClinique/1";

	    }
	    
		@GetMapping("/echoExamenClinique/edit/{id}")
		public String edit(@PathVariable Long id, Model model) {
			model.addAttribute("echoExamenClinique", echoExamenCliniqueRepository.getById(id));
			
	        return "dossierMedical/editEcho"; 
			
			
		} 

	@PutMapping("/echoExamenClinique/update")
	public String updateEchoExamenClinique(
			@ModelAttribute("echoExamenClinique") EchoExamenClinique echoExamenClinique,
			Model model, final RedirectAttributes ra) {
		echoExamenCliniqueRepository.save(echoExamenClinique);
		 ra.addFlashAttribute("successFlash", "EchoExamenClinique Modifier avec succés.");
		  return "redirect:/echoExamenClinique/1";	
	}
	
	
	@GetMapping("/echoExamenClinique/delete/{id}")
	public String deleteEchoExamenClinique(@PathVariable Long id) {
		echoExamenCliniqueRepository.deleteById(id);
		return "redirect:/echoExamenClinique/1";
	
	
	}
}


