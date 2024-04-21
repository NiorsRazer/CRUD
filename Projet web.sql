CREATE TABLE User(
    id_user SERIAL PRIMARY KEY,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    id_type_job int,
    dtn Date,
    salaire int
);


CREATE TABLE Type_job(
    id_type_job SERIAL PRIMARY KEY,
    nom VARCHAR(125)
)
