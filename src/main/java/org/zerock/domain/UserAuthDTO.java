package org.zerock.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.mapper.UserMapper;
@Repository
public class UserAuthDTO {
	@Autowired
    private static UserMapper mapper;
 
    public static CustomUserDetails getUserById(String username) {
        return mapper.selectUserById(username);
    }

}
