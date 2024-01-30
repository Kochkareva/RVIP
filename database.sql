-- Создание таблицы
CREATE TABLE t_number (
                     id SERIAL PRIMARY KEY,
                     number INTEGER NOT NULL,
                     is_Even BOOLEAN NOT NULL
);