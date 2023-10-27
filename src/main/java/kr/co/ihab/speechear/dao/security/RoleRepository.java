package kr.co.ihab.speechear.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.ihab.speechear.model.security.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findQneById(Long id);
}
