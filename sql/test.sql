SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `test_id` int(11) NOT NULL auto_increment,
  `test_name` varchar(255) NOT NULL,
  `precipitation` double NOT NULL,
  `test_time` datetime NOT NULL,
  `tester` varchar(255) NOT NULL,
  `area_id` int(11),
  PRIMARY KEY (`test_id`),
  index `idx_area_id` (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1;
