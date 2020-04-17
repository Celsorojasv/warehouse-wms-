-- Generado por Oracle SQL Developer Data Modeler 19.4.0.350.1424
--   en:        2020-04-16 22:13:32 CST
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



CREATE TABLE bitacora (
    id_user      INTEGER NOT NULL,
    transaction  VARCHAR2(250) NOT NULL,
    table_name   VARCHAR2(50) NOT NULL,
    description  VARCHAR2(250),
    date_time    DATE NOT NULL
);

CREATE TABLE branch (
    id_branch       INTEGER NOT NULL,
    name_branch     VARCHAR2(120) NOT NULL,
    address_branch  VARCHAR2(220) NOT NULL,
    phone_branch    VARCHAR2(11) NOT NULL
);

ALTER TABLE branch ADD CONSTRAINT branch_pk PRIMARY KEY ( id_branch );

CREATE TABLE category (
    id_category  INTEGER NOT NULL,
    name         VARCHAR2(50),
    description  VARCHAR(100) 
--  ERROR: Datatype UNKNOWN is not allowed 
);

ALTER TABLE category ADD CONSTRAINT category_pk PRIMARY KEY ( id_category );

CREATE TABLE dispatch_by_warehouse (
    id_dispatch_by_warehouse  INTEGER NOT NULL,
    id_branch                 INTEGER NOT NULL,
    id_user                   INTEGER NOT NULL,
    last_sent                 DATE NOT NULL,
        CONSTRAINT branch_dispatch_fk FOREIGN KEY (id_branch) REFERENCES   Branch(id_branch),
            CONSTRAINT user_dispatch_fk FOREIGN KEY (id_user) REFERENCES   warehouse_user(id_user)


);

ALTER TABLE dispatch_by_warehouse ADD CONSTRAINT dispatch_by_warehouse_pk PRIMARY KEY ( id_dispatch_by_warehouse );

CREATE TABLE dispatch_details (
    id_dispatch               INTEGER NOT NULL,
    id_dispatch_by_warehouse  INTEGER NOT NULL,
    quantity_out              INTEGER NOT NULL,
    id_provider_by_product    INTEGER NOT NULL,
    CONSTRAINT prov_prod1_detail_fk FOREIGN KEY (id_provider_by_product) REFERENCES   provider_by_product(id_provider_by_product),
    CONSTRAINT dispatch1_detail_fk FOREIGN KEY (id_dispatch_by_warehouse) REFERENCES   dispatch_by_warehouse(id_dispatch_by_warehouse)

);

ALTER TABLE dispatch_details ADD CONSTRAINT dispatch_details1_pk PRIMARY KEY ( id_dispatch );

CREATE TABLE "Order" (
    id_order      INTEGER NOT NULL,
    date_time     DATE NOT NULL,
    total_amount  NUMBER(10, 2) NOT NULL
);

ALTER TABLE "Order" ADD CONSTRAINT order_pk PRIMARY KEY ( id_order );

CREATE TABLE order_detail (
    id_detail               INTEGER NOT NULL,
    id_provider_by_product  INTEGER NOT NULL,
    quatity_in              INTEGER NOT NULL,
    price_by_product        NUMBER NOT NULL,
    total_order             NUMBER(10, 2) NOT NULL,
    id_order                INTEGER NOT NULL,
    CONSTRAINT prov_prod_detail_fk FOREIGN KEY (id_provider_by_product) REFERENCES   provider_by_product(id_provider_by_product),
        CONSTRAINT order_fk FOREIGN KEY (id_order) REFERENCES   "Order"(id_order)


);

ALTER TABLE order_detail ADD CONSTRAINT order_detail_pk PRIMARY KEY ( id_detail );

CREATE TABLE product (
    id_product       INTEGER NOT NULL,
    name_product     VARCHAR2(120) NOT NULL,
    created_product  DATE NOT NULL,
    id_category INTEGER NOT NULL,
    CONSTRAINT product_category_FK FOREIGN KEY (id_category) REFERENCES   Category(id_category)
);

ALTER TABLE product ADD CONSTRAINT product_pk PRIMARY KEY ( id_product );

CREATE TABLE provider (
    id_provider       INTEGER NOT NULL,
    name_provider     VARCHAR2(250) NOT NULL,
    nit_provider      VARCHAR2(15),
    phone_provider    VARCHAR2(11),
    address_provider  VARCHAR2(220)
);

ALTER TABLE provider ADD CONSTRAINT provider_pk PRIMARY KEY ( id_provider );

CREATE TABLE provider_by_product (
    id_provider_by_product  INTEGER NOT NULL,
    last_added              DATE NOT NULL,
    id_provider             INTEGER NOT NULL,
    id_product              INTEGER NOT NULL,
    id_user                 INTEGER NOT NULL,
    quantity                INTEGER NOT NULL,
    price_product           FLOAT(10) NOT NULL,
    CONSTRAINT provider_detail_fk FOREIGN KEY (id_provider) REFERENCES   Provider(id_provider),
    CONSTRAINT product_detail_fk FOREIGN KEY (id_product) REFERENCES   Product(id_product),
    CONSTRAINT user_detail_fk FOREIGN KEY (id_user) REFERENCES   warehouse_user(id_user)


);

ALTER TABLE provider_by_product ADD CONSTRAINT provider_by_product_pk PRIMARY KEY ( id_provider_by_product );

CREATE TABLE warehouse_user (
    id_user     INTEGER NOT NULL,
    name_user   VARCHAR2(220) NOT NULL,
    phone_user  VARCHAR2(11),
    job_title   VARCHAR2(220)
);

ALTER TABLE warehouse_user ADD CONSTRAINT warehouse_user_pk PRIMARY KEY ( id_user );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            11
-- CREATE INDEX                             0
-- ALTER TABLE                             10
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   1
-- WARNINGS                                 0



SELECT * FROM BRANCH;


INSERT INTO BRANCH (ID_BRANCH, NAME_BRANCH,ADDRESS_BRANCH,PHONE_BRANCH)VALUES(1,'LAPOLA','LAS VEGAS','8184856105'); 
