package br.coordinates.dto;

import java.util.ArrayList;
import java.util.List;

public class PossibleCoordinateDto {
    private CollaboratorDto collaborator;
    private List<StoreDto> store = new ArrayList<>();

    public PossibleCoordinateDto(CollaboratorDto collaborator) {
        this.collaborator = collaborator;
    }

    public CollaboratorDto getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(CollaboratorDto collaborator) {
        this.collaborator = collaborator;
    }

    public List<StoreDto> getStore() {
        return store;
    }

    public void setStore(List<StoreDto> store) {
        this.store = store;
    }
}
