package br.coordinates.exception.handler;

import br.coordinates.config.MyObjectMapper;
import br.coordinates.exception.exception.AccessDaniedException;
import br.coordinates.infra.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

/*
*   A authenticação não ajuda na requisição e a solicitação não deve ser repetida.
*   403 Irá ocorrer quando acesso ao recurso é proíbido ou restringido a uma lista de ips, ou algo do genêro! (Que não esteja relacionado a authenticação)
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler, Serializable {

    private static final long serialVersionUID = 5557802264503707756L;
    private static final Logger log = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

    @Autowired
    private MyObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) {
        AccessDaniedException daniedAcess = new AccessDaniedException("Acesso negado", HttpStatus.FORBIDDEN);

        Response<Object> objectResponse = new Response<>(daniedAcess.getHttpStatus());
        objectResponse.setMessage(daniedAcess.getMessage());

        try {
            String json = objectMapper.writeValueAsString(objectResponse);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
            response.getWriter().write(json);
        } catch (Exception e1) {
            log.error("Acesso negado: {}", e.getMessage());
        }
    }
}
