insert into usuario(id, nombre,clave,fecha_creacion) values(1,'test','1234',now());
insert into roles_carrion (id, nombre_rol) values (1, 'conductor');
insert into roles_carrion (id, nombre_rol) values (2, 'cliente');
insert into usuario_carrion (id,identificacion, nombre, apellido,usuario, clave, edad, tipo_rol, ciudad_residencia, correo_electronico, fecha_creacion) values (1, 1143171888, 'json', 'galeano', 'json1', '1234567', 22, 1, 'Barranquilla', 'jeiso.galeano@gmail.com', now());
insert into usuario_carrion (id,identificacion, nombre, apellido,usuario, clave, edad, tipo_rol, ciudad_residencia, correo_electronico, fecha_creacion) values (2, 1143171889, 'jeison', 'galeano', 'json2', '1234567', 22, 2, 'Barranquilla', 'jeison.galeano@gmail.com', now());
insert into tipo_vehiculo_carrion (id, nombre_tipo_vehiculo) values (1,'Turbo');
insert into vehiculo_carrion(id_conductor, placa, numero_motor, numero_chasis, toneladas, tipo_vehiculo, modelo, marca) values (1, 'QHM970', 'NHSHH112', 'HGAHU111', 10, 1, 2020, 'Nissan');
insert into vehiculo_carrion(id_conductor, placa, numero_motor, numero_chasis, toneladas, tipo_vehiculo, modelo, marca) values (1, 'QHM535', 'NHSHH1122', 'HGAHU1111', 10, 1, 2020, 'Nissan');
insert into viajes_carrion (id_usuario, id_conductor,toneladas, tipo_vehiculo, fecha_creacion, fecha_servicio, origen, destino, terminado, tipo_casa, precio) values (1, 2, 10, 1, now(), now(), 'Barranquilla', 'SantaM Marta', true, 'casa', 150000);