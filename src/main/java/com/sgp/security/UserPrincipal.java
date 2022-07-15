package com.sgp.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sgp.model.User;



public class UserPrincipal implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	public UserPrincipal(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();

		// Extract list of permissions (name)
		/*
		 * this.user.getRoles().forEach(r -> { r.getPrivileges().forEach(p -> {
		 * 
		 * GrantedAuthority authority = new SimpleGrantedAuthority(p + "_PRIVILEGE");
		 * authorities.add(authority); }); });
		 */
		
		this.user.getRoles().forEach(r -> {
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r.getName());
			authorities.add(authority);
		});

		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}
	
	

}
