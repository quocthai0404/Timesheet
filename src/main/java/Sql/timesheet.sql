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
	reason varchar(255)
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
    description varchar(50) not null,
	work_type varchar(50) not null
)
GO

CREATE TABLE work_schedule (
  work_schedule_id int PRIMARY KEY IDENTITY NOT NULL,
  employee_id int FOREIGN KEY REFERENCES employee(employee_id) NOT NULL,
  work_date date NOT NULL,
  work_shift_id int FOREIGN KEY REFERENCES work_shift(work_shift_id) NOT NULL,
  isHide bit NOT NULL DEFAULT 0
);



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
alter table attendance
drop column status;

alter table attendance
alter column time_in varchar(50) null

alter table attendance
alter column time_out varchar(50) null



create table salary_deduction
(
	salary_deduciton_id int primary key identity not null,
	employee_id int FOREIGN KEY REFERENCES employee(employee_id) not null,
	deduction_reason varchar(255) not null,
	deduction_amount float not null,
	deduction_date date not null
)
go

create table HRaccount(
	id int primary key identity not null,
	username varchar(50),
	password varchar(50)
)

insert into employee(employee_name, position, birthday, gender)
values('michale', 'manager', '2000-11-19', 1)

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('John Doe', 'employee', '1995-01-01', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Jane Doe', 'employee', '1996-02-02', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Peter Pan', 'employee', '1997-03-03', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Wendy Darling', 'employee', '1998-04-04', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Captain Hook', 'employee', '1999-05-05', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Tick-Tock the Crocodile', 'employee', '2000-06-06', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Mr. Smee', 'employee', '2001-07-07', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Mrs. Darling', 'employee', '2002-08-08', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Mr. Darling', 'employee', '2003-09-09', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Michael Darling', 'employee', '2004-10-10', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('John Darling', 'employee', '2005-11-11', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Wendy Darling', 'employee', '2006-12-12', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Peter Pan', 'employee', '2000-01-01', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Wendy Darling', 'employee', '2002-02-02', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Captain Hook', 'employee', '2002-03-03', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Maris', 'employee', '1999-04-04', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Meliora', 'employee', '1998-06-04', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Lysandra', 'employee', '1997-09-19', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Letitia', 'employee', '1999-02-11', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Glenda', 'employee', '1987-03-09', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Guinevere', 'employee', '1989-05-07', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Gerda', 'employee', '1990-04-09', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Eirlys', 'employee', '1999-07-15', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Eira', 'employee', '2000-04-12', 0);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Acacia', 'employee', '2001-05-04', 1);

INSERT INTO employee (employee_name, position, birthday, gender)
VALUES ('Agnes', 'employee', '2000-09-04', 0);

INSERT INTO work_shift(description, work_type)
VALUES ('8h-12h | 13h-17h', 'regular');

INSERT INTO work_shift(description, work_type)
VALUES ('8h-12h', 'regular');

INSERT INTO work_shift(description, work_type)
VALUES ('13h-17h', 'regular');

INSERT INTO work_shift(description, work_type)
VALUES ('17h-20h', 'overtime');

insert into account(employee_id, username,password, email)
values(1, 'manager', 'manager', 'manager@gmail.com')

insert into account(employee_id, username,password, email)
values(2, 'employee', 'employee', 'employee@gmail.com')

create table admin( 
	id int primary key identity,
	username varchar(50) not null,
	password varchar(50) not null
)

insert into admin(username, password)
values('admin', 'admin')






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


SELECT 
    SUM(CASE WHEN MONTH(startdate) = 9 THEN number_of_days ELSE 0 END) AS total_days_in_month,
    SUM(CASE WHEN YEAR(startdate) = 2000 THEN number_of_days ELSE 0 END) AS total_days_in_2000
FROM
    leave
WHERE
    employee_id = 9
GROUP BY
    employee_id;

	select ws.work_schedule_id, ws.employee_id,ws.work_date,ws.work_shift_id,work_shift.description
	from work_schedule as ws
	inner join work_shift
	on  work_shift.work_shift_id=ws.work_shift_id
	where ws.employee_id=2
	go

	insert into work_schedule(employee_id, work_date, work_shift_id)
	values (4, '2000-12-31', 2)
	select * from work_schedule
	where isHide!=0

	select ws.work_schedule_id, ws.employee_id,ws.work_date,ws.work_shift_id,work_shift.description
	from work_schedule as ws
		inner join work_shift
			on  work_shift.work_shift_id=ws.work_shift_id
		where ws.employee_id=2 and ws.isHide=0



	select ws.work_schedule_id, ws.employee_id, ws.work_date, ws.work_shift_id, work_shift.description, work_shift.work_type 
	from work_schedule as ws
	inner join work_shift
	on work_shift.work_shift_id=ws.work_shift_id
	where ws.employee_id=2 and work_date='2000-12-31' and ws.isHide=0


	select hours_worked
	from attendance
	where work_schedule_id=9

	select * 
	from work_schedule

	select * 
	from work_schedule
	where employee_id=2 and work_date='2023-12-10'



	select * from salary where employee_id=3


	-- tong so ngay nghi co phep
	SELECT SUM(number_of_days) AS total_days_off
	FROM leave
	WHERE employee_id = 3
	AND month(startdate) = 12
	and year(startdate) = 2023

	-- tong so ngay nghi ko phep
	SELECT SUM(number_of_days) AS total_unpaid_days_off
	FROM leave
	WHERE employee_id = 3
	AND month(startdate) = 12
	and year(startdate) = 2023

	-- tong so gio tang ca
	SELECT SUM(hours_worked) AS total_overtime_hours
	FROM work_schedule ws
	INNER JOIN attendance a ON a.work_schedule_id = ws.work_schedule_id
	 join work_shift  on work_shift.work_shift_id = ws.work_shift_id
	WHERE a.employee_id = 3
	and work_shift.work_type = 'overtime'
	and month(ws.work_date) = 12
	and year (ws.work_date) = 2023

	--tong so tien bi tru
	select sum(deduction_amount)  as totaldeduc
	from salary_deduction
	where employee_id=3
	and MONTH(deduction_date)=12
	and year(deduction_date)=2023

	
	



	
