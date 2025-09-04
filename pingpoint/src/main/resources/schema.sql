-- schema.sql

CREATE TABLE persons (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE endpoints (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(255),
    user_id INT,
    endpoint_id BIGINT,
    CONSTRAINT fk_post_user FOREIGN KEY (user_id) REFERENCES persons(id),
    CONSTRAINT fk_post_endpoint FOREIGN KEY (endpoint_id) REFERENCES endpoints(id)
);

-- Join table for many-to-many relation between users & endpoints
CREATE TABLE person_endpoints (
    user_id INT,
    endpoint_id BIGINT,
    PRIMARY KEY (user_id, endpoint_id),
    CONSTRAINT fk_ue_user FOREIGN KEY (user_id) REFERENCES persons(id),
    CONSTRAINT fk_ue_endpoint FOREIGN KEY (endpoint_id) REFERENCES endpoints(id)
);
