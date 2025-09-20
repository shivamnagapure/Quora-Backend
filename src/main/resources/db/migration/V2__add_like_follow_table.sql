CREATE TABLE likes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    target_type ENUM('question','answer','comment') NOT NULL,
    target_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,

    UNIQUE (user_id , target_type , target_id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);