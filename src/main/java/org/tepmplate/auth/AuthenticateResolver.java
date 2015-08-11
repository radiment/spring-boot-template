package org.tepmplate.auth;

import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.security.Principal;
import java.util.Map;

@Component
public class AuthenticateResolver {

    @Autowired
    LdapUserDetailsService ldapUserDetailsService;

    public void resolveAuthenticate(Map<String, Object> session) {
        try {
            String username = getUsername(session);
            UserDetails userDetails = ldapUserDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
                    new UserPrincipal(username), userDetails.getPassword(), userDetails.getAuthorities());
            result.setDetails(userDetails);
            SecurityContextHolder.getContext().setAuthentication(result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Error when getting username: ", e);
        }
    }

    public String getUsername(Map<String, Object> session) throws NoSuchFieldException, IllegalAccessException {
        Field user = session.getClass().getDeclaredField("user");
        user.setAccessible(true);
        Principal principal = (Principal) user.get(session);
        return principal.getName();
    }
}
