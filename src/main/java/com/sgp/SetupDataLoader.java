package com.sgp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sgp.model.Privilege;
import com.sgp.model.Role;
import com.sgp.model.User;
import com.sgp.repository.MedecinRepository;
import com.sgp.repository.PersonneRepository;
import com.sgp.repository.PrivilegeRepository;
import com.sgp.repository.RoleRepository;
import com.sgp.repository.UserRepository;

import java.util.List;

import java.util.Arrays;
import java.util.Collection;


import javax.transaction.Transactional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

@Component
 
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	private final Log logger = LogFactory.getLog(SetupDataLoader.class);

   
	 @Autowired
	    private UserRepository userRepository;
	 
	    @Autowired
	    private RoleRepository roleRepository;
	    
	    @Autowired
	    private PersonneRepository personneRepository;
	 
	    @Autowired
	    private MedecinRepository medecinRepository;
	    
	    @Autowired
	    private PrivilegeRepository privilegeRepository;
	 
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
	    @Override
	    @Transactional
	    public void onApplicationEvent(ContextRefreshedEvent event) {
	 
	        if (userRepository.findAll().isEmpty())
	        	
	        {
	        	logger.info("No Users accounts found. Creation some users");
	        	
	        Privilege readPrivilege  = createPrivilegeIfNotFound("READ");
	        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE");
	 
	        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
	        createRoleIfNotFound("ADMIN", adminPrivileges);
	        createRoleIfNotFound("USER", Arrays.asList(readPrivilege));
	        createRoleIfNotFound("MEDECIN", Arrays.asList(writePrivilege));
	        createRoleIfNotFound("INFERMIER", Arrays.asList(readPrivilege));

	        Role adminRole = roleRepository.findByName("ADMIN");
	        
	        User admin = new User();
	        admin.setPassword(passwordEncoder.encode("admin"));
	        admin.setEmail("admin");
	        admin.setRoles(Arrays.asList(adminRole));
	        admin.setEnabled(true);
	        userRepository.save(admin);
	        
	        Role userRole = roleRepository.findByName("USER");
	        User user = new User();
	        user.setPassword(passwordEncoder.encode("user"));
	        user.setEmail("user");
	        user.setRoles(Arrays.asList(userRole));
	        user.setEnabled(true);
	        userRepository.save(user);
	        
	        Role medecinRole = roleRepository.findByName("MEDECIN");
	        User medecin = new User();
	        medecin.setPassword(passwordEncoder.encode("medecin"));
	        medecin.setEmail("medecin");
	        medecin.setRoles(Arrays.asList(medecinRole));
	        medecin.setEnabled(true);
	        userRepository.save(medecin);
	      
	        
	        Role infermierRole = roleRepository.findByName("INFERMIER");
	        User infermier = new User();
	        infermier.setPassword(passwordEncoder.encode("infermier"));
	        infermier.setEmail("infermier");
	        infermier.setRoles(Arrays.asList(infermierRole));
	        infermier.setEnabled(true);
	        userRepository.save(infermier);
	        
	        }
	        
	    	logger.info("Users accounts found.");
	        Role medecinRole = roleRepository.findByName("MEDECIN");
	    	 User medecin = new User();
		        medecin.setPassword(passwordEncoder.encode("medecin"));
		        medecin.setEmail("medecin");
		        medecin.setRoles(Arrays.asList(medecinRole));
		        medecin.setEnabled(true);
	    	
	     		

	    }

	    @Transactional
	    Privilege createPrivilegeIfNotFound(String name) {
	 
	        Privilege privilege = privilegeRepository.findByName(name);
	        if (privilege == null) {
	            privilege = new Privilege(name);
	            privilegeRepository.save(privilege);
	        }
	        return privilege;
	    }

	    @Transactional
	    Role createRoleIfNotFound(
	      String name, Collection<Privilege> privileges) {
	        Role role = roleRepository.findByName(name);
	        if (role == null) {
	            role = new Role(name);
	            role.setPrivileges(privileges);
	            roleRepository.save(role);
	        }
	        return role;
	    }

	}