package com.microservice.product.microserviceproduct.datSQL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.microservice.product.microserviceproduct.persistence.DAO.iProductDAO;
import com.microservice.product.microserviceproduct.persistence.DAO.iTypeProductDAO;
import com.microservice.product.microserviceproduct.persistence.entity.ProductEntity;
import com.microservice.product.microserviceproduct.persistence.entity.TypeProductEntity;

@Component
public class InitialData implements CommandLineRunner {

    private iProductDAO productDao;
    private iTypeProductDAO typeProductDao;

    public InitialData(iProductDAO productDao, iTypeProductDAO typeProductDao) {
        this.productDao = productDao;
        this.typeProductDao = typeProductDao;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Products and typesProducts inserted...");

        TypeProductEntity typeProduct1 = typeProductDao.save(new TypeProductEntity("FOOD"));
        TypeProductEntity typeProduct2 = typeProductDao.save(new TypeProductEntity("ELECTRONIC"));
        TypeProductEntity typeProduct3 = typeProductDao.save(new TypeProductEntity("HYGIENIC"));

        productDao.save(new ProductEntity("Macarrones", "Pasta con huevo", 1.39, 100,typeProduct1));
        productDao.save(new ProductEntity("Ordenador", "Ordenador portatil", 1000.0, 50,typeProduct2));
        productDao.save(new ProductEntity("Desodorante", "Desodorante mujer", 2.30, 60,typeProduct3));
    }

}