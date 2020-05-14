package org.zerock.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomUserDetails implements UserDetails {
	
	private int mem_no;
	private String mem_id;
	private String mem_password;
	private String mem_email;
	private String mem_receive_email;
	private String mem_nickname;
	private String mem_img;
	private Date mem_register_date;
	private String role;
	private String enabled;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		  ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
	        auth.add(new SimpleGrantedAuthority(role));
	        return auth;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return mem_password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return mem_id;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled.equals("1") ;
	}

}
