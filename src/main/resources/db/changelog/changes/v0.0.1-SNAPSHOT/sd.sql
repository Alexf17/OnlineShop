-- liquibase formatted sql

-- changeset alex_f17:1
CREATE TABLE IF NOT EXISTS user_info_roles
(
    ui_id BINARY(16) NOT NULL,
    role_id BINARY(16),
    PRIMARY KEY (role_id,ui_id),
    FOREIGN KEY (role_id) REFERENCES roles (role_id),
    FOREIGN KEY (ui_id) REFERENCES user_info (ui_id)
    );