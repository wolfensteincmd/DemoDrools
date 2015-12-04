DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
  id       VARCHAR(10) PRIMARY KEY,
  balance  DECIMAL(8,2)
);