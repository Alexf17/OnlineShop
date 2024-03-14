INSERT INTO promo_codes (pc_id, discount, start_date, exp_date, max_number_of_uses, used)
VALUES (UUID_TO_BIN(UUID()), 5.0, '2024-03-14 12:00:00', '2024-03-29 12:00:00', 20, 1),
       (UUID_TO_BIN(UUID()), 10.0, '2024-03-14 12:00:00', '2024-03-29 12:00:00', 20, 0),
       (UUID_TO_BIN(UUID()), 3.5, '2024-03-14 12:00:00', '2024-03-29 12:00:00', 20, 0),
       (UUID_TO_BIN(UUID()), 7.0, '2024-03-14 12:00:00', '2024-03-29 12:00:00', 20, 1),
       (UUID_TO_BIN(UUID()), 20.0, '2024-03-14 12:00:00', '2024-03-29 12:00:00', 20, 0),;

INSERT INTO suppliers (su_id, name, address, city, postCode, country, phone)
VALUES (UUID_TO_BIN(UUID()), 'Tech Solutions Inc.', '123 Main Street', 'New York', '10001', 'USA', '123-456-7890'),
       (UUID_TO_BIN(UUID()), 'Gadgets World Ltd.', '456 Elm Avenue', 'Los Angeles', '90001', 'USA', '987-654-3210'),
       (UUID_TO_BIN(UUID()), 'Software Plus LLC', '789 Oak Road', 'Chicago', '60601', 'USA', '555-123-4567'),
       (UUID_TO_BIN(UUID()) 'Tech Innovations Ltd.', '101 Pine Street', 'San Francisco', '94101', 'USA',
        '777-888-9999'),
       (UUID_TO_BIN(UUID()), 'Digital Solutions LLC', '202 Maple Avenue', 'Seattle', '98101', 'USA', '111-222-3333');

INSERT INTO categories (cat_id, name, description, parent_category_id)
VALUES (UUID_TO_BIN(UUID()), 'electronics',
        'Explore our extensive collection of cutting-edge electronics, featuring the' ||
        ' latest gadgets and devices to enhance your digital lifestyle.', null),
       (UUID_TO_BIN(UUID()), 'notebooks', 'Whether you''re streaming movies on the go, staying connected with' ||
                                          ' friends and family, or playing games, it''s all easy with a laptop. ' ||
                                          'They are now very technically sophisticated and there is a wide variety' ||
                                          ' of laptops, ultrabooks and 2-in-1 devices to choose from. Depending on' ||
                                          ' what you want to use the notebook for, one of these variants will probably' ||
                                          ' suit you best.',
        (SELECT cat_id FROM categories WHERE name = 'electronics')),

       (UUID_TO_BIN(UUID()), 'consoles', 'Discover an array of gaming consoles to elevate your gaming experience,' ||
                                         ' from top brands to exclusive bundles, all conveniently located in our' ||
                                         ' Consoles section.',
        (SELECT cat_id FROM categories WHERE name = 'electronics')),
       (UUID_TO_BIN(UUID()), 'software ', 'Discover the latest software innovations in our online store''s software' ||
                                          ' category, offering a diverse range of applications for personal, professional,' ||
                                          ' and business use.', null),
       (UUID_TO_BIN(UUID()), 'office365',
        'Explore our extensive range of Office365 subscription plans, tailored to meet' ||
        ' the diverse needs of modern businesses and individuals alike.'
           , (SELECT cat_id FROM categories WHERE name = 'software'));

INSERT INTO products (p_id, name, description, quantity, price, is_active, category_id, supplier_id)
VALUES (UUID_TO_BIN(UUID()), 'XBOX SERIES X 1TB',
        'Kickstart your ultimate adventure with Xbox Series X and the Forza' ||
        ' Horizon 5 Premium Edition. ', 12, 300.5, true,
        (SELECT cat_id FROM categories WHERE name = 'consoles'),
        (SELECT su_id FROM suppliers WHERE name = 'Tech Solutions Inc.')),
       (UUID_TO_BIN(UUID()), 'Lenovo V15 Laptop',
        '16GB high-bandwidth RAM to smoothly run multiple applications and' ||
        ' browser tabs all at once; 512GB PCIe NVMe M.2 Solid State Drive allows' ||
        ' to fast bootup and data transfer',
        10, 370.5, true,
        (SELECT cat_id FROM categories WHERE name = 'notebooks'),
        (SELECT su_id FROM suppliers WHERE name = 'Gadgets World Ltd.')),
       (UUID_TO_BIN(UUID()), 'OfficeSuite Home & Business 2023 ',
        'Full 5-in-1 Office Pack for DOCUMENTS, SPREADSHEETS, PRESENTATIONS, PDF, and MAIL.', 10, 100, true,
        (SELECT cat_id FROM categories WHERE name = 'office365'),
        (SELECT su_id FROM suppliers WHERE name = 'Software Plus LLC')),
       (UUID_TO_BIN(UUID()), 'GPS Navigation for Car',
        'Providing Intelligent Current Speed Camera Alerts, Sound Warning, Route Planning, Street Names' ||
        ' Broadcast, Current Speed and Active Lane Assistant, Display Remaining Distance, telling Estimated' ||
        ' Arrival Time.', 5, 75.50, true,
        (SELECT cat_id FROM categories WHERE name = 'electronics'),
        (SELECT su_id FROM suppliers WHERE name = 'Tech Innovations Ltd.')),
       (UUID_TO_BIN(UUID()), 'Lenovo IdeaPad 1 Student Laptop',
        '20GB high-bandwidth RAM to smoothly run multiple applications and browser tabs all at once;' ||
        ' 1TB PCIe NVMe M.2 Solid State Drive + 128GB eMMC allows to fast bootup and data transfer',
        10, 333, true,
        (SELECT cat_id FROM categories WHERE name = 'notebooks'),
        (SELECT su_id FROM suppliers WHERE name = 'Digital Solutions LLC''')),
;
