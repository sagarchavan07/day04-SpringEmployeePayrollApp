package com.bl.employeepayroll.Utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.stereotype.Component;

@Component
public class TokenUtility {
    private String TOKEN_SECRET="BridgeLabz";

    public String generateToken(long id){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            return JWT.create().withClaim("id",id).sign(algorithm);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int decodeToken(String token){
        Verification verification = null;
        try {
            verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));

        } catch (Exception e){
            e.printStackTrace();
        }
        assert verification != null;
        DecodedJWT decodedJWT = verification.build().verify(token);
        int userId = decodedJWT.getClaim("id").asInt();
        return userId;
    }

}
