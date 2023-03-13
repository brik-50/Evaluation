package com.example.test2.Repos;

import com.example.test2.Models.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TacheRepo extends JpaRepository<Tache,Long> {

    @Query(value = "SELECT * FROM tache  ORDER BY id_tache ASC;",nativeQuery = true)
    public List<Tache> getTaches();

    @Query(value = "DELETE FROM tache WHERE id_projet = :id", nativeQuery = true)
    public void removeTachesOfProjet(@Param("id") long id);









}
