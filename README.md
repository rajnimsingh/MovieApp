# MovieApp

In Order to use this project, please download Mysql Workbench for your machine.

After donwloading Mysql Workbench, follow the below steps:

1) Create new connection. 
2) Add the name of Database movie_db
3) Run the below commands:
4) use movie_db;
5) Create the table using following query:
```
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
