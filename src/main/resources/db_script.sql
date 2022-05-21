use movie_db;

create table movie
(
    ID              INTEGER      not null primary key auto_increment,
    MOVIE_NAME      VARCHAR(500) not null unique,
    MOVIE_DESC      VARCHAR(500) not null,
    RELEASE_DATE    date         not null,
    DURATION        DOUBLE       not null,
    COVER_PHOTO_URL VARCHAR(500) not null,
    TRAILER_URL     VARCHAR(500) not null
);