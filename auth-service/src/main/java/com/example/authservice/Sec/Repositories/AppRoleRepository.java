package com.example.authservice.Sec.Repositories;
import com.example.authservice.Sec.Entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
       AppRole findByRoleName(String roleName);
}
