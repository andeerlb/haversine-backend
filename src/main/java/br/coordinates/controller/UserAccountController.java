package br.coordinates.controller;

import br.coordinates.dto.UserDto;
import br.coordinates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/useraccount")
public class UserAccountController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<UserDto> getUserLogged() {
        return ResponseEntity.ok(service.getUserLogged());
    }

    @GetMapping(value = "/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpSession session) {
        service.loggout(session);
    }
}
