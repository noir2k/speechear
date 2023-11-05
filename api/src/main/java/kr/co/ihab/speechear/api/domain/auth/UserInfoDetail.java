package kr.co.ihab.speechear.api.domain.auth;

import kr.co.ihab.speechear.persistence.jooq.tables.pojos.RoleInfo;
import kr.co.ihab.speechear.persistence.jooq.tables.pojos.UserInfo;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserInfoDetail implements UserDetails, Serializable {
    @Serial
    private static final long serialVersionUID = 4642097053432640909L;

    private final UserInfo userInfo;
    private final List<RoleInfo> roles;

    private Collection<GrantedAuthority> authorities;

    public UserInfoDetail(UserInfo userInfo, List<RoleInfo> roles) {
        this.userInfo = userInfo;
        this.roles = roles;
        this.authorities = roles.stream()
                .map(r -> (GrantedAuthority) r::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
