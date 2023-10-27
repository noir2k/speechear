package kr.co.ihab.speechear.dao.security;

import kr.co.ihab.speechear.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
    User findOneById(String id);
}
