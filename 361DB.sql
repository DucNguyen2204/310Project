drop table if exists Bank;
drop table if exists Account;
drop table if exists User;

CREATE TABLE User(
	userId int not null primary key auto_increment,
    cardNumber varchar(20),
    PIN varchar(4)
)collate=latin1_general_cs;

CREATE TABLE Account(
	accountId int not null primary key auto_increment,
    userId int not null,
    availableFund double,
    currencyName varchar(10),
    exchangeRateToUSD double,
    exchangeRateFromUSD double,
    
    foreign key (userId) references User(userId)
    
)collate=latin1_general_cs;

CREATE TABLE Bank(
	bankId int not null primary key auto_increment,
    accountId int not null,
    bankName varchar(255),
    foreign key (accountId) references Account(accountId)
)collate=latin1_general_cs;

INSERT INTO User(cardNumber, PIN) values ("0321 3213 4313 5543", "3214");
INSERT INTO User(cardNumber, PIN) values ("4321 4315 6542 4523", "3534");
INSERT INTO User(cardNumber, PIN) values ("8526 5622 9349 5425", "1345");
INSERT INTO User(cardNumber, PIN) values ("6589 2554 5425 5424", "5425");
INSERT INTO User(cardNumber, PIN) values ("6892 5425 5657 6956", "8659");
INSERT INTO User(cardNumber, PIN) values ("8491 5456 3112 4902", "0900");

INSERT INTO Account(userId, availableFund, currencyName, exchangeRateToUSD, exchangeRateFromUSD) values ((SELECT userId FROM User WHERE userId = 3), 4813.43, "USD", 1.00, 1.00);
INSERT INTO Account(userId, availableFund, currencyName, exchangeRateToUSD, exchangeRateFromUSD) values ((SELECT userId FROM User WHERE userId = 1), 14314.31, "USD", 1.00, 1.00);
INSERT INTO Account(userId, availableFund, currencyName, exchangeRateToUSD, exchangeRateFromUSD) values ((SELECT userId FROM User WHERE userId = 2), 5432401, "VND", 0.000044, 22831.05);
INSERT INTO Account(userId, availableFund, currencyName, exchangeRateToUSD, exchangeRateFromUSD) values ((SELECT userId FROM User WHERE userId = 5), 68194, "CNY", 	0.16, 6.33);
INSERT INTO Account(userId, availableFund, currencyName, exchangeRateToUSD, exchangeRateFromUSD) values ((SELECT userId FROM User WHERE userId = 6), 542153, "JPY", 0.0094, 106.4);
INSERT INTO Account(userId, availableFund, currencyName, exchangeRateToUSD, exchangeRateFromUSD) values ((SELECT userId FROM User WHERE userId = 4), 34132, "GBP", 1.39, 0.72);

INSERT INTO Bank(accountId, bankName) values ((SELECT accountId FROM Account WHERE accountId = 1), "Wells Fargo");
INSERT INTO Bank(accountId, bankName) values ((SELECT accountId FROM Account WHERE accountId = 3), "Techcom Bank");
INSERT INTO Bank(accountId, bankName) values ((SELECT accountId FROM Account WHERE accountId = 5), "Mizuho Trust & Banking");
INSERT INTO Bank(accountId, bankName) values ((SELECT accountId FROM Account WHERE accountId = 2), "US BANK");
INSERT INTO Bank(accountId, bankName) values ((SELECT accountId FROM Account WHERE accountId = 4), "Hua Xia Bank");
INSERT INTO Bank(accountId, bankName) values ((SELECT accountId FROM Account WHERE accountId = 6), "Barclays");

SELECT * FROM User;
SELECT * FROM Account;
SELECT * FROM Bank;