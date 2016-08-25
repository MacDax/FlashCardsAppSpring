INSERT INTO `flashcardsdb`.`susers` (`fname`, `lname`, `email`) VALUES ('Mickey', 'Mouse', 'mickey@disney.com');
INSERT INTO `flashcardsdb`.`susers` (`fname`, `lname`, `email`) VALUES ('Minni', 'Mouse', 'minni@disney.com');
INSERT INTO `flashcardsdb`.`susers` (`fname`, `lname`, `email`) VALUES ('Goofy', 'Gops', 'goofy@disney.com');



--DECK DATA
INSERT INTO `flashcardsdb`.`deck` (`title`, `editable`, `userid`) VALUES ('Advanced Java', '1', '1');
INSERT INTO `flashcardsdb`.`deck` (`title`, `userid`) VALUES ('Basic Java', '2');


--CARDS DATA:

INSERT INTO `flashcardsdb`.`cards` (`deckid`, `question`, `answer`) VALUES ('2', 'Two TCP/IP socket names for Networking', 'Socket and ServerSocket');
INSERT INTO `flashcardsdb`.`cards` (`deckid`, `question`, `answer`) VALUES ('2', 'MVC stands for', 'Model-View-Controller');
INSERT INTO `flashcardsdb`.`cards` (`deckid`, `question`, `answer`) VALUES ('2', 'Use of notifyAll', 'This method wakes up ALL waiting threads; the schedular decides which one to run');
INSERT INTO `flashcardsdb`.`cards` (`deckid`, `question`, `answer`) VALUES ('5', 'Inside which HTML element do we put the javascript?', '<script>');
INSERT INTO `flashcardsdb`.`cards` (`deckid`, `question`, `answer`) VALUES ('5', 'Where is the correct place to insert a javascript?', 'The <head> section');
INSERT INTO `flashcardsdb`.`cards` (`deckid`, `question`, `answer`) VALUES ('5', 'How do you create a function in javascript?', 'function myFunction()');
INSERT INTO `flashcardsdb`.`cards` (`deckid`, `question`, `answer`) VALUES ('11', 'How do you call a function named \"myFunction\"', 'myFunction()');
INSERT INTO `flashcardsdb`.`cards` (`deckid`, `question`, `answer`) VALUES ('11', 'How to round the number 7.25, to the nearest integer?', 'Math.round(7.25)');


--Add version into cards table:
UPDATE `flashcardsdb`.`cards` SET `version`='0' WHERE `cardid`='4';
UPDATE `flashcardsdb`.`cards` SET `version`='0' WHERE `cardid`='5';
UPDATE `flashcardsdb`.`cards` SET `version`='0' WHERE `cardid`='6';
UPDATE `flashcardsdb`.`cards` SET `version`='0' WHERE `cardid`='7';
UPDATE `flashcardsdb`.`cards` SET `version`='0' WHERE `cardid`='8';
UPDATE `flashcardsdb`.`cards` SET `version`='0' WHERE `cardid`='9';
UPDATE `flashcardsdb`.`cards` SET `version`='0' WHERE `cardid`='10';
UPDATE `flashcardsdb`.`cards` SET `version`='0' WHERE `cardid`='11';
UPDATE `flashcardsdb`.`cards` SET `version`='0' WHERE `cardid`='12';
UPDATE `flashcardsdb`.`cards` SET `version`='0' WHERE `cardid`='16';
UPDATE `flashcardsdb`.`cards` SET `version`='0' WHERE `cardid`='17';




