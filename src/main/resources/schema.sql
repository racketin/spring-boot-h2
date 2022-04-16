create table employee (
    ID VARCHAR(128) NOT NULL,
	name VARCHAR(128) NOT NULL,	
    PRIMARY KEY (id)
);

create table project (
    ID VARCHAR(128) NOT NULL,
	name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

create table department (
    ID VARCHAR(128) NOT NULL,
	name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

create table employee_Project_Department (
    ID VARCHAR(128) NOT NULL,
	PROJECT_ID VARCHAR(128) NOT NULL ,
	EMPLOYEE_ID VARCHAR(128) NOT NULL ,
	DEPARTMENT_ID VARCHAR(128)  NOT NULL ,
    PRIMARY KEY (id),
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES employee(ID),
    FOREIGN KEY (PROJECT_ID) REFERENCES project(ID),
    FOREIGN KEY (DEPARTMENT_ID) REFERENCES department(ID)
);