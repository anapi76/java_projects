package com.microservice.user.microserviceuser.dataSQL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.microservice.user.microserviceuser.persistence.DAO.iRoleDAO;
import com.microservice.user.microserviceuser.persistence.DAO.iUserDAO;
import com.microservice.user.microserviceuser.persistence.entities.RoleEntity;
import com.microservice.user.microserviceuser.persistence.entities.UserEntity;

@Component
public class InitialData implements CommandLineRunner {

    private iUserDAO userDao;
    private iRoleDAO roleDao;

    public InitialData(iUserDAO userDao, iRoleDAO roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Roles and users inserted...");

        RoleEntity roleUser = roleDao.save(new RoleEntity("USER"));
        RoleEntity roleAdmin = roleDao. save(new RoleEntity("ADMIN"));

        userDao.save(new UserEntity("ana", "abp", "ana@gmail.com",
                "$2a$10$l1QcFcgeVVN.1c/LIAkVmulnBJfeypbhKvOquqEAicoEljEiWkr1G", roleAdmin));
        userDao.save(new UserEntity("hugo", "hgp","hgp@gmail.com",
                "$2a$10$l1QcFcgeVVN.1c/LIAkVmulnBJfeypbhKvOquqEAicoEljEiWkr1G", roleUser));
       
    }

}
