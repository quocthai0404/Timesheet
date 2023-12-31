use master
go

drop database if exists timesheet_new
create database timesheet_new
go

use timesheet_new
go

--DATE - format: yyyy-MM-dd.
create table employee
(
	employee_id int primary key identity not null,
	employee_name varchar(100) not null,
	position varchar(50) not null,
	birthday date not null,
	gender bit not null
)
go

create table leave
(
	leave_id int primary key identity not null,
	employee_id int FOREIGN KEY REFERENCES employee(employee_id) not null, 
	leave_type varchar(30) not null,
	startdate date not null,
	number_of_days int not null, 
	reason varchar(255),
	approved bit

)
go

create table account
(	
	account_id int primary key identity not null,
	employee_id int FOREIGN KEY REFERENCES employee(employee_id) not null, 
	username varchar(50) not null,
	password varchar(255) not null,
	email varchar(100) not null,
)
go

 
 create table salary 
 (
	salary_id int primary key identity not null,
	employee_id int FOREIGN KEY REFERENCES employee(employee_id) not null,
	base_salary float,
	overtime_pay float,
	paid_leave_pay float, 
	allowance float

 )
 go

create table detailed_salary
(
	detailed_salary_id int primary key identity not null,
	employee_id int FOREIGN KEY REFERENCES employee(employee_id) not null,
	base_salary float,
	paid_leave_pay float, 
	allowance float,
	number_of_paid_leave_days int,
	number_of_unpaid_leave_days int, 
	number_of_overtime_hours float,
	unpaid_leave_deduction float,
	overtime_pay float
)
go

create table work_shift
(
    work_shift_id int primary key identity not null,
    description varchar(50) not null
)
GO

create table work_schedule
(
	work_schedule_id int primary key identity not null,
	employee_id int FOREIGN KEY REFERENCES employee(employee_id) not null,
	work_date date not null,
	work_shift_id int FOREIGN KEY REFERENCES work_shift(work_shift_id) not null,
	work_type varchar(50) not null
)

create table attendance
(
	attendance_id int primary key identity not null,
	employee_id int FOREIGN KEY REFERENCES employee(employee_id) not null,
	work_schedule_id int FOREIGN KEY REFERENCES work_schedule(work_schedule_id) not null,
	time_in datetime not null, 
	time_out datetime not null, 
	hours_worked float not null, 
	status varchar(50) not null
)

create table salary_deduction
(
	salary_deduciton_id int primary key identity not null,
	employee_id int FOREIGN KEY REFERENCES employee(employee_id) not null,
	deduction_reason varchar(255) not null,
	deduction_amount float not null,
	deduction_date date not null
)
go

insert into employee(employee_name, position, birthday, gender)
values('michale', 'manager', '2000-11-19', 1)
INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('John Doe', 'manager', '1995-01-01', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Jane Doe', 'employee', '1996-02-02', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Peter Pan', 'manager', '1997-03-03', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Wendy Darling', 'employee', '1998-04-04', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Captain Hook', 'manager', '1999-05-05', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Tick-Tock the Crocodile', 'employee', '2000-06-06', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Mr. Smee', 'manager', '2001-07-07', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Mrs. Darling', 'employee', '2002-08-08', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Mr. Darling', 'manager', '2003-09-09', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Michael Darling', 'employee', '2004-10-10', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('John Darling', 'manager', '2005-11-11', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Wendy Darling', 'employee', '2006-12-12', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Peter Pan', 'manager', '2007-01-01', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Wendy Darling', 'employee', '2008-02-02', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Captain Hook', 'manager', '2009-03-03', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Tick-Tock the Crocodile', 'employee', '2010-04-04', 0);

insert into work_shift(description)
values('8am-12pm, 13pm-17pm');

insert into work_schedule(employee_id, work_date, work_shift_id, work_type)
values (1, '2023-03-01', 1, 'overtime');

insert into salary_deduction(employee_id, deduction_reason, deduction_amount, deduction_date)
values (1, 'abc', 2000, '2000-09-09');

delete from work_schedule
where work_schedule_id = 2
go

update work_schedule 
set employee_id = 2, 
work_date = '2000-12-31', 
work_shift_id = 1, 
work_type = 'regular' 
where work_schedule_id=3
go


update employee
set employee_name = '',
position='',
birthday= '',
gender=0
where employee_id=18
go

SELECT CONVERT(VARCHAR(32), HashBytes('MD5', 'http://laptrinhvb.net'), 2)

insert into account(employee_id, username, password, email)
values(1, 'admin', 'admin', 'thaiphan0804@gmail.com', 'test')

select password
from account
where username='admin'
go

insert into account(employee_id, username, password, email)
values(1, 'manager', 'manager', 'thaiphan0804@gmail.com')

insert into account(employee_id, username, password, email)
values(3, 'employee', 'employee', 'thaiphan@gmail.com')

select * from employee where employee_id=8


select account.username, account.password, employee.position
from account
inner join employee on employee.employee_id=account.employee_id
where account.username='manager'
go

--proc
CREATE PROCEDURE InsertAccount
    @employee_id INT,
    @username VARCHAR(50),
    @password VARCHAR(255),
    @email VARCHAR(100)
AS
BEGIN
    SET NOCOUNT ON;

    INSERT INTO account (employee_id, username, password, email)
    VALUES (@employee_id, @username, @password, @email);
END;
GO
-------------------------
-------------------------
select account.username, account.password, employee.position, account.employee_id
from account
inner join employee on employee.employee_id=account.employee_id
where account.username='employee'
go

ALTER TABLE work_schedule
DROP COLUMN work_type;

ALTER TABLE work_shift
ADD work_type varchar(50);

<<<<<<< HEAD
insert into leave(employee_id, leave_type, startdate, number_of_days, reason, approved)
values (2, 'unpaid leave', '2000-12-31', 2, 'laksdjlkasdj', 0)

SELECT * FROM account where email = 'thaiphan0804@gmail.com'

select description from work_shift;
=======
UPDATE leave SET approved=1,leave_type='paid leave'  WHERE leave_id=5
select * from leave

select * from work_shift

select * from attendance 
where employee_id=1

select * from leave

SELECT SUM(number_of_days) AS total_number_of_day
FROM leave
WHERE employee_id = 2
AND MONTH(startdate) = 12;

SELECT SUM(number_of_days) AS total_number_of_day, SUM(number_of_days) AS total_number_of_day
FROM leave
WHERE employee_id = 1
AND YEAR(startdate) = 2000;
select * from leave
SELECT SUM(number_of_days) AS total_number_of_day_month, SUM(number_of_days) AS total_number_of_day_year FROM leave WHERE employee_id = 3 AND MONTH(startdate) = 12 AND YEAR(startdate) = 2023;

select * from leave
select * from employee

insert into leave(employee_id, leave_type, startdate, number_of_days, reason, approved)
values (20, 'unpaid leave', '2000-09-09', 2, 'okxcasd', 0)

insert into leave(employee_id, leave_type, startdate, number_of_days, reason, approved)
values (20, 'unpaid leave', '2000-10-09', 2, 'okxcasd', 0)
SELECT SUM(number_of_days) AS total_number_of_day_month, SUM(number_of_days) AS total_number_of_day_year 
FROM leave 
WHERE employee_id = 20 AND MONTH(startdate) = 09 and YEAR(startdate) = 2000;


SELECT 
    SUM(CASE WHEN MONTH(startdate) = 9 THEN number_of_days ELSE 0 END) AS total_days_in_month,
    SUM(CASE WHEN YEAR(startdate) = 2000 THEN number_of_days ELSE 0 END) AS total_days_in_2000
FROM
    leave
WHERE
    employee_id = 9
GROUP BY
    employee_id;
select * from employee
insert into account(employee_id, username, password, email)
values(104, 'test1', 'test1', 'sad')

insert into leave(employee_id,leave_type,startdate,number_of_days,reason,approved)
values(100, 'abc', '2000-12-31', 3, 'asdas', null);

