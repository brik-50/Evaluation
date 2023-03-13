package com.example.test2.Controllers;

import com.example.test2.Exceptions.ProjectNotFoundException;
import com.example.test2.Exceptions.TacheNotFoundException;
import com.example.test2.Models.Tache;
import com.example.test2.Services.Impl.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TacheController {


    @Autowired
    private TacheService tacheService;

    @GetMapping("tache/{id}")
    public Tache getTacheById(@PathVariable  long id) throws TacheNotFoundException {
        return tacheService.getTacheById(id);
    }

    @GetMapping("taches")
    public List<Tache> getTaches(){
        return tacheService.getTaches();
    }


    @PostMapping("remove/Taches/{id}")
    public void removeTachesOfProjet(@PathVariable long id){
        tacheService.removeTachesOfProjet(id);
    }


    @PostMapping("add/tache")
    public Tache ajouterTacheToProjet(Tache tache) throws ProjectNotFoundException {
        return tacheService.ajouterTacheToProjet(tache);
    }



}
