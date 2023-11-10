package top.imono.jk.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.imono.jk.common.exception.CommonException;
import top.imono.jk.common.utils.JsonVos;
import top.imono.jk.pojo.result.CodeMsg;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

@Component
@Slf4j
public class JwtUtil {
    private static final String SECRET = "zxcvbnmfdasaererafafafafafafakjlkjalkfafadffdafadfafafaaa234567908fadfadfaf3";
    public static final long EXPIRE = 60 * 24 * 7; // 有效期7天
    public static final String HEADER = "Authorization";
    public static final String PREFIX = "Bearer";

    /**
     * 生成jwt token
     */
    public String generateToken(String username, String id) {
        SecretKey signingKey = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        //过期时间
        LocalDateTime tokenExpirationTime = LocalDateTime.now().plusMinutes(EXPIRE);
        return Jwts.builder()
                .header().add("typ", "JWT").and()
                .issuedAt(Timestamp.valueOf(LocalDateTime.now()))
                .subject("user")
                .expiration(Timestamp.valueOf(tokenExpirationTime))
                .claims(Map.of("username", username, "id", id))
                .signWith(signingKey, Jwts.SIG.HS512)
                .compact();
    }

    public Claims getClaimsByToken(String token) {
        SecretKey signingKey = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        return Jwts.parser()
                .verifyWith(signingKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * 检查token是否过期
     *
     * @return true：过期
     */
//    public boolean isTokenExpired(Date expiration) {
//        return expiration.before(new Date());
//    }

    //判断jwtToken是否合法
    public boolean isVerify(String jwtToken) {
        //这个是官方的校验规则，这里只写了一个”校验算法“，可以自己加
//        Algorithm algorithm = null;
//        switch (signatureAlgorithm) {
//            case HS256:
//                algorithm = Algorithm.HMAC256(Base64.decodeBase64(base64EncodedSecretKey));
//                break;
//            default:
//                throw new RuntimeException("不支持该算法");
//        }

        try {
            Algorithm algorithm = Algorithm.HMAC512(SECRET.getBytes(StandardCharsets.UTF_8));
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(jwtToken);  // 校验不通过会抛出异常
            //判断合法的标准：1. 头部和荷载部分没有篡改过。2. 没有过期
            return true;
        } catch (Exception e) {
            log.debug(e.getMessage());
            JsonVos.raise(CodeMsg.TOKEN_INVALID);
        }
//        catch (SignatureVerificationException e){
//            JsonVos.raise(CodeMsg.TOKEN_EXPIRED);
//        }
        return false;
    }


    /**
     * 获得token中的自定义信息,一般是获取token的username，无需secret解密也能获得
     *
     * @param token
     * @param filed
     * @return
     */
    public String getClaimFiled(String token, String filed) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(filed).asString();
        } catch (JWTDecodeException e) {
            log.error("JwtUtil getClaimFiled error: ", e);
            return null;
        }
    }

    public static void main(String[] args) {
        JwtUtil jwtUtil = new JwtUtil();
        String token = jwtUtil.generateToken("admin", "222");
        token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2OTkyNDI2NjUsInN1YiI6InVzZXIiLCJ4eCI6IjExMSIsImV4cCI6MTY5OTI0MjcyNSwidXNlcm5hbWUiOiJhZG1pbiIsImlkIjoiMSJ9.u-kRFt2cWxHOqbmaxKG8f2e6IgeLbudO6J0aO65q5SLU7gaL2myRR9-0t7zKD09DeRV8NdlP4UaFQ_ltgqy8yA";
        // token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2OTkyNDI3ODcsInN1YiI6InVzZXIiLCJ4eCI6IjExMSIsImV4cCI6MTY5OTg0NzY0NywidXNlcm5hbWUiOiJhZG1pbiIsImlkIjoiMSJ9.g1Xi-zkRSktD814cI2zehPS0SEpRgEjOijvi8qbfwpOuKAW4aK8Ank5xZqSZ-5Z3FIXudvybCd5kkKS0DJRrSA";
        System.out.println("token = " + token);


//        Claims claims = jwtUtil.getClaimsByToken(token);
//        System.out.println("claims = " + claims);

        String username = jwtUtil.getClaimFiled(token, "username");
        String id = jwtUtil.getClaimFiled(token, "xx");
        System.out.println("username = " + username);
//        System.out.println("id = " + claims.get("id") + ' ' + claims.getId());
        System.out.println("isVerify = " + jwtUtil.isVerify(token));

    }


    public static String getTokenFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader(JwtUtil.HEADER);
        if (authHeader == null || authHeader.length() <= JwtUtil.PREFIX.length()) {
            return null;
        }
        return authHeader.substring(JwtUtil.PREFIX.length() + 1);
    }
}
