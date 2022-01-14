CREATE TABLE IF NOT EXISTS studs(
last_name       CHAR(10) PRIMARY KEY NOT NULL,
name            CHAR(10) NOT NULL,
login           CHAR(10) NOT NULL,
password        CHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS wish(
name            CHAR(10) NOT NULL,
surname       CHAR(10) PRIMARY KEY NOT NULL,
wishes         CHAR(10) NOT NULL,
recDate        date
);