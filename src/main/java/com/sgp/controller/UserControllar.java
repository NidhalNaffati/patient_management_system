package com.sgp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgp.model.User;
import com.sgp.repository.UserRepository;

@Controller

public class UserControllar {
	@Autowired

	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping(value = "/user/{pageNumber}")
	public String list(@PathVariable Integer pageNumber, Model model,
			@RequestParam(name = "keyWord", defaultValue = "") String kw) {
		Page<User> page = userRepository.findByEmailContains(kw, PageRequest.of(pageNumber, 10));
		List<User> userList = userRepository.findAll();
		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 10);
		int end = Math.min(begin + 10, page.getTotalPages());

		model.addAttribute("page", page);
		model.addAttribute("list", userList);

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		return "user/list";

	}
	

	@GetMapping("/user/add")
	public String add(Model model) {

		model.addAttribute("user", new User());
		return "user/form";
	}

	@GetMapping("/Registre")
	public String showRegistrationForm(Model model) {

		model.addAttribute("userExist", false);
		model.addAttribute("user", new User());

		return "user/form";
	}

	@PostMapping(value = "user/save")
	public String save(User user, final RedirectAttributes ra, Model model) {
		
			
			
			if (userRepository.existsByEmail(user.getEmail())) {
				model.addAttribute("userExists", true);
				model.addAttribute("user", user);
				return "user/form";
			
		}
		

	if (userRepository.existsByMatricule(user.getMatricule())) {
			model.addAttribute("userExist", true);
			model.addAttribute("user", user);
			return "user/form";
			
		} 
		
		else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setEnabled(false);
			userRepository.save(user);
			return "user/validation";
		}
	}
		

	@GetMapping("/user/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("user", userRepository.getById(id));
		return "user/form";

	}

	@PutMapping("/user/update")
	public String updateUser(@ModelAttribute("user") User user, Model model) {
		userRepository.save(user);
		return "redirect:/user";
	}

	@GetMapping("/user/inactive/{id}")
	public String inActiveUser(@PathVariable Long id) {

		User user = userRepository.findById(id).get();
		user.setEnabled(false);
		userRepository.save(user);
		return "redirect:/user/1";
	}

	@GetMapping("/user/active/{id}")
	public String activeUser(@PathVariable Long id) {

		User user = userRepository.findById(id).get();
		user.setEnabled(true);
		userRepository.save(user);
		return "redirect:/user/1";
	}

	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return "redirect:/user/1";

	}
}