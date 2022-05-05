Create database  if not exists service ;

CREATE TABLE `service`.`user` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `addressid` INT NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `userstatus` TINYINT NOT NULL,
  PRIMARY KEY (`userid`));
  
  use  service;
  INSERT INTO user (name,password,addressid,phone,userstatus)
VALUES ( "chocka", "pass", 1, "9677553778" , 1 );




select * from user;

select * from request;


CREATE TABLE `service`.`request` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(100) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `product` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_key_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_key`
    FOREIGN KEY (`user_id`)
    REFERENCES `service`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
      INSERT INTO request
VALUES ( 2,"heater not working properly", "Open" , "Gieser" , 3);
-- password root 

CREATE TABLE `service`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `flat_no` VARCHAR(45) NOT NULL,
  `flat_name` VARCHAR(45) NULL,
  `street` VARCHAR(45) NOT NULL,
  `area` VARCHAR(45) NULL,
  `city/village` VARCHAR(45) NOT NULL,
  `pin` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `service`.`user` 
ADD CONSTRAINT `add`
  FOREIGN KEY (`addressid`)
  REFERENCES `service`.`address` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
