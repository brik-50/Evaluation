package com.example.test2.Services.Impl;

import com.example.test2.Exceptions.ProjectNotFoundException;
import com.example.test2.Exceptions.UserNotFoundException;
import com.example.test2.Models.Projet;
import com.example.test2.Models.User;
import com.example.test2.Repos.ProjetRepo;
import com.example.test2.Repos.UserRepo;
import com.example.test2.Services.InterProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetService implements InterProjetService {


    @Autowired
    private ProjetRepo projetRepo;

    @Autowired
    private UserRepo userRepo;
    @Override
    public Projet getProjetById(long id) throws ProjectNotFoundException {

        Optional<Projet> projet= projetRepo.findById(id);
        if(projet.isPresent()){
            return projet.get();
        }else{
            throw new ProjectNotFoundException("user not found with id ="+id);
        }

    }

    @Override
    public List<Projet> getProjets() {
        return projetRepo.getProjets();
    }



    @Override
    public Projet addProjetToUser(Projet projet, long id_user) throws UserNotFoundException {
       Optional<User> user = userRepo.findById(id_user);

        if(user.isPresent()){
           return projetRepo.save(projet);
        }else{
            throw new UserNotFoundException("user not found "+ id_user);
        }


    }
}
