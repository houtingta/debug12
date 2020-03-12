--Insert data into three tables
/*Insert data into department table*/
INSERT INTO department (name, description, location) VALUES
('HR', 'Human Resource', 'Room 100, 999 Washington Ave. Falls Church, VA'),
('R&D', 'Research and Development', 'Room 101, 999 Washington Ave. Falls Church, VA'),
('Tech', 'Technical Support', 'Room 102, 999 Washington Ave. Falls Church, VA'),
('CS', 'Custom Service', 'Room 103, 999 Washington Ave. Falls Church, VA');

/*Insert data into employee table*/
INSERT INTO employee (name, first_name, last_name, email, address, department_id) VALUES
('dwang', 'David', 'Wang', 'david.wang@training.ascendingdc.com', '999 Washington Ave, Fairfax, VA 22030', 2),
('rhang', 'Ryo', 'Hang', 'ryo.hang@training.ascendingdc.com', '998 Washington Ave, Fairfax, VA 22030', 2),
('gzhang', 'Gloria', 'Zhang', 'gloria.zhang@training.ascendingdc.com', '997 Washington Ave, Fairfax, VA 22030', 1),
('xhuang', 'Xingyue', 'Huang', 'xingyue.Hang@training.ascendingdc.com', '996 Washington Ave, Fairfax, VA 22030', 3);

/*Insert data into account table*/
INSERT INTO account (type, balance, employee_id) VALUES
('guest', 100.72, 1),
('member', 1000.99, 2),
('vip',99999.99,3),
('boss',6666666.66,3);
