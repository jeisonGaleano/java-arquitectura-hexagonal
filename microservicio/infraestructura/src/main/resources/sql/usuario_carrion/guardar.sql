insert into usuario_carrion (identificacion, nombre, apellido,usuario,clave, edad, tipo_rol, ciudad_residencia, correo_electronico, fecha_creacion) values (:identificacion, :nombre, :apellido, :usuario, :clave, :edad,:tipoRol, :ciudadResidencia, :correoElectronico, now())