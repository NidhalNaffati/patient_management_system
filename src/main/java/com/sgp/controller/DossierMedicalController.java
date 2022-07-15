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
import com.sgp.model.Consultation;
import com.sgp.model.DossierMedical;
import com.sgp.model.EchoExamenClinique;
import com.sgp.model.Patient;
import com.sgp.repository.BilanRepository;
import com.sgp.repository.ConsultationRepository;
import com.sgp.repository.DossierMedicalRepository;
import com.sgp.repository.EchoExamenCliniqueRepository;
import com.sgp.repository.PatientsRepository;

@Controller
public class DossierMedicalController {

	@Autowired
	private DossierMedicalRepository dossierMedicalRepository;
	
	@Autowired
	private PatientsRepository patientsRepository;
	
	@Autowired
	private ConsultationRepository consultationRepository;
	
	@Autowired
	private BilanRepository bilanRepository;
	@Autowired
	private PatientsRepository patientRepository;
	
	@Autowired
	private EchoExamenCliniqueRepository echoExamenCliniqueRepository;

	@GetMapping(value = "/dossierMedical/{pageNumber}")
		    public String list(@PathVariable Integer pageNumber, Model model, @RequestParam(name = "keyWord", defaultValue = "") String keyWord) {
				Page<DossierMedical> page=dossierMedicalRepository.findBylactaleSgContains(keyWord, PageRequest.of(pageNumber, 10));
				List<DossierMedical> dossierMedicalList=dossierMedicalRepository.findAll();
				List<Consultation>  consultList = consultationRepository.findAll();
				List<Bilan> bilanList = bilanRepository.findAll();
				List<EchoExamenClinique> echoList = echoExamenCliniqueRepository.findAll();
				List<Patient> patientList = patientRepository.findAll();
				
		        int current = page.getNumber() +1;
		        int begin = Math.max(1, current - 10);
		        int end = Math.min(begin + 10, page.getTotalPages());

		        model.addAttribute("page", page);
		        model.addAttribute("listPatient", patientList); 
				 model.addAttribute("list", dossierMedicalList); 
                 model.addAttribute("consultList",consultList);
                 model.addAttribute("bilanList",bilanList);
                 model.addAttribute("echoList",echoList);
                 
                 
		        model.addAttribute("beginIndex", begin);
		        model.addAttribute("endIndex", end);
		        model.addAttribute("currentIndex", current);

		        return "dossierMedical/list";

		    }

	@GetMapping("/dossierMedical/add/{id}")
	public String add(@PathVariable("id") Long id,Model model) {
		DossierMedical dosModel = new DossierMedical();
		System.out.println("IDD "+id);
		dosModel.setId(id);
		model.addAttribute("dossierMedical", dosModel);
		return "dossierMedical/form";
	}

	@PostMapping(value = "dossierMedical/save/{id}")
	public String save(@PathVariable("id") Long id , DossierMedical dossierMedical, final RedirectAttributes ra) {
       System.out.println("PAtient ID: "+id);
       Patient patient = patientsRepository.getById(id);
       if(patient == null)
    	   return "dossierMedical/form";
       patient.setDossierMedical(dossierMedical);
       patientsRepository.save(patient);
		return "redirect:/dossierMedical/"+id;

	}

	@GetMapping("/dossierMedical/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("dossierMedical", dossierMedicalRepository.getById(id));
		return "dossierMedical/form";
	}

	@PutMapping("/dossierMedical/update")
	public String updatedossierMedical(@ModelAttribute("dossierMedical") DossierMedical dossierMedical, Model model) {
		dossierMedicalRepository.save(dossierMedical);
		return "redirect:/dossierMedical";
	}

	@GetMapping("/dossierMedical/delete/{id}")
	public String deletedossierMedical(@PathVariable Long id) {
		dossierMedicalRepository.deleteById(id);
		return "redirect:/dossierMedical/1";

	}

}
