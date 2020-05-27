drop table if exists models;
drop table if exists engines;
drop table if exists transmissions;
drop table if exists paints;
drop table if exists tires;

create table models
(
    id    int primary key,
    name  varchar,
    price double
);

create table engines
(
    id       int primary key,
    name     varchar,
    capacity int,
    power    int,
    price    double,
    in_stock boolean
);

create table transmissions
(
    id        int primary key,
    name      varchar,
    automatic boolean,
    gears     int,
    price     double,
    in_stock boolean

);

create table paints
(
    id    int primary key,
    color varchar,
    price double,
    in_stock boolean
);

create table tires
(
    id           int primary key,
    manufacturer varchar,
    size         int,
    price        double,
    in_stock boolean
);
