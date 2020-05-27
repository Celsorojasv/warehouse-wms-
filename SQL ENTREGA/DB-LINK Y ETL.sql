CREATE USER WAREHOUSE_REPORTS IDENTIFIED BY ROOT

CREATE DATABASE LINK WAREHOUSE_LINK CONNECT TO WAREHOUSE IDENTIFIED BY ROOT USING
'(DESCRIPTION =
    (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521))
    (CONNECT_DATA =
      (SERVER = DEDICATED)
      (SERVICE_NAME = xe)
    )
)';


CREATE OR REPLACE PROCEDURE SP_ETL (SQL_TABLE_NAME IN VARCHAR2, QUERY_NAME IN VARCHAR2) IS
   ddl_script VARCHAR2(1000);
   exist INTEGER;
BEGIN

    SELECT COUNT(*) INTO exist FROM SYS.ALL_TABLES WHERE TABLE_NAME=SQL_TABLE_NAME; 
    
    IF (exist)=1 THEN 
        ddl_script := 'DROP TABLE IF EXISTS '|| SQL_TABLE_NAME;
        EXECUTE IMMEDIATE ddl_script;
    END IF;
    ddl_script := ' CREATE TABLE '|| SQL_TABLE_NAME || ' AS ' || QUERY_NAME;
        
    EXECUTE IMMEDIATE ddl_script;
    EXCEPTION 
  WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('DDL FALLO '||SQL_TABLE_NAME||':: ERROR::'||SQLERRM);
END;
/


EXECUTE SP_ETL('TOTAL_VENTASS3_PROVEDOR', '(SELECT p.name_provider, count(nor.id_order) AS TOTAL_ORDENES, sum(od.price_by_product) AS TOTAL FROM provider_by_product@WAREHOUSE_LINK pbp INNER JOIN ORDER_DETAIL@WAREHOUSE_LINK OD ON od.id_provider_by_product = pbp.id_provider_by_product INNER JOIN provider@WAREHOUSE_LINK p ON pbp.id_provider = p.id_provider INNER JOIN N_ORDER@WAREHOUSE_LINK NOR ON od.id_order = nor.id_order GROUP BY p.name_provider,nor.id_order, od.total_order)');

--- SIN DBLINK
SELECT p.name_provider, COUNT(nor.id_order) AS TOTAL_ORDENES, 
SUM(od.price_by_product) AS TOTAL FROM provider_by_product  pbp 
INNER JOIN ORDER_DETAIL  OD ON od.id_provider_by_product = pbp.id_provider_by_product 
INNER JOIN provider  p ON pbp.id_provider = p.id_provider 
INNER JOIN N_ORDER  NOR ON od.id_order = nor.id_order 
GROUP BY p.name_provider,nor.id_order, od. PRICE_BY_PRODUCT