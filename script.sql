DROP TABLE IF EXISTS Konto;

CREATE TABLE Konto(
    kontonr varchar(50) NOT NULL,
    saldo double,
    eier varchar(50) NOT NULL,
    lock_var integer NOT NULL,
    PRIMARY KEY (kontonr)
);