package com.example.test2.Services.Impl;


import com.example.test2.Exceptions.ProjectNotFoundException;
import com.example.test2.Exceptions.TacheNotFoundException;
import com.example.test2.Models.Projet;
import com.example.test2.Models.Tache;
import com.example.test2.Repos.ProjetRepo;
import com.example.test2.Repos.TacheRepo;
import com.example.test2.Services.InterTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacheService  implements InterTacheService {

    @Autowired
    private TacheRepo tacheRepo;

    @Autowired
    private ProjetRepo projetRepo;

    @Override
    public Tache getTacheById(long id) throws TacheNotFoundException {
        Optional<Tache> tache= tacheRepo.findById(id);
        if(tache.isPresent()){
            return tache.get();
        }else{
            throw new TacheNotFoundException("user not found with id ="+id);
        }
    }

    @Override
    public List<Tache> getTaches() {
        return tacheRepo.getTaches();
    }

    @Override
    public void removeTachesOfProjet(long projet_id) {
        tacheRepo.removeTachesOfProjet(projet_id);
    }

    @Override
    public Tache ajouterTacheToProjet(Tache tache) throws ProjectNotFoundException {

        Optional<Projet> projet=projetRepo.findById(tache.getProjet().getProjet_id());
        if(projet.isPresent()){
           return tacheRepo.save(tache);

        }else{
            throw new ProjectNotFoundException("projet not found  with id ="+tache.getProjet().getProjet_id());
        }

    }
}
