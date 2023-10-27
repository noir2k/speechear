package kr.co.ihab.speechear.dto.security;

import java.util.Set;

import kr.co.ihab.speechear.model.security.Role;
import kr.co.ihab.speechear.model.security.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
