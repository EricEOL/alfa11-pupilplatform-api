INSERT INTO PUPIL(name, email, password) VALUES('Pupil01', 'pupil01@email.com', '$2a$10$c.V9rtFtchEGpIr7wyKLiumGNrWyZppHRtT3L4RDWS7ZejkcnAVJ.');
INSERT INTO PUPIL(name, email, password) VALUES('Admin01', 'admin01@email.com', '$2a$10$c.V9rtFtchEGpIr7wyKLiumGNrWyZppHRtT3L4RDWS7ZejkcnAVJ.');

INSERT INTO ROLE(id, name) VALUES(1, 'ROLE_PUPIL');
INSERT INTO ROLE(id, name) VALUES(2, 'ROLE_ADMIN');

INSERT INTO PUPIL_ROLES(pupil_id, roles_id) VALUES(1, 1);
INSERT INTO PUPIL_ROLES(pupil_id, roles_id) VALUES(2, 2);

INSERT INTO OPERATION(stock, points, created_at, pupil_id) VALUES('Dólar', 27, '2022-01-30 18:00:00', 1);
INSERT INTO OPERATION(stock, points, created_at, pupil_id) VALUES('B3', 490, '2022-01-27 18:00:00', 1);
INSERT INTO OPERATION(stock, points, created_at, pupil_id) VALUES('Dólar', 14, '2022-01-08 18:00:00', 1);