use master
go

drop database if exists timesheet
create database timesheet
go

use timesheet
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

insert into account(employee_id, username, password, email, account_privilege)
values(1, 'admin', 'admin', 'thaiphan0804@gmail.com', 'test')

select password
from account
where username='admin'
go

create proc selectPer
@pageNumber int, @rowOfPages int
as
begin
select * from employee
	order by employee_id
	offset (@pageNumber-1)*@rowOfPages rows
	fetch next @rowOfPages rows only
	end 
go
selectPer 6,20

select * from employee
	order by employee_id
	offset (1-1)*20 rows
	fetch next 20 rows only