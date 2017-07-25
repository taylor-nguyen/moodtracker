CREATE TABLE `user_mood` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(350) DEFAULT NULL,
  `mood` varchar(255) NOT NULL,
  `submitted_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8