package com.example.authservice.Sec.Service;

import com.example.authservice.Sec.Entities.AppRole;
import com.example.authservice.Sec.Entities.AppUser;
import com.example.authservice.Sec.Repositories.AppRoleRepository;
import com.example.authservice.Sec.Repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Car c'est un service
@Service
//Permet de donner un attribut qu'est log qui permet de loguer
@Slf4j
//Pour raison de securité @Autowired n'est pas recomandée
@AllArgsConstructor
//Spring qui va gérer les transactions
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public AppUser addNewUser(AppUser appUser) {
        String pw=appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
       return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
          AppUser appUser=appUserRepository.findByUsername(username);
          if (appUser==null) throw new RuntimeException("User not found");
          AppRole appRole=appRoleRepository.findByRoleName(roleName);
         if (appRole==null) throw new RuntimeException("Role not found");
          appUser.getAppRoles().add(appRole);
          //c'est pas l'appel de faire save car c'est transactionnel
    }

    @Override
    public AppUser loadUserByUserName(String username) {

        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
}
