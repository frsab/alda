SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

DROP INDEX email_2 ON users;
DROP INDEX email_3 ON users;
DROP INDEX email_4 ON users;
DROP INDEX email_5 ON users;
DROP INDEX email_6 ON users;
DROP INDEX email_7 ON users;
DROP INDEX email_8 ON users;



/* Drop Tables */

DROP TABLE IF EXISTS annoncefavori;
DROP TABLE IF EXISTS photo;
DROP TABLE IF EXISTS annonce;
DROP TABLE IF EXISTS criterederecherche;
DROP TABLE IF EXISTS users;




/* Create Tables */

CREATE TABLE annonce
(
	id_annonce int NOT NULL AUTO_INCREMENT,
	dateDeMiseEnLigne datetime,
	prix int,
	description varchar(255),
	type varchar(255),
	adresse varchar(255),
	codePostal int,
	codeRegion int,
	id_user int NOT NULL,
	PRIMARY KEY (id_annonce)
) DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;


CREATE TABLE annoncefavori
(
	id_favoris int unsigned NOT NULL AUTO_INCREMENT,
	id_user int NOT NULL,
	id_annonce int NOT NULL,
	PRIMARY KEY (id_favoris)
) DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;


CREATE TABLE criterederecherche
(
	id_annonce int NOT NULL AUTO_INCREMENT,
	prixMax int,
	priMin int,
	codePostalBienCherche int,
	surfaceBienCherche int,
	typeBienCherche varchar(255),
	id_user int NOT NULL,
	PRIMARY KEY (id_annonce)
) DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;


CREATE TABLE photo
(
	id_photo int NOT NULL AUTO_INCREMENT,
	url varchar(255) NOT NULL,
	id_annonce int NOT NULL,
	PRIMARY KEY (id_photo),
	UNIQUE (url)
);


CREATE TABLE users
(
	id_user int NOT NULL AUTO_INCREMENT,
	nom varchar(255),
	email varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	telephoneNb varchar(255),
	typeUser varchar(255),
	adresseUser varchar(255),
	codePostalUser int,
	PRIMARY KEY (id_user),
	UNIQUE (email)
) DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;



/* Create Foreign Keys */

ALTER TABLE annoncefavori
	ADD FOREIGN KEY (id_annonce)
	REFERENCES annonce (id_annonce)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE photo
	ADD FOREIGN KEY (id_annonce)
	REFERENCES annonce (id_annonce)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE annonce
	ADD FOREIGN KEY (id_user)
	REFERENCES users (id_user)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE annoncefavori
	ADD FOREIGN KEY (id_user)
	REFERENCES users (id_user)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE criterederecherche
	ADD FOREIGN KEY (id_user)
	REFERENCES users (id_user)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Create Indexes */

CREATE UNIQUE INDEX email_2 USING BTREE ON users (email ASC);
CREATE UNIQUE INDEX email_3 USING BTREE ON users (email ASC);
CREATE UNIQUE INDEX email_4 USING BTREE ON users (email ASC);
CREATE UNIQUE INDEX email_5 USING BTREE ON users (email ASC);
CREATE UNIQUE INDEX email_6 USING BTREE ON users (email ASC);
CREATE UNIQUE INDEX email_7 USING BTREE ON users (email ASC);
CREATE UNIQUE INDEX email_8 USING BTREE ON users (email ASC);



