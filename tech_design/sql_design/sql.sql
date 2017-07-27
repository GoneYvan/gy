show DATABASES ;
create DATABASE `gy_ut_db`;
USE gy_ut_db;
show TABLES ;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `status` TINYINT DEFAULT 1 COMMENT '数据状态(0删除1正常)',
  `version` INT DEFAULT 0 COMMENT '数据版本',

  `name` VARCHAR(20) NOT NULL COMMENT '姓名',
  `phone` VARCHAR(15) COMMENT '联系方式',
  `gender` VARCHAR(1) DEFAULT 'G' COMMENT '性别(G男M女)',
  `age` TINYINT(3) COMMENT '年龄',
  `birthday` VARCHAR(10) COMMENT '生日',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO users (name, phone, age, birthday) VALUES ('张三','13311111111',20,NULL),('李四','14522222222',21,NULL),('王五','16733333333',22,NULL);
SELECT * from users;
