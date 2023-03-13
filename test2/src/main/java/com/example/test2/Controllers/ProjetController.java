package com.example.test2.Controllers;

import com.example.test2.Exceptions.ProjectNotFoundException;
import com.example.test2.Exceptions.UserNotFoundException;
import com.example.test2.Models.Projet;
import com.example.test2.Models.Tache;
import com.example.test2.Services.Impl.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjetController {

    @Autowired
    private ProjetService projetService;

    @GetMapping("projet/{id}")
    public Projet getProjetById(@PathVariable long id) throws ProjectNotFoundException {
        return projetService.getProjetById(id);
    }

    @GetMapping("projets")
    public List<Projet> getProjets(){
        return projetService.getProjets();
    }



    @PostMapping("save/projet")
    public  void addProjetToUser(Projet projet,long id_user) throws UserNotFoundException {
        projetService.addProjetToUser(projet,id_user);
    }


}
