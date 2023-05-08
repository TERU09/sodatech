CREATE TABLE attendanceManagement.calendar (
	calendar_id int auto_increment NOT NULL,
	dating INT NOT NULL,
	week INT NOT NULL,
	off_division varchar(100) NULL,
	CONSTRAINT calendar_PK PRIMARY KEY (calendar_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

CREATE TABLE attendanceManagement.users (
	id INT auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	mail varchar(100) NOT NULL,
	password varchar(100) NULL,
	remarks varchar(100) NULL,
	CONSTRAINT users_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;


CREATE TABLE attendanceManagement.work_ record (
	user_id int NOT NULL,
	calendar_id int NOT NULL,
	start_time int NULL,
	end_time int NULL,
	spare_column varchar(100) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
