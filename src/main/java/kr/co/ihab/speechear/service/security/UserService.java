package kr.co.ihab.speechear.service.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.ihab.speechear.dao.security.RoleRepository;
import kr.co.ihab.speechear.dao.security.UserDao;
import kr.co.ihab.speechear.dao.security.UserRepository;
import kr.co.ihab.speechear.dto.security.UserDto;
import kr.co.ihab.speechear.model.security.Role;

import lombok.RequiredArgsConstructor;

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
