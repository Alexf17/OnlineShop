

INSERT INTO promo_codes (pc_id, name, discount, start_date, exp_date, max_number_of_uses, used)
VALUES (UUID(), 'SPRINGSALE', 5.0, '2024-03-14 12:00:00', '2024-03-29 12:00:00', 20, 1),
       (UUID(), 'SUMMERDEAL', 10.0, '2024-03-14 12:00:00', '2024-03-29 12:00:00', 20, 0),
       (UUID(), 'WELCOME10', 10, '2024-03-14 12:00:00', '2024-03-29 12:00:00', 20, 0),
       (UUID(), 'HOLIDAYSALE', 7.0, '2024-03-14 12:00:00', '2024-03-29 12:00:00', 20, 1),
       (UUID(), 'NEWCUSTOMER', 20.0, '2024-03-14 12:00:00', '2024-03-29 12:00:00', 20, 0);

INSERT INTO suppliers (su_id, name, address, city, postcode, country, phone)
VALUES (UUID(), 'Tech Solutions Inc.', '123 Main Street', 'NEW_YORK', 'W7RTY3I', 'USA', '123-456-7890'),
       (UUID(), 'Gadgets World Ltd.', '456 Elm Avenue', 'LOS_ANGELES', 'HD87R', 'USA', '987-654-3210'),
       (UUID(), 'Software Plus LLC', '789 Oak Road', 'CHICAGO', 'HD34U', 'USA', '555-123-4567'),
       (UUID(), 'Tech Innovations Ltd.', '101 Pine Street', 'SAN_FRANCISCO', 'HD87R', 'USA',
        '777-888-9999'),
       (UUID(), 'Digital Solutions LLC', '202 Maple Avenue', 'SEATTLE', 'HD34U', 'USA', '111-222-3333');

INSERT INTO shippers (sh_id, name, phone)
VALUES (UUID(), 'FastShip', '+1234567890'),
       (UUID(), 'QuickDeliver', '+0987654321'),
       (UUID(), 'SpeedyCourier', '+9876543210'),
       (UUID(), 'SwiftTransit', '+0123456789'),
       (UUID(), 'RapidLogistics', '+9876543210');

INSERT INTO categories (cat_id, name, description, parent_category_id)
VALUES (UUID(), 'electronics',
        'Explore our extensive collection of cutting-edge electronics, featuring the
latest gadgets and devices to enhance your digital lifestyle.', null),
       (UUID(), 'software', 'Discover the latest software innovations in our online store''s software
category, offering a diverse range of applications for personal, professional,
and business use.', null);

INSERT INTO categories (cat_id, name, description, parent_category_id)
SELECT UUID(),
       'notebooks',
       'Whether you''re streaming movies on the go, staying connected with
friends and family, or playing games, it''s all easy with a laptop.',
       cat_id
FROM categories
WHERE name = 'electronics'
UNION ALL
SELECT UUID(),
       'office365',
       'Explore our extensive range of Office365 subscription plans, tailored to meet
the diverse needs of modern businesses and individuals alike.',
       cat_id
FROM categories
WHERE name = 'software'
UNION ALL
SELECT UUID(),
       'consoles',
       'Discover an array of gaming consoles to elevate your gaming experience,
from top brands to exclusive bundles, all conveniently located in our
Consoles section.',
       cat_id
FROM categories
WHERE name = 'electronics';

INSERT INTO products (p_id, name, description, quantity, price, is_active, category_id, supplier_id)
VALUES (UUID(), 'XBOX SERIES X 1TB',
        'Kickstart your ultimate adventure with Xbox Series X and the Forza
Horizon 5 Premium Edition. ', 12, 300.5, true,
        (SELECT cat_id FROM categories WHERE name = 'consoles'),
        (SELECT su_id FROM suppliers WHERE name = 'Tech Solutions Inc.')),
       (UUID(), 'Lenovo V15 Laptop',
        '16GB high-bandwidth RAM to smoothly run multiple applications and
browser tabs all at once; 512GB PCIe NVMe M.2 Solid State Drive allows to fast bootup and data transfer',
        10, 370.5, true,
        (SELECT cat_id FROM categories WHERE name = 'notebooks'),
        (SELECT su_id FROM suppliers WHERE name = 'Gadgets World Ltd.')),
       (UUID(), 'OfficeSuite Home & Business 2023',
        'Full 5-in-1 Office Pack for DOCUMENTS, SPREADSHEETS, PRESENTATIONS, PDF, and MAIL.', 10, 100, true,
        (SELECT cat_id FROM categories WHERE name = 'office365'),
        (SELECT su_id FROM suppliers WHERE name = 'Software Plus LLC')),
       (UUID(), 'GPS Navigation for Car',
        'Providing Intelligent Current Speed Camera Alerts, Sound Warning, Route Planning, Street Names
Broadcast, Current Speed and Active Lane Assistant, Display Remaining Distance, telling Estimated
Arrival Time.', 5, 75.50, true,
        (SELECT cat_id FROM categories WHERE name = 'electronics'),
        (SELECT su_id FROM suppliers WHERE name = 'Tech Innovations Ltd.')),
       (UUID(), 'Lenovo IdeaPad 1 Student Laptop',
        '20GB high-bandwidth RAM to smoothly run multiple applications and browser tabs all at once;
1TB PCIe NVMe M.2 Solid State Drive + 128GB eMMC allows to fast bootup and data transfer',
        10, 333, true,
        (SELECT cat_id FROM categories WHERE name = 'notebooks'),
        (SELECT su_id FROM suppliers WHERE name = 'Digital Solutions LLC'));

INSERT INTO roles (role_id, role_name)
VALUES (UUID(), 'Administrator'),
       (UUID(), 'Manager'),
       (UUID(), 'Client');

INSERT INTO authorities (auth_id, authority_name)
VALUES (UUID(), 'CREATE_ORDER'),
       (UUID(), 'CREATE_PRODUCT'),
       (UUID(), 'WRITE_REVIEW'),
       (UUID(), 'VIEW_ORDERS'),
       (UUID(), 'MANAGE_INVENTORY');

INSERT INTO user_info (ui_id, user_name, password, address, city, postcode, card_number, phone, email, date_of_birth)
VALUES (CAST('123e1237-e89b-12d3-a456-426655440000'as binary(16)), 'john_doe', 'password123', '123 Main St', 'NUREMBERG', 'HD34U',
        '1234 5678 9012 3456', '+1234567890',
        'john.doe@example.com', '1990-01-01 12:00:00'),
       (CAST('223e4567-e81b-13d3-a466-436655442222'as binary(16)), 'jane_smith', 'p@ssw0rd', '456 Elm St', 'BOCHUM', 'HD87R',
        '9876 5432 1098 7654',
        '+1987654321',
        'jane.smith@example.com', '1985-05-15 12:00:00'),
       (CAST('323e4567-e82b-14d3-a476-446655444444'as binary(16)), 'mike_jackson', 'securePW', '789 Oak St', 'CHICAGO', 'HD34U',
        '2468 1357 8024 6813', '+1765432109',
        'mike.jackson@example.com', '1978-11-30 12:00:00'),
       (CAST('423e4567-e83b-15d3-a486-456655446666'as binary(16)), 'emily_wang', '12345678', '321 Pine St', 'HOUSTON', 'HD87R',
        '8642 9753 2106 4832', '+1654321098',
        'emily.wang@example.com', '1995-09-20 12:00:00'),
       (CAST('523e4567-e84b-16d3-a496-466655448888'as binary(16)), 'alex_jones', 'password', '654 Birch St', 'BIELEFELD', 'HD34U',
        '7531 8642 3069 1752',
        '+1443210987',
        'alex.jones@example.com', '1982-03-10 12:00:00');

INSERT INTO users (u_id, first_name, second_name, country, created_at, user_info_id)
VALUES (CAST('93c4aee5-079e-481b-9d27-118585650913'as binary(16)), 'John', 'Doe', 'USA', '2024-03-10 12:00:00',
        (SELECT ui_id FROM user_info WHERE user_name = 'john_doe') ),
       (CAST('e40ae67a-d6e6-4a4e-bcc1-9a8e97646e7b'as binary(16)), 'Jane', 'Smith', 'UK', '2024-03-09 12:00:00',
        (SELECT ui_id FROM user_info WHERE user_name = 'jane_smith')),
       (CAST('2fd6dd51-98a7-40f5-ba8d-1d2e87c6740c'as binary(16)), 'Michael', 'Johnson', 'CANADA', '2024-03-08 12:00:00',
        (SELECT ui_id FROM user_info WHERE user_name = 'mike_jackson')),
       (CAST('875e44d3-21d7-4b5c-98d5-fc6f5d0b72e8'as binary(16)), 'Emily', 'Brown', 'USA', '2024-03-07 12:00:00',
        (SELECT ui_id FROM user_info WHERE user_name = 'emily_wang')),
       (CAST('b7ed6b7d-07a3-457b-918d-f47f7353cc3c'as binary(16)), 'David', 'Wilson', 'GERMANY', '2024-03-06 12:00:00',
        (SELECT ui_id FROM user_info WHERE user_name = 'alex_jones'));

INSERT INTO reviews (r_id, content, created_at, rate, user_id, product_id)
VALUES (UUID(), 'Great product, highly recommend it!', '2024-03-10 12:00:00','EXCELLENT',
        (SELECT u_id FROM users WHERE first_name = 'John'),
        (SELECT p_id FROM products WHERE name = 'XBOX SERIES X 1TB')),
       (UUID(), 'Excellent service, very satisfied with my purchase.', '2024-03-09 12:00:00','VERY_GOOD',
        (SELECT u_id FROM users WHERE first_name = 'Jane'),
        (SELECT p_id FROM products WHERE name = 'Lenovo V15 Laptop')),
       (UUID(), 'Average product, could be better.', '2024-03-08 12:00:00','NOT_BAD',
        (SELECT u_id FROM users WHERE first_name = 'Michael'),
        (SELECT p_id FROM products WHERE name = 'OfficeSuite Home & Business 2023')),
       (UUID(), 'Not impressed, had issues with functionality.', '2024-03-07 12:00:00','GOOD',
        (SELECT u_id FROM users WHERE first_name = 'Emily'),
        (SELECT p_id FROM products WHERE name = 'GPS Navigation for Car')),
       (UUID(), 'Poor quality, disappointed with my purchase.', '2024-03-06 12:00:00','GOOD',
        (SELECT u_id FROM users WHERE first_name = 'David'),
        (SELECT p_id FROM products WHERE name = 'Lenovo IdeaPad 1 Student Laptop'));

INSERT INTO orders (o_id, created_at, status, promo_code_id, user_id, shipper_id)
VALUES (UUID(), '2024-03-10 12:00:00', 'SUCCESSFUL', (SELECT pc_id FROM promo_codes WHERE name = 'SPRINGSALE'),
        (SELECT u_id FROM users WHERE first_name = 'John'),
        (SELECT sh_id FROM shippers WHERE name = 'FastShip')),
       (UUID(), '2024-03-09 12:00:00', 'PROCESSING', (SELECT pc_id FROM promo_codes WHERE name = 'SUMMERDEAL'),
        (SELECT u_id FROM users WHERE first_name = 'Jane'),
        (SELECT sh_id FROM shippers WHERE name = 'QuickDeliver')),
       (UUID(), '2024-03-08 12:00:00', 'UNSUCCESSFUL', (SELECT pc_id FROM promo_codes WHERE name = 'WELCOME10'),
        (SELECT u_id FROM users WHERE first_name = 'Michael'),
        (SELECT sh_id FROM shippers WHERE name = 'SpeedyCourier')),
       (UUID(), '2024-03-07 12:00:00', 'CANCELED', (SELECT pc_id FROM promo_codes WHERE name = 'NEWCUSTOMER'),
        (SELECT u_id FROM users WHERE first_name = 'Emily'),
        (SELECT sh_id FROM shippers WHERE name = 'SwiftTransit')),
       (UUID(), '2024-03-06 12:00:00', 'SHIPPED', (SELECT pc_id FROM promo_codes WHERE name = 'NEWCUSTOMER'),
        (SELECT u_id FROM users WHERE first_name = 'David'),
        (SELECT sh_id FROM shippers WHERE name = 'RapidLogistics'));

INSERT INTO orders_detail (od_id, quantity, order_id, product_id)
VALUES (UUID(), 2, (SELECT o_id FROM orders WHERE status = 'SUCCESSFUL'),
        (SELECT p_id FROM products WHERE name = 'XBOX SERIES X 1TB')),
       (UUID(), 1, (SELECT o_id FROM orders WHERE status = 'SUCCESSFUL'),
        (SELECT p_id FROM products WHERE name = 'Lenovo V15 Laptop')),
       (UUID(), 1, (SELECT o_id FROM orders WHERE status = 'PROCESSING'),
        (SELECT p_id FROM products WHERE name = 'Lenovo V15 Laptop')),
       (UUID(), 3, (SELECT o_id FROM orders WHERE status = 'SHIPPED'),
        (SELECT p_id FROM products WHERE name = 'OfficeSuite Home & Business 2023')),
       (UUID(), 1, (SELECT o_id FROM orders WHERE status = 'UNSUCCESSFUL'),
        (SELECT p_id FROM products WHERE name = 'GPS Navigation for Car')),
       (UUID(), 2, (SELECT o_id FROM orders WHERE status = 'CANCELED'),
        (SELECT p_id FROM products WHERE name = 'Lenovo IdeaPad 1 Student Laptop'));

INSERT INTO authorities_roles (role_id, auth_id)
values ((select role_id from roles where role_name = 'Administrator'),
        (select auth_id from authorities where authority_name = 'CREATE_ORDER')),
       ((select role_id from roles where role_name = 'Manager'),
        (select auth_id from authorities where authority_name = 'CREATE_PRODUCT')),
       ((select role_id from roles where role_name = 'Manager'),
        (select auth_id from authorities where authority_name = 'WRITE_REVIEW')),
       ((select role_id from roles where role_name = 'Client'),
        (select auth_id from authorities where authority_name = 'MANAGE_INVENTORY')),
       ((select role_id from roles where role_name = 'Client'),
        (select auth_id from authorities where authority_name = 'VIEW_ORDERS'));

INSERT INTO user_info_roles (role_id, ui_id)
values ((select role_id from roles where role_name = 'Administrator'),
        (select ui_id from user_info where user_name = 'john_doe')),
       ((select role_id from roles where role_name = 'Manager'),
        (select ui_id from user_info where user_name = 'jane_smith')),
       ((select role_id from roles where role_name = 'Client'),
        (select ui_id from user_info where user_name = 'mike_jackson')),
       ((select role_id from roles where role_name = 'Client'),
        (select ui_id from user_info where user_name = 'emily_wang')),
       ((select role_id from roles where role_name = 'Client'),
        (select ui_id from user_info where user_name = 'alex_jones'));