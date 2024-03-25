
CREATE TABLE IF NOT EXISTS  promo_codes (
                             pc_id BINARY(16) PRIMARY KEY NOT NULL,
                             name VARCHAR(50) NOT NULL,
                             discount DOUBLE NOT NULL,
                             start_date TIMESTAMP NOT NULL,
                             exp_date TIMESTAMP NOT NULL,
                             max_number_of_uses INTEGER NOT NULL,
                             used INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS  categories (
                            cat_id BINARY(16) PRIMARY KEY NOT NULL,
                            name VARCHAR(50) NOT NULL UNIQUE,
                            description clob NOT NULL,
                            parent_category_id BINARY(16)
);

CREATE TABLE IF NOT EXISTS suppliers (
                           su_id BINARY(16) PRIMARY KEY NOT NULL,
                           name VARCHAR(30) NOT NULL UNIQUE,
                           address VARCHAR(50) NOT NULL,
                           city VARCHAR(50) NOT NULL,
                           postcode VARCHAR(50) NOT NULL,
                           country VARCHAR(50) NOT NULL,
                           phone VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS shippers (
                          sh_id BINARY(16) PRIMARY KEY NOT NULL,
                          name VARCHAR(30) NOT NULL UNIQUE,
                          phone VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS reviews (
                         r_id BINARY(16) PRIMARY KEY NOT NULL,
                         content VARCHAR(60) NOT NULL UNIQUE,
                         created_at TIMESTAMP NOT NULL,
                         rate VARCHAR(60) NOT NULL,
                         user_id BINARY(16) NOT NULL,
                         product_id BINARY(16) NOT NULL
);

CREATE TABLE IF NOT EXISTS roles (
                       role_id BINARY(16) PRIMARY KEY NOT NULL,
                       role_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_info (
                           ui_id BINARY(16) PRIMARY KEY NOT NULL,
                           user_name VARCHAR(255) NOT NULL,
                           password VARCHAR(255) NOT NULL,
                           address VARCHAR(255) NOT NULL,
                           city VARCHAR(255) NOT NULL,
                           postcode VARCHAR(255) NOT NULL,
                           card_number VARCHAR(255) NOT NULL,
                           phone VARCHAR(255) NOT NULL,
                           email VARCHAR(255) NOT NULL,
                           date_of_birth TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
                                     u_id BINARY(16) primary key  NOT NULL,
                                     first_name VARCHAR(255) NOT NULL,
                                     second_name VARCHAR(255) NOT NULL,
                                     country VARCHAR(255) NOT NULL,
                                     created_at TIMESTAMP NOT NULL,
                                     user_info_id BINARY(16) NOT NULL


);

CREATE TABLE IF NOT EXISTS authorities (
                             auth_id BINARY(16) PRIMARY KEY NOT NULL,
                             authority_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
                        o_id BINARY(16) PRIMARY KEY NOT NULL,
                        created_at TIMESTAMP NOT NULL,
                        status VARCHAR(255) NOT NULL,
                        promo_code_id BINARY(16),
                        user_id BINARY(16) NOT NULL,
                        shipper_id BINARY(16)
);

CREATE TABLE IF NOT EXISTS products (
                          p_id BINARY(16) PRIMARY KEY NOT NULL,
                          name VARCHAR(255) NOT NULL,
                          description VARCHAR(365),
                          quantity INTEGER NOT NULL,
                          price NUMERIC(19,4) NOT NULL,
                          is_active BOOLEAN NOT NULL,
                          category_id BINARY(16),
                          supplier_id BINARY(16)
);

CREATE TABLE IF NOT EXISTS orders_detail (
                               od_id BINARY(16) PRIMARY KEY NOT NULL,
                               quantity INTEGER NOT NULL,
                               order_id BINARY(16) NOT NULL,
                               product_id BINARY(16) NOT NULL
);

CREATE TABLE IF NOT EXISTS authorities_roles (
                                   role_id BINARY(16) NOT NULL,
                                   auth_id BINARY(16) NOT NULL,
                                   PRIMARY KEY (role_id, auth_id),
                                   CONSTRAINT roles_authorities_roles FOREIGN KEY (role_id) REFERENCES roles (role_id),
                                   CONSTRAINT authorities_roles_authorities FOREIGN KEY (auth_id) REFERENCES authorities (auth_id)
);

CREATE TABLE IF NOT EXISTS user_info_roles (
                                 role_id BINARY(16) NOT NULL,
                                 ui_id BINARY(16) NOT NULL,
                                 PRIMARY KEY (role_id, ui_id),
                                 CONSTRAINT roles_user_info FOREIGN KEY (role_id) REFERENCES roles (role_id),
                                 CONSTRAINT user_info_roles FOREIGN KEY (ui_id) REFERENCES user_info (ui_id)
);