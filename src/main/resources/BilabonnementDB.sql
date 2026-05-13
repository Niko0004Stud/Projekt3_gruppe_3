DROP DATABASE IF EXISTS BilabonnementDB;

CREATE DATABASE BilabonnementDB;

USE BilabonnementDB;

CREATE TABLE Kunde(
    id INT AUTO_INCREMENT PRIMARY KEY,
    fornavn VARCHAR (50) NOT NULL,
    efternavn VARCHAR (50) NOT NULL,
    tlfNummer INTEGER NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    adresse VARCHAR (100) NOT NULL,
    status VARCHAR(10) NOT NULL
);


CREATE TABLE Bil(
    id INT AUTO_INCREMENT PRIMARY KEY,
    vognnummer VARCHAR(50) NOT NULL,
    stelnummer VARCHAR(50) NOT NULL,
    maerke VARCHAR(50) NOT NULL,
    udstyrsniveau INTEGER NOT NULL,
    staalpris DECIMAL NOT NULL,
    regAfgift DECIMAL NOT NULL,
    co2Udledning DECIMAL NOT NULL
);

CREATE TABLE SkadeMatrix(
                            id INT AUTO_INCREMENT PRIMARY KEY,
#                             lejeaftaleId INT NOT NULL,
#                             FOREIGN KEY (lejeaftaleId) REFERENCES Lejeaftale(id),
                            beskrivelse VARCHAR(100) NOT NULL,
                            prisPaaSkade DECIMAL NOT NULL,
                            registreringsDate DATE NOT NULL
);

CREATE TABLE Lejeaftale(
    id INT AUTO_INCREMENT PRIMARY KEY,
    bilId INT NOT NULL,
    FOREIGN KEY (bilId) REFERENCES Bil(id),
    kundeId INT  NOT NULL,
    skadeMatrixId INT NOT NULL,
    startDate DATE NOT NULL,
    laengdeDays INTEGER NOT NULL,
    slutDato DATE NOT NULL,
    prisKr DECIMAL NOT NULL
);


