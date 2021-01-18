--DOMINIOS NECESARIOS 

CREATE DOMAIN dom_descripcion AS VARCHAR(30);
CREATE DOMAIN dom_nombre AS VARCHAR(30);
CREATE DOMAIN dom_fechas AS DATE;
--1)------------------------------TABLA UNIDADES---------------------------------------------
CREATE TABLE unidades(
	codunidades VARCHAR(8) NOT NULL,
	nombreu dom_nombre NOT NULL,
	c_costo VARCHAR(20) NOT NULL
);
ALTER TABLE unidades 
ADD CONSTRAINT PK_codUnidades 
PRIMARY KEY(codunidades);

ALTER TABLE unidades
ADD CONSTRAINT UQ_nombreu
UNIQUE(nombreu);

--2)------------------------TABLA LINEAS---------------------------------------------------
CREATE TABLE lineas(
	codlineas VARCHAR(8) NOT NULL,
	descripcionl dom_descripcion NOT NULL
);
ALTER TABLE lineas 
ADD CONSTRAINT PK_codLineas 
PRIMARY KEY(codlineas);

ALTER TABLE lineas 
ADD CONSTRAINT UQ_descripcionL 
UNIQUE(descripcionl);

--3)--------------------------------TABLA ITEMS----------------------------------------------------------
CREATE TABLE items(
	coditem VARCHAR(8) NOT NULL,
	nombrei VARCHAR(20) NOT NULL,
	descripcioni dom_descripcion NOT NULL,
	umedida CHAR(3) NOT NULL,
	preciou FLOAT NOT NULL,
	codlineas VARCHAR(8) NOT NULL --FK
);

ALTER TABLE items 
ADD CONSTRAINT PK_coditem 
PRIMARY KEY(coditem);

ALTER TABLE items 
ADD CONSTRAINT FK_codlineas
FOREIGN KEY(codlineas) 
REFERENCES lineas(codlineas)
ON DELETE NO ACTION 
ON UPDATE CASCADE;

--4)-------------------------TABLA PROVEEDORES-------------------------------------------------
CREATE TABLE proveedores(
	rif INT NOT NULL,
	r_social VARCHAR(30) NOT NULL,
	direccion VARCHAR(60)
);

ALTER TABLE proveedores 
ADD CONSTRAINT PK_rif 
PRIMARY KEY(rif);

ALTER TABLE proveedores 
ADD CONSTRAINT UQ_r_social 
UNIQUE(r_social);

--5)---------------------------CORREOS DE LOS PROVEEDORES----------------------------------------------

CREATE TABLE correos( 
	rifproveedor INT NOT NULL, --FK
	correo VARCHAR(40) NOT NULL
);

ALTER TABLE correos 
ADD CONSTRAINT PK_rif_correo 
PRIMARY KEY(rifproveedor,correo);

ALTER TABLE correos
ADD CONSTRAINT FK_rifproveedor
FOREIGN KEY(rifproveedor)
REFERENCES proveedores(rif)
ON DELETE NO ACTION
ON UPDATE CASCADE;

--6)----------------------------TELEFONOS DE LOS PROVEEDORES-------------------------------------------

CREATE TABLE telefonos(
	rifproveedor INT NOT NULL, --FK
	telefonos VARCHAR(11) NOT NULL 
);

ALTER TABLE telefonos 
ADD CONSTRAINT PK_rif_telefonos 
PRIMARY KEY(rifproveedor,telefonos);

ALTER TABLE telefonos
ADD CONSTRAINT FK_rif_proveedor
FOREIGN KEY(rifproveedor)
REFERENCES proveedores(rif)
ON DELETE NO ACTION
ON UPDATE CASCADE;

--7)----------------------LINEAS QUE SUMINISTRAN LOS PROVEEDORES--------------------------

CREATE TABLE suministran(
	rifproveedor INT NOT NULL, --FK
	codlineas VARCHAR(8) NOT NULL --FK
);

ALTER TABLE suministran 
ADD CONSTRAINT PK_rifproveedor_codlineas
PRIMARY KEY(rifproveedor,codlineas);

ALTER TABLE suministran
ADD CONSTRAINT FK_rif_proveedor_1
FOREIGN KEY(rifproveedor)
REFERENCES proveedores(rif)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE suministran
ADD CONSTRAINT FK_codlineas_1
FOREIGN KEY(codlineas)
REFERENCES lineas(codlineas)
ON DELETE NO ACTION
ON UPDATE CASCADE;

--8)----------------------- TABLA DE EMPLEADOS--------------------------------------------

CREATE TABLE empleados(
	cedula INT NOT NULL,
	nombre dom_nombre NOT NULL,
	tipoe CHAR(1) NOT NULL,
	codunidades VARCHAR(8) NOT NULL --FK
);



ALTER TABLE empleados 
ADD CONSTRAINT PK_cedula 
PRIMARY KEY(cedula);

ALTER TABLE empleados
ADD CONSTRAINT FK_codunidades 
FOREIGN KEY (codunidades)
REFERENCES unidades(codunidades);

ALTER TABLE empleados 
ADD CONSTRAINT CK_tipoE 
CHECK(tipoe = 'J' or tipoe = 'D'); --J: Jefe, D: director

--9)-------------------------TABLA DE JEFES------------------------------------------------------------

CREATE TABLE jefes(
	fichaj INT NOT NULL --FK
);

ALTER TABLE jefes 
ADD CONSTRAINT PK_jefes 
PRIMARY KEY(fichaj);

ALTER TABLE jefes
ADD CONSTRAINT FK_jefes
FOREIGN KEY(fichaj)
REFERENCES empleados(cedula);

--10)-------------------------TABLA DE DIRECTORES FINANCIERO-----------------------------------------------

CREATE TABLE directores(
	fichad INT NOT NULL --FK
);

ALTER TABLE directores 
ADD CONSTRAINT PK_fichad
PRIMARY KEY(fichad);

ALTER TABLE directores
ADD CONSTRAINT FK_fichad
FOREIGN KEY(fichad)
REFERENCES empleados(cedula);

--11)------------------------------REQUISICIONES DE LAS UNIDADES--------------------------------------------

CREATE TABLE requisiciones(
	nrorequisicion SERIAL NOT NULL,
	f_emision dom_fechas NOT NULL,
	cotizada CHAR(1),
	codunidades VARCHAR(8) NOT NULL, --FK
	ficha_director INT NOT NULL, --FK
	ficha_jefeu INT NOT NULL,  --FK
	codlineas VARCHAR(8) NOT NULL --FK
);
--NOTA: EL ATRIBUTO TOTAL DEBE SER UN ATRIBUTO CALCULADO

ALTER TABLE requisiciones
ADD CONSTRAINT PK_nrorequisicion
PRIMARY KEY(nrorequisicion);

ALTER TABLE requisiciones
ADD CONSTRAINT FK_codunidades
FOREIGN KEY(codunidades)
REFERENCES unidades(codunidades)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE requisiciones
ADD CONSTRAINT FK_ficha_director_financiero
FOREIGN KEY(ficha_director)
REFERENCES directores(fichad)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE requisiciones
ADD CONSTRAINT FK_ficha_jefe_unidad
FOREIGN KEY(ficha_jefeu)
REFERENCES jefes(fichaj)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE requisiciones
ADD CONSTRAINT FK_codlineas_2
FOREIGN KEY(codlineas)
REFERENCES lineas(codlineas)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE requisiciones
ADD CONSTRAINT CK_cotizada
CHECK (cotizada='S' or cotizada='N');

--12)--------------------------DETALLES DE LA REQUISICION-----------------------------------------

CREATE TABLE detalles_requisicion(
	nrorequisicion SERIAL NOT NULL, --FK
	coditem VARCHAR(8) NOT NULL, --FK
	cantidad INT NOT NULL,
	precioAprox FLOAT NOT NULL
);

ALTER TABLE detalles_requisicion
ADD CONSTRAINT PK_nroconReq_coditem
PRIMARY KEY(nrorequisicion,coditem);


ALTER TABLE detalles_requisicion
ADD CONSTRAINT FK_nrorequisicion_detalles
FOREIGN KEY(nrorequisicion)
REFERENCES requisiciones(nrorequisicion)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE detalles_requisicion
ADD CONSTRAINT FK_coditem_detalle
FOREIGN KEY(coditem)
REFERENCES items(coditem)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE detalles_requisicion
ADD CONSTRAINT CK_cantidad
CHECK (cantidad>=0);


--13)---------------------------COTIZACIONES DE LA REQUISICION---------------------------------------------

CREATE TABLE cotizaciones(
	codigocot VARCHAR(8) NOT NULL,
	f_emision dom_fechas NOT NULL,
	observaciones VARCHAR(100),
	codlineas VARCHAR(8) NOT NULL, --FK 
	rifproveedor INT NOT NULL --FK
);

ALTER TABLE cotizaciones
ADD CONSTRAINT PK_codigocot
PRIMARY KEY(codigocot);

ALTER TABLE cotizaciones
ADD CONSTRAINT FK_codlineas_cot
FOREIGN KEY(codlineas)
REFERENCES lineas(codlineas)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE cotizaciones
ADD CONSTRAINT FK_codProveedor_3
FOREIGN KEY(rifproveedor)
REFERENCES proveedores(rif)
ON DELETE NO ACTION
ON UPDATE CASCADE;

--14)---------------------------DETALLES COTIZACIONES--------------------------------------------------------

CREATE TABLE detalles_cotizacion(
	codigocot VARCHAR(8) NOT NULL, --FK
	nrorequisicion SERIAL NOT NULL, --FK
	coditem VARCHAR(8) NOT NULL, --FK
	rifproveedor INT NOT NULL, --FK
	condicionesc VARCHAR(80), 
	precioa FLOAT,
	cantidada INT
);

ALTER TABLE detalles_cotizacion
ADD CONSTRAINT PK_codcot_nreq_coditem_rifprov
PRIMARY KEY(codigocot,nrorequisicion,coditem,rifproveedor);

ALTER TABLE detalles_cotizacion
ADD CONSTRAINT FK_codcot_2
FOREIGN KEY(codigocot)
REFERENCES cotizaciones(codigocot)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE detalles_cotizacion
ADD CONSTRAINT FK_nrorequisicion_coditem_detcot
FOREIGN KEY(nrorequisicion,coditem)
REFERENCES detalles_requisicion(nrorequisicion,coditem)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE detalles_cotizacion
ADD CONSTRAINT FK_proveedor_detcot
FOREIGN KEY(rifproveedor)
REFERENCES proveedores(rif)
ON DELETE NO ACTION
ON UPDATE CASCADE;


--15)-----------------------------ORDENES DE COMPRA---------------------------------------------------

CREATE TABLE ordenes(
	nroorden VARCHAR(6) NOT NULL,
	f_orden dom_fechas NOT NULL,
	tipom CHAR(1) NOT NULL, -- D: dolares , B: bolivares 
	f_entrega dom_fechas,
	condicionp CHAR(1) NOT NULL, -- E: efectivo , T: transferencia
	rifproveedor INT NOT NULL, --FK
	ficha_director INT NOT NULL --FK
);



ALTER TABLE ordenes
ADD CONSTRAINT PK_nroorden
PRIMARY KEY(nroorden);

ALTER TABLE ordenes
ADD CONSTRAINT FK_rifproveedor_3
FOREIGN KEY(rifproveedor)
REFERENCES proveedores(rif)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE ordenes
ADD CONSTRAINT FK_ficha_director_3
FOREIGN KEY(ficha_director)
REFERENCES directores(fichad)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE ordenes
ADD CONSTRAINT CK_TipoM
CHECK(tipom='D' or tipom='B');

ALTER TABLE ordenes
ADD CONSTRAINT CK_condicionp
CHECK(condicionp='E' or condicionp='T');

--16)----------------------------DETALLES DE ORDENES DE COMPRA-------------------------------------------

CREATE TABLE detalles_compra(
	nroorden VARCHAR(6) NOT NULL, --FK
	codigocot VARCHAR(8) NOT NULL, --FK
	nrorequisicion SERIAL NOT NULL, --FK
	coditem VARCHAR(8) NOT NULL, --FK
	rifproveedor INT NOT NULL --FK
);

--NOTA: La variable total es una variable calculada

ALTER TABLE detalles_compra
ADD CONSTRAINT PK_nroordn_codcot_nroreq_coditem_rif_detcomp
PRIMARY KEY(nroorden,codigocot,nrorequisicion,coditem,rifproveedor);

ALTER TABLE detalles_compra
ADD CONSTRAINT FK_nroorden_detcomp
FOREIGN KEY(nroorden)
REFERENCES ordenes(nroorden)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE detalles_compra
ADD CONSTRAINT FK_codcot_nroreq_coditem_rifp_detcomp
FOREIGN KEY(codigocot,nrorequisicion,coditem,rifproveedor)
REFERENCES detalles_cotizacion(codigocot,nrorequisicion,coditem,rifproveedor)
ON DELETE NO ACTION
ON UPDATE CASCADE;


