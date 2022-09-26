INSERT INTO hero (HeroId, IsHero, Name, Description)
VALUES (1, TRUE, 'Catwoman', 'acts like a cat'),
       (2, TRUE, 'Batman', 'Rich guy who has an array of tools'),
       (3, TRUE, 'Spiderman', 'Got bit by a spider and protects New York'),
       (4, 'Wolverine', 'Government experiment turned badass', 'Metal skeletal enhancements, rapid injury recovery'),
       (5, 'Cyclops', 'Mutant you cant look at you safely', 'Death Ray eyes'),
       (6, 'Dr.Strange', 'Surgeon Turned Magic Master', 'Master at many of the Arcane Arts'),
       (7, 'Human Torch', 'Too hot to handle', 'Control Flame'),
       (8, 'Ravan', 'criminal', 'Control Earth');

INSERT INTO location (LocationId, Name, Latitude, Longitude, Description, AddressInformation)
VALUES (1, 'New York', 40.71280000, 74.00600000, 'The Big Apple', 'New York State'),
       (2, 'London', 51.50720000, 0.12760000, 'Britians Finest', 'United Kingdom'),
       (3, 'Los Angeles', 34.05220000, 118.24370000, 'Home of the Stars', 'California, US'),
       (4, 'Tokyo',35.67620000, 139.65030000, 'Japans most popular tourist spot', 'Japan, Asia'),
       (5, 'New Delhi', 28.61390000, 77.20900000, 'Capitol of India', 'India'),
       (6, 'Gotham City', 41.87810000, 81.62980000,'Fictional imagination of Chicago', 'Illinois, USA');
INSERT INTO Organization (OrganizationId, Name, IsHero, Description, Address, Contact)
VALUES (1, 'X-men: Group of super mutants.', TRUE, 'Secret house somewhere in midwest.', 'charles@xmen.com'),
       (2, 'Avengers: Large Collection of heros originally formed to combat Theros', TRUE, 'Many locations around multiverse',
        'contact@avengers.com'),
       (3, 'Fantastic: a small group of super friends', TRUE, 'Baxter Building, New York', 'fantastic4@fantastic.com');

INSERT INTO sighting (SightingId, HeroId, LocationId, Date)
VALUES (1, 4, 1, '2022-03-05'),
       (2, 2, 1, '2022-03-05'),
       (3, 6, 1, '2022-03-05'),
       (4, 4, 1, '2022-03-06'),
       (5, 4, 1, '2022-03-07'),
       (6, 4, 1, '2022-03-08'),
       (7, 4, 1, '2022-03-09'),
       (8, 4, 1, '2022-03-10'),
       (9, 4, 1, '2022-03-11'),
       (10, 4, 1, '2022-03-11'),
       (11, 4, 1, '2022-03-11'),
       (12, 4, 1, '2022-03-11'),
       (13, 4, 1, '2022-03-11'),
       (14, 4, 1, '2022-03-11'),
       (15, 4, 1, '2022-03-12'),
       (16, 4, 1, '2022-03-12'),
       (17, 4, 1, '2022-03-14'),
       (18, 4, 1, '2022-10-16'),
       (19, 1, 6, '2022-04-23'),
       (20, 1, 6, '2022-04-22'),
       (21, 1, 6, '2022-04-21'),
       (22, 2, 6, '2022-04-21'),
       (23, 2, 6, '2022-04-22'),
       (24, 2, 6, '2022-04-23'),
       (25, 8, 1, '2022-02-24'),
       (26, 8, 1, '2021-10-10');
INSERT INTO HeroOrganization (HeroId, OrganizationId)
VALUES (3, 2),
       (5, 1),
       (6, 1),
       (7, 2);