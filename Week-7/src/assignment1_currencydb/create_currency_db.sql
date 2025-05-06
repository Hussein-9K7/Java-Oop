DROP DATABASE IF EXISTS currencydb;
CREATE DATABASE currencydb;
USE currencydb;

CREATE TABLE currency (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          abbreviation VARCHAR(10) NOT NULL,
                          name VARCHAR(50) NOT NULL,
                          rate_to_usd DOUBLE NOT NULL
);

INSERT INTO currency (abbreviation, name, rate_to_usd) VALUES ('USD', 'US Dollar', 1.00);
INSERT INTO currency (abbreviation, name, rate_to_usd) VALUES ('EUR', 'Euro', 0.91);
INSERT INTO currency (abbreviation, name, rate_to_usd) VALUES ('GBP', 'British Pound', 0.78);
INSERT INTO currency (abbreviation, name, rate_to_usd) VALUES ('JPY', 'Japanese Yen', 110.00);
INSERT INTO currency (abbreviation, name, rate_to_usd) VALUES ('CAD', 'Canadian Dollar', 1.36);
INSERT INTO currency (abbreviation, name, rate_to_usd) VALUES ('AUD', 'Australian Dollar', 1.49);
INSERT INTO currency (abbreviation, name, rate_to_usd) VALUES ('CHF', 'Swiss Franc', 0.91);
INSERT INTO currency (abbreviation, name, rate_to_usd) VALUES ('CNY', 'Chinese Yuan', 7.23);

DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password123';
GRANT SELECT, INSERT ON currencydb.* TO 'appuser'@'localhost';
