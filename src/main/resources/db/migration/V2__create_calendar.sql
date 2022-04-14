CREATE TABLE "calendar" (
	"id"	integer NOT NULL,
	"date"	datetime UNIQUE,
	"en_date"	varchar(255),
	"ru_date"	varchar(255),
	PRIMARY KEY("id")
);