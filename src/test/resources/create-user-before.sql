delete from user_role;
delete from usr;

insert into usr(id, active, password, username) values
(1, true, '$2a$08$fnaH7yBbw38cAfZhlTGVCuj/a6WuYzqMX5QEDlCmOF/dQpJaWoQ2S', 'testuser'),
(2, true, '$2a$08$3rfPUhp3Cq/BkZtKKfxHDuI3mfGXRYyGj0c2I9lWoVdqLUvJxhJ4a', 'mike');

insert into user_role(user_id, roles) values
(1, 'ADMIN'), (1, 'USER'),
(2, 'USER');