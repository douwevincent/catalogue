package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Utilisateur;
import com.stage.catalogue.security.CurrentUser;
import com.stage.catalogue.service.UtilisateurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author cellule
 */
@RestController
@RequestMapping("${apiPrefix}/utilisateurs")
public class UtilisateurController {
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @PostMapping()
    public Utilisateur addUtilisateur(@RequestBody Utilisateur util){
        return utilisateurService.addUtilisateur(util);
    }
    /*
    // TODO I need to revise this
    @GetMapping
    public Utilisateur getUtilisateurByName(@PathParam("name") String name){
        // return utilisateurService.getUtilisateurByName(name);
        return null;
    }
    */
    @GetMapping
    public List<Utilisateur> getAll(){
        return utilisateurService.getAll();
    }
    
    @GetMapping("/current")
    public Utilisateur currentUser(@CurrentUser Utilisateur utilisateur){
        return utilisateur;
    }

    @PutMapping(value = "/{id}")
    public Utilisateur updateUtilisateur(Utilisateur util, @PathVariable("id") long idUtilisateur){
        return utilisateurService.editUtilisateur(util);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropUtilisateurById(@PathVariable("idUtilisateur") long idUtilisateur){
        utilisateurService.deleteById(idUtilisateur);
    }
}
