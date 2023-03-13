package com.example.test2.Repos;


import com.example.test2.Models.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepo extends JpaRepository<Projet,Long> {

    @Query(value = "SELECT * FROM projet  ORDER BY projet_id ASC;",nativeQuery = true)
    public List<Projet> getProjets();













}


//private EntityManager entityManager;

//public List<Projet> rechercherProjets();

//public void sauvegarderProjet(Projet projet);


//public List<Projet> rechercherProjets() {
//        return entityManager.createQuery("SELECT p FROM Projet p ORDER BY p.id ASC", Projet.class)
//                .getResultList();
//    }


//public void sauvegarderProjet(Projet projet) {
//        entityManager.createNamedQuery("Projet.save", Projet.class)
//                .setParameter("titre", projet.getTitreProjet())
//                .setParameter("description", projet.getDescriptionProjet())
//                .setParameter("utilisateur", projet.getUser())
//                .executeUpdate();
//    }

