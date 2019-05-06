SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL auto_increment,
  `username` varchar(255) NOT NULL ,
  `password` varchar(255) NOT NULL ,
  `salt` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE `idx_username`(`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1;
