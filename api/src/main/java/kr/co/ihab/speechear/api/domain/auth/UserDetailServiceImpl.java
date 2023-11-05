package kr.co.ihab.speechear.api.domain.auth;

import kr.co.ihab.speechear.persistence.jooq.tables.pojos.RoleInfo;
import kr.co.ihab.speechear.persistence.jooq.tables.pojos.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static kr.co.ihab.speechear.persistence.jooq.Tables.*;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.select;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private static final String FIELD_AUTH = "authorities";
    private final DSLContext dslContext;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        @SuppressWarnings("unchecked")
        UserInfoDetail userDetail = dslContext
                .select(USER_INFO.fields())
                .select(
                        multiset(
                            select(ROLE_INFO.fields())
                            .from(USER_ROLES)
                                .innerJoin(ROLE_INFO)
                                .on(USER_ROLES.ROLE_ID.eq(ROLE_INFO.ID))
                            .where(USER_ROLES.USER_ID.eq(username))
                        )
                        .as(FIELD_AUTH)
                        .convertFrom(r -> r.map(o -> o.into(ROLE_INFO).into(RoleInfo.class)))
                )
                .from(USER_INFO)
                .leftJoin(USER_ROLES).on(USER_ROLES.USER_ID.eq(USER_INFO.ID))
                .where(USER_INFO.ID.eq(username))
                .fetchOptional()
                .map(r -> new UserInfoDetail(
                        r.into(USER_INFO).into(UserInfo.class),
                        r.get(FIELD_AUTH, List.class).stream().toList()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return userDetail;
    }
}
