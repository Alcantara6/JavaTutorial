DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    `username` VARCHAR(40) NOT NULL,
    `password` VARCHAR(40) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;