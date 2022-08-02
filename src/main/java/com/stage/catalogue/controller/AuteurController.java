package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Auteur;
import com.stage.catalogue.service.AuteurService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author cellule
 */
@RestController
@RequestMapping("/auteurs")

public class AuteurController {
    
    @Autowired
    private AuteurService auteur;
    
    @PostMapping()
    public ResponseEntity<Auteur> addAuteur(@RequestBody Auteur aut){
        return auteur.addAuteur(aut);
    }
    
    @GetMapping(value = "{id: \\id+}")
    public ResponseEntity<Auteur> getAuteurById(@PathParam("idAuteur") int idAuteur){
        return auteur.getAuteurById(idAuteur);
    }
    
    @GetMapping()
    public Page<Auteur> getAuteurByNom(@PathParam("nomAuteur") String nomAuteur, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return auteur.getAuteurByNom(nomAuteur, page, size);
    }
    
    @GetMapping(value = "/all")
    public Page<Auteur> getAllAuteur(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return auteur.getAuteur(page, size);
    }
    
    @PutMapping()
    public ResponseEntity<Auteur> updateAuteur(Auteur aut, @PathParam("idAuteur") int idAuteur){
        return auteur.editAuteur(aut, idAuteur);
    }
    
    @DeleteMapping(value = "/delete/{id: \\id+}")
    public void dropAuteur(@PathParam("idAuteur") int idAuteur){
        auteur.dropAuteurById(idAuteur);
    }
}
