DROP DATABASE IF EXISTS BilabonnementDB;

CREATE DATABASE BilabonnementDB;

USE BilabonnementDB;

CREATE TABLE Kunde(
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    fornavn VARCHAR (50) NOT NULL,
                    efternavn VARCHAR (50) NOT NULL,
                    tlfNummer INTEGER NOT NULL,
                    email VARCHAR(50) NOT NULL,
                    adresse VARCHAR (100) NOT NULL,
                    status VARCHAR(10) NOT NULL
);

CREATE TABLE Bil(
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    vognnummer VARCHAR(50) NOT NULL,
                    stelnummer VARCHAR(50) NOT NULL,
                    maerke VARCHAR(50) NOT NULL,
                    udstyrsniveau INTEGER NOT NULL,
                    staalpris decimal NOT NULL,
                    regAfgift decimal NOT NULL,
                    co2Udledning decimal NOT NULL
);


CREATE TABLE Lejeaftale(
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            FOREIGN KEY (id) REFERENCES Bil(id),
                            FOREIGN KEY (id) REFERENCES Kunde(id),
                            startDate date NOT NULL,
                            laengdeDays INTEGER NOT NULL,
                            prisKr decimal NOT NULL,
                            skadeMatrixId INTEGER NOT NULL
);

CREATE TABLE Skade(
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    FOREIGN KEY (id) REFERENCES Lejeaftale(id),
                    beskrivelse VARCHAR(100) NOT NULL,
                    prispaaskade decimal NOT NULL,
                    registreringsDate date
);
