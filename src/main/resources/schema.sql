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
