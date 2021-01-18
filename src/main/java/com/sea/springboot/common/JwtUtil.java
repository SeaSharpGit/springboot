package com.sea.springboot.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;

@Repository
public class JwtUtil {
    private static final String SECRET = "123456789";
    private static final String ISSUER = "WH";
    private static final Integer EXPIRE_DAYS = 1;

    /**
     * 新建token
     */
    public static String createToken(int userId) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, EXPIRE_DAYS);
        Date expiresDate =calendar.getTime();
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        return JWT.create()
                .withIssuer(ISSUER)
                .withExpiresAt(expiresDate)
                .withClaim("userId", userId)
                .sign(algorithm);
    }

    public static int getUserId() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        return getUserId(token);
    }

    private static int getUserId(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(ISSUER)
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Claim claim = jwt.getClaim("userId");
        return claim.asInt();
    }
}
