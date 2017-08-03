DROP TABLE client_account;

CREATE TABLE client_account
(id VARCHAR2(20) PRIMARY KEY,
balance NUMBER  DEFAULT 10000 CHECK(balance >=0),
bonusPoint NUMBER DEFAULT 0);

CREATE TABLE delivery(
	num NUMBER PRIMARY KEY,
	name VARCHAR2(20),
	addr VARCHAR2(30)
);

CREATE SEQUENCE delivery_seq;