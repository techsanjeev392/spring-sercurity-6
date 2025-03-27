-- Insert Roles
INSERT INTO role (id, role_name) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, role_name) VALUES (2, 'ROLE_ADMIN');

-- Insert Users
INSERT INTO users (id, username, password, email) VALUES (1, 'john_doe', 'password123', 'john@example.com');
INSERT INTO users (id, username, password, email) VALUES (2, 'jane_doe', 'password456', 'jane@example.com');

-- Assign Roles to Users
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- john_doe is USER
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- jane_doe is ADMIN

-- Insert Categories
INSERT INTO category (id, name) VALUES (1, 'Electronics');
INSERT INTO category (id, name) VALUES (2, 'Clothing');

-- Insert Products
INSERT INTO product (id, name, price, description, category_id) 
VALUES (1, 'Smartphone', 699.99, 'High-end smartphone with great features', 1);
INSERT INTO product (id, name, price, description, category_id) 
VALUES (2, 'Laptop', 999.99, 'Powerful laptop for professionals', 1);
INSERT INTO product (id, name, price, description, category_id) 
VALUES (3, 'Headphones', 199.99, 'Noise-cancelling wireless headphones', 1);
INSERT INTO product (id, name, price, description, category_id) 
VALUES (4, 'T-Shirt', 19.99, 'Cotton t-shirt with modern design', 2);
INSERT INTO product (id, name, price, description, category_id) 
VALUES (5, 'Jeans', 49.99, 'Slim-fit jeans for everyday use', 2);

-- Insert Carts for Users
INSERT INTO cart (id, user_id) VALUES (1, 1); -- Cart for john_doe
INSERT INTO cart (id, user_id) VALUES (2, 2); -- Cart for jane_doe

-- Add Products to Carts
INSERT INTO cart_product (id, cart_id, product_id, quantity) VALUES (1, 1, 1, 2); -- 2 Smartphones for john
INSERT INTO cart_product (id, cart_id, product_id, quantity) VALUES (2, 1, 4, 3); -- 3 T-Shirts for john
INSERT INTO cart_product (id, cart_id, product_id, quantity) VALUES (3, 2, 2, 1); -- 1 Laptop for jane
INSERT INTO cart_product (id, cart_id, product_id, quantity) VALUES (4, 2, 5, 2); -- 2 Jeans for jane
