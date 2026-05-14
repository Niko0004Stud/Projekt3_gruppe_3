INSERT INTO Model (model, maerke, beskrivelse)
VALUES ('Bilad21','Opel','Super fed bil' );
INSERT INTO Bil (vognnummer, stelnummer, modelId, udstyrsniveau,
                 staalpris, regAfgift, co2Udledning)
VALUES  ('1','2', LAST_INSERT_ID(), 5, 500,
         400, 200);

# insert into SkadeMatrix (skadeId, bilId, omkostninger,registreringsDate)
# VALUES  ('big dmg', '555555', 2020-06-09);
insert into SkadeMatrix (skadeId, bilId, omkostninger,registreringsDate)
VALUES  (0,4, 5555, '2010-05-04');

INSERT INTO User(username, password, sysrole)
VALUES ('testAdmin', 'testpassword', 'admin');

INSERT INTO User(username, password, sysrole)
VALUES ('testDR', 'testpassword', 'dataregistrerer');

INSERT INTO LaKvittering(skadeMatrixId, startDate, slutDate, totalPrisKr, type)
VALUES (NULL, '2000-02-14', '2021-01-12', 36.8, 'bla');

INSERT INTO Skade( beskrivelse, omkostning, registreringsDate)
VALUES ('nej', 345.2, '2020-02-21');

INSERT INTO SkadeMatrix(skadeId, bilId, omkostninger, registreringsDate)
VALUES();

