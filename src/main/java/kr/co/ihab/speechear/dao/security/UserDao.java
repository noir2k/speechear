package kr.co.ihab.speechear.dao.security;

import kr.co.ihab.speechear.dto.security.UserDto;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    UserDto getMemberInfo(String id);
}
