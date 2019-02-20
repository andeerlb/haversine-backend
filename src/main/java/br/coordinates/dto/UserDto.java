package br.coordinates.dto;

import br.coordinates.model.Collaborator;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {

    private static final long serialVersionUID = 6378598785630704931L;

    private Integer id;
    private String name;
    private String username;

    public UserDto() {
    }

    public UserDto(Integer id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
