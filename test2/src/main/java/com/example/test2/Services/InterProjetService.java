package com.example.test2.Services;

import com.example.test2.Exceptions.ProjectNotFoundException;
import com.example.test2.Exceptions.UserNotFoundException;
import com.example.test2.Models.Projet;
import com.example.test2.Models.Tache;

import java.util.List;

public interface InterProjetService {

    public Projet getProjetById(long id) throws ProjectNotFoundException;

    public List<Projet> getProjets();


    Projet addProjetToUser(Projet projet, long id_user) throws UserNotFoundException;
}
