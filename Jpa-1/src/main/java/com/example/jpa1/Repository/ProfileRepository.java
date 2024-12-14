package com.example.jpa1.Repository;

import com.example.jpa1.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {

    Profile findProfileById(Integer id);
}
