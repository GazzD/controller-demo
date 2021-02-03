CREATE TABLE product (
  id BIGINT AUTO_INCREMENT NOT NULL,
  name VARCHAR(255),
  price DECIMAL(10,2),
  category VARCHAR(30),
  department VARCHAR(30),
  PRIMARY KEY (id)
);

INSERT INTO product (name, price, category, department) VALUES
('Diamond Necklace', 750.49, 'COMMERCIAL_NEW', 'JEWELRY'),
('Pooka Shell Bracelet', 7.50, 'HANDMADE', 'JEWELRY'),
('Commodore 64', 225.00, 'COMMERCIAL_USED', 'ELECTRONICS'),
('Baby Blue Tuxedo', 65.25, 'COMMERCIAL_USED', 'CLOTHING'),
('Rectangular Persian Rug', 7500.00, 'HANDMADE', 'HOMEGOODS');