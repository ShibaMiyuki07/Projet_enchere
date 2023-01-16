a
Create database enchere;
Create role enchere;
Alter role enchere login password 'enchere';
Alter database enchere owner to enchere;
\c enchere;


drop table surencherir;
drop table Produit_image;
drop table Produitenenchere;
drop table enchere;
drop table rechargementcompte;
drop table Produit;
drop table categorie;
drop table utilisateur;

-- 1
Create table utilisateur(
    idUtilisateur serial primary key not null,
    nom varchar(20) not null,
    prenom varchar(20) not null,
    email varchar(20) not null,
    mdp varchar(20) not null,
    solde_compte float default 0
);

-- 2
Create table admin(
    idAdmin serial primary key not null,
    nom text not null,
    mdp text not null,
    compte float default 0
);



-- 3
Create table Categorie(
    idCategorie serial primary key not null,
    categorie text not null,
    dureeEnchereCategorie double precision default 0 not null
);

-- 4
-- 5
Create table rechargement(
    idUtilisateur int not null references Utilisateur(idUtilisateur),
    montantrecharge float,
    dateheurechargement timestamp default current_timestamp,
    validation int default 0
);

-- 6
Create table Enchere(
    idEnchere serial primary key not null,
    idUtilisateur int  not null references utilisateur(idUtilisateur),
    dureeEnchere double precision default 0 not null,
    description TEXT,
    idCategorie int not null references categorie(idCategorie),
    dateheureenchere timestamp default current_timestamp,
    prixdevente float not null,
    prixminimum float not null
);

-- 7
Create table surencherir(
    idSurencherir serial primary key not null,
    idEnchere int references Enchere(idEnchere),
    idUtilisateur int references Utilisateur(idUtilisateur),
    montant float not null,
    dateheuresurenchere timestamp default current_timestamp
);

-- 8 ATAO MongoDb
Create table Produit_image(
    idEnchere int not null references enchere(idEnchere),
    image TEXT
);

-- 9
Create table commission(
    idEnchere int not null references Enchere(idEnchere),
    commission float not null default 30000
);

--  rehefa valider de manao payement anleh enchere de misy ho any comission de misy ho an'ny admincreate table payement();


 create table token(
     id serial primary key,token text,expire date,idutilisateur int
);