CREATE TABLE IF NOT EXISTS store(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  geolocation_id INT NOT NULL,
  collaborator_id INT NULL,
  city_id INT NOT NULL,
  CONSTRAINT fk_stor_geo FOREIGN KEY (geolocation_id) REFERENCES geolocation (id),
  CONSTRAINT fk_stor_col FOREIGN KEY (collaborator_id) REFERENCES collaborator (id),
  CONSTRAINT fk_store_city FOREIGN KEY(city_id) REFERENCES city(id),
  PRIMARY KEY(id)
);