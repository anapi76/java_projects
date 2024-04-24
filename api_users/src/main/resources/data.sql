INSERT INTO roles (name) VALUES ('ADMIN'),('USER');

INSERT INTO users (username,password,email,role_id,is_enabled,account_no_expired,account_no_locked,credential_no_expired) VALUES ('ana','$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC','aaa@gmail.com',1,true,true,true,true),('hugo','$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC','aaa@gmail.com',2,true,true,true,true);

