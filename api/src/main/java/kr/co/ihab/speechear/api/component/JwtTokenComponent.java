package kr.co.ihab.speechear.api.component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.security.Keys;
import kr.co.ihab.speechear.api.domain.auth.JwtTokenInfo;
import kr.co.ihab.speechear.api.domain.auth.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

@Log4j2
@Component
@RequiredArgsConstructor
public class JwtTokenComponent {
    public static final String AUTH_HEADER = "Authorization";
    public static final String TOKEN_TYPE = "Bearer";
    private static final long DAY = 86400000L;

//    @Value(value = "${jwt.secretKey}")
    private static String jwtSecretKey = "exampleSecretKeyexampleSecretKeyexampleSecretKeyexampleSecretKeyexampleSecretKey";
    private final Key key;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    public JwtTokenComponent() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public JwtTokenInfo generateJwtToken(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        log.info("authorities :" + authorities);
        long now = (new Date()).getTime();

        Date accessTokenExpiresIn = new Date(now + DAY);
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("auth", authorities)
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        String refreshToken = Jwts.builder()
                .setExpiration(new Date(now + (DAY * 7)))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return JwtTokenInfo.builder()
                .grantType(TOKEN_TYPE)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public Authentication getAuthentication(String accessToken) {
        Claims claims = parseClaims(accessToken);

        if (claims.get("auth") == null) {
            throw new RuntimeException("Invalid Authorization Token");
        }

//        Collection<? extends GrantedAuthority> authorities =
//                Arrays.stream(claims.get("auth").toString().split(","))
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());

        UserDetails userDetails = userDetailService.loadUserByUsername(claims.getSubject());
        //new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(userDetails, accessToken, userDetails.getAuthorities());
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty", e);
        } catch (DecodingException e) {
            log.info("Decoding Error", e);
        }
        return false;
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

//    private static Map<String, Object> createClaims(UserDto userDto) {
//        Map<String, Object> claims = new HashMap<>();
//
//        log.info("userDto :" + userDto.toString());
//
//        claims.put("userId", userDto.getId());
//        claims.put("userName", userDto.getName());
//        claims.put("userRole", userDto.getRoles());
//        claims.put("userCellPhone", userDto.getCellphone());
//        claims.put("userEmail", userDto.getEmail());
//
//        return claims;
//    }

}
