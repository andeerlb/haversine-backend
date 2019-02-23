CREATE TABLE IF NOT EXISTS collaborator(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  geolocation_id INT NOT NULL,
  city_id INT NOT NULL,
  CONSTRAINT fk_col_geo FOREIGN KEY (geolocation_id) REFERENCES geolocation (id),
  CONSTRAINT fk_col_city FOREIGN KEY(city_id) REFERENCES city(id),
  PRIMARY KEY(id)
);