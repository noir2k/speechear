package kr.co.ihab.speechear.api.dto.security;

import kr.co.ihab.speechear.api.security.Role;
import kr.co.ihab.speechear.api.security.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String id;
    private String password;
    private String name;
    private String email;
    private String cellphone;
    private Set<Long> roles;

    public User toEntity(Set<Role> roles) {
		return User.builder().id(id).password(password).name(name).roles(roles).build();
	}
}
