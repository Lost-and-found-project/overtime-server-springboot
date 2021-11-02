package org.overtime.common.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

/**
 * Jwt util
 * <p>
 * see https://github.com/jwtk/jjwt
 *
 * @author ForteScarlet
 */
@SuppressWarnings({"GrazieInspection", "SpellCheckingInspection"})
public class JwtUtil {

    // Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // String jws = Jwts.builder().setSubject("Joe").signWith(key).compact();
    // assert Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws).getBody().getSubject().equals("Joe");

    //  Jwts.builder().addClaims(datas).setSubject("Job").signWith(JwtUtil.getKey()).compact();

    // We need a signing key, so we'll create one just for this example. Usually
    // the key would be read from your application configuration instead.
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static Key getKey() {
        return KEY;
    }


}
