package com.microservice.auth.microserviceauth.dataSQL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.microservice.auth.microserviceauth.entity.AuthUserEntity;
import com.microservice.auth.microserviceauth.entity.RoleEntity;
import com.microservice.auth.microserviceauth.persistance.DAO.iAuthUserDAO;
import com.microservice.auth.microserviceauth.persistance.DAO.iRoleDAO;

@Component
public class InitialData implements CommandLineRunner {

    private iRoleDAO roleDao;
    private iAuthUserDAO authUserDao;

    public InitialData(iRoleDAO roleDao, iAuthUserDAO authUserDao) {
        this.roleDao = roleDao;
        this.authUserDao = authUserDao;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Roles and users inserted...");

        RoleEntity roleUser = roleDao.save(new RoleEntity("USER"));
        RoleEntity roleAdmin = roleDao.save(new RoleEntity("ADMIN"));

        authUserDao.save(new AuthUserEntity("abp",
                "$2a$10$l1QcFcgeVVN.1c/LIAkVmulnBJfeypbhKvOquqEAicoEljEiWkr1G", roleAdmin));
        authUserDao.save(new AuthUserEntity("hgp",
                "$2a$10$l1QcFcgeVVN.1c/LIAkVmulnBJfeypbhKvOquqEAicoEljEiWkr1G", roleUser));
    }

}
