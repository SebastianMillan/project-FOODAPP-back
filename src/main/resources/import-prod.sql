--CLIENTES
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













































































































































INSERT INTO CATEGORIA(id, nombre) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e044d', 'Hamburguesa');
INSERT INTO CATEGORIA(id, nombre) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e044e', 'Entrante');
INSERT INTO CATEGORIA(id, nombre) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e0445', 'Bebida');
INSERT INTO CATEGORIA(id, nombre) VALUES ('1a730d09-2667-411b-9f8d-c5cd965e0446', 'Postres');

INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0447', 'Cuarto de libra con queso', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'Jugosa carne de ternera ahumada a la plancha con queso gouda', '12', '0', '{Gocha}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0448', 'Retinta al tinto', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'Deliciosa carne madurada de vaca retinta con salsa de reducción de vino tinto', '12', '0', '{Gocha, De la tierra}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0449', 'Serranita', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'Lo mismo que un serranito pero te vamos a cobrar el doble', '15', '0', '{Sevillania}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0450', 'Hamburguesa de pavía', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'La favoria del Pali', '12', '0', '{Sevillania}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0451', 'Morcilla de caldera', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'Una de estas te hace un hombre', '12', '0', '{Otro nivel, Maribel}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0452', 'Choco frito', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'Mi huelva tiene una riaaaa...', '12', '0', '{Otro nivel, Colombina}', '1a730d09-2667-411b-9f8d-c5cd965e044d');
INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0453', 'Guisantes', 'https://www.cnature.es/wp-content/uploads/elementor/thumbs/hamburguesa-con-guacamole-qatb9dfxztr5an44q7dowb74i3r76ru30c25o10ymw.jpg', 'Para los veganos', '12', '0', '{Vegano, verde}', '1a730d09-2667-411b-9f8d-c5cd965e044d');


INSERT INTO PRODUCTO(id, nombre, imagen, descripcion, precio, precio_oferta, tags, categoria_id)VALUES('1a730d09-2667-411b-9f8d-c5cd965e0453', 'Ensaladilla', 'https://www.petitchef.es/imgupl/recipe/ensaladilla-rusa--md-466471p742864.jpg', 'Enladilla de bar de toda la vida', '12', '0', '{No le digas rusa}', '1a730d09-2667-411b-9f8d-c5cd965e044e');
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