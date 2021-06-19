
-- Teams schema

-- !Ups

CREATE TABLE teams (
	id INTEGER PRIMARY KEY,
	name TEXT NOT NULL,
	description TEXT NOT NULL
);

-- !Downs

DROP TABLE teams;