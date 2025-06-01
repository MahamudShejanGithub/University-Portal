-- Students
INSERT INTO student (id, name, email, password) VALUES (1, 'Alice', 'alice@example.com', 'password123');
INSERT INTO student (id, name, email, password) VALUES (2, 'Bob', 'bob@example.com', 'password456');

-- Courses
INSERT INTO course (id, name, code, description) VALUES (1, 'Math 101', 'MTH101', 'Basic Mathematics');
INSERT INTO course (id, name, code, description) VALUES (2, 'Physics 101', 'PHY101', 'Basic Physics');
INSERT INTO course (id, name, code, description) VALUES (3, 'Advanced Physics', 'PHY201', 'Requires Physics 101');

-- Course prerequisites
INSERT INTO course_prerequisites (course_id, prerequisite_id) VALUES (3, 2);

-- Password: password123 (BCrypt)
INSERT INTO student (id, name, email, password) VALUES (1, 'Alice', 'alice@example.com', '$2a$10$ZAZPq9WYdx4z38HfRqpZ1u3a0ZmKtw2vwopIvBZk3zBxy1GUt97xO');