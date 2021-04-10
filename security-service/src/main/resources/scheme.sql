INSERT INTO user (id, username, password) VALUES (1, 'sindy', '$10$NxV07ERtX7ZP3lFqj7ofXuxJb5WCcf7ziDvozktu/G4IP4eiHxf2C');
INSERT INTO user (id, username, password)  VALUES (2, 'admin', '$2a$10$10mJfOzf8wF2ljJ2ubTN0.QRuKqR4ypkaisoIxqP84LFu9F6e/Wrq');

INSERT INTO role (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);