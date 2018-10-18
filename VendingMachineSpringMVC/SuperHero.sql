SET SQL_SAFE_UPDATES = 0;

DROP DATABASE IF EXISTS superHeroes;

create database superHeroes;

use SuperHeroes;


CREATE TABLE supers(
ID int primary key not null,
`Name` varchar(30),
`descriptions` varchar(50),
superPower varchar(50)

);
CREATE TABLE Locations(
ID int primary key not null,
`names` varchar(50) not null,
address varchar (50),
Latitude Decimal(10,5) not null,
Longtitude Decimal (10,5) not null
);



CREATE TABLE Sightings(
SightingsID int primary key not null,
`Date` Datetime not null,
LocationID int,
FOREIGN KEY (LocationID) REFERENCES Locations(ID) );

CREATE TABLE SuperheroSightings(
SuperheroID int,
SightingsID int,
foreign key (SuperheroID) REFERENCES Superhero(ID),
foreign key  (SightingsID) REFERENCES Sightings (ID)

);

CREATE TABLE Organizations(
ID int primary key not null,
`names` varchar(30) not null,
`Descriptions` varchar(50) not null,
address varchar(50)
);

CREATE TABLE superheroOrganizations
(superheroID int,
organizationsID int,
foreign key (superheroID) references Superhero(ID),
foreign key (organizationsID) references Organizations(ID)
);



