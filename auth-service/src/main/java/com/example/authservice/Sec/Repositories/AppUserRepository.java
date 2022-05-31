package com.example.authservice.Sec.Repositories;
import com.example.authservice.Sec.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
      AppUser findByUsername(String username);
}
