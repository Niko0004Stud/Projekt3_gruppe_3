INSERT INTO Model (model, maerke, beskrivelse)
VALUES ('Bilad21','Opel','Super fed bil' );
INSERT INTO Bil (vognnummer, stelnummer, modelId, udstyrsniveau,
                 staalpris, regAfgift, co2Udledning, statusBil)
VALUES  ('1','2', LAST_INSERT_ID(), 5, 500,
         400, 200, 'nyBil');
#          400, 200);

INSERT INTO Bil (vognnummer, stelnummer, modelId, udstyrsniveau,
                 staalpris, regAfgift, co2Udledning, statusBil)
VALUES  ('6','5', LAST_INSERT_ID(), 5, 500,
         400, 200, 'udlejet');

# insert into SkadeMatrix (skadeId, bilId, omkostninger,registreringsDate)
# VALUES  ('big dmg', '555555', 2020-06-09);
insert into SkadeMatrix ( bilId, omkostninger,registreringsDate)
VALUES  (1, 5555, '2010-05-04');

INSERT INTO User(username, password, sysrole)
VALUES ('testAdmin', 'testpassword', 'admin');

INSERT INTO User(username, password, sysrole)
VALUES ('testBilTech', 'testpassword', 'biltech');

INSERT INTO User(username, password, sysrole)
VALUES ('testDR', 'testpassword', 'dataregistrerer');



# INSERT INTO Bil(vognnummer, stelnummer, modelId, udstyrsNiveau, staalpris, regAfgift, co2Udledning)
# VALUES (1, '3F', 5, 876, 665.8, 665.9, 987.8);


# INSERT INTO ()
# VALUES();



# insert into SkadeMatrix (skadeId, bilId, omkostninger,registreringsDate)
# VALUES  ('big dmg', '555555', 2020-06-09);
# insert into SkadeMatrix (skadeId, bilId, omkostninger,registreringsDate)
# VALUES  (1,4, 5555, 2010-05-04);