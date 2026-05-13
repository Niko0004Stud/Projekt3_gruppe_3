insert into Bil (vognnummer, stelnummer, modelId, udstyrsniveau,
                 staalpris, regAfgift, co2Udledning)
VALUES  (6, 3, 6, 7, 100,
         40.09, 10.60);

insert into SkadeMatrix (skadeId, bilId, omkostninger,registreringsDate)
VALUES  (1,4, 5555, 2010-05-04);

INSERT INTO User(username, password, sysrole)
VALUES ('testAdmin', 'testpassword', 'admin');

INSERT INTO User(username, password, sysrole)
VALUES ('testDR', 'testpassword', 'dataregistrerer');