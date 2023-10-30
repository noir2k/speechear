package kr.co.ihab.speechear.api.dao.security;

import kr.co.ihab.speechear.api.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findQneById(Long id);
}
