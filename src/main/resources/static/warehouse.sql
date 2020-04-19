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
    description  VARCHAR2(100) 
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

CREATE TABLE n_Order (
    id_order      INTEGER NOT NULL,
    date_time     DATE NOT NULL,
    total_amount  NUMBER(10, 2) NOT NULL
);

ALTER TABLE n_Order ADD CONSTRAINT order_pk PRIMARY KEY ( id_order );

CREATE TABLE order_detail (
    id_detail               INTEGER NOT NULL,
    id_provider_by_product  INTEGER NOT NULL,
    quatity_in              INTEGER NOT NULL,
    price_by_product        NUMBER NOT NULL,
    total_order             NUMBER(10, 2) NOT NULL,
    id_order                INTEGER NOT NULL,
    CONSTRAINT prov_prod_detail_fk FOREIGN KEY (id_provider_by_product) REFERENCES   provider_by_product(id_provider_by_product),
        CONSTRAINT order_fk FOREIGN KEY (id_order) REFERENCES   n_Order(id_order)


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



-----

DROP TABLE BITACORA;  
DROP TABLE BRANCH;  --CRUD   LISTAR
DROP TABLE CATEGORY; --CRUD  LISTAR
DROP TABLE DISPATCH_BY_WAREHOUSE; --CRUD LISTAR/D
DROP TABLE DISPATCH_DETAILS; --CRUD LISTAR
DROP TABLE ORDER_DETAIL; --CRUD LISTAR
DROP TABLE n_Order; --CRUD LISTAR
DROP TABLE PRODUCT; --CRUD LISTAR 
DROP TABLE PROVIDER; --CRUD LISTAR
DROP TABLE PROVIDER_BY_PRODUCT; --CRUD LISTAR
DROP TABLE WAREHOUSE_USER; --CRUD LISTAR


SELECT * FROM BRANCH;
SELECT * FROM CATEGORY;
SELECT * FROM PRODUCT;
SELECT * FROM PROVIDER;
SELECT * FROM WAREHOUSE_USER;
SELECT * FROM provider_by_product;
SELECT * FROM ORDER_DETAIL;
SELECT * FROM DISPATCH_BY_WAREHOUSE;
SELECT * FROM DISPATCH_DETAILS;

INSERT INTO BRANCH (ID_BRANCH, NAME_BRANCH,ADDRESS_BRANCH,PHONE_BRANCH)VALUES(1,'LAPOLA','LAS VEGAS','8184856105'); 
INSERT INTO BRANCH (ID_BRANCH, NAME_BRANCH,ADDRESS_BRANCH,PHONE_BRANCH)VALUES(2,'BOLANOS','LOS ANGELES','1001001012'); 

INSERT INTO CATEGORY (id_category,name,description)VALUES (1,'ELECTRO DOMESTICOS','PRODUCTOS DE USO DEL HOGAR');
INSERT INTO CATEGORY (id_category,name,description)VALUES (2,'CONSUMO BASICO','se compran regularmente, no pueden faltar.');

INSERT INTO PRODUCT (id_product,name_product,created_product,id_category) VALUES (1,'ESTUFA',TO_DATE('2020/04/17 20:01:43','yyyy/mm/dd hh24:mi:ss'),1);
INSERT INTO PRODUCT (id_product,name_product,created_product,id_category) VALUES (2,'CAFE',TO_DATE('2020/04/17 20:01:43', 'yyyy/mm/dd hh24:mi:ss'),2);

INSERT INTO PROVIDER (id_provider,name_provider,nit_provider,phone_provider,address_provider) VALUES (1,'UBERFREIHGT','10035230-8','2200000','Mixco Guatemala');
INSERT INTO PROVIDER (id_provider,name_provider,nit_provider,phone_provider,address_provider) VALUES (2,'LANDSTAR','109920-3','2300000','Ciudad de Guatemala');

INSERT INTO WAREHOUSE_USER (id_user,name_user,phone_user,job_title) VALUES (1,'Fernando A', '5555-2222', 'Owner');
INSERT INTO WAREHOUSE_USER (id_user,name_user,phone_user,job_title) VALUES (2,'Pedro F', '5555-2222', 'DBA');

INSERT INTO n_Order (id_order,date_time,total_amount) VALUES (1,TO_DATE('2020/04/17 20:01:43', 'yyyy/mm/dd hh24:mi:ss'),100.24);
INSERT INTO n_Order (id_order,date_time,total_amount) VALUES (2,TO_DATE('2020/04/17 20:01:43', 'yyyy/mm/dd hh24:mi:ss'),200.50);

INSERT INTO provider_by_product (id_provider_by_product,last_added,id_provider,id_product,id_user,quantity,price_product) VALUES (1,TO_DATE('2020/04/17 20:01:43','yyyy/mm/dd hh24:mi:ss'),1,2,1,100,125.50);
INSERT INTO provider_by_product (id_provider_by_product,last_added,id_provider,id_product,id_user,quantity,price_product) VALUES (2,TO_DATE('2020/04/19 20:01:43','yyyy/mm/dd hh24:mi:ss'),1,2,1,400,150.99);

INSERT INTO order_detail (id_detail,id_provider_by_product,quatity_in,price_by_product,total_order,id_order) VALUES (1,1,100,150.55,300.50,1);
INSERT INTO order_detail (id_detail,id_provider_by_product,quatity_in,price_by_product,total_order,id_order) VALUES (2,2,400,350.55,1300.50,2);

INSERT INTO DISPATCH_BY_WAREHOUSE (id_dispatch_by_warehouse,id_branch,id_user,last_sent ) VALUES (1,1,1,TO_DATE('2020/04/17 20:01:43', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO DISPATCH_BY_WAREHOUSE (id_dispatch_by_warehouse,id_branch,id_user,last_sent ) VALUES (2,2,2,TO_DATE('2020/05/25 20:01:43', 'yyyy/mm/dd hh24:mi:ss'));

INSERT INTO DISPATCH_DETAILS (id_dispatch,id_dispatch_by_warehouse,quantity_out,id_provider_by_product) VALUES (1,1,100,2);
INSERT INTO DISPATCH_DETAILS (id_dispatch,id_dispatch_by_warehouse,quantity_out,id_provider_by_product) VALUES (2,2,10,1);