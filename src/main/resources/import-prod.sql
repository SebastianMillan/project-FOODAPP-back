--CLIENTES
INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed68', 'sebas01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Sebastián Millán', 'sebastian@gmail.com','334554666', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO CLIENTE (id, pin, direccion, cod_postal, poblacion, provincia, puntos) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed68','1111','C/Muhalcen nº43', '44344', 'Bollullos de la Mitación','Sevilla',100);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (2,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbed68');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed61', 'fernando01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Fernando Claro', 'fernando@gmail.com','112332112', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO CLIENTE (id, pin, direccion, cod_postal, poblacion, provincia, puntos) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed61','2222','C/Pajaro nº33', '41414', 'San Juan','Sevilla',200);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (2,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbed61');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed22', 'pedro01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Pedro Franch', 'pedro@gmail.com','556554222', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO CLIENTE (id, pin, direccion, cod_postal, poblacion, provincia, puntos) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed22','333','C/Aviación nºqw', '22333', 'Triana','Sevilla',120);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (2,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbed22');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77', 'luismi01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Luis Miguel López', 'lm@gmail.com','443221332', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77','1999-06-30',1);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed55', 'miguel01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Miguel Campos', 'miguel@gmail.com','443778999', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed55','1922-09-12',2);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbed55');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed99', 'angel01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Angel', 'angel@gmail.com','333223311', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed99','1995-11-11',0);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (0,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbed99');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('95be9812-3bae-43ca-b3bc-31ee702247dd', 'ant01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Antonio Abascal', 'antonio@gmail.com','332112879', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO CLIENTE (id, pin, direccion, cod_postal, poblacion, provincia, puntos) VALUES ('95be9812-3bae-43ca-b3bc-31ee702247dd','123','C/Arroyo nº23', '445443', 'San Juan','Sevilla',190);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (2,'95be9812-3bae-43ca-b3bc-31ee702247dd');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('95be9812-3bae-43ca-b3bc-31ee702247ee', 'marco01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Marco Rubens', 'marco@gmail.com','434434434', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO CLIENTE (id, pin, direccion, cod_postal, poblacion, provincia, puntos) VALUES ('95be9812-3bae-43ca-b3bc-31ee702247ee','331','C/Magallanes nº23', '45443', 'Mairena del Aljarafe','Sevilla',145);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (2,'95be9812-3bae-43ca-b3bc-31ee702247ee');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('95be9812-3bae-43ca-b3bc-31ee702247ff', 'cristian01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Cristian Ruiz', 'cristian@gmail.com','86857843', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO CLIENTE (id, pin, direccion, cod_postal, poblacion, provincia, puntos) VALUES ('95be9812-3bae-43ca-b3bc-31ee702247ff','342','C/Orilluela nº55', '444441', 'Pilas','Sevilla',145);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (2,'95be9812-3bae-43ca-b3bc-31ee702247ff');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('cf5fdd22-60f4-4ad9-9a3c-0afd65f3b204', 'carlos01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Carlos Molina', 'carlos@gmail.com','545222767', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO CLIENTE (id, pin, direccion, cod_postal, poblacion, provincia, puntos) VALUES ('cf5fdd22-60f4-4ad9-9a3c-0afd65f3b204','129','C/Morera nº51', '32132166', 'Valencina','Sevilla',145);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (2,'cf5fdd22-60f4-4ad9-9a3c-0afd65f3b204');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('9d027c06-1ae7-4e3c-b3fa-f0186c875c6e', 'tomas01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Tomas Rebolledo', 'tomas@gmail.com','455443128', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO CLIENTE (id, pin, direccion, cod_postal, poblacion, provincia, puntos) VALUES ('9d027c06-1ae7-4e3c-b3fa-f0186c875c6e','129','C/Nazaret nº51', '1231234', 'Olivares','Sevilla',122);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (2,'9d027c06-1ae7-4e3c-b3fa-f0186c875c6e');

--COCINEROS
INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('cb63f0d7-cb98-4e46-b399-a189bfd3f103', 'luisma01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Luis Miguel López', 'lm@gmail.com','443221332', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('cb63f0d7-cb98-4e46-b399-a189bfd3f103','1999-06-30',1);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'cb63f0d7-cb98-4e46-b399-a189bfd3f103');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbe529', 'alvaro01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Alvaro López', 'alvaro@gmail.com','878787878', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbe529','1991-03-30',1);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbe529');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbe555', 'pepe01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Pepe Broncano', 'pepe@gmail.com','123456789', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbe555','1991-02-04',1);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbe555');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('b1a5ae54-9942-46b0-8976-cf6f763670a5', 'josefa01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Jose Francisca', 'josefa@gmail.com','65923472', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('b1a5ae54-9942-46b0-8976-cf6f763670a5','2001-12-14',1);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'b1a5ae54-9942-46b0-8976-cf6f763670a5');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbeabc', 'josefina01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Jose Francisca', 'josefa@gmail.com','65923472', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbeabc','2001-12-14',1);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbeabc');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbebcd', 'joseca01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Jose Carlos Moro', 'joseca@gmail.com','454223010', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbebcd','2000-10-24',1);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbebcd');

--REPARTIDORES
INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbe456', 'miguel02','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Miguel Campos', 'miguel@gmail.com','443778999', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbe456','1922-10-15',2);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbe456');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbe234', 'jose01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Jose Manuel Claro Campos', 'jose@gmail.com','889445777', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbe234','1922-02-01',2);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbe234');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed03', 'raul01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Raul Mingueza', 'raul@gmail.com','91928372', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed03','1922-03-20',2);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbed03');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('4bae7a13-1bb0-4aaa-a551-026442a3188b', 'maria01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Maria Bernal', 'maria@gmail.com','657657888', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('4bae7a13-1bb0-4aaa-a551-026442a3188b','1972-05-22',2);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'4bae7a13-1bb0-4aaa-a551-026442a3188b');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('da8ac66d-c0fd-4153-8b6e-20aa86d4b4f1', 'cristina01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Cristina Torre', 'cristina@gmail.com','9292929291', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('da8ac66d-c0fd-4153-8b6e-20aa86d4b4f1','1989-03-13',2);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'da8ac66d-c0fd-4153-8b6e-20aa86d4b4f1');

--ADMINISTRADORES
INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('86cc45ac-7e72-40d7-b528-2863a1e2500f', 'angel02','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Angel', 'angel@gmail.com','333223311', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('86cc45ac-7e72-40d7-b528-2863a1e2500f','1995-11-11',0);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (0,'86cc45ac-7e72-40d7-b528-2863a1e2500f');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('3120f318-8a2b-4ca6-8da8-671e998db8c4', 'manolo01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Manolo Sanchez', 'manolo@gmail.com','332334111', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('3120f318-8a2b-4ca6-8da8-671e998db8c4','1991-02-12',0);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (0,'3120f318-8a2b-4ca6-8da8-671e998db8c4');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('ebc0d46c-7b76-43dd-80a4-9b35acb93324', 'ale01','{bcrypt}$2a$12$qG8MR/W6ExYtPPdpr2Ry/eEy.x30mvHWlRyLuG6fP57lCK.6Kuz.W', 'Alejandro Pepe', 'ale@gmail.com','556554445', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('ebc0d46c-7b76-43dd-80a4-9b35acb93324','1967-03-22',0);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (0,'ebc0d46c-7b76-43dd-80a4-9b35acb93324');



INSERT INTO CATEGORIA(id, nombre) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e044d', 'Hamburguesa');
INSERT INTO CATEGORIA(id, nombre) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e044e', 'Entrante');
INSERT INTO CATEGORIA(id, nombre) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e0445', 'Bebida');
INSERT INTO CATEGORIA(id, nombre) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e0446', 'Postres');
INSERT INTO CATEGORIA(id, nombre) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e0447', 'Carnes');
INSERT INTO CATEGORIA(id, nombre) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e0448', 'Montaditos');

INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0447', 'Cuarto de libra con queso', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'Jugosa carne de ternera ahumada a la plancha con queso gouda', '12', '0', '{Gocha}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0448', 'Retinta al tinto', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'Deliciosa carne madurada de vaca retinta con salsa de reducción de vino tinto', '12', '0', '{Gocha, De la tierra}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0449', 'Serranita', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'Lo mismo que un serranito pero te vamos a cobrar el doble', '15', '0', '{Sevillania}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0450', 'Hamburguesa de pavía', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'La favoria del Pali', '12', '0', '{Sevillania}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0451', 'Morcilla de caldera', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'Una de estas te hace un hombre', '12', '0', '{Otro nivel, Maribel}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0452', 'Choco frito', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'Mi huelva tiene una riaaaa...', '12', '0', '{Otro nivel, Colombina}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0453', 'Guisantes', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'Para los veganos', '12', '0', '{Vegano, verde}', '1a730d09-2667-411b-9f8d-c5cd965e044d');


INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e046f', 'Ensaladilla', 'https://www.petitchef.es/imgupl/recipe/ensaladilla-rusa--md-466471p742864.jpg', 'Enladilla de bar de toda la vida', '12', '0', '{No le digas rusa}', '1a730d09-2667-411b-9f8d-c5cd965e044e');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('2a730d09-2667-411b-9f8d-c5cd965e0454', 'Tortilla de papas', 'https://lacocinadefrabisa.lavozdegalicia.es/wp-content/uploads/2019/05/tortilla-española.jpg', 'Deliciosa tortilla de patatas casera', '10', '0', '{tortilla, patatas, cebolla por supuesto}', '1a730d09-2667-411b-9f8d-c5cd965e044e');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('3a730d09-2667-411b-9f8d-c5cd965e0455', 'Croquetas de jamón', 'https://s1.eestatic.com/2023/06/15/cocinillas/recetas/aperitivos-y-entrantes/771683179_233966774_1706x960.jpg', 'Como las de tu madre, literal porque la tenemos secuestrada', '8', '0', '{croquetas, jamón}', '1a730d09-2667-411b-9f8d-c5cd965e044e');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('4a730d09-2667-411b-9f8d-c5cd965e0456', 'Calamares a la romana', 'https://cdn.elcocinerocasero.com/imagen/receta/1000/2022-05-25-21-02-06/calamares-a-la-romana.jpeg', 'Deliciosos calamares fritos con una fina capa crujiente', '15', '0', '{calamares, fritos}', '1a730d09-2667-411b-9f8d-c5cd965e044e');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES('5a730d09-2667-411b-9f8d-c5cd965e0457', 'Patatas bravas', 'https://i.blogs.es/e808a3/bravas_rec/1366_2000.jpg', 'Patatas fritas con salsa brava y alioli', '9', '0', '{patatas, bravas}', '1a730d09-2667-411b-9f8d-c5cd965e044e');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES('6a730d09-2667-411b-9f8d-c5cd965e0458', 'Pimientos de Padrón', 'https://www.lavanguardia.com/uploads/2017/07/06/5e9979e75c668.jpeg', 'Unos pican y otros también', '7', '0', '{pimientos, Padrón}', '1a730d09-2667-411b-9f8d-c5cd965e044e');


INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES ('7a730d09-2667-411b-9f8d-c5cd965e0459', 'Refresco de cola', 'https://isla360shop.com/wp-content/uploads/2023/03/Refresco_FREEWAY_330ml_cola_isla360shop.jpg', 'La favorita del Damer', '2.5', '0', '{refresco, cola}', '1a730d09-2667-411b-9f8d-c5cd965e0445');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES ('8a730d09-2667-411b-9f8d-c5cd965e0460', 'Agua mineral', 'https://www.pineo.cat/wp-content/uploads/Fillico-Juweel-water2.jpg', 'Agua mineral natural embotellada', '1.5', '0', '{agua, mineral}', '1a730d09-2667-411b-9f8d-c5cd965e0445');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES ('9a730d09-2667-411b-9f8d-c5cd965e0461', 'Cerveza Lager', 'https://www.odibo.es/locales/145/15907629361256051862.jpg', 'Cerveza Lager ligera y refrescante', '3', '0', '{cerveza, Lager}', '1a730d09-2667-411b-9f8d-c5cd965e0445');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e0462', 'Vino tinto', 'https://www.dia.es/product_images/35430/35430_ISO_0_ES.jpg?imwidth=1200', 'Vino tinto de calidad, ideal para maridar con carnes', '5', '0', '{vino, tinto}', '1a730d09-2667-411b-9f8d-c5cd965e0445');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e0463', 'Café espresso', 'https://cafesnovell.com/wp-content/uploads/2019/10/5000.jpg', 'Café espresso intenso y aromático', '2.5', '0', '{café, espresso}', '1a730d09-2667-411b-9f8d-c5cd965e0445');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e0464', 'Agua con gas', 'https://acre.tienda/353-large_01oslo/agua-con-gas-san-pellegrino.jpg', 'Agua mineral con gas, perfecta para acompañar tus comidas', '1.5', '0', '{agua, gas}', '1a730d09-2667-411b-9f8d-c5cd965e0445');


INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e0465', 'Tarta de queso', 'https://www.lakasa.es//platos/postres/Lakasa_tarta_de_queso_azul.jpg', 'Para una tarta de queso siempre hay hueco', '5', '0', '{tarta, queso}', '1a730d09-2667-411b-9f8d-c5cd965e0446');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e0466', 'Tarta de Lotus', 'https://www.annarecetasfaciles.com/files/tarta-de-queso-con-galletas-lotus.jpg', 'Para una tarta de queso siempre hay hueco', '5', '0', '{tarta, queso}', '1a730d09-2667-411b-9f8d-c5cd965e0446');

INSERT INTO PEDIDO(id, fecha, cliente, cocinero, estado_pedido, repartidor)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0466', '2023-11-28 12:30:00', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed22', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77', 'EN_CAMINO', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed55')
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0467', '1a730d09-2667-411b-9f8d-c5cd965e0466', 3, 12.0, '1a730d09-2667-411b-9f8d-c5cd965e0447')
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0468', '1a730d09-2667-411b-9f8d-c5cd965e0466', 2, 1.5, '1a730d09-2667-411b-9f8d-c5cd965e0464')

INSERT INTO PEDIDO(id, fecha, cliente, cocinero, estado_pedido, repartidor)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0467', '2023-11-28 12:30:00', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed22', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77', 'ENTREGADO', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed55')
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0469', '1a730d09-2667-411b-9f8d-c5cd965e0467', 3, 12.0, '1a730d09-2667-411b-9f8d-c5cd965e0447')

INSERT INTO PEDIDO(id, fecha, cliente, cocinero, estado_pedido, repartidor)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0468', '2023-11-28 12:30:00', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed22', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77', 'EN_CAMINO', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed55')
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0470', '1a730d09-2667-411b-9f8d-c5cd965e0468', 3, 12.0, '1a730d09-2667-411b-9f8d-c5cd965e0447')
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0471', '1a730d09-2667-411b-9f8d-c5cd965e0468', 2, 1.5, '1a730d09-2667-411b-9f8d-c5cd965e0464')

INSERT INTO PEDIDO(id, fecha, cliente, cocinero, estado_pedido, repartidor)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0420', '2023-11-28 12:30:00', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed22', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77', 'EN_PREPARACION', null)
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0470', '1a730d09-2667-411b-9f8d-c5cd965e0420', 3, 12.0, '1a730d09-2667-411b-9f8d-c5cd965e0447')
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0471', '1a730d09-2667-411b-9f8d-c5cd965e0420', 2, 1.5, '1a730d09-2667-411b-9f8d-c5cd965e0464')

INSERT INTO PEDIDO(id, fecha, cliente, cocinero, estado_pedido, repartidor)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0421', '2023-11-28 12:30:00', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed22', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77', 'ENTREGADO', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbe456');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0472', '1a730d09-2667-411b-9f8d-c5cd965e0421', 1, 8.0, '1a730d09-2667-411b-9f8d-c5cd965e0447');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0473', '1a730d09-2667-411b-9f8d-c5cd965e0421', 2, 1.0, '1a730d09-2667-411b-9f8d-c5cd965e0447');

INSERT INTO PEDIDO(id, fecha, cliente, cocinero, estado_pedido, repartidor)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0422', '2023-11-28 12:30:00', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed22', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77', 'EN_PREPARACION', null);
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0474', '1a730d09-2667-411b-9f8d-c5cd965e0422', 1, 2.0, '1a730d09-2667-411b-9f8d-c5cd965e0447');




INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('b7fa6846-8eb1-11ee-b9d1-0242ac120002', 'Hamburguesa de vacuno', 'https://cecinasllanquihue.cl/blog/wp-content/uploads/2019/04/Res-Jam%C3%B2n-Serrano-y-pi.jpg', 'Jamón Serrano y piña', '12', '0', '{Carne, Buena}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('b7fa6846-8eb1-11ee-b9d1-0242ac120003', 'Shack burger', 'https://cecinasllanquihue.cl/blog/wp-content/uploads/2019/04/Shake-Shack.jpg', ' Todas las hamburguesas de este tipo son de carne de ternera y para acompañarla, las famosas patatas fritas rizadas.', '12', '0', '{Carne, Queso}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('b7fa6846-8eb1-11ee-b9d1-0242ac120004', 'Hamburguesa clásica', 'https://cecinasllanquihue.cl/blog/wp-content/uploads/2019/04/Res-Jam%C3%B2n-Serrano-y-pi.jpg', 'Carne picada de ternera, pan humedecido en leche, huevo, tocineta de cerdo y otros condimentos constituyen la base de un excelente sabor. Esta es una hamburguesa súper jugosa que siempre va a triunfar entre quienes la prueban.', '12', '0', '{Ternera, Queso, Bacon}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('b7fa6846-8eb1-11ee-b9d1-0242ac120005', 'Hamburguesa a la ranchera', 'https://cecinasllanquihue.cl/blog/wp-content/uploads/2019/04/Res-Jam%C3%B2n-Serrano-y-pi.jpg', 'tienes que probar la hamburguesa de pollo a la ranchera, ya que es de todo menos dulce o sin sabor. La acompaña buena salsa de tomate y cebolla sofritos, además de unos frijoles y varias tiras de bacon.', '12', '0', '{Carne, Buena}', '1a730d09-2667-411b-9f8d-c5cd965e044d');

INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('b7fa6846-8eb1-11ee-b9d1-0242ac120006', 'Ensala-dilla', 'https://www.petitchef.es/imgupl/recipe/ensaladilla-rusa--md-466471p742864.jpg', 'Ensala-dilla', '12', '0', '{healthy}', '1a730d09-2667-411b-9f8d-c5cd965e044e');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('b7fa6846-8eb1-11ee-b9d1-0242ac120007', 'Cigalas con ajo y perejil', 'https://www.annarecetasfaciles.com/files/cigalas-con-ajo-y-perejil-500x281.jpg', 'No es el Cigala', '12', '0', '{fish}', '1a730d09-2667-411b-9f8d-c5cd965e044e');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('b7fa6846-8eb1-11ee-b9d1-0242ac120008', 'Huevos rellenos', 'https://www.annarecetasfaciles.com/files/huevos-con-bechamel-500x281.jpg', 'Huevos rellenos bechamel', '12', '0', '{healthy}', '1a730d09-2667-411b-9f8d-c5cd965e044e');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('b7fa6846-8eb1-11ee-b9d1-0242ac120009', 'Orejas rebozadas', 'https://www.annarecetasfaciles.com/files/maxresdefault-25-500x281.jpg', 'No son orejas de verdad xD', '12', '0', '{ricolin}', '1a730d09-2667-411b-9f8d-c5cd965e044e');

INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES ('545de668-8eb7-11ee-b9d1-0242ac120010', 'Cruzcampo', 'https://5sentidos.es/wp-content/uploads/2020/10/Cruzcampo_Cerveza_de_25_CL.jpg', 'La rubia que nunca falla', '2.5', '0', '{Sana, Elixir}', '1a730d09-2667-411b-9f8d-c5cd965e0445');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES ('545de668-8eb7-11ee-b9d1-0242ac120011', 'Nestea', 'https://thebeastburger.es/wp-content/uploads/2022/12/nestea-limon.jpg', 'Bebida para los lights', '2.5', '0', '{0 azucar}', '1a730d09-2667-411b-9f8d-c5cd965e0445');

INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES ('03be55ac-8eb8-11ee-b9d1-0242ac120012', 'Vasitos de crema', 'https://content-cocina.lecturas.com/medio/2018/07/19/vasitos-de-crema-de-queso-y-mermelada-de-tomate_3df5e88a_360x360.jpg', 'Queso y mermelada de tomate', '5', '0', '{tarta, queso, mermelada}', '1a730d09-2667-411b-9f8d-c5cd965e0446');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id) VALUES ('03be55ac-8eb8-11ee-b9d1-0242ac120013', 'Postre fresco', 'https://content-cocina.lecturas.com/medio/2023/07/21/postre-de-sandia-con-bolitas-de-queso-fresco_28c41bf7_360x360.jpg', 'Sandía y bolitas de queso', '5', '0', '{sandía, queso}', '1a730d09-2667-411b-9f8d-c5cd965e0446');

INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e043e', 'Carrillada Ibérica', 'https://www.aceitesdeolivadeespana.com/wp-content/uploads/2020/12/receta-carrillera-cerdo-iberico.jpg', 'La de Casa Oliva está increible', '4.50', '3.30', '{Carne}', '1a730d09-2667-411b-9f8d-c5cd965e0447');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0454', 'Cachopo', 'https://imag.bonviveur.com/churrasco-de-ternera-a-la-parrilla-listo-para-degustar.jpg', 'El del nuevo Casa pepe de atrás de mi casa está increible', '7', '5.50', '{Carne}', '1a730d09-2667-411b-9f8d-c5cd965e0447');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0456', 'Montadito de gambas alioli', 'https://media-cdn.tripadvisor.com/media/photo-s/0d/1a/9c/e5/montadito-de-gambas-alioli.jpg', 'El de Casa Oliva es un escándalo', '4', '2.50', '{Alioli exquisito}', '1a730d09-2667-411b-9f8d-c5cd965e0448');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0457', 'Montadito de lomo', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFwv3EPH4AYZesLIy3DHcP_vnmHfhHA09WTQ&usqp=CAU', 'El mondadito más mítico', '3.50', '2.50', '{Mítico del 100 montaditos}', '1a730d09-2667-411b-9f8d-c5cd965e0448');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0458', 'Petisui', 'https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/202201/25/00118821000306____29__600x600.jpg', 'Petisui de toda la vida', '1', '0.50', '{Para que crezca el niño}', '1a730d09-2667-411b-9f8d-c5cd965e0446');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0459', 'Tortitas', 'https://imag.bonviveur.com/tortitas-americanas-caseras-o-pancakes.jpg', 'Tortitas buenísimas', '2', '1', '{tortitas, leche}', '1a730d09-2667-411b-9f8d-c5cd965e0446');







INSERT INTO PEDIDO(id, fecha, cliente, cocinero, estado_pedido, repartidor)VALUES('1a730d09-2667-411b-9f8d-c5cd965e022d', '2023-11-28 12:30:00', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed61', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77', 'EN_PREPARACION', null);
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e05e5', '1a730d09-2667-411b-9f8d-c5cd965e022d', 1, 2.0, 'b7fa6846-8eb1-11ee-b9d1-0242ac120006');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e05f5', '1a730d09-2667-411b-9f8d-c5cd965e022d', 1, 2.0, 'b7fa6846-8eb1-11ee-b9d1-0242ac120007');

INSERT INTO PEDIDO(id, fecha, cliente, cocinero, estado_pedido, repartidor)VALUES('1a730d09-2667-411b-9f8d-c5cd965e055f', '2023-11-28 12:30:00', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed61', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77', 'EN_PREPARACION', null);
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e05e7', '1a730d09-2667-411b-9f8d-c5cd965e055f', 1, 2.0, '1a730d09-2667-411b-9f8d-c5cd965e043e');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e05fe', '1a730d09-2667-411b-9f8d-c5cd965e055f', 1, 2.0, '1a730d09-2667-411b-9f8d-c5cd965e0456');

INSERT INTO PEDIDO(id, fecha, cliente, cocinero, estado_pedido, repartidor)VALUES('1a730d09-2667-411b-9f8d-c5cd965e066d', '2023-11-28 12:30:00', '95be9812-3bae-43ca-b3bc-31ee702247dd', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77', 'EN_CAMINO', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbe456');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e05e9', '1a730d09-2667-411b-9f8d-c5cd965e066d', 1, 2.0, 'b7fa6846-8eb1-11ee-b9d1-0242ac120009');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e05fd', '1a730d09-2667-411b-9f8d-c5cd965e066d', 1, 2.0, 'b7fa6846-8eb1-11ee-b9d1-0242ac120008');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e05f1', '1a730d09-2667-411b-9f8d-c5cd965e066d', 1, 2.0, '1a730d09-2667-411b-9f8d-c5cd965e0451');

INSERT INTO PEDIDO(id, fecha, cliente, cocinero, estado_pedido, repartidor)VALUES('1a730d09-2667-411b-9f8d-c5cd965e067d', '2023-11-28 12:30:00', '95be9812-3bae-43ca-b3bc-31ee702247ff', 'b1a5ae54-9942-46b0-8976-cf6f763670a5', 'EN_CAMINO', 'da8ac66d-c0fd-4153-8b6e-20aa86d4b4f1');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e05e9', '1a730d09-2667-411b-9f8d-c5cd965e067d', 1, 2.0, 'b7fa6846-8eb1-11ee-b9d1-0242ac120005');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e05fd', '1a730d09-2667-411b-9f8d-c5cd965e067d', 1, 2.0, 'b7fa6846-8eb1-11ee-b9d1-0242ac120006');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e05f1', '1a730d09-2667-411b-9f8d-c5cd965e067d', 1, 2.0, '03be55ac-8eb8-11ee-b9d1-0242ac120013');

INSERT INTO PEDIDO(id, fecha, cliente, cocinero, estado_pedido, repartidor)VALUES('1a730d09-2667-411b-9f7d-c5cd965e067d', '2023-11-28 12:30:00', '95be9812-3bae-43ca-b3bc-31ee702247ff', 'b1a5ae54-9942-46b0-8976-cf6f763670a5', 'EN_CAMINO', 'da8ac66d-c0fd-4153-8b6e-20aa86d4b4f1');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e06e9', '1a730d09-2667-411b-9f7d-c5cd965e067d', 1, 2.0, 'b7fa6846-8eb1-11ee-b9d1-0242ac120005');

INSERT INTO PEDIDO(id, fecha, cliente, cocinero, estado_pedido, repartidor)VALUES('1a730d09-2667-411b-5f8d-c5cd965e022d', '2023-12-28 12:30:00', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed68', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbe555', 'ENTREGADO', 'da8ac66d-c0fd-4153-8b6e-20aa86d4b4f1');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e16e9', '1a730d09-2667-411b-5f8d-c5cd965e022d', 1, 2.0, 'b7fa6846-8eb1-11ee-b9d1-0242ac120005');




INSERT INTO PEDIDO(id, fecha, cliente, cocinero, estado_pedido, repartidor)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0616', '2023-11-28 12:30:00', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed22', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77', 'ENTREGADO', '1ce9c1c7-7a02-4c7f-bf69-6d0306cbe456');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0472', '1a730d09-2667-411b-9f8d-c5cd965e0616', 1, 8.0, '1a730d09-2667-411b-9f8d-c5cd965e0454');
INSERT INTO LINEA_PEDIDO(cod_linea, pedido_id, cantidad, precio_unitario, producto_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0473', '1a730d09-2667-411b-9f8d-c5cd965e0616', 2, 1.0, '1a730d09-2667-411b-9f8d-c5cd965e0458');



INSERT INTO CATEGORIA(id, nombre) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e0236', 'Carnes');
INSERT INTO CATEGORIA(id, nombre) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e04e4', 'Montaditos');

