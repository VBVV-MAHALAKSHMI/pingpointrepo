-- data.sql

INSERT INTO persons (username, email) VALUES ('john_doe', 'john@example.com');
INSERT INTO persons (username, email) VALUES ('alice', 'alice@example.com');

INSERT INTO endpoints (name) VALUES ('/news');
INSERT INTO endpoints (name) VALUES ('/sports');

INSERT INTO posts (content, user_id, endpoint_id) VALUES
('Hello world!', 1, 1),
('Breaking news!', 2, 1),
('Sports update!', 1, 2);

INSERT INTO person_endpoints (user_id, endpoint_id) VALUES
(1, 1), -- john subscribed to /news
(1, 2), -- john subscribed to /sports
(2, 1); -- alice subscribed to /news
