package kr.co.ihab.speechear.api.service.security;

import kr.co.ihab.speechear.api.dao.security.RoleRepository;
import kr.co.ihab.speechear.api.dao.security.UserRepository;
import kr.co.ihab.speechear.api.dto.security.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

//    private final UserDao dao;

    public void insert(UserDto userDto) {
//        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
//        Set<Role> rolesSet = new HashSet<Role>();
//        rolesSet.add(roleRepository.findQneById(3L));
//        userRepository.save(userDto.toEntity(rolesSet));
    }

    public UserDto getMemberInfo(String id) {
        return new UserDto();
//        return dao.getMemberInfo(id);
    }
}
