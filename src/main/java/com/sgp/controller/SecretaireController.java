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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgp.model.Medecin;
import com.sgp.model.Secretaire;
import com.sgp.model.User;
import com.sgp.repository.SecretaireRepository;
import com.sgp.repository.UserRepository;







@Controller
public class SecretaireController {
	@Autowired
	
	private SecretaireRepository secretaireRepository;
	
	@Autowired
	private UserRepository userRepository;
		
		   @GetMapping(value = "/secretaire/{pageNumber}")
		    public String list(@PathVariable Integer pageNumber, Model model, @RequestParam(name = "keyWord", defaultValue = "") String kw) {
				Page<Secretaire> page=secretaireRepository.findByNomContains(kw, PageRequest.of(pageNumber, 10));
				List<Secretaire> secretaireList=secretaireRepository.findAll();
		        int current = page.getNumber() +1;
		        int begin = Math.max(1, current - 10);
		        int end = Math.min(begin + 10, page.getTotalPages());

		        model.addAttribute("page", page);
				 model.addAttribute("list", secretaireList); 

		        model.addAttribute("beginIndex", begin);
		        model.addAttribute("endIndex", end);
		        model.addAttribute("currentIndex", current);

		        return "secretaire/list";

		    }
		   @GetMapping(value = "/Profil")
		    public String list( Model model) {
					// get login user
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				UserDetails userDetails = (UserDetails) authentication.getPrincipal();
				User loginUser = userRepository.findByEmail(userDetails.getUsername());
				
				List<Secretaire> secretaireList=secretaireRepository.findByMatricule(loginUser.getMatricule());// medecinRepository.findAll();
		       
				 model.addAttribute("list", secretaireList); 

		     

		        return "secretaire/profil";

		    }
		   
		   
		   @GetMapping("/secretaire/add")
		    public String add(Model model) {
			   List<User> mList = userRepository.findAll();
				System.out.println(mList);
				
					model.addAttribute("mList",mList);
		        model.addAttribute("secretaire", new Secretaire());
		        return "secretaire/form"; 
		        } 

		    @PostMapping(value = "secretaire/save")
		    public String save(Secretaire secretaire, final RedirectAttributes ra) {

		        @SuppressWarnings("unused")
		        Secretaire save = secretaireRepository.save(secretaire);
		        ra.addFlashAttribute("successFlash", "secretaire ajouter avec succés.");
		        return "redirect:/secretaire/1";

		    }
		    
			@GetMapping("/secretaire/edit/{id}")
			public String edit(@PathVariable Long id, Model model) {
				 List<User> mList = userRepository.findAll();
					System.out.println(mList);
					
						model.addAttribute("mList",mList);
				model.addAttribute("secretaire", secretaireRepository.getById(id));
		        return "secretaire/edit"; 
				
				
			} 

		@PutMapping("/secretaire/update")
		public String updatesecretaire(
				@ModelAttribute("secretaire") Secretaire secretaire,
				Model model) {
			secretaireRepository.save(secretaire);
			return "redirect:/secretaire";		
		}
		
		
		@GetMapping("/secretaire/delete/{id}")
		public String deletesecretaire(@PathVariable Long id) {
			secretaireRepository.deleteById(id);
			return "redirect:/secretaire/1";
		
		
		}
	}