INSERT INTO ca2.cityinfo (CITY, ZIPCODE) VALUES ("København N", 2200);
INSERT INTO ca2.cityinfo (CITY, ZIPCODE) VALUES ("Lyngby", 2800);
INSERT INTO ca2.cityinfo (CITY, ZIPCODE) VALUES ("Roskilde", 4000);
INSERT INTO ca2.cityinfo (CITY, ZIPCODE) VALUES ("Helsingør", 3000);

INSERT INTO ca2.hobby (NAME, DESCRIPTION) values ("Football", "Two teams try to kick the ball into the goal of the opposing team. Traditionally played with 22 players in total on a grass-field.");
INSERT INTO ca2.hobby (NAME, DESCRIPTION) values ("Dancing", "Moving rythmically to music");
INSERT INTO ca2.hobby (NAME, DESCRIPTION) values ("Gaming", "Playing video games on a console or personal computer");
INSERT INTO ca2.hobby (NAME, DESCRIPTION) values ("Running", "Running long distances. Often to improve health");
INSERT INTO ca2.hobby (NAME, DESCRIPTION) values ("Napping", "Sleeping in the middle of the day");

INSERT INTO ca2.address (STREET, ADDITIONALINFO, CITYINFO_ID) VALUES ("Rådhudsstræde 65", "Home", 1);
INSERT INTO ca2.address (STREET, ADDITIONALINFO, CITYINFO_ID) VALUES ("Brolæggerstræde 76", "Home", 1);
INSERT INTO ca2.address (STREET, ADDITIONALINFO, CITYINFO_ID) VALUES ("Skindergade 13", "Home", 1);
INSERT INTO ca2.address (STREET, ADDITIONALINFO, CITYINFO_ID) VALUES ("Nørgaardsvej 2", "Home", 2);
INSERT INTO ca2.address (STREET, ADDITIONALINFO, CITYINFO_ID) VALUES ("Toftebæksvej 34", "Home", 2);
INSERT INTO ca2.address (STREET, ADDITIONALINFO, CITYINFO_ID) VALUES ("Birkholmsvej 65", "Home", 2);
INSERT INTO ca2.address (STREET, ADDITIONALINFO, CITYINFO_ID) VALUES ("Peter Rørdams Vej 8", "Home", 2);
INSERT INTO ca2.address (STREET, ADDITIONALINFO, CITYINFO_ID) VALUES ("Møllehusvej 120", "Home", 3);
INSERT INTO ca2.address (STREET, ADDITIONALINFO, CITYINFO_ID) VALUES ("Skomagergade 53", "Company", 3);
INSERT INTO ca2.address (STREET, ADDITIONALINFO, CITYINFO_ID) VALUES ("Esrumvej 20", "Company", 4);
INSERT INTO ca2.address (STREET, ADDITIONALINFO, CITYINFO_ID) VALUES ("Blichersvej 5", "Company", 4);
INSERT INTO ca2.address (STREET, ADDITIONALINFO, CITYINFO_ID) VALUES ("Carl Plougs Vej 42", "Company", 4);
INSERT INTO ca2.address (STREET, ADDITIONALINFO, CITYINFO_ID) VALUES ("Willumsensvej 23", "Company", 4);


INSERT INTO ca2.company (NAME, CVR, DESCRIPTION, NUMEMPLOYEES, MARKETVALUE, EMAIL, ADDRESS_ID) values ("TDC", "81808650", "Tele-selskab", 20000, 5000000, "tdc@tdc.dk", 9);
INSERT INTO ca2.company (NAME, CVR, DESCRIPTION, NUMEMPLOYEES, MARKETVALUE, EMAIL, ADDRESS_ID) values ("Grundfos", "24120208", "Pumpe-løsninger", 25000, 5500000, "gf@grundfos.dk", 10);
INSERT INTO ca2.company (NAME, CVR, DESCRIPTION, NUMEMPLOYEES, MARKETVALUE, EMAIL, ADDRESS_ID) values ("Statoil", "59372553", "Olieselskab", 20000, 3000000, "statoil@statoil.com", 11);
INSERT INTO ca2.company (NAME, CVR, DESCRIPTION, NUMEMPLOYEES, MARKETVALUE, EMAIL, ADDRESS_ID) values ("Lego", "30521646", "Kreativt legetøj", 30000, 10000000, "lego@lego.dk", 12);
INSERT INTO ca2.company (NAME, CVR, DESCRIPTION, NUMEMPLOYEES, MARKETVALUE, EMAIL, ADDRESS_ID) values ("SAS Group", "03208176", "Flyselskab", 27500, 8000000, "sasgroup@sas.dk", 13);


INSERT INTO ca2.person (FIRSTNAME, LASTNAME, EMAIL,  ADDRESS_ID) VALUES ("Lars", "Von Trier", "lars.v.t@gmail.com", 1);
INSERT INTO ca2.person (FIRSTNAME, LASTNAME, EMAIL, ADDRESS_ID) VALUES ("Rolf", "Hansen", "rolf.h@gmail.com", 2);
INSERT INTO ca2.person (FIRSTNAME, LASTNAME, EMAIL, ADDRESS_ID) VALUES ("Martin", "Lennart", "martin.l@gmail.com", 3);
INSERT INTO ca2.person (FIRSTNAME, LASTNAME, EMAIL, ADDRESS_ID) VALUES ("Karl", "Skov", "karl.s@gmail.com", 4);
INSERT INTO ca2.person (FIRSTNAME, LASTNAME, EMAIL, ADDRESS_ID) VALUES ("Finn", "Nygaard", "finn.n@gmail.com", 4);
INSERT INTO ca2.person (FIRSTNAME, LASTNAME, EMAIL, ADDRESS_ID) VALUES ("Lasse", "Nielsen", "lasse.n@gmail.com", 5);
INSERT INTO ca2.person (FIRSTNAME, LASTNAME, EMAIL, ADDRESS_ID) VALUES ("Simon", "Andreas", "simon.a@gmail.com", 6);
INSERT INTO ca2.person (FIRSTNAME, LASTNAME, EMAIL, ADDRESS_ID) VALUES ("Arne", "Jacobsen", "arne.j@gmail.com", 7);
INSERT INTO ca2.person (FIRSTNAME, LASTNAME, EMAIL, ADDRESS_ID) VALUES ("Poul", "Hansen", "poul.h@gmail.com", 7);
INSERT INTO ca2.person (FIRSTNAME, LASTNAME, EMAIL, ADDRESS_ID) VALUES ("Jesper", "Poulsen", "jesper.p@gmail.com", 8);

INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("36163726", "Private", 1);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("39166492", "Private", 1);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("67671197", "Private", 2);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("17843055", "Private", 2);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("00200458", "Private", 2);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("98069664", "Private", 3);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("15472433", "Private", 4);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("76628051", "Private", 4);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("09910057", "Private", 4);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("73511626", "Private", 5);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("80747008", "Private", 5);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("47116192", "Private", 6);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("97716095", "Private", 6);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("96375596", "Private", 7);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("96524052", "Private", 8);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("73193114", "Private", 8);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("54383998", "Private", 9);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("51470093", "Private", 9);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("81713841", "Private", 10);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("16818330", "Business", 1);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("46658242", "Business", 1);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("08961241", "Business", 1);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("57751992", "Business", 2);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("08581796", "Business", 2);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("01534078", "Business", 2);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("69180408", "Business", 2);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("23398335", "Business", 3);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("22613153", "Business", 3);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("64045477", "Business", 4);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("50121329", "Business", 4);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("81088594", "Business", 4);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("99561601", "Business", 5);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("81818649", "Business", 5);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("53825069", "Business", 5);
INSERT INTO ca2.phone (NUMBER, DESCRIPTION, INFOENTITY_ID) values ("02440971", "Business", 5);

INSERT INTO ca2.person_hobby (persons_ID, hobbies_ID) VALUES (1, 1);
INSERT INTO ca2.person_hobby (persons_ID, hobbies_ID) VALUES (1, 2);
INSERT INTO ca2.person_hobby (persons_ID, hobbies_ID) VALUES (2, 1);
INSERT INTO ca2.person_hobby (persons_ID, hobbies_ID) VALUES (3, 3);
INSERT INTO ca2.person_hobby (persons_ID, hobbies_ID) VALUES (4, 3);
INSERT INTO ca2.person_hobby (persons_ID, hobbies_ID) VALUES (4, 2);
INSERT INTO ca2.person_hobby (persons_ID, hobbies_ID) VALUES (5, 4);
INSERT INTO ca2.person_hobby (persons_ID, hobbies_ID) VALUES (6, 4);
INSERT INTO ca2.person_hobby (persons_ID, hobbies_ID) VALUES (7, 5);
INSERT INTO ca2.person_hobby (persons_ID, hobbies_ID) VALUES (8, 2);
INSERT INTO ca2.person_hobby (persons_ID, hobbies_ID) VALUES (8, 3);