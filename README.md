# nro
```SQL
CREATE TABLE token (
	token_id		BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	CODE VARCHAR(50) NOT NULL,
	created date DEFAULT CURRENT_date,
	account_id INT NOT NULL UNIQUE,
	expiry DATE ,
	FOREIGN KEY(account_id) REFERENCES account(id)
	);
	CREATE TABLE post_question(
		question_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
		title TEXT NOT null,
		content TEXT,
		created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		STATUS INT DEFAULT 0
	);
	CREATE TABLE COMMENT
	(
		comment_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
		question_id BIGINT NOT NULL,
		content TEXT,
		created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		FOREIGN KEY (question_id)  REFERENCES post_question(question_id)
	);
	
		
	
CREATE TABLE CARD(
	card_id INT AUTO_INCREMENT NOT NULL  PRIMARY key,
	NAME TEXT ,
	khuyen_mai INT DEFAULT 0 
	);
CREATE TABLE CARD_DETAIL(
	card_detail_id int AUTO_INCREMENT  NOT NULL PRIMARY key,
	card_id INT NOT NULL,
	price INT NOT NULL,
	thoi_vang INT NOT NULL,
	FOREIGN KEY ( card_id) REFERENCES card(card_id)
	);
CREATE TABLE recharge_card(
		recharge_card_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
		card_detail_id  INT NOT NULL,
		account_id int NOT NULL ,
		seri TEXT,
		CODE TEXT,
		Created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		STATUS INT DEFAULT 1,
		FOREIGN KEY (card_detail_id) REFERENCES CARD_DETAIL(card_detail_id ),
		FOREIGN KEY (account_id) REFERENCES account(id)
	);
	
		
		
		```
