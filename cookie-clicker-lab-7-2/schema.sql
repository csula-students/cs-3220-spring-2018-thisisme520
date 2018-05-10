CREATE TABLE events(
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NULL,
    trigger_at INTEGER NULL,
);

INSERT INTO events(id,name,description,trigger_at) VALUES(1,'grandma','test',10),(2,'grandpa','You can construct factory now!',50),(3,'mama',"We've found cookies in deep mountain ... in the mine?",200);