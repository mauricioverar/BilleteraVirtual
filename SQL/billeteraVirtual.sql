-- crea basedato
create database if not exists billeteraVirtual;
-- usar basedato
use billeteraVirtual;


-- DDL *****
-- Crear tablas en la basedato billeteraVirtual *****
-- crea tabla monedas
create table if not exists monedas (
  idCurrency int primary key auto_increment,
  currency_name varchar(10) not null,
  currency_symbol varchar(3) not null
);
-- crea tabla usuarios
create table if not exists usuarios (
  idUsuario int primary key auto_increment,
  nombreUsuario varchar(45) not null,
  correoUsuario varchar(45) not null,
  claveUsuario varchar(45) not null,
  saldoUsuario double default 5000
);
-- crea tabla transacciones
create table if not exists transacciones (
  idTransaccion int primary key auto_increment,
  sender_user_id int not null references usuarios(idUsuario),
  receiver_user_id int not null references usuarios(idUsuario),
  importe double not null,
  tipo_moneda varchar(3) references monedas(currency_symbol),
  fechaTransaccion date not null
);
-- crea tabla intermedia monedas_has_transaccion
create table if not exists monedas_has_transacciones (
  moneda_idCurrency int not null,
  transaccion_idTransaccion int not null,
  primary key (
    moneda_idCurrency,
    transaccion_idTransaccion
  )
);
 
 
-- Ingresar datos a la basedato billeteraVirtual *****
-- ingresar datos a tabla moneda
insert into
  monedas (currency_name, currency_symbol) 
  values ('dolares', 'usd'),
		('euros', 'eur'),
        ('pesos', 'clp')
  ;
-- ingresar datos a tabla usuarios
insert into
  usuarios (nombreUsuario, correoUsuario, claveUsuario)
values
  ('Andrea', 'and@gmail.com', 'and123'),
  ('Braulio', 'bra@gmail.com', 'bra123'),
  ('Carlos', 'car@gmail.com', 'car123'),
  ('Daniela', 'dan@gmail.com', 'dan123'),
  ('Emma', 'emm@gmail.com', 'emm123');
-- ingresar datos a tabla transacciones
insert into
  transacciones (
    sender_user_id,
    receiver_user_id,
    importe,
    fechaTransaccion
  )
values
  (1, 3, 1000, '2022-02-02'),
  (2, 4, 1000, '2023-03-03'),
  (5, 1, 1000, '2024-04-04')
;
-- ingresar datos a tabla monedas_has_transacciones
insert into
  monedas_has_transacciones (
    moneda_idCurrency,
    transaccion_idTransaccion
  )
values
  (2, 1),
  (3, 2),
  (1, 3);


-- Consultas a la basedato billeteraVirtual *****
-- usar basedato
use billeteraVirtual;
-- ver tabla moneda
select  * from  monedas;
-- ver tabla usuarios
select  * from  usuarios;
-- ver tabla transacciones
select  * from  transacciones;
-- ver tabla monedas_has_transacciones
select  * from  monedas_has_transacciones;

/* Consulta para obtener el nombre de la moneda elegida por un usuario específico */
SELECT
  nombreUsuario as Nombre_Usuario,
  currency_name AS Nombre_Moneda_Elegida
FROM
  usuarios
  inner join transacciones on usuarios.idUsuario = transacciones.sender_user_id
  inner join monedas_has_transacciones on transacciones.idTransaccion = monedas_has_transacciones.transaccion_idTransaccion
  inner join monedas on monedas_has_transacciones.moneda_idCurrency = monedas.idCurrency
where
  usuarios.idUsuario = (5); -- Emma	dolares
  
/* consulta para obtener las transacciones realizadas por un usuario  específico */
SELECT
nombreUsuario as Nombre,
count(sender_user_id) as Transacciones_Realizadas
FROM
  usuarios
  inner join transacciones on usuarios.idUsuario = transacciones.sender_user_id
where
  usuarios.idUsuario = 1; -- Andrea	1

/* Consulta para obtener todos los usuarios registrados */
select
  nombreUsuario as Nombre_usuarios_registrados
from
  usuarios; -- Andrea Braulio Carlos Daniela Emma

/* Consulta para obtener todas las monedas registradas */
select
  currency_name as Nombre_Moneda
from
  monedas
order by
  currency_name asc; -- Dolar Euro Peso
  
/* Consulta para obtener todas las transacciones registradas */
select
  *
from
  transacciones;
  
/* Consulta para obtener todas las transacciones recibidas por un usuario específico */
SELECT
  nombreUsuario as Nombre,
count(receiver_user_id) as Transacciones_Recibidas
FROM
  usuarios
  inner join transacciones on usuarios.idUsuario = transacciones.receiver_user_id
where
  usuarios.idUsuario = 3; -- Carlos	1
  
-- DML *****
/* Sentencia DML para modificar el campo correo electrónico de un usuario específico */
UPDATE
  usuarios
SET
  correoUsuario = "ema@gmail.com"
WHERE
  idUsuario = 5;

/* Sentencia para eliminar los datos de una transacción (eliminado de la fila completa) */
DELETE FROM
  transacciones
WHERE
  idTransaccion = 2;
  
/* Sentencia para DDL modificar el nombre de la columna correo_electronico por email */
ALTER TABLE  usuarios RENAME COLUMN correoUsuario to email;