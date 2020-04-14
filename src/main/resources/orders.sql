DROP TABLE IF EXISTS orders;

CREATE TABLE orders: (

    orderID integer NOT NULL,
    userID integer NOT NULL,
    paymentMethod character varying (255) NOT NULL,
    shippingMethod character varying (255) NOT NULL
);

INSERT INTO orders VALUES (1, 1, 'Credit Card', 'DHL');
