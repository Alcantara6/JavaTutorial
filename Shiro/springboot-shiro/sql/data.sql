USE shiro;
INSERT INTO `user` (`id`,`name`,`password`,`salt`,`username`) VALUES (1, '管理员','951cd60dec2104024949d2e0b2af45ae', 'xbNIxrQfn6COSYn1/GdloA==', 'wmyskxz');
INSERT INTO `permission` (`id`,`description`,`name`,`url`) VALUES (1,'查询用户','user:view','/userList');
INSERT INTO `permission` (`id`,`description`,`name`,`url`) VALUES (2,'增加用户','user:add','/userAdd');
INSERT INTO `permission` (`id`,`description`,`name`,`url`) VALUES (3,'删除用户','user:delete','/userDelete');
INSERT INTO `role` (`id`,`description`,`name`) VALUES (1,'管理员','admin');
INSERT INTO `role_permission` (`permission_id`,`role_id`) VALUES (1,1);
INSERT INTO `role_permission` (`permission_id`,`role_id`) VALUES (2,1);
INSERT INTO `user_role` (`role_id`,`user_id`) VALUES (1,1);
