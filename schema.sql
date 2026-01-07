\c mini_dish_db;


   CREATE TABLE Dish(
       id int PRIMARY KEY NOT NULL,
       name VARCHAR(255) NOT NULL,
       dish_type VARCHAR CHECK ( dish_type IN ('START', 'MAIN', 'DESSERT'))
   );

ALTER TABLE dish
    ADD COLUMN price DOUBLE PRECISION;


CREATE TYPE ingredient_type AS ENUM (('VEGETABLE', 'ANIMAL', 'MARINE', 'DAIRY', 'OTHER'));

   CREATE TABLE Ingredient(
       id int PRIMARY KEY NOT NULL,
       name VARCHAR(255) NOT NULL,
       price NUMERIC NOT NULL,
       category ingredient_type,
       id_dish int,
       FOREIGN KEY (id_dish) REFERENCES Dish(id)
   );
