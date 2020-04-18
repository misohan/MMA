DROP TABLE IF EXISTS users;

CREATE TABLE users (

    userId SERIAL PRIMARY KEY,
    name character varying(255) NOT NULL,
    surname character varying(255) NOT NULL,
    password character varying(100) NOT NULL,
    email character varying(255) NOT NULL,
    loginStatus boolean NOT NULL
    PRIMARY KEY (userId)
);


INSERT INTO users VALUES (1, 'Dominique', 'Williams', 'pass_123', 'dolor@laoreet.co.uk', false);
INSERT INTO users VALUES (2, 'Jemima', 'Foreman', 'haslo345', 'magna@etultrices.net', false);
INSERT INTO users VALUES (3, 'Zeph', 'Massey', 'unikatowe', 'a.feugiat.tellus@montesnasceturridiculus.co.uk', false);
INSERT INTO users VALUES (4, 'Jo', 'Crawford', 'trwrewr', 'lacinia.mattis@arcu.co.uk', false);
INSERT INTO users VALUES (5, 'Ifeoma', 'Bird', 'qwirjo5qwer', 'diam.duis.mi@orcitinciduntadipiscing.com', false);




