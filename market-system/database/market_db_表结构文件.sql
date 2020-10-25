CREATE TABLE `shopping_info`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_id` varchar(100) NULL,
  `userid` int UNSIGNED NULL,
  `goods_name` varchar(100) NULL,
  `sort` varchar(100) NULL,
  `count` int UNSIGNED NULL DEFAULT 0,
  `price` double UNSIGNED NULL,
  `date` varchar(64) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `sys_cfg`  (
  `sort` int UNSIGNED NULL,
  `name` varchar(100) NULL,
  `value` varchar(255) NULL,
  `desc` varchar(255) NULL
);

CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NULL,
  `sex` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '0男 1女',
  `age` int UNSIGNED NULL,
  `work_unit` varchar(255) NULL,
  `phone` varchar(64) NULL,
  `create_date` varchar(64) NULL,
  `user_exp` int UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`id`)
);

