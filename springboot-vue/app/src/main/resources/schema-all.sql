-- 后台部分
# Temporarily disabling referential constraints (set FOREIGN_KEY_CHECKS to 0) is useful when you
# need to re-create the tables and load data in any parent-child order.
SET FOREIGN_KEY_CHECKS = 0;

-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user`
(
    `id`       BIGINT(20)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(40)  NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `salt`     VARCHAR(255) NOT NULL
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;

-- book和category关系数据表
DROP TABLE IF EXISTS `book`;
DROP TABLE IF EXISTS `category`;

CREATE TABLE `category`
(
    `id`   INT(11)      NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `book`
(
    `id`     INT(11)      NOT NULL AUTO_INCREMENT,
    `cover`  VARCHAR(255)          DEFAULT '',
    `title`  VARCHAR(255) NOT NULL DEFAULT '',
    `author` VARCHAR(255)          DEFAULT '',
    `date`   DATE,
    `press`  VARCHAR(255)          DEFAULT '',
    `abs`    VARCHAR(255),
    `cid`    INT(11),
    PRIMARY KEY (`id`),
    INDEX `fk_book_category_on_cid` (`cid`),
    CONSTRAINT `fk_book_category_on_cid` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 102
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu`
(
    `id`        INT(11) NOT NULL AUTO_INCREMENT,
    `path`      VARCHAR(64)                                            DEFAULT NULL,
    `name`      VARCHAR(64)                                            DEFAULT NULL,
    `name_zh`   VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `icon_cls`  VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `component` VARCHAR(64)                                            DEFAULT NULL,
    `parent_id` INT(11)                                                DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_ci;

-- ----------------------------
-- Table structure for admin_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_menu`;
CREATE TABLE `admin_role_menu`
(
    `id`  INT(11) NOT NULL AUTO_INCREMENT,
    `rid` INT(11) DEFAULT NULL,
    `mid` INT(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 194
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_ci;

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`
(
    `id`      INT(11) NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `name_zh` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `enabled` TINYINT(1)                                              DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role`
(
    `id`  INT(11) NOT NULL AUTO_INCREMENT,
    `uid` INT(11) DEFAULT NULL,
    `rid` INT(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_operator_role_operator_1` (`uid`),
    KEY `fk_operator_role_role_1` (`rid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 68
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`
(
    `id`       INT(11)                                              NOT NULL AUTO_INCREMENT,
    `username` CHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password` VARCHAR(255)                                            DEFAULT NULL,
    `salt`     VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `name`     VARCHAR(255)                                            DEFAULT NULL,
    `phone`    VARCHAR(255)                                            DEFAULT NULL,
    `email`    VARCHAR(255)                                            DEFAULT NULL,
    `enabled`  TINYINT(1)                                              DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 110
  DEFAULT CHARSET = utf8;