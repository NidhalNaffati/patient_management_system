package com.sgp.controller;

import java.util.Date;
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

import com.sgp.model.Consultation;
import com.sgp.model.DossierMedical;
import com.sgp.model.Medecin;
import com.sgp.model.Patient;
import com.sgp.repository.ConsultationRepository;
import com.sgp.repository.DossierMedicalRepository;
import com.sgp.repository.MedecinRepository;
import com.sgp.repository.PatientsRepository;

@Controller

public class ConsultationController {
	@Autowired

	private ConsultationRepository consultationRepository;

	@Autowired
	MedecinRepository medecinRepository;
	@Autowired
	DossierMedicalRepository dossierMedicalRepository;

	@GetMapping(value = "/consultation/{pageNumber}")
	public String list(@PathVariable Integer pageNumber, Model model,
			@RequestParam(name = "keyWord", defaultValue = "") String kw) {
		Page<Consultation> page = consultationRepository.findAll(PageRequest.of(pageNumber, 10));
		List<Consultation> consultationList = consultationRepository.findAll();
		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 10);
		int end = Math.min(begin + 10, page.getTotalPages());

		model.addAttribute("page", page);
		model.addAttribute("list", consultationList);

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		return "medecin/listconsultation";

	}

	@GetMapping("/consultation/add/{id}")
	public String add(Model model) {
		/*
		 * List<DossierMedical> dList = dossierMedicalRepository.findAll();
		 * System.out.println(dList);
		 * 
		 * model.addAttribute("dList",dList);
		 */
		List<Medecin> mList = medecinRepository.findAll();
		System.out.println(mList);
		
			model.addAttribute("mList",mList);
			model.addAttribute("consultation", new Consultation());
		
		return "medecin/consultation";
	}

	@PostMapping(value = "consultation/save")
	public String save(Consultation consultation, final RedirectAttributes ra) {

		consultation.setDateConsultation(new Date());
		consultationRepository.save(consultation);
		ra.addFlashAttribute("successFlash", "Consultation ajouter avec succés.");
		return "redirect:/consultation/1";

	}

	@GetMapping("/consultation/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("consultation", consultationRepository.getById(id));
		return "redirect:/consultation";

	}

	@PutMapping("/consultation/update")
	public String updateConsultation(@ModelAttribute("consultation") Consultation consultation, Model model) {
		consultationRepository.save(consultation);
		return "redirect:/consultation";
	}

	@GetMapping("/consultation/delete/{id}")
	public String deleteConsultation(@PathVariable Long id) {
		consultationRepository.deleteById(id);
		return "redirect:/consultation/1";

	}
}
