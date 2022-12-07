CREATE DATABASE ToDoList;

SHOW databases;

USE ToDoList;

CREATE TABLE Task(
  id int auto_increment,
  name varchar(255),
  progress TINYINT,
  PRIMARY KEY(id)
);

INSERT into Task
(
  name, progress)
 values(
  '今週の献立を考える',0
  );
INSERT into Task
(
  name, progress)
 values(
  'Java Gold取得',1
  );
  INSERT into Task
(
  name, progress)
 values(
  'Java Silver取得',2
  );
