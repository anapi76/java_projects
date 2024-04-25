package com.microservice.auth.microserviceauth.dataSQL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.microservice.auth.microserviceauth.entity.RoleEntity;
import com.microservice.auth.microserviceauth.persistance.DAO.iRoleDAO;

@Component
public class InitialData implements CommandLineRunner {
    
    private iRoleDAO roleDao;

    public InitialData(iRoleDAO roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Roles and users inserted...");

        roleDao.save(new RoleEntity("USER"));
        roleDao. save(new RoleEntity("ADMIN"));
       
    }

}
