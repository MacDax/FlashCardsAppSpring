CREATE SCHEMA `flashcardsdb` ;

CREATE TABLE flashcardsdb.susers(userid INT NOT NULL AUTO_INCREMENT,
  fname VARCHAR(30) NOT NULL,
  lname VARCHAR(30)  NULL,
  PRIMARY KEY (userid),
  email VARCHAR(40) NOT NULL,
  UNIQUE INDEX (email));

CREATE TABLE flashcardsdb.deck(deckid INT NOT NULL auto_increment,
title VARCHAR(40) NOT NULL,
editable boolean default false,
userid int NOT NULL,
PRIMARY KEY(deckid), CONSTRAINT fk_usersdeck foreign key(userid) references flashcardsdb.susers(userid));

CREATE TABLE flashcardsdb.cards(cardid INT NOT NULL auto_increment,
deckid INT NOT NULL, CONSTRAINT fk_cardsdeck foreign key(deckid) references flashcardsdb.deck(deckid),
question varchar(200) NOT NULL, CONSTRAINT uk_question UNIQUE(question),
answer varchar(500) NOT NULL,
PRIMARY KEY(cardid),
createddate datetime default current_timestamp(),
editeddate datetime default current_timestamp());

Alter table flashcardsdb.cards ADD editedby  int; 
Alter table flashcardsdb.cards ADD CONSTRAINT fk_cardeditedby foreign key (editedby) references susers(userid);
Alter table flashcardsdb.cards ADD version  int; 





