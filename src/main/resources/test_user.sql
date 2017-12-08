CREATE TABLE IF NOT EXISTS `test_user`(
 `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 `first_name` varchar(32) NOT NULL,
 `last_name` varchar(32) NOT NULL,
 `password` VARCHAR(255) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;