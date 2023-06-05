CREATE TABLE IF NOT EXISTS full_time_interval
(
    id BIGSERIAL PRIMARY KEY,
    full_time_interval int DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS blue_line
(
    id BIGSERIAL PRIMARY KEY,
    beginning_time_period TIME DEFAULT NULL,
    end_time_period TIME DEFAULT NULL,
    weekends_days_interval DOUBLE PRECISION DEFAULT NULL,
    working_days_interval DOUBLE PRECISION DEFAULT NULL,
    friday_days_interval DOUBLE PRECISION DEFAULT NULL,
    full_time_interval_id BIGINT DEFAULT NULL,
    CONSTRAINT FK6verypuaocmpwfgjcjyd9vk0r FOREIGN KEY(full_time_interval_id) REFERENCES full_time_interval(id)
);

CREATE TABLE IF NOT EXISTS green_line
(
    id BIGSERIAL PRIMARY KEY,
    beginning_time_period TIME DEFAULT NULL,
    end_time_period TIME DEFAULT NULL,
    weekends_days_interval DOUBLE PRECISION DEFAULT NULL,
    working_days_interval DOUBLE PRECISION DEFAULT NULL,
    full_time_interval_id BIGINT DEFAULT NULL,
    CONSTRAINT FKjujtewjnplxllnnqs51cxpsri FOREIGN KEY(full_time_interval_id) REFERENCES full_time_interval(id)
);

CREATE TABLE IF NOT EXISTS red_line
(
    id BIGSERIAL PRIMARY KEY,
    beginning_time_period TIME DEFAULT NULL,
    end_time_period TIME DEFAULT NULL,
    weekends_days_interval DOUBLE PRECISION DEFAULT NULL,
    working_days_interval DOUBLE PRECISION DEFAULT NULL,
    friday_days_interval DOUBLE PRECISION DEFAULT NULL,
    full_time_interval_id BIGINT DEFAULT NULL,
    CONSTRAINT FKp0vxhlw0sl7rb44peicuallfv FOREIGN KEY(full_time_interval_id) REFERENCES full_time_interval(id)
);

CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY,
    password VARCHAR(255) DEFAULT NULL,
    username VARCHAR(255) DEFAULT NULL,
    active BIT(1) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS user_role
(
    user_id BIGINT NOT NULL,
    roles VARCHAR(255) DEFAULT NULL,
    CONSTRAINT FKj345gk1bovqvfame88rcx7yyx FOREIGN KEY(user_id) REFERENCES users(id)
);