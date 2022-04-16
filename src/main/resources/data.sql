INSERT INTO employee (id, name) VALUES ('E10001', 'Employee 1');
INSERT INTO employee (id, name) VALUES ('E10002', 'Employee 2');
INSERT INTO employee (id, name) VALUES ('E10003', 'Employee 3');
INSERT INTO employee (id, name) VALUES ('E10004', 'Employee 4');

INSERT INTO project (id, name) VALUES ('P1001', 'Project 1');
INSERT INTO project (id, name) VALUES ('P1002', 'Project 2');
INSERT INTO project (id, name) VALUES ('P1003', 'Project 3');
INSERT INTO project (id, name) VALUES ('P1004', 'Project 4');

INSERT INTO department (id, name) VALUES ('D101', 'Department 1');
INSERT INTO department (id, name) VALUES ('D102', 'Department 2');
INSERT INTO department (id, name) VALUES ('D103', 'Department 3');
INSERT INTO department (id, name) VALUES ('D104', 'Department 4');

INSERT INTO employee_project_department (id, PROJECT_ID, EMPLOYEE_ID, DEPARTMENT_ID) VALUES ('1', 'P1001', 'E10001', 'D101');
INSERT INTO employee_project_department (id, PROJECT_ID, EMPLOYEE_ID, DEPARTMENT_ID) VALUES ('2', 'P1002', 'E10001', 'D101');