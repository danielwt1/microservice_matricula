package com.acelerati.microservice.microservice_matricula.configuration.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private final JwtTokenUtil jwtTokenUtil;

    public JwtRequestFilter(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = this.jwtTokenUtil.getTokenFromRequest(request);
        String usernameFromHeader = null;
        if (token != null) {
            usernameFromHeader = request.getHeader("user");
        }
        try {
            if (usernameFromHeader != null && this.jwtTokenUtil.validateToken(token, usernameFromHeader)) {
                String usernameFromToken = this.jwtTokenUtil.getUsernameFromToken(token);
                List<String> roles = this.jwtTokenUtil.getRolesFromToken(token);
                UserDetails userDetails = User.builder()
                        .username(usernameFromToken)
                        .password("")
                        .roles(roles.toArray(roles.toArray(new String[0])))
                        .build();
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        token,
                        userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(request);
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        } catch (SignatureException |MalformedJwtException | ExpiredJwtException | UnsupportedJwtException |IllegalArgumentException e) {
            request.getSession().setAttribute("messageToken", e.getMessage());
        }
        filterChain.doFilter(request, response);

    }

}
