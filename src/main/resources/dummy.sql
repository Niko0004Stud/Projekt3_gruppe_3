insert into Bil (vognnummer, stelnummer, maerke, udstyrsniveau,
                 staalpris, regAfgift, co2Udledning)
VALUES  ('1','2', 'opel', 5, 500,
         400, 200)

insert into SkadeMatrix (beskrivelse, prisPaaSkade, registreringsDate)
VALUES  ('big dmg', '555555', '2020-09-12')

insert into LaKvittering(skadeMatrixId, startDate, slutDate, totalPrisKr, type)
VALUES(1, '2026-04-12', '2026-05-12', 300.0, 'lejeaftale')