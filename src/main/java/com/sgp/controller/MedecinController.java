package com.sgp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgp.model.Medecin;
import com.sgp.model.User;
import com.sgp.repository.MedecinRepository;
import com.sgp.repository.UserRepository;


@Controller

public class MedecinController {
	@Autowired
	
private MedecinRepository medecinRepository;
	@Autowired
private UserRepository userRepository;
	
	

@GetMapping(value = "/medecin/{pageNumber}")
public String list(@PathVariable Integer pageNumber, Model model,
		@RequestParam(name = "keyWord", defaultValue = "") String kw) {
	Page<Medecin> page = medecinRepository.findByNomContains(kw, PageRequest.of(pageNumber, 10)); 
	
	List<Medecin> medecinList = medecinRepository.findAll();
	
	medecinRepository.findAll();
	int current = page.getNumber() + 1;
	int begin = Math.max(1, current - 10);
	int end = Math.min(begin + 10, page.getTotalPages());

	model.addAttribute("page", page);
	model.addAttribute("list", medecinList);

	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);

	return "medecin/list";

}

	   @GetMapping(value = "/myProfil")
	    public String list( Model model) {
				// get login user
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			User loginUser = userRepository.findByEmail(userDetails.getUsername());
			
			List<Medecin> medecinList=medecinRepository.findByMatricule(loginUser.getMatricule());// medecinRepository.findAll();
	       
			 model.addAttribute("list", medecinList); 

	     

	        return "medecin/profil";

	    }
	   @GetMapping("/medecin/add")
	    public String add(Model model) {
		   List<User> mList = userRepository.findAll();
			System.out.println(mList);
			
				model.addAttribute("mList",mList);
				
	        model.addAttribute("medecin", new Medecin());
	        return "medecin/form"; 
	        } 

	    @PostMapping(value = "medecin/save")
	    public String save(Medecin medecin, final RedirectAttributes ra) {

	        @SuppressWarnings("unused")
	        Medecin save = medecinRepository.save(medecin);
	        ra.addFlashAttribute("successFlash", "Medecin ajouter avec succés.");
	        return "redirect:/medecin/1";

	    }
	    
		@GetMapping("/medecin/edit/{id}")
		public String edit(@PathVariable Long id, Model model) {
			  List<User> mList = userRepository.findAll();
				System.out.println(mList);
				
					model.addAttribute("mList",mList);
			model.addAttribute("medecin", medecinRepository.getById(id));
	        return "medecin/edit"; 
			
			
		} 
		
		@GetMapping("/medecin/editprofil/{id}")
		public String editprofil(@PathVariable Long id, Model model) {
			  List<User> mList = userRepository.findAll();
				System.out.println(mList);
				
					model.addAttribute("mList",mList);
			model.addAttribute("medecin", medecinRepository.getById(id));
	        return "medecin/editprofil"; 
			
			
		} 
	@PutMapping("/medecin/update")
	public String updateMedecin(
			@ModelAttribute("medecin") Medecin medecin,
			Model model) {
		medecinRepository.save(medecin);
		return "redirect:/medecin";		
	}
	
	
	@GetMapping("/medecin/delete/{id}")
	public String deleteMedecin(@PathVariable Long id) {
		medecinRepository.deleteById(id);
		return "redirect:/medecin/1";
	
	
	}
}