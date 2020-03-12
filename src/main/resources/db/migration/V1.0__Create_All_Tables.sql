--Create Three tables - employee, department, and account
CREATE TABLE department (
    id                SERIAL NOT NULL,
    name              VARCHAR(30) NOT NULL UNIQUE,
    description       VARCHAR(150),
    location          VARCHAR(100),
    CONSTRAINT  department_did_pk PRIMARY KEY (id)
);

CREATE TABLE employee(
    id              SERIAL NOT NULL,
    name            VARCHAR(30) NOT NULL UNIQUE,
    first_name      VARCHAR(30),
    last_name       VARCHAR(30),
    email           VARCHAR(50),
    address         VARCHAR(150),
    age             INTEGER,
    salary          NUMERIC(7,2),
    department_id   INTEGER,
    CONSTRAINT  employee_eid_pk PRIMARY KEY (id),
    CONSTRAINT  employee_edid_fk FOREIGN KEY (department_id) REFERENCES department (id)
);


CREATE TABLE account (
    id               	SERIAL NOT NULL,
    type				VARCHAR(30) NOT NULL UNIQUE,
    balance				NUMERIC(10,2),
    employee_id        	INTEGER,
    CONSTRAINT  account_aid_pk PRIMARY KEY (id),
    CONSTRAINT  account_aeid_fk FOREIGN KEY (employee_id) REFERENCES employee (id)
);

