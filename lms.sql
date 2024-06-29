SELECT * from books;

create DATABASE librarymanagementsystem;


INSERT INTO books (title, author) VALUES ('The Great Gatsby', 'F. Scott Fitzgerald');

SELECT * from books;




SELECT * from user_profiles;


SELECT count(*) from BOOK_REQUESTS;
SELECT * FROM BOOK_REQUESTS;

update BOOK_REQUESTS set user_id = 1;

drop table BOOK_REQUESTS;
drop table user_profiles;
DROP TABLE BOOKS;
delete from BOOK_REQUESTS where user_id is NULL;






drop table BOOK_REQUESTS;   











CREATE TABLE BOOK_REQUESTS (
    status_flg CHAR(1),
    admin_id BIGINT,
    book_id BIGINT,
    book_name VARCHAR(255),
    id BIGINT NOT NULL,
    request_date DATETIME2(6),
    return_date DATETIME2(6),
    user_id BIGINT,
    PRIMARY KEY (id)
);

CREATE TABLE books (
    id BIGINT IDENTITY NOT NULL,
    author VARCHAR(255),
    title VARCHAR(255),
        quantity INT,
    PRIMARY KEY (id)
);

CREATE TABLE events (
    capacity INT,
    endtime DATETIME2(6),
    id BIGINT IDENTITY NOT NULL,
    starttime DATETIME2(6),
    eventlocation VARCHAR(255),
    eventname VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE user_accounts (
    id BIGINT IDENTITY NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL,
    pasword VARCHAR(255) NOT NULL,
    userrole VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE user_profiles (
    id BIGINT NOT NULL,
    fname VARCHAR(255),
    lname VARCHAR(255),
    adress VARCHAR(255),
    mobno VARCHAR(255),
    CONSTRAINT fk_user_profiles_user_accounts FOREIGN KEY (id) REFERENCES user_accounts(id),
    PRIMARY KEY (id)
);

CREATE TABLE rooms (
    id INTEGER IDENTITY(1,1) PRIMARY KEY,
    roomname VARCHAR(255) NOT NULL,
    starttime DATETIME,
    endtime DATETIME,
    capacity INT,
    roomstatus VARCHAR(255) NOT NULL,
);


INSERT INTO  user_profiles (username,pasword,userrole) VALUES('suchi','suchi','student');
select * from BOOK_REQUESTS;

TRUNCATE TABLE BOOK_REQUESTS;

INSERT INTO rooms (capacity, endtime, starttime, roomname, roomstatus)
VALUES
    (10, '2024-04-13 10:00:00', '2024-04-13 12:00:00', 'Room A', 'Available'),
    (8, '2024-04-13 14:00:00', '2024-04-13 16:00:00', 'Room B', 'Occupied'),
    (12, '2024-04-13 09:00:00', '2024-04-13 11:00:00', 'Room C', 'Available');
