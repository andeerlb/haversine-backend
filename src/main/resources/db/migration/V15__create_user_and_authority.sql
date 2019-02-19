CREATE TABLE IF NOT EXISTS authority (
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS users (
   id INT PRIMARY KEY AUTO_INCREMENT,
   account_expired boolean,
   account_locked boolean,
   credentials_expired boolean,
   enabled boolean,
   password varchar(255),
   user_name varchar(255)
);

CREATE TABLE IF NOT EXISTS users_authorities (
   user_id INT,
   authority_id INT,
   PRIMARY KEY (user_id, authority_id)
);

ALTER TABLE users_authorities
ADD CONSTRAINT FK_users_authorities_authority
FOREIGN KEY (authority_id) REFERENCES authority(id);

ALTER TABLE users_authorities
ADD CONSTRAINT FK_users_authorities_user
FOREIGN KEY (user_id) REFERENCES users(id);