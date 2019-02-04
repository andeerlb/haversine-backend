package br.coordinates.service;

import br.coordinates.dto.CollaboratorDto;
import br.coordinates.dto.ImPossibleCoordinateDto;
import br.coordinates.dto.PossibleCoordinateDto;
import br.coordinates.dto.StoreDto;
import br.coordinates.model.Collaborator;
import br.coordinates.model.Store;
import br.coordinates.repository.CollaboratorRepository;
import br.coordinates.repository.StoreRepository;
import br.coordinates.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PossibleRouterService {

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private StoreRepository storeRepository;

    public List<PossibleCoordinateDto> possibleRouter(Double radius, String groupBy, boolean idlbeCollaborator, boolean outOfReachByCollaborator, Integer cityId) {
        List<Collaborator> collaborators = collaboratorRepository.findAllByCity(cityId);
        List<Store> stores = storeRepository.findAllByCity(cityId);

        List<PossibleCoordinateDto> possibleCoordinateDto = new ArrayList<>();

        for (Collaborator c : collaborators) {
            PossibleCoordinateDto psDto = new PossibleCoordinateDto(new CollaboratorDto(c));

            for (Store s : stores) {
                double haversine = CoordinateUtil.haversine(c.getGeolocation(), s.getGeolocation());

                StoreDto storeDto = new StoreDto(s);
                storeDto.setDistance(haversine);
                if(outOfReachByCollaborator && storeDto.getDistance() > radius) {
                    psDto.getStore().add(storeDto);
                } else if (!outOfReachByCollaborator && storeDto.getDistance() <= radius){
                    psDto.getStore().add(storeDto);
                }

            }

            if(idlbeCollaborator && psDto.getStore().isEmpty()){
                possibleCoordinateDto.add(psDto);
            } else if(!idlbeCollaborator && !psDto.getStore().isEmpty()) {
                possibleCoordinateDto.add(psDto);
            }
        }

        possibleCoordinateDto.forEach(possible -> {
            Collections.sort(possible.getStore(), Comparator.comparing(StoreDto::getDistance));
        });

        return possibleCoordinateDto;
    }

    public List<ImPossibleCoordinateDto> impossibleRouterWithIdleCollaboratorsOrderByDistance() {
        List<Collaborator> collaborators = collaboratorRepository.findAll();
        List<Store> stores = storeRepository.findAll();

        List<ImPossibleCoordinateDto> imPossibleCoordinateDto = new ArrayList<>();

        for (Store s : stores) {
            ImPossibleCoordinateDto ipscDto = new ImPossibleCoordinateDto(new StoreDto(s));

            for (Collaborator c : collaborators) {
                double haversine = CoordinateUtil.haversine(c.getGeolocation(), s.getGeolocation());

                if(haversine <= 2) {
                    break;
                }

                CollaboratorDto cDto = new CollaboratorDto(c);
                cDto.setDistance(haversine);
                ipscDto.getCollaborators().add(cDto);
            }

            if(ipscDto.getCollaborators().isEmpty()){
                continue;
            }
            imPossibleCoordinateDto.add(ipscDto);
        }

        imPossibleCoordinateDto.forEach(imp -> {
            Collections.sort(imp.getCollaborators(), Comparator.comparing(CollaboratorDto::getDistance));
        });

        return imPossibleCoordinateDto;
    }
}
