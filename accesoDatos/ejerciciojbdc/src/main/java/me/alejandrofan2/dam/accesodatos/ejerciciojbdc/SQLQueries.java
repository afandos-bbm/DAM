package me.alejandrofan2.dam.accesodatos.ejerciciojbdc;

public enum SQLQueries {

    CREACION("""

            --------------------- DOMINIOS -------------------------

            /* Crear un dominio para identificadores con nombre DOM_ID,
            para enteros (de 16 bits) con valores entre 0 y 1000*/

            create domain dom_id as smallint
                constraint rango_0_1000 check (value between 0 and 1000);


            /* Crear un dominio de nombre don_matricula que permita almacenar
            cadenas de 4 dígitos seguidos de 3 letras mayúscula*/

            create domain dom_matricula as text check ( value ~ '^[0-9]{4}[A-Z]{3}$');


            /* Crear un dominio cadena para cadenas de longitud 10*/

            create domain cad10 as varchar(10);



            ---------------------  TABLAS --------------------------

            /****************************************************************************
            Nombre de la tabla: BUSES
            Campos:
                1. ID_bus: DOM_id
                2. Modelo: cad10
            ***************************************************************************/

            create table BUSES (
                id_bus		Dom_Id  not null primary key,
                modelo		Cad10,
                matricula	dom_matricula
            );


            /****************************************************************************
            Nombre de la tabla: Conductores
            Campos:
                1. ID_conductor: 	DOM_id
                2. Nombre: 		cad10
                3. DNI:			cad10
            Restricciones:
                1. La clave primaria es ID_conductor
            ***************************************************************************/

            create table conductores (
                ID_conductor 	Dom_Id  not null primary key,
                Nombre		cad10 not null,
                DNI		cad10
            );


            /****************************************************************************
            Nombre de la tabla: lineas
            Campos:
                1. ID_linea: Dom_id
                1. ID_bus: DOM_id
                2. ID_conductor:DOM_id
                3. numparadas: entero de 2 Bytes con valor por defecto 0

            Restricciones:
                1. La clave primaria es ID_linea
                2. Clave ajena ID_bus a la tabla BUSES
                3. Clave ajena ID_conductor a la tabla CONDUCTORES
            ***************************************************************************/


            create table lineas (
                id_linea	Dom_id not null primary key,
                id_bus		Dom_Id not null references BUSES(id_bus),
                id_conductor	Dom_Id not null references CONDUCTORES(id_conductor),
                numparadas	smallint  default 0
            );



            /****************************************************************************
            Nombre de la tabla: PARADAS
            Campos:
                1. ID_parada: 	DOM_id
                2. Nombre:	cad10

            Restricciones:
                1. La clave primaria es ID_parada
            ***************************************************************************/


            create table paradas (
                ID_parada	Dom_id not null primary key,
                nombre		cad10
            );



            /****************************************************************************
            Nombre de la tabla: PARADAS_LINEAS
            Campos:
                1. ID_linea:		DOM_id
                2. ID_parada:	DOM_id

            Restricciones:
                1. La clave primaria es ID_linea + id_parada
                2. Claves ajenas ID_linea e id _parada a sus tablas correspondientes
            ***************************************************************************/

            create table paradas_linea (
                ID_parada	Dom_id not null references paradas,
                ID_linea	Dom_Id not null references lineas,
                primary key (id_parada,id_linea)
            );


            /************************************************************************/
            /************************** INSERCIÓN DE DATOS **************************/
            /************************************************************************/


            INSERT INTO Conductores (id_conductor,Nombre,DNI) VALUES(101,'Pepe',	'1111111');
            INSERT INTO Conductores (id_conductor,Nombre,DNI) VALUES(102,'Marta','1093992');
            INSERT INTO Conductores (id_conductor,Nombre,DNI) VALUES(103,'Luis','22222222');
            INSERT INTO Conductores (id_conductor,Nombre,DNI) VALUES(104,'Ana','1092994');
            INSERT INTO Conductores (id_conductor,Nombre,DNI) VALUES(105,'Paloma','1034995');

            INSERT INTO Buses (ID_bus,modelo, matricula) VALUES(1,'Liebre', '1234ABC');
            INSERT INTO Buses (ID_bus,modelo, matricula) VALUES(2,'Tortuga', '2460BCD');
            INSERT INTO Buses (ID_bus,modelo, matricula) VALUES(3,'Gacela', '5678CDE');
            INSERT INTO Buses (ID_bus,modelo, matricula) VALUES(4,'Caracol', '4321ABC');
            INSERT INTO Buses (ID_bus,modelo, matricula) VALUES(5,'Liebre', '8765ABC');

            INSERT INTO lineas (id_linea, id_conductor, ID_bus, numparadas) VALUES(11, 101,1,1);
            INSERT INTO lineas (id_linea, id_conductor, ID_bus, numparadas) VALUES(21,101,2,2);
            INSERT INTO lineas (id_linea, id_conductor, ID_bus) VALUES(31,101,4);
            INSERT INTO lineas (id_linea, id_conductor, ID_bus) VALUES(41,102,1);
            INSERT INTO lineas (id_linea, id_conductor, ID_bus, numparadas) VALUES(51,105,3,2);
            INSERT INTO lineas (id_linea, id_conductor, ID_bus, numparadas) VALUES(61,103,1,2);

            INSERT INTO Paradas (ID_parada, nombre) VALUES(111,'La Vall');
            INSERT INTO Paradas (ID_parada, nombre) VALUES(222,'Nules');
            INSERT INTO Paradas (ID_parada, nombre) VALUES(333,'Moncofar');
            INSERT INTO Paradas (ID_parada, nombre) VALUES(444,'Burriana');
            INSERT INTO Paradas (ID_parada, nombre) VALUES(555,'Almenara');
            INSERT INTO Paradas (ID_parada, nombre) VALUES(666,'Chilches');
            INSERT INTO Paradas (ID_parada, nombre) VALUES(777,'Mascarell');


            INSERT INTO Paradas_Linea (ID_parada, id_linea) VALUES(111, 11);
            INSERT INTO Paradas_Linea (ID_parada, id_linea) VALUES(222, 21);
            INSERT INTO Paradas_Linea (ID_parada, id_linea) VALUES(333, 21);
            INSERT INTO Paradas_Linea (ID_parada, id_linea) VALUES(444, 61);
            INSERT INTO Paradas_Linea (ID_parada, id_linea) VALUES(555, 61);
            INSERT INTO Paradas_Linea (ID_parada, id_linea) VALUES(666, 51);
            INSERT INTO Paradas_Linea (ID_parada, id_linea) VALUES(777, 51); """),
    // * MODIFICACIÓN DE LA BASE DE DATOS
    QUERY1(""),
    // * INSERCIÓN DE NUEVOS DATOS
    QUERY2(""),
    // * CONSULTA DE DATOS
    // * * CONSULTA1
    QUERY3(""),
    // * * CONSULTA2
    QUERY4(""),
    // * * CONSULTA3
    QUERY5(""),
    // * ACTUALIZACIÓN DE DATOS
    // * * CONSULTA1
    QUERY6(""),
    // * * CONSULTA2
    QUERY7("");

    private String sql;

    private SQLQueries(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
