package com.example.demo.controller;

import com.example.demo.entity.Placement;
import com.example.demo.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/placements")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @GetMapping
    public List<Placement> getAllPlacements() {
        return placementService.getAllPlacements();
    }

    @PostMapping
    public Placement createPlacement(@RequestBody Placement placement) {
        return placementService.savePlacement(placement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Placement> getPlacementById(@PathVariable Long id) {
        return placementService.findById(id)
                .map(placement -> ResponseEntity.ok().body(placement))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Placement> updatePlacement(@PathVariable Long id, @RequestBody Placement placementDetails) {
        return placementService.findById(id)
                .map(placement -> {
                    placement.setName(placementDetails.getName());
                    placement.setDate(placementDetails.getDate());
                    Placement updatedPlacement = placementService.savePlacement(placement);
                    return ResponseEntity.ok().body(updatedPlacement);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePlacement(@PathVariable Long id) {
        return placementService.findById(id)
                .map(placement -> {
                    placementService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
