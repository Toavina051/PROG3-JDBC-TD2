INSERT INTO Dish (id, name, dish_type) VALUES
                                           (1, 'Salade fraiche', 'START'),
                                           (2, 'Poulet grille', 'MAIN'),
                                           (3, 'Riz aux legumes', 'MAIN'),
                                           (4, 'Gateau au chocolat', 'DESSERT'),
                                           (5, 'Salade de fruits', 'DESSERT');

INSERT INTO Ingredient (id, name, price, category, id_dish) VALUES
                                                                (1,'Laitue', '800.00', 'VEGETABLE', 1),
                                                                (2, 'Tomate', '600.00', 'VEGETABLE',1),
                                                                (3, 'Poulet', '4500.00', 'ANIMAL', 2),
                                                                (4, 'Chocolat', '3000.00', 'OTHER', 4),
                                                                (5, 'Beurre', '2500.00', 'DAIRY', 4);

UPDATE dish SET price = 2000 WHERE name = 'Salade fraiche';
UPDATE dish SET price = 6000 WHERE name = 'Poulet grille';
UPDATE dish SET price = NULL WHERE name = 'Riz au légume';
UPDATE dish SET price = NULL WHERE name = 'Gâteau au chocolat';
UPDATE dish SET price = NULL WHERE name = 'Salade de fruit';
