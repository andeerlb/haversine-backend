/* password default: 123 */

INSERT INTO users(id, user_name, password, account_expired, account_locked, credentials_expired, enabled)
VALUES (1, 'admin','$2a$10$Ja5eUUt7q1x2RmDIzKpTXu7Pstpg10Dkxwf5f2CRE.lQf8yJyEDFa', false, false, false, true);

INSERT INTO users(id, user_name, password, account_expired, account_locked, credentials_expired, enabled)
VALUES (2, 'reader', '$2a$10$Ja5eUUt7q1x2RmDIzKpTXu7Pstpg10Dkxwf5f2CRE.lQf8yJyEDFa', false, false, false, true);

INSERT INTO users(id, user_name, password, account_expired, account_locked, credentials_expired, enabled)
VALUES (3, 'modifier','$2a$10$Ja5eUUt7q1x2RmDIzKpTXu7Pstpg10Dkxwf5f2CRE.lQf8yJyEDFa', false, false, false, true);

INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 1);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 2);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 3);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 4);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 5);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 6);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 7);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 8);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 9);

INSERT INTO users_authorities(user_id, authority_id) VALUES (2, 2);
INSERT INTO users_authorities(user_id, authority_id) VALUES (2, 6);

INSERT INTO users_authorities(user_id, authority_id) VALUES (3, 3);
INSERT INTO users_authorities(user_id, authority_id) VALUES (3, 7);