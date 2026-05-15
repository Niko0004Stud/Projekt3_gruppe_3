INSERT INTO Model (model, maerke, beskrivelse)
VALUES ('Bilad21','Opel','Super fed bil' );
INSERT INTO Bil (vognnummer, stelnummer, modelId, udstyrsniveau,
                 staalpris, regAfgift, co2Udledning, statusBil)
VALUES  ('1','2', LAST_INSERT_ID(), 5, 500,
         400, 200, 'nyBil');

INSERT INTO User(username, password, sysrole)
VALUES ('testAdmin', 'testpassword', 'admin');

INSERT INTO User(username, password, sysrole)
VALUES ('testDR', 'testpassword', 'dataregistrerer');

# insert into SkadeMatrix (skadeId, bilId, omkostninger,registreringsDate)
# VALUES  ('big dmg', '555555', 2020-06-09);
# insert into SkadeMatrix (skadeId, bilId, omkostninger,registreringsDate)
# VALUES  (1,4, 5555, 2010-05-04);