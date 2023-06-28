package com.travelatlasmorocco.security;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;
public class AuthorizationFilter extends BasicAuthenticationFilter{
    AuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        // play role of midllware
            throws IOException, ServletException {

        String header = request.getHeader(SecurityConstants.HEADER_STRING);
        if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }


    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstants.HEADER_STRING);

        if (token != null) {

            token = token.replace(SecurityConstants.TOKEN_PREFIX, "");// bearer

            String user = Jwts.parser().setSigningKey(SecurityConstants.TOKEN_SECRET).parseClaimsJws(token).getBody()
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }

            return null;
        }

        return null;
    }
}
