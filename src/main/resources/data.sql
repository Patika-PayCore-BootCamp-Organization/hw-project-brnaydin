
--  Initially drops all tables

DROP TABLE IF EXISTS tbl_post;
DROP TABLE IF EXISTS tbl_dict_status_post;
DROP TABLE IF EXISTS tbl_dict_type_post;
DROP TABLE IF EXISTS tbl_user;
DROP TABLE IF EXISTS tbl_dict_status_user;
DROP TABLE IF EXISTS tbl_dict_type_user;

-- user status : ACTIVE,INACTIVE
CREATE TABLE tbl_dict_status_user
(
    id   INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(50)
);

-- user type : ADMIN,MEMBER
CREATE TABLE tbl_dict_type_user
(
    id   INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(50)
);

-- user table
CREATE TABLE tbl_user
(
    id       INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    name     VARCHAR(50),
    surname  VARCHAR(50),
    status   VARCHAR(50) NOT NULL,
    type     VARCHAR(50) NOT NULL,
    FOREIGN KEY (status) REFERENCES tbl_dict_status_user (code) ,
    FOREIGN KEY (type) REFERENCES tbl_dict_type_user (code)
);

-- post status : ACTIVE, INACTIVE, DRAFT
CREATE TABLE tbl_dict_status_post
(
    id   INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(50)
);

-- post type : ARTICLE, COMMENT
CREATE TABLE tbl_dict_type_post
(
    id   INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(50)
);

-- post table
CREATE TABLE tbl_post
(
    id         INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    parent_id  INT,
    title      VARCHAR(50),
    content    VARCHAR(255),
    status     VARCHAR(50) NOT NULL,
    type       VARCHAR(50) NOT NULL,
    author_id  INT UNIQUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    created_by INT,
    updated_by INT,

    FOREIGN KEY (author_id) REFERENCES tbl_user (id),
    FOREIGN KEY (status) REFERENCES tbl_dict_status_post (code),
    FOREIGN KEY (type) REFERENCES tbl_dict_type_post (code)
);

--  Sample static test values

INSERT INTO tbl_dict_status_user(id, code, name)
VALUES (1, 'ACTIVE', 'Active'),
       (2, 'INACTIVE', 'Inactive');

INSERT INTO tbl_dict_type_user(id, code, name)
VALUES (1, 'ADMIN', 'Admin'),
       (2, 'MEMBER', 'Member');

INSERT INTO tbl_user(id, username, name, surname, status, type)
VALUES (1, 'baranaydin', 'baran', 'aydin', 'ACTIVE', 'ADMIN'),
       (2, 'alitunc', 'ali', 'tunc', 'ACTIVE', 'MEMBER'),
       (3, 'velidemir', 'veli', 'demir', 'ACTIVE', 'MEMBER'),
       (4, 'halilcelik', 'halil', 'celik', 'ACTIVE', 'MEMBER'),
       (5, 'hasangumus', 'hasan', 'gumus', 'INACTIVE', 'MEMBER');

INSERT INTO tbl_dict_status_post(id, code, name)
VALUES (1, 'ACTIVE', 'Active'),
       (2, 'INACTIVE', 'Inactive'),
       (3, 'DRAFT', 'Draft');

INSERT INTO tbl_dict_type_post(id, code, name)
VALUES (1, 'ARTICLE', 'Article'),
       (2, 'COMMENT', 'Comment');


INSERT INTO tbl_post(title, content, status, type, author_id, created_at, updated_at, created_by, updated_by)
VALUES ('Sırbistan Gezisi', 'Sırbistan 10 üzerinden 7 alır', 'ACTIVE', 'ARTICLE', 1, '2015-01-08 14:05:06',
        '2019-04-18 16:03:08', 2, 2),
       ('Makedonya Gezisi', 'Makedonya 10 üzerinden 5 alır', 'ACTIVE', 'ARTICLE', 2, '2016-03-08 10:06:26',
        '2022-01-18 16:03:08', 2, 2),
       ('Sırbistan Gezi Yorumu', 'Sırbistan kesinlikle 10 üzerinden 9 alır', 'ACTIVE', 'COMMENT', 3,
        '2018-05-28 09:11:01', '2019-04-18 16:03:08', 3, 3),
       ('Sırbistan Gezi Yorumu', 'Sırbistan bence 10 üzerinden 3 bile alamaz', 'INACTIVE', 'COMMENT', 4,
        '2019-01-08 19:04:02', '2022-01-10 13:35:08', 4, 4),
       ('Sırbistan Gezi Yorumu', 'Sırbistan bence 10 üzerinden 5 alır', 'DRAFT', 'COMMENT', 5, '2022-01-11 16:34:02',
        '2022-01-12 13:35:08', 5, 5);
