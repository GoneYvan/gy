show DATABASES ;
create DATABASE `gy_ut_db`;
USE gy_ut_db;
show TABLES ;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `status` TINYINT DEFAULT 1 COMMENT '数据状态(0删除1正常)',
  `version` INT DEFAULT 0 COMMENT '数据版本',

  `name` VARCHAR(20) NOT NULL COMMENT '姓名',
  `account` VARCHAR(20) NOT NULL COMMENT '账号',
  `password` VARCHAR(50) NOT NULL COMMENT '密码',

  `phone` VARCHAR(15) COMMENT '联系方式',
  `gender` VARCHAR(1) DEFAULT 'G' COMMENT '性别(G男M女)',
  `age` TINYINT(3) COMMENT '年龄',
  `birthday` VARCHAR(10) COMMENT '生日',
  PRIMARY KEY (`ID`), INDEX (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO users (name, account, password) VALUE (
    '管理员', 'admin', 'E10ADC3949BA59ABBE56E057F20F883E'
);