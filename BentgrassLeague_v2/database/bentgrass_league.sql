Begin Transaction;

DROP TABLE IF EXISTS member, tournament, golf_course, round, tournament_round CASCADE;

CREATE TABLE member
(
    member_id serial,
    userName  VARCHAR(50) UNIQUE NOT NULL,
    CONSTRAINT PK_member PRIMARY KEY (member_id),
    CONSTRAINT UQ_userName UNIQUE (userName)
);

CREATE TABLE tournament
(
    tournament_id serial,
    season        int          NOT NULL,
    event_name    VARCHAR(100) NOT NULL,
    from_date     date         NOT NULL,
    to_date       date         NOT NULL,
    CONSTRAINT PK_tournament PRIMARY KEY (tournament_id)
);

CREATE TABLE golf_course
(
    golf_course_id serial,
    name           VARCHAR(50)   NOT NULL,
    par            int           NOT NULL,
    yardage        int           NOT NULL,
    course_rating   numeric(6, 2) NOT NULL,
    CONSTRAINT PK_golf_course PRIMARY KEY (golf_course_id)
);

CREATE TABLE round
(
    round_id       serial,
    golf_course_id int         NOT NULL,
    round_score    int         NOT NULL,
    round_type     VARCHAR(20) NOT NULL,
    date_played    timestamp   NOT NULL,
    member_id      int         NOT NULL,
    CONSTRAINT PK_round_id PRIMARY KEY (round_id),
    CONSTRAINT FK_golf_course_id FOREIGN KEY (golf_course_id) REFERENCES golf_course (golf_course_id),
    CONSTRAINT FK_member_id FOREIGN KEY (member_id) REFERENCES member(member_id),
    CONSTRAINT CHK_round_type CHECK (round_type IN ('Competitive, Casual, Tournament')),
    CONSTRAINT CHK_round_score CHECK(round_score BETWEEN 40 AND 120)
);

CREATE TABLE tournament_round
(
    round_id int NOT NULL,
    tournament_id int NOT NULL,
    CONSTRAINT PK_tournament_round PRIMARY KEY(round_id, tournament_id),
    CONSTRAINT FK_tournament_round_round FOREIGN KEY (round_id) REFERENCES round (round_id),
    CONSTRAINT FK_tournament_round_tournament FOREIGN KEY (tournament_id) REFERENCES tournament (tournament_id)
);

COMMIT;