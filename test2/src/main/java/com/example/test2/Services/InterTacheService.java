package com.example.test2.Services;


import com.example.test2.Exceptions.ProjectNotFoundException;
import com.example.test2.Exceptions.TacheNotFoundException;
import com.example.test2.Models.Tache;

import java.util.List;

public interface InterTacheService {

    public Tache getTacheById(long id) throws TacheNotFoundException;


    public List<Tache> getTaches();

    public void removeTachesOfProjet(long projet_id);

    public Tache ajouterTacheToProjet(Tache tache ) throws ProjectNotFoundException;
}
