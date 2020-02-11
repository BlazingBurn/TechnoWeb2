CREATE TABLE employee(
    id integer primary key auto_increment,
    first_name varchar(255),
    last_name varchar(255)
);

CREATE TABLE salary(
    id integer primary key auto_increment,
    montantVerse double,
    nbJoursTravailMois integer,
    dateVersement date default CURRENT_DATE,
    dateVersementDu varchar(7)
);

CREATE TABLE vacation(
    id integer primary key auto_increment,
    dayVacation date
);