CREATE USER 'flashcard_user'@'localhost' IDENTIFIED BY 'SysCardFlash';

GRANT ALL PRIVILEGES ON flashcardsdb.* TO 'flashcard_user'@'localhost' WITH GRANT OPTION;

SHOW GRANTS FOR 'flashcard_user'@'localhost';