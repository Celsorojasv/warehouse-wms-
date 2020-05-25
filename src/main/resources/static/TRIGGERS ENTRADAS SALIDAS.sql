

SELECT no.id_order, p.name_product, ot.id_detail, ot.price_by_product, pbp.id_provider_by_product, ot.quatity_in, pbp.quantity FROM N_ORDER NO 
INNER JOIN ORDER_DETAIL OT 
    ON NO.ID_ORDER = OT.ID_ORDER
INNER JOIN provider_by_product PBP 
    ON ot.id_provider_by_product = pbp.id_provider_by_product
INNER JOIN PRODUCT P ON pbp.id_product = p.id_product;


CREATE OR REPLACE TRIGGER PRODUCT_IN AFTER INSERT 
ON ORDER_DETAIL FOR EACH ROW
BEGIN
    UPDATE N_ORDER SET TOTAL_AMOUNT = TOTAL_AMOUNT + :NEW.PRICE_BY_PRODUCT WHERE ID_ORDER = :NEW.ID_ORDER;
    UPDATE provider_by_product SET quantity = quantity + :new.quatity_in WHERE id_provider_by_product = :new.id_provider_by_product;
END;

CREATE OR REPLACE TRIGGER PRODUCT_OUT BEFORE INSERT 
ON DISPATCH_DETAILS FOR EACH ROW
DECLARE
    current_qty INTEGER;
    pragma autonomous_transaction;
BEGIN
    SELECT quantity INTO current_qty FROM provider_by_product where id_provider_by_product = :new.id_provider_by_product;
    IF (current_qty > :new.quantity_out) then
        UPDATE provider_by_product SET quantity = quantity - :new.quantity_out WHERE id_provider_by_product = :new.id_provider_by_product;
    ELSE 
          raise_application_error(-20000
                , 'Bodega insuficiente para el despacho.');
    END IF;
END;


SELECT dby.last_sent, dd.id_dispatch_by_warehouse, dd.quantity_out, pbp.quantity, pbp.id_provider_by_product FROM dispatch_by_warehouse dby INNER JOIN dispatch_details DD ON dby.id_dispatch_by_warehouse = dd.id_dispatch_by_warehouse
INNER JOIN provider_by_product PBP 
    ON DD.id_provider_by_product = pbp.id_provider_by_product
INNER JOIN PRODUCT P ON pbp.id_product = p.id_product;

CALL CREATE_DISPATCH_DETAILS (1,500,2);




