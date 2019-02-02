package br.coordinates.controller;

import br.coordinates.dto.ImPossibleCoordinateDto;
import br.coordinates.dto.PossibleCoordinateDto;
import br.coordinates.service.PossibleRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/routers")
public class PossibleRouterController {

    @Autowired
    private PossibleRouterService service;

    @GetMapping("/possibles")
    public ResponseEntity<List<PossibleCoordinateDto>> possibleRouter(@RequestParam("radius") Double radius,
                                                                      @RequestParam("groupBy") String groupBy,
                                                                      @RequestParam("idlbeCollaborator") boolean idlbeCollaborator,
                                                                      @RequestParam("outOfReachByCollaborator") boolean outOfReachByCollaborator) {
        return ResponseEntity.ok(service.possibleRouter(radius, groupBy, idlbeCollaborator, outOfReachByCollaborator));
    }

    @GetMapping("/impossiblewithidlecollaborators")
    public ResponseEntity<List<ImPossibleCoordinateDto>> impossibleRouterWithIdleCollaboratorsOrderByDistance() {
        return ResponseEntity.ok(service.impossibleRouterWithIdleCollaboratorsOrderByDistance());
    }
}
