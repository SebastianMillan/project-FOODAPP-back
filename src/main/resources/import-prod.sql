INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed68', 'sebas01','1234', 'Sebastián Millán', 'sebastian@gmail.com','334554666', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO CLIENTE (id, pin, direccion, cod_postal, poblacion, provincia, puntos) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed68','1111','C/Muhalcen nº43', '44344', 'Bollullos de la Mitación','Sevilla',100);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (2,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbed68');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed61', 'fernando01','1234', 'Fernando Claro', 'fernando@gmail.com','112332112', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO CLIENTE (id, pin, direccion, cod_postal, poblacion, provincia, puntos) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed61','2222','C/Pajaro nº33', '41414', 'San Juan','Sevilla',200);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (2,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbed61');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed22', 'pedro01','1234', 'Pedro Franch', 'pedro@gmail.com','556554222', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO CLIENTE (id, pin, direccion, cod_postal, poblacion, provincia, puntos) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed22','333','C/Aviación nºqw', '22333', 'Triana','Sevilla',120);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (2,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbed22');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77', 'luismi01','1234', 'Luis Miguel López', 'lm@gmail.com','443221332', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77','1999-06-30',1);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbed77');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed55', 'miguel01','1234', 'Miguel Campos', 'miguel@gmail.com','443778999', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed55','1922-09-12',2);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (1,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbed55');

INSERT INTO USUARIO (id, username, password, nombre, email, telefono, avatar, account_non_expired, account_non_locked,credentials_non_expired, enabled) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed99', 'angel01','1234', 'Angel', 'angel@gmail.com','333223311', 'https://media.istockphoto.com/id/92044396/es/foto/rana-con-gafas-de-sol.jpg?s=170667a&w=0&k=20&c=jEh4ZMUWU9Y3gx5odmT-LmbCGymtiBVzzEPerkawqm0=', true, true, true, true);
INSERT INTO TRABAJADOR (id, fecha_nacimiento, tipo_trabajador) VALUES ('1ce9c1c7-7a02-4c7f-bf69-6d0306cbed99','1995-11-11',0);
INSERT INTO USUARIO_ROLES (roles, usuario_id) VALUES (0,'1ce9c1c7-7a02-4c7f-bf69-6d0306cbed99');
