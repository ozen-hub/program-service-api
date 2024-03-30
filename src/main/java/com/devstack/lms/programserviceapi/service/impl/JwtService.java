package com.devstack.lms.programserviceapi.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Service
public class JwtService {

    private final String publickkeayString = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA8Yw3n04qmUu21c5+8S6qgN+jbuP4rJK1NIA2c69GrH7rG8Vl9ankYIYRx7fuRLeP63Tni62DQmxvvGT20Z3CSG0GIXJzwOEJJXCTsLl7WwS/VJzFWDSNLNxKT8Oft4D3calyuaUpv/4wp9l0h+NXV0aOQoHqK4M+fHMgMxBFV9uaWisvm1A+nN5QnzmZbQnIvC72rpP5XDvA+Q+OdUG1v0kHabSWgIEnF1vhvyPIKG6c5hUx66KzTvEInfYmN4s7lQwotqMNUqOlDCCAL9r0QviC/uABz0WGuQuP3m2ZcM+DFqmkdMNZWX42qMBicu9tzEu6oN+XJV3/1v3XFc2WPwIDAQAB";

    public String getEmail(String token){
        try{
            byte[] keyBytes = Base64.getDecoder().decode(publickkeayString);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(spec);

            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .build().parseClaimsJws(token);

            Claims body = claimsJws.getBody();
            return body.get("email", String.class);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
