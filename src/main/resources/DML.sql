INSERT INTO Bil (vognnummer, stelnummer, modelId, udstyrsniveau,
                 staalpris, regAfgift, co2Udledning)
VALUES  (6, 3, 6, 7, 100,
         40.09, 10.60);

INSERT INTO SkadeMatrix (skadeId, bilId, omkostninger,registreringsDate)
VALUES  (1,4, 5555, 2026-05-13);

INSERT INTO User(username, password, sysrole)
VALUES ('testAdmin', 'testpassword', 'admin');

INSERT INTO User(username, password, sysrole)
VALUES ('testDR', 'testpassword', 'dataregistrerer');

INSERT INTO  LaKvittering(skadeMatrixId, startDate, slutDate, totalPrisKR, type)
VALUES (2, 2026-05-13, 2026-05-13, 500.5, 'noget')