package org.overtime.test;

import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.overtime.common.jwt.JwtUtil;

import java.util.HashMap;

/**
 * @author ForteScarlet
 */
public class JwtTest {

    //@Test
    public void jwtTest() {
        var datas = new HashMap<String, Object>();
        datas.put("name", "ForteScarlet");
        datas.put("age", 5);

        String jws = Jwts.builder().addClaims(datas).setSubject("Job").signWith(JwtUtil.getKey()).compact();
        System.out.println(jws);
    }
}
