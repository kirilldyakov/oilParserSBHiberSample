CREATE TABLE "company" (
	"id"	integer NOT NULL,
	"name"	varchar(255) UNIQUE,
	PRIMARY KEY("id")
);

CREATE TABLE "data_type" (
	"id"	integer NOT NULL,
	"name"	varchar(255) UNIQUE,
	PRIMARY KEY("id")
);

CREATE TABLE "liquid_type" (
	"id"	integer NOT NULL,
	"name"	varchar(255) UNIQUE,
	PRIMARY KEY("id")
);

CREATE TABLE "source_type" (
	"id"	integer NOT NULL,
	"name"	varchar(255) UNIQUE,
	PRIMARY KEY("id")
);

CREATE TABLE "data" (
	"id"	integer NOT NULL,
	"date"	datetime NOT NULL,
	"value"	integer NOT NULL,
	"company_id"	integer,
	"source_type_id"	integer,
	"liquid_type_id"	integer,
	"data_type_id"	integer,
	PRIMARY KEY("id"),
	FOREIGN KEY("company_id") REFERENCES company(id),
	FOREIGN KEY("source_type_id") REFERENCES data_type(id),
	FOREIGN KEY("liquid_type_id") REFERENCES liquid_type(id),
	FOREIGN KEY("data_type_id") REFERENCES data_type(id)
)

