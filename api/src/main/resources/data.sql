INSERT INTO type_product (name) VALUES
    ('FOOD'),
    ('ELECTRONIC'),
    ('HYGIENIC');

INSERT INTO product (name, description, price, stock, type_product) VALUES
    ('Macarrones', 'Pasta con huevo', 1.39, 100,1),
    ('Ordenador', 'Ordenador portatil', 1000, 50,2),
    ('Desodorante', 'Desodorante mujer', 2.30, 60,3);

INSERT INTO roles (name) VALUES ('ADMIN'),('USER');

INSERT INTO users (user_name,password,role_id,is_enabled,account_no_expired,account_no_locked,credential_no_expired) VALUES ('ana','$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC',1,true,true,true,true),('hugo','$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC',2,true,true,true,true);

