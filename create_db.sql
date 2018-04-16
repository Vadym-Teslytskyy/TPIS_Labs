CREATE TABLE city
(
  city_id    INT AUTO_INCREMENT
    PRIMARY KEY,
  city_name  VARCHAR(255) NULL,
  country_id INT          NULL
)
  ENGINE = InnoDB;

CREATE INDEX FKrpd7j1p7yxr784adkx4pyepba
  ON city (country_id);

CREATE TABLE country
(
  country_id          INT AUTO_INCREMENT
    PRIMARY KEY,
  country_name        VARCHAR(255) NULL,
  restaurant_chain_id INT          NULL
)
  ENGINE = InnoDB;

CREATE INDEX FK8pg796jamgisml7twqr19drb3
  ON country (restaurant_chain_id);

ALTER TABLE city
  ADD CONSTRAINT FKrpd7j1p7yxr784adkx4pyepba
FOREIGN KEY (country_id) REFERENCES country (country_id);

CREATE TABLE restaurant_chain
(
  restaurant_chain_id      INT AUTO_INCREMENT
    PRIMARY KEY,
  restaurant_chain_founded DATE         NULL,
  restaurant_chain_name    VARCHAR(255) NULL
)
  ENGINE = InnoDB;

ALTER TABLE country
  ADD CONSTRAINT FK8pg796jamgisml7twqr19drb3
FOREIGN KEY (restaurant_chain_id) REFERENCES restaurant_chain (restaurant_chain_id);


