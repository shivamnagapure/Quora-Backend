CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    bio VARCHAR(255)
);

CREATE TABLE questions(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    title VARCHAR(255) NOT NULL,
    body VARCHAR(255) NOT NULL,
    user_id BIGINT NOT NULL,

    CONSTRAINT fk_question_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE answers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    text VARCHAR(255) NOT NULL,
    question_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_answer_question FOREIGN KEY (question_id) REFERENCES  questions(id) ON DELETE CASCADE,
    CONSTRAINT fk_answer_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE comments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id BIGINT NOT NULL,
    text VARCHAR(255) NOT NULL,
    parent_comment_id BIGINT NULL ,
    answer_id BIGINT NULL,

    CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_comment_answer FOREIGN KEY (answer_id) REFERENCES answers(id) ON DELETE CASCADE,
    CONSTRAINT fk_comment_parent_comment FOREIGN KEY (parent_comment_id) REFERENCES comments(id) ON DELETE CASCADE
);

CREATE TABLE topics (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    name VARCHAR(255) NOT NULL UNIQUE

);

CREATE TABLE questions_topics (
    question_id BIGINT NOT NULL,
    topic_id BIGINT NOT NULL,
    CONSTRAINT fk_question_topic_question FOREIGN KEY (question_id) REFERENCES questions(id) ON DELETE CASCADE,
    CONSTRAINT fk_question_topic_topic FOREIGN KEY (topic_id) REFERENCES topics(id) ON DELETE CASCADE,
    PRIMARY KEY (question_id, topic_id)
);


