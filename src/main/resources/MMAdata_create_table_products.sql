DROP TABLE IF EXISTS products;

CREATE TABLE products (

    ID integer NOT NULL,
    title character varying(255) NOT NULL,
    brand character varying(100) NOT NULL,
    model character varying(255) NOT NULL,
    type character varying(255) NOT NULL,
    price integer NOT NULL,
    productSize integer NOT NULL,
    availability boolean NOT NULL
);

INSERT INTO products VALUES (1, 'Nike Viper Black', 'Nike', 'Viper', 'Black', 450, 42, true);
INSERT INTO products VALUES (2, 'Addidas Shogun Red', 'Addidas', 'Shogun', 'Red', 550, 41, true);
INSERT INTO products VALUES (3, 'Puma Cosmos Blue', 'Puma', 'Cosmos', 'Blue', 370, 38, true);





