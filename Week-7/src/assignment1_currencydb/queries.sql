USE currencydb;

SELECT * FROM currency;

SELECT * FROM currency WHERE abbreviation = 'EUR';

SELECT COUNT(*) AS total_currencies FROM currency;

SELECT * FROM currency ORDER BY rate_to_usd DESC LIMIT 1;
