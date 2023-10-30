package kr.co.ihab.speechear.api.dao.security;

import kr.co.ihab.speechear.api.dto.security.UserDto;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    UserDto getMemberInfo(String id);
}
