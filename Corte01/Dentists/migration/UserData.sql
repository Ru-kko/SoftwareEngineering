CREATE TABLE usr
(
    id       UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name     VARCHAR(255)  NOT NULL,
    email    VARCHAR(255)  NOT NULL UNIQUE,
    password VARCHAR(1024) NOT NULL,
    role     VARCHAR(255)  NOT NULL
);

CREATE TABLE responsible
(
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    firstName VARCHAR(255),
    lastName  VARCHAR(255),
    dni        VARCHAR(255),
    birthDate DATE
);

CREATE TABLE schedule
(
    id        UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    startHour TIME NOT NULL,
    endHour   TIME NOT NULL
);