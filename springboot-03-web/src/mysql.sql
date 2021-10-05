use mybatis;
show tables ;

CREATE TABLE `department`(
                             id INT(11) NOT NULL PRIMARY KEY COMMENT'部门编号（主键）',
                             department VARCHAR(50) COMMENT'部门名称'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE employee(
                         id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT'员工编号',
                         lastName VARCHAR(50) COMMENT'姓名',
                         email VARCHAR(50) COMMENT'邮箱',
                         gender INT(2) COMMENT'性别',
                         departmentId INT(11) NOT NULL COMMENT'对应部门表的外键',
                         birth datetime COMMENT'员工生日',
                         FOREIGN KEY(departmentId) REFERENCES department(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

insert into department(id, department) values
(1, '技术部'),
(2, '市场部'),
(3, '调研部'),
(4, '后勤部'),
(5, '运营部');

insert into employee(id, lastName, email, gender, departmentId, birth) values
(1, 'AA', 'A@qq.com', 1, 1,'2001-08-01'),
(2, 'BB', 'B@qq.com', 0, 2,'2002-08-01'),
(3, 'CC', 'C@qq.com', 1, 3,'2003-08-01'),
(4, 'DD', 'D@qq.com', 0, 4,'2004-08-01'),
(5, 'EE', 'E@qq.com', 1, 5,'2005-08-01');

select e.id, e.lastName, e.email, e.gender, d.id departmentId, d.department, e.birth from employee e, department d where e.departmentId=d.id;

alter table employee modify id int(11) auto_increment;	# 改为自增

insert into employee(id, lastName, email, gender, departmentId, birth) value
    (null, 'AA', 'A@qq.com', 1, 1,'2001-08-01');