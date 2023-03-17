/*
package com.ahsh.home.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ahsh.home.dao.domain.SysRoleUser;
import com.ahsh.home.dao.domain.SysUser;
import com.ahsh.home.dao.domain.ext.SysMenuExt;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Data
public class LoginAppUser extends SysUser implements UserDetails, Serializable {

	private static final long serialVersionUID = -7912962216288934990L;

	private List<SysRoleUser> sysRoles;

	private List<String> permissions;

	private List<String> menus;

	private List<SysMenuExt> consoleMenus;

	private String memberId;

	private Object applicationData;

	private String deptName;

	private String flag;


	*/
/***
	 * 权限重写
	 *//*

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new HashSet<>();
		Collection<GrantedAuthority> synchronizedCollection = Collections.synchronizedCollection(collection) ;

		if (!CollectionUtils.isEmpty(permissions)) {
			permissions.parallelStream().forEach(per -> {
				synchronizedCollection.add(new SimpleGrantedAuthority(per));
			});
		}

		return collection;
	}

	@Override
	public String getUsername() {
		return this.getUserName();
	}


	@JsonIgnore
	public Collection<? extends GrantedAuthority> putAll(Collection<GrantedAuthority> collections) {
		Collection<GrantedAuthority> collection = new HashSet<>();

		collection.addAll(collections) ;

		return collection;
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
		return true;
	}

}
*/
