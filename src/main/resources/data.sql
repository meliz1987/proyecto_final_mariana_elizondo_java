INSERT INTO categoria (id, nombre) VALUES (1, 'Animales');
INSERT INTO categoria (id, nombre) VALUES (2, 'Muñecos');
INSERT INTO categoria (id, nombre) VALUES (3, 'Llaveros');
INSERT INTO categoria (id, nombre) VALUES (4, 'Plantas');

-- Ejemplo: necesitarás ids de categoria ya que usamos FK.
INSERT INTO amigurumi (id, descripcion, precio, categoria_id) VALUES (1, 'Oveja', 22000.0, 1);
INSERT INTO amigurumi (id, descripcion, precio, categoria_id) VALUES (2, 'Gatito Blanco', 25000.0, 1);
