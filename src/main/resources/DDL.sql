DROP DATABASE IF EXISTS BilabonnementDB;

CREATE DATABASE BilabonnementDB;

USE BilabonnementDB;


CREATE TABLE User(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    sysrole VARCHAR(50) NOT NULL
);


CREATE TABLE Model(
   id INT AUTO_INCREMENT PRIMARY KEY,
   model VARCHAR(50) NOT NULL,
   maerke VARCHAR(50)NOT NULL,
   beskrivelse TEXT NOT NULL
);

CREATE TABLE Bil(
    id INT AUTO_INCREMENT PRIMARY KEY,
    vognnummer VARCHAR(50) NOT NULL,
    stelnummer VARCHAR(50) NOT NULL UNIQUE,
    modelId INT NOT NULL,
    FOREIGN KEY (modelId) REFERENCES Model(id),
    udstyrsNiveau INT NOT NULL,
    staalpris DECIMAL NOT NULL,
    regAfgift DECIMAL NOT NULL,
    co2Udledning DECIMAL NOT NULL,
    statusBil VARCHAR(50) NOT NULL
);


CREATE TABLE SkadeMatrix(
    id INT AUTO_INCREMENT PRIMARY KEY,
    bilId INT NOT NULL,
    FOREIGN KEY (bilId) REFERENCES Bil(id),
    omkostninger DECIMAL NOT NULL,
    registreringsDate DATE NOT NULL
);

CREATE TABLE LaKvittering(
     id INT AUTO_INCREMENT PRIMARY KEY,
     skadeMatrixId INT,
     FOREIGN KEY (skadeMatrixId) REFERENCES SkadeMatrix(id),
     startDate DATE NOT NULL,
     slutDate DATE NOT NULL,
     totalPrisKr DECIMAL NOT NULL,
     type VARCHAR(50) NOT NULL
);

CREATE TABLE Lejeaftale(
    id INT AUTO_INCREMENT PRIMARY KEY,
    bilId INT NOT NULL,
--     FOREIGN KEY (bilId) REFERENCES Bil(id),
    kundeId INT NOT NULL,
    laKvitteringId INT NOT NULL,
    FOREIGN KEY (laKvitteringId) REFERENCES LaKvittering(id),
    startDate DATE NOT NULL,
    slutDate DATE NOT NULL,
    startPrisKr DECIMAL NOT NULL
);

CREATE TABLE FhaKvittering(
   id INT AUTO_INCREMENT PRIMARY KEY,
   skadeMatrixId INT NOT NULL,
   FOREIGN KEY (skadeMatrixId) REFERENCES SkadeMatrix(id),
   registreringDate DATE NOT NULL,
   totalPrisKr DECIMAL NOT NULL
);

CREATE TABLE Forhaansaftale(
    id INT AUTO_INCREMENT PRIMARY KEY,
    bilId INT NOT NULL,
    FOREIGN KEY (bilId) REFERENCES Bil(id),
    kundeId INT NOT NULL,
    FhaKvitteringId INT NOT NULL,
#     FOREIGN KEY (FhaKvitteringId) REFERENCES FhaKvittering(id),
    registreringsDate DATE NOT NULL,
    startPrisKr DECIMAL NOT NULL
);

CREATE TABLE Log(
    id INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES User(id),
    timeStamp DATETIME NOT NULL,
    action VARCHAR(100) NOT NULL,
    beskrivelse TEXT NOT NULL
);


