USE dulces_y_ladridos;
-- Usuarios
INSERT INTO users(first_name,last_name,telephone_number,email,password,birth_date)
VALUES("Carlos","Chongo","961-271-4616","cacc.chongo@gmail.com","patitas1207","2000-12-07");
INSERT INTO users(first_name,last_name,telephone_number,email,password,birth_date)
VALUES("Erik","Contreras","961-271-4616","casiqbp@gmail.com","patitas0806","2000-08-06");
INSERT INTO users(first_name,last_name,telephone_number,email,password,birth_date)
VALUES("Frida","Estrada","961-271-4616","FridaEstrada24@gmail.com","patitas0701","2001-07-01");
INSERT INTO users(first_name,last_name,telephone_number,email,password,birth_date)
VALUES("Victor","Mairena","961-271-4616","vmairenafx@gmail.com","patitas1117","1999-11-17");
INSERT INTO users(first_name,last_name,telephone_number,email,password,birth_date)
VALUES("Andres","Pardo","961-271-4616","jorgeandres.pardorea@gmail.com","patitas1126","1998-11-26");
INSERT INTO users(first_name,last_name,telephone_number,email,password,birth_date)
VALUES("Fernando","Cervantes","961-271-4616","fer2311cervantes@gmail.com","patitas1123","2000-11-23");
INSERT INTO users(first_name,last_name,telephone_number,email,password,birth_date)
VALUES("Giss","Islas","961-271-4616","gissislas0493@gmail.com","patitas0419","2000-04-19");
INSERT INTO users(first_name,last_name,telephone_number,email,password,birth_date)
VALUES("Daniela","Gomez","961-271-4616","dansmc.courses@gmail.com","patitas1218","2000-12-18");
INSERT INTO users(first_name,last_name,telephone_number,email,password,birth_date)
VALUES("Bastian","Cortés","961-271-4616","coab1998@gmail.com","patitas1002","2000-10-02");

-- asignando privilegios
INSERT INTO users_has_privileges(id_user,id_privilege)
VALUES(1,2);
INSERT INTO users_has_privileges(id_user,id_privilege)
VALUES(2,3);
INSERT INTO users_has_privileges(id_user,id_privilege)
VALUES(3,2);
INSERT INTO users_has_privileges(id_user,id_privilege)
VALUES(4,2);
INSERT INTO users_has_privileges(id_user,id_privilege)
VALUES(5,2);
INSERT INTO users_has_privileges(id_user,id_privilege)
VALUES(6,2);
INSERT INTO users_has_privileges(id_user,id_privilege)
VALUES(7,2);
INSERT INTO users_has_privileges(id_user,id_privilege)
VALUES(8,2);
INSERT INTO users_has_privileges(id_user,id_privilege)
VALUES(9,2);

SELECT
  users.first_name,
  users.last_name,
  privileges.privilege
FROM
  users
INNER JOIN
  users_has_privileges
  ON users.id_user = users_has_privileges.id_user
INNER JOIN
  privileges
  ON users_has_privileges.id_privilege = privileges.id_privilege;