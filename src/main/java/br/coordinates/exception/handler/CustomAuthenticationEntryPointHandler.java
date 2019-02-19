package br.coordinates.exception.handler;

import br.coordinates.config.MyObjectMapper;
import br.coordinates.exception.exception.AccessDaniedException;
import br.coordinates.infra.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

/*
* Utilizado quando usuário já está logado e tenta acessar algum recurso que não tem acesso.
* Quando tem problema com a authenticação do usuário, ex: ele não tem as 'ROLES' para acessar determinado recurso.
 */
@Component
public class CustomAuthenticationEntryPointHandler implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = 4603592830459621994L;
    private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationEntryPointHandler.class);

    @Autowired
    private MyObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        AccessDaniedException daniedAcess = new AccessDaniedException("Acesso negado", HttpStatus.UNAUTHORIZED);

        Response<Object> objectResponse = new Response<>(daniedAcess.getHttpStatus());
        objectResponse.setMessage(daniedAcess.getMessage());

        try {
            String json = objectMapper.writeValueAsString(objectResponse);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
            response.getWriter().write(json);
        } catch (Exception e1) {
            log.error("Acesso negado: {}", e.getMessage());
        }
    }
}
