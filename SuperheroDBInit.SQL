create table Hero
(
    HeroId      SERIAL primary key,
    IsHero      boolean     not null,
    Name        varchar(50) not null,
    Description varchar(255)
);

-- Superpower
create table Superpower
(
    SuperpowerId SERIAL primary key,
    Name         varchar(50) not null,
    Description  varchar(255)
);

-- HeroSuperpower
create table HeroSuperpower
(
    HeroId       int not null,
    SuperpowerId int not null,
    PRIMARY KEY (HeroId, SuperpowerId),
    foreign key (HeroId)
        references Hero (HeroId),
    foreign key (SuperpowerId)
        references Superpower (SuperpowerId)
);

-- Organization
create table Organization
(
    OrganizationId SERIAL primary key,
    Name           varchar(50) not null,
    IsHero         boolean     not null,
    Description    varchar(255),
    Address        varchar(255),
    Contact        varchar(255)
);


-- HeroOrganization
create table HeroOrganization
(
    HeroId         int not null,
    OrganizationId int not null,
    PRIMARY KEY (HeroId, OrganizationId),
    foreign key (HeroId)
        references Hero (HeroId),
    foreign key (OrganizationId)
        references Organization (OrganizationId)
);

-- Location
create table Location
(
    LocationId         SERIAL primary key,
    Name               varchar(50)    not null,
    Latitude           DECIMAL(10, 8) not null,
    Longitude          DECIMAL(11, 8) not null,
    Description        varchar(255),
    AddressInformation varchar(255)
);

-- Sighting
create table Sighting
(
    SightingId SERIAL primary key,
    HeroId     int  not null,
    LocationId int  not null,
    Date       date not null,
    foreign key (HeroId)
        references Hero (HeroId),
    foreign key (LocationId)
        references Location (LocationId)
);