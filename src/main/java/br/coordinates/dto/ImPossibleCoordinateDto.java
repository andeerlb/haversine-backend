package br.coordinates.dto;

import java.util.ArrayList;
import java.util.List;

public class ImPossibleCoordinateDto {
    private List<CollaboratorDto> collaborators = new ArrayList<>();
    private StoreDto store;

    public ImPossibleCoordinateDto(StoreDto store) {
        this.store = store;
    }

    public List<CollaboratorDto> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<CollaboratorDto> collaborators) {
        this.collaborators = collaborators;
    }

    public StoreDto getStore() {
        return store;
    }

    public void setStore(StoreDto store) {
        this.store = store;
    }
}
