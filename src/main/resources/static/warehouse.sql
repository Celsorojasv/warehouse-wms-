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

--BRANCH
INSERT INTO BRANCH (ID_BRANCH, NAME_BRANCH,ADDRESS_BRANCH,PHONE_BRANCH)VALUES(1,'LAPOLA','LAS VEGAS','8184856105'); 
INSERT INTO BRANCH (ID_BRANCH, NAME_BRANCH,ADDRESS_BRANCH,PHONE_BRANCH)VALUES(2,'BOLANOS','LOS ANGELES','1001001012'); 

--Procedimientos CRUD BRANCH
--CREATE
CREATE OR REPLACE PROCEDURE create_branch (Pid_branch IN branch.id_branch%TYPE, Pname_branch IN branch.name_branch%TYPE,Paddress_branch IN branch.address_branch%TYPE,Pphone_branch IN branch.phone_branch%TYPE) AS
BEGIN
  INSERT INTO BRANCH (id_branch,name_branch,address_branch,phone_branch) VALUES (Pid_branch,Pname_branch,Paddress_branch,Pphone_branch);
  COMMIT;
END;

CALL create_branch (4,'JIFFY','MIXCO','4754-5847');

--UPDATE
CREATE OR REPLACE PROCEDURE update_branch (Pid_branch IN branch.id_branch%TYPE, Pname_branch IN branch.name_branch%TYPE,Paddress_branch IN branch.address_branch%TYPE,Pphone_branch IN branch.phone_branch%TYPE) AS
BEGIN
  UPDATE BRANCH
  SET 
  name_branch = Pname_branch, address_branch = Paddress_branch , phone_branch = Pphone_branch
  WHERE
  id_branch = Pid_branch;
  COMMIT;
END;

CALL update_branch(3,'EL FOX','Los Olivos','5555-2222');

--DELETE
CREATE OR REPLACE PROCEDURE delete_branch (Pid_branch IN branch.id_branch%TYPE) IS
BEGIN
  DELETE FROM BRANCH WHERE id_branch =  Pid_branch;
END delete_branch;

BEGIN
   delete_branch(3);
END;


--CATEGORY
INSERT INTO CATEGORY (id_category,name,description)VALUES (1,'ELECTRO DOMESTICOS','PRODUCTOS DE USO DEL HOGAR');
INSERT INTO CATEGORY (id_category,name,description)VALUES (2,'CONSUMO BASICO','se compran regularmente, no pueden faltar.');

--Procedimientos CRUD CATEGORY
--CREATE
CREATE OR REPLACE PROCEDURE create_category (pid_category IN category.id_category%TYPE, pname IN category.name%TYPE, pdescription IN category.description%TYPE) AS
BEGIN
    INSERT INTO CATEGORY (id_category,name,description) VALUES (pid_category,pname,pdescription);
    COMMIT;
END;

CALL create_category(3,'ALIMENTOS','ALIMENTOS NO REFRIGERADOS');

--UPDATE
CREATE OR REPLACE PROCEDURE update_category (pid_category IN category.id_category%TYPE, pname IN category.name%TYPE, pdescription IN category.description%TYPE) AS
BEGIN
    UPDATE CATEGORY
    SET
    name = pname,
    description = pdescription
    WHERE
    id_category = pid_category;
    COMMIT;
END;

CALL update_category(3,'COMIDA PERROS','ALIMENTOS NO REFRIGERADOS');

--DELETE
CREATE OR REPLACE PROCEDURE delete_category (Pid_category IN category.id_category%TYPE) IS
BEGIN
  DELETE FROM CATEGORY WHERE id_category =  Pid_category;
END delete_category;

BEGIN
   delete_category(3);
END;

--PRODUCT
INSERT INTO PRODUCT (id_product,name_product,created_product,id_category) VALUES (1,'ESTUFA',TO_DATE('2020/04/17 20:01:43','yyyy/mm/dd hh24:mi:ss'),1);
INSERT INTO PRODUCT (id_product,name_product,created_product,id_category) VALUES (2,'CAFE',TO_DATE('2020/04/17 20:01:43', 'yyyy/mm/dd hh24:mi:ss'),2);

--Procedimientos CRUD PRODUCT
--CREATE
CREATE OR REPLACE PROCEDURE create_product (pid_product IN product.id_product%TYPE, pname_product IN product.name_product%TYPE, pcreated_product IN product.created_product%TYPE,
pid_category IN product.id_category%TYPE) AS
BEGIN 
    INSERT INTO PRODUCT(id_product,name_product,created_product,id_category) VALUES (pid_product,pname_product,pcreated_product,pid_category);
    COMMIT;
END;

CALL create_product(4,'PEPSI',TO_DATE('2020/04/17 20:01:43','yyyy/mm/dd hh24:mi:ss'),2);

--UPDATE
CREATE OR REPLACE PROCEDURE update_product (pid_product IN product.id_product%TYPE, pname_product IN product.name_product%TYPE, pcreated_product IN product.created_product%TYPE,
pid_category IN product.id_category%TYPE) AS
BEGIN   
    UPDATE PRODUCT 
    SET
    name_product = pname_product,
    created_product = pcreated_product,
    id_category = pid_category
    WHERE
    id_product = pid_product;
    COMMIT;
END;

CALL update_product(4,'7UP',TO_DATE('2020/04/17 20:01:43','yyyy/mm/dd hh24:mi:ss'),2);

--DELETE
CREATE OR REPLACE PROCEDURE delete_product (Pid_product IN product.id_product%TYPE) IS
BEGIN
  DELETE FROM PRODUCT WHERE id_product =  Pid_product;
END delete_product;

BEGIN
   delete_product(4);
END;

--PROVIDER
INSERT INTO PROVIDER (id_provider,name_provider,nit_provider,phone_provider,address_provider) VALUES (1,'UBERFREIHGT','10035230-8','2200000','Mixco Guatemala');
INSERT INTO PROVIDER (id_provider,name_provider,nit_provider,phone_provider,address_provider) VALUES (2,'LANDSTAR','109920-3','2300000','Ciudad de Guatemala');


--Procedimientos CRUD PROVIDER
--CREATE
CREATE OR REPLACE PROCEDURE create_provider (pid_provider IN provider.id_provider%TYPE,pname_provider IN provider.name_provider%TYPE, pnit_provider IN provider.nit_provider%TYPE,
pphone_provider IN provider.phone_provider%TYPE,paddress_provider IN provider.address_provider%TYPE) AS
BEGIN
    INSERT INTO PROVIDER (id_provider,name_provider,nit_provider,phone_provider,address_provider) VALUES (pid_provider,pname_provider,pnit_provider,pphone_provider,paddress_provider);
    COMMIT;
END;

CALL create_provider(3,'UBERFREIHGT','10035230-8','2200000','Mixco Guatemala');

--UPDATE
CREATE OR REPLACE PROCEDURE update_provider (pid_provider IN provider.id_provider%TYPE,pname_provider IN provider.name_provider%TYPE, pnit_provider IN provider.nit_provider%TYPE,
pphone_provider IN provider.phone_provider%TYPE,paddress_provider IN provider.address_provider%TYPE) AS
BEGIN 
    UPDATE PROVIDER
    SET
    name_provider = pname_provider,
    nit_provider = pnit_provider,
    phone_provider = pphone_provider,
    address_provider = paddress_provider
    WHERE
    id_provider  = pid_provider;
    COMMIT;
END;

CALL update_provider(3,'AQ TRANS','10035230-8','2200000','Mixco Guatemala');

--DELETE
CREATE OR REPLACE PROCEDURE delete_provider (pid_provider IN provider.id_provider%TYPE) IS
BEGIN
    DELETE FROM PROVIDER WHERE id_provider = pid_provider;
END delete_provider;

BEGIN
    delete_provider(3);
END;

--WAREHOUSE_USER
INSERT INTO WAREHOUSE_USER (id_user,name_user,phone_user,job_title) VALUES (1,'Fernando A', '5555-2222', 'Owner');
INSERT INTO WAREHOUSE_USER (id_user,name_user,phone_user,job_title) VALUES (2,'Pedro F', '5555-2222', 'DBA');

--Procedimientos CRUD WAREHOUSE_USER
--CREATE
CREATE OR REPLACE PROCEDURE create_warehouse_user(pid_user IN warehouse_user.id_user%TYPE,pname_user IN warehouse_user.name_user%TYPE,pphone_user IN warehouse_user.phone_user%TYPE,pjob_title warehouse_user.job_title%TYPE)AS
BEGIN
    INSERT INTO WAREHOUSE_USER (id_user,name_user,phone_user,job_title) VALUES (pid_user,pname_user,pphone_user,pjob_title);
    COMMIT;
END;

CALL create_warehouse_user (3,'Fernando A', '5555-2222', 'Owner');

--UPDATE
CREATE OR REPLACE PROCEDURE update_warehouse_user(pid_user IN warehouse_user.id_user%TYPE,pname_user IN warehouse_user.name_user%TYPE,pphone_user IN warehouse_user.phone_user%TYPE,pjob_title warehouse_user.job_title%TYPE)AS
BEGIN

    UPDATE WAREHOUSE_USER
    SET
    name_user = pname_user,
    phone_user = pphone_user,
    job_title = pjob_title
    WHERE
    id_user = pid_user;
    COMMIT;
END; 

CALL update_warehouse_user (3,'CELSO ROJAS', '5555-2222', 'Owner'); 

--DELETE
CREATE OR REPLACE PROCEDURE delete_warehouse_user (pid_user IN warehouse_user.id_user%TYPE) IS
BEGIN
    DELETE FROM WAREHOUSE_USER WHERE id_user = pid_user;
END delete_warehouse_user ;

BEGIN
    delete_warehouse_user (3);
END;

--ORDER
INSERT INTO n_Order (id_order,date_time,total_amount) VALUES (1,TO_DATE('2020/04/17 20:01:43', 'yyyy/mm/dd hh24:mi:ss'),100.24);
INSERT INTO n_Order (id_order,date_time,total_amount) VALUES (2,TO_DATE('2020/04/17 20:01:43', 'yyyy/mm/dd hh24:mi:ss'),200.50);

--Procedimientos CRUD n_Order
--CREATE
CREATE OR REPLACE PROCEDURE create_n_order(pid_order IN n_order.id_order%TYPE, pdate_time IN n_order.date_time%TYPE, ptotal_amount IN n_order.total_amount%TYPE)AS
BEGIN
    INSERT INTO N_ORDER (id_order,date_time,total_amount) VALUES (pid_order,TO_DATE(pdate_time, 'yyyy/mm/dd hh24:mi:ss'),ptotal_amount);
    COMMIT;
END;

CALL create_n_order (3,TO_DATE('2020/04/17 20:01:43', 'yyyy/mm/dd hh24:mi:ss'),100.24);

--UPDATE
CREATE OR REPLACE PROCEDURE update_n_order (pid_order IN n_order.id_order%TYPE, pdate_time IN n_order.date_time%TYPE, ptotal_amount IN n_order.total_amount%TYPE)AS
BEGIN
    UPDATE N_ORDER
    SET 
    date_time = pdate_time,
    total_amount = ptotal_amount
    WHERE
    id_order = pid_order;
    COMMIT;
END;

CALL update_n_order (3,TO_DATE('2021/04/17 20:01:43', 'yyyy/mm/dd hh24:mi:ss'),100.24);

--DELETE
CREATE OR REPLACE PROCEDURE delete_n_order (pid_order IN n_order.id_order%TYPE) IS
BEGIN
    DELETE FROM N_ORDER WHERE id_order = pid_order;
END delete_n_order ;

BEGIN
    delete_n_order (3);
END;

--PROVIDER_BY_PRODUCT

INSERT INTO provider_by_product (id_provider_by_product,last_added,id_provider,id_product,id_user,quantity,price_product) VALUES (1,TO_DATE('2020/04/17 20:01:43','yyyy/mm/dd hh24:mi:ss'),1,2,1,100,125.50);
INSERT INTO provider_by_product (id_provider_by_product,last_added,id_provider,id_product,id_user,quantity,price_product) VALUES (2,TO_DATE('2020/04/19 20:01:43','yyyy/mm/dd hh24:mi:ss'),1,2,1,400,150.99);
--Procedimientos CRUD PROVIDER_BY_PRODUCT
--CREATE
CREATE OR REPLACE PROCEDURE create_provider_by_product(pid_provider_by_product IN provider_by_product.id_provider_by_product%TYPE,plast_added IN provider_by_product.last_added%TYPE,pid_provider IN provider_by_product.id_provider%TYPE,
pid_product IN  provider_by_product.id_product%TYPE,pid_user IN provider_by_product.id_user%TYPE,pquantity IN provider_by_product.quantity%TYPE,pprice_product IN provider_by_product.price_product%TYPE)AS
BEGIN
    INSERT INTO provider_by_product (id_provider_by_product,last_added,id_provider,id_product,id_user,quantity,price_product) VALUES (pid_provider_by_product,TO_DATE(plast_added,'yyyy/mm/dd hh24:mi:ss'),pid_provider,pid_product,pid_user,pquantity,pprice_product);
    COMMIT;
END;

CALL create_provider_by_product (3,TO_DATE('2020/04/17 20:01:43','yyyy/mm/dd hh24:mi:ss'),1,2,1,100,125.50);

--UPDATE

CREATE OR REPLACE PROCEDURE update_provider_by_product (pid_provider_by_product IN provider_by_product.id_provider_by_product%TYPE,plast_added IN provider_by_product.last_added%TYPE,pid_provider IN provider_by_product.id_provider%TYPE,
pid_product IN  provider_by_product.id_product%TYPE,pid_user IN provider_by_product.id_user%TYPE,pquantity IN provider_by_product.quantity%TYPE,pprice_product IN provider_by_product.price_product%TYPE)AS
BEGIN
    UPDATE provider_by_product
    SET 
    last_added = plast_added,
    id_provider = pid_provider,
    id_product = pid_product,
    id_user = pid_user,
    quantity = pquantity,
    price_product = pprice_product
    WHERE
    id_provider_by_product = pid_provider_by_product;
    COMMIT;
END;

CALL update_provider_by_product (3,TO_DATE('1998/04/17 20:01:43','yyyy/mm/dd hh24:mi:ss'),1,2,1,100,125.50);


--DELETE

CREATE OR REPLACE PROCEDURE delete_provider_by_product (pid_provider_by_product IN provider_by_product.id_provider_by_product%TYPE) IS
BEGIN
    DELETE FROM provider_by_product WHERE id_provider_by_product = pid_provider_by_product;
END delete_provider_by_product ;

BEGIN
    delete_provider_by_product (3);
END;


--ORDER_DETAIL
INSERT INTO order_detail (id_detail,id_provider_by_product,quatity_in,price_by_product,total_order,id_order) VALUES (1,1,100,150.55,300.50,1);
INSERT INTO order_detail (id_detail,id_provider_by_product,quatity_in,price_by_product,total_order,id_order) VALUES (2,2,400,350.55,1300.50,2);
--Procedimientos CRUD ORDER_DETAIL
--CREATE
CREATE OR REPLACE PROCEDURE create_order_detail(pid_detail IN order_detail.id_detail%TYPE,pid_provider_by_product IN order_detail.id_provider_by_product%TYPE,pquatity_in IN order_detail.quatity_in%TYPE,
pprice_by_product IN order_detail.price_by_product%TYPE,ptotal_order IN order_detail.total_order%TYPE,pid_order IN order_detail.id_order%TYPE)AS
BEGIN
    INSERT INTO order_detail (id_detail,id_provider_by_product,quatity_in,price_by_product,total_order,id_order) VALUES (pid_detail,pid_provider_by_product,pquatity_in,pprice_by_product,ptotal_order,pid_order);
    COMMIT;
END;

CALL create_order_detail (3,1,100,150.55,300.50,1);

--UPDATE
CREATE OR REPLACE PROCEDURE update_order_detail(pid_detail IN order_detail.id_detail%TYPE,pid_provider_by_product IN order_detail.id_provider_by_product%TYPE,pquatity_in IN order_detail.quatity_in%TYPE,
pprice_by_product IN order_detail.price_by_product%TYPE,ptotal_order IN order_detail.total_order%TYPE,pid_order IN order_detail.id_order%TYPE)AS
BEGIN
    UPDATE order_detail
    SET 
    id_provider_by_product = pid_provider_by_product,
    quatity_in = pquatity_in,
    price_by_product = pprice_by_product,
    total_order = ptotal_order,
    id_order = pid_order
    WHERE
    id_detail = pid_detail;
    COMMIT;
END;

CALL update_order_detail (3,1,400,150.55,300.50,1);

--DELETE

CREATE OR REPLACE PROCEDURE delete_order_detail (pid_detail IN order_detail.id_detail%TYPE) IS
BEGIN
    DELETE FROM order_detail WHERE id_detail= pid_detail;
END delete_order_detail ;

BEGIN
    delete_order_detail (3);
END;

--DISPATCH_BY_WAREHOUSE
INSERT INTO DISPATCH_BY_WAREHOUSE (id_dispatch_by_warehouse,id_branch,id_user,last_sent ) VALUES (1,1,1,TO_DATE('2020/04/17 20:01:43', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO DISPATCH_BY_WAREHOUSE (id_dispatch_by_warehouse,id_branch,id_user,last_sent ) VALUES (2,2,2,TO_DATE('2020/05/25 20:01:43', 'yyyy/mm/dd hh24:mi:ss'));
--Procedimientos CRUD DISPATCH_BY_WAREHOUSE
--CREATE
CREATE OR REPLACE PROCEDURE create_dispatch_by_warehouse(pid_dispatch_by_warehouse IN dispatch_by_warehouse.id_dispatch_by_warehouse%TYPE,pid_branch IN dispatch_by_warehouse.id_branch%TYPE , pid_user IN dispatch_by_warehouse.id_user%TYPE ,
plast_sent IN dispatch_by_warehouse.last_sent%TYPE)AS
BEGIN
    INSERT INTO DISPATCH_BY_WAREHOUSE (id_dispatch_by_warehouse,id_branch,id_user,last_sent ) VALUES (pid_dispatch_by_warehouse,pid_branch,pid_user,TO_DATE(plast_sent , 'yyyy/mm/dd hh24:mi:ss'));
    COMMIT;
END;

CALL create_dispatch_by_warehouse (3,1,1,TO_DATE('2020/04/17 20:01:43', 'yyyy/mm/dd hh24:mi:ss'));

--UPDATE
CREATE OR REPLACE PROCEDURE update_dispatch_by_warehouse (pid_dispatch_by_warehouse IN dispatch_by_warehouse.id_dispatch_by_warehouse%TYPE,pid_branch IN dispatch_by_warehouse.id_branch%TYPE , pid_user IN dispatch_by_warehouse.id_user%TYPE ,
plast_sent IN dispatch_by_warehouse.last_sent%TYPE)AS
BEGIN
    UPDATE dispatch_by_warehouse
    SET 
    id_branch = pid_branch,
    id_user = pid_user,
    last_sent = plast_sent
    WHERE
    id_dispatch_by_warehouse = pid_dispatch_by_warehouse;
    COMMIT;
END;

CALL update_dispatch_by_warehouse (3,1,1,TO_DATE('2022/04/17 20:01:43', 'yyyy/mm/dd hh24:mi:ss'));

--DELETE
CREATE OR REPLACE PROCEDURE delete_dispatch_by_warehouse (pid_dispatch_by_warehouse IN dispatch_by_warehouse.id_dispatch_by_warehouse%TYPE) IS
BEGIN
    DELETE FROM dispatch_by_warehouse WHERE id_dispatch_by_warehouse= pid_dispatch_by_warehouse;
END delete_dispatch_by_warehouse ;

BEGIN
    delete_dispatch_by_warehouse (3);
END;

--DISPATCH_DETAILS
INSERT INTO DISPATCH_DETAILS (id_dispatch,id_dispatch_by_warehouse,quantity_out,id_provider_by_product) VALUES (1,1,100,2);
INSERT INTO DISPATCH_DETAILS (id_dispatch,id_dispatch_by_warehouse,quantity_out,id_provider_by_product) VALUES (2,2,10,1);
--Procedimientos CRUD --DISPATCH_DETAILS

--CREATE
CREATE OR REPLACE PROCEDURE create_dispatch_details(pid_dispatch IN dispatch_details.id_dispatch%TYPE , pid_dispatch_by_warehouse IN dispatch_details.id_dispatch_by_warehouse%TYPE , pquantity_out IN dispatch_details.quantity_out%TYPE,
pid_provider_by_product IN dispatch_details.id_provider_by_product%TYPE)AS
BEGIN
    INSERT INTO DISPATCH_DETAILS (id_dispatch,id_dispatch_by_warehouse,quantity_out,id_provider_by_product) VALUES (pid_dispatch,pid_dispatch_by_warehouse,pquantity_out,pid_provider_by_product);
    COMMIT;
END;

CALL create_dispatch_details (3,1,100,2);

--UPDATE
CREATE OR REPLACE PROCEDURE update_dispatch_details(pid_dispatch IN dispatch_details.id_dispatch%TYPE , pid_dispatch_by_warehouse IN dispatch_details.id_dispatch_by_warehouse%TYPE , pquantity_out IN dispatch_details.quantity_out%TYPE,
pid_provider_by_product IN dispatch_details.id_provider_by_product%TYPE)AS
BEGIN
    UPDATE DISPATCH_DETAILS
    SET 
    id_dispatch_by_warehouse = pid_dispatch_by_warehouse,
    quantity_out = pquantity_out,
    id_provider_by_product = pid_provider_by_product
    WHERE
    id_dispatch = pid_dispatch;
    COMMIT;
END;

CALL update_dispatch_details (3,1,200,2);

--DELETE
CREATE OR REPLACE PROCEDURE delete_dispatch_details (pid_dispatch IN dispatch_details.id_dispatch%TYPE) IS
BEGIN
    DELETE FROM DISPATCH_DETAILS WHERE id_dispatch = pid_dispatch;
    COMMIT;
END delete_dispatch_details ;

BEGIN
    delete_dispatch_details (3);
END;

