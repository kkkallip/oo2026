package net.kkkallip.film.repository;

import net.kkkallip.film.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

//repository > andmebaasiga suhtlemiseks, tema sees on koik funktsioonid, mida on voimalik andmebaasiga teha

public interface MovieRepository extends JpaRepository<Movie,Long> {

}