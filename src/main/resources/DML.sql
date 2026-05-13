insert into Bil (vognnummer, stelnummer, modelId, udstyrsniveau,
                 staalpris, regAfgift, co2Udledning)
VALUES  ('1','2', 'opel', 5, 500,
         400, 200);

insert into SkadeMatrix (skadeId, bilId, omkostninger,registreringsDate)
VALUES  ('big dmg', '555555', 2020-06-09);

INSERT INTO User(username, password, sysrole)
VALUES ('testAdmin', 'testpassword', 'admin');

INSERT INTO User(username, password, sysrole)
VALUES ('testDR', 'testpassword', 'dataregistrerer');