-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user`
(
    `id`       BIGINT(20)  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(40) NOT NULL,
    `password` VARCHAR(40) NOT NULL
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;

-- book和category关系数据表
DROP TABLE IF EXISTS `book`;
DROP TABLE IF EXISTS `category`;

CREATE TABLE `category`
(
    `id`   int(11)      NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `book`
(
    `id`     int(11)      NOT NULL AUTO_INCREMENT,
    `cover`  varchar(255)          DEFAULT '',
    `title`  varchar(255) NOT NULL DEFAULT '',
    `author` varchar(255)          DEFAULT '',
    `date`   DATE,
    `press`  varchar(255)          DEFAULT '',
    `abs`    varchar(255),
    `cid`    int(11),
    PRIMARY KEY (`id`),
    INDEX `fk_book_category_on_cid` (`cid`),
    CONSTRAINT `fk_book_category_on_cid` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 102
  DEFAULT CHARSET = utf8;