package epam.news.services;


import epam.news.model.dto.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Service
public class SecurityService {
    private final static Logger LOGGER = Logger.getLogger(SecurityService.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

//    public void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
//        try {
//            request.login(username, password);
//        } catch (ServletException e) {
//            LOGGER.error("Error while login ", e);
//        }

//    public void autoLogin(HttpServletRequest request, String username, String password) {
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
//        authToken.setDetails(new WebAuthenticationDetails(request));
//
//        Authentication authentication = authenticationManager.authenticate(authToken);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        LOGGER.debug(String.format("Successfully %s auto logged in", username));
//    }
//}

//    public void autoLogin(HttpServletRequest request, String username, String password) {
//        try {
//            request.login(username, password);
//        } catch (ServletException e) {
//            LOGGER.error("Error while login ", e);
//        }
//    }
//}


    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(authenticationToken);

        if (authenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            LOGGER.debug(String.format("Successfully %s auto logged in", username));

        }
    }
}
//}
//    public void autoLogin(UserDTO userDTO, HttpServletRequest request) {
//        String username = userDTO.getUsername();
//        String password = userDTO.getPassword();
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
//
//        request.getSession();
//
//        token.setDetails(new WebAuthenticationDetails(request));
//        Authentication authenticatedUser = authenticationManager.authenticate(token);
//
//        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
//    }
