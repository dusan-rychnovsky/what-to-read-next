SET IGNORECASE TRUE;

CREATE TABLE Authors (
	authorId INT NOT NULL IDENTITY,
	firstname VARCHAR(255),
	lastname VARCHAR(255)
);

CREATE TABLE Books (
	bookId INT NOT NULL IDENTITY,
	title VARCHAR(255),
	description LONGVARCHAR,
	imageUrl VARCHAR(255)
);

CREATE TABLE Authorship (
	authorId INT NOT NULL,
	bookId INT NOT NULL
);

CREATE TABLE Reviews (
	bookId INT NOT NULL,
	opinionId INT NOT NULL
);

CREATE TABLE Opinions (
	opinionId INT NOT NULL IDENTITY,
	opinion VARCHAR(255)
);

INSERT INTO Opinions (opinion)
VALUES ('LIKE');


INSERT INTO Opinions (opinion)
VALUES ('DISLIKE');

INSERT INTO Opinions (opinion)
VALUES ('NEUTRAL');
