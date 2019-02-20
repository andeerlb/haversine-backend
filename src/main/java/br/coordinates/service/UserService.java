package br.coordinates.service;

import br.coordinates.dto.UserDto;
import br.coordinates.model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private DefaultTokenServices defaultTokenServices;

    @Autowired
    private TokenStore tokenStore;

    public UserDto getUserLogged() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new UserDto(user.getId(), null, user.getUsername());
    }

    public void loggout(HttpSession session) {
        final OAuth2Authentication auth = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        final String token = tokenStore.getAccessToken(auth).getValue();

        session.invalidate();
        SecurityContextHolder.clearContext();
        defaultTokenServices.revokeToken(token);
    }
}
