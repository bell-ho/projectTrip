package org.zerock.mapper;

import org.zerock.domain.CustomUserDetails;

public interface UserMapper {
	public CustomUserDetails selectUserById(String username);
}
