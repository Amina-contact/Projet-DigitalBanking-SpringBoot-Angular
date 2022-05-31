package com.example.authservice.Sec.Service;


import com.example.authservice.Sec.Entities.AppRole;
import com.example.authservice.Sec.Entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username,String roleName);
    AppUser loadUserByUserName(String username);
    List<AppUser> listUsers();
}
