/*
MySQL Backup
Source Server Version: 5.7.16
Source Database: student
Date: 2018/11/22 09:04:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `student_info`
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ic` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `xueli` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `hunfou` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `inschool` varchar(255) DEFAULT NULL,
  `shichangbu` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `operatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `stud_interview`
-- ----------------------------
DROP TABLE IF EXISTS `stud_interview`;
CREATE TABLE `stud_interview` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stud_id` int(11) DEFAULT NULL,
  `stud_name` varchar(255) DEFAULT NULL,
  `com_name` varchar(255) DEFAULT NULL,
  `com_xz` varchar(255) DEFAULT NULL,
  `com_adress` varchar(255) DEFAULT NULL,
  `interview_gw` varchar(255) DEFAULT NULL,
  `com_gm` varchar(255) DEFAULT NULL,
  `zp_gm` varchar(255) DEFAULT NULL,
  `interview_date` varchar(255) DEFAULT NULL,
  `interview_lc` varchar(255) DEFAULT NULL,
  `interview_comment` varchar(255) DEFAULT NULL,
  `link_mail` varchar(255) DEFAULT NULL,
  `link_phone` varchar(255) DEFAULT NULL,
  `is_channel` varchar(255) DEFAULT NULL,
  `channel_manager` varchar(255) DEFAULT NULL,
  `resume` varchar(255) DEFAULT NULL,
  `passing_difficulty` varchar(255) DEFAULT NULL,
  `is_recommend` varchar(255) DEFAULT NULL,
  `is_written` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `stud_learn`
-- ----------------------------
DROP TABLE IF EXISTS `stud_learn`;
CREATE TABLE `stud_learn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stud_id` int(11) DEFAULT NULL,
  `stud_code` varchar(255) DEFAULT NULL,
  `stud_name` varchar(255) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `teacher2_id` int(11) DEFAULT NULL,
  `teacher2_name` varchar(255) DEFAULT NULL,
  `teacher3_id` int(11) DEFAULT NULL,
  `teacher3_name` varchar(255) DEFAULT NULL,
  `course_begin` varchar(255) DEFAULT NULL,
  `course_end` varchar(255) DEFAULT NULL,
  `ll_course` varchar(255) DEFAULT NULL,
  `jn_course` varchar(255) DEFAULT NULL,
  `mb_conut` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `stud_review`
-- ----------------------------
DROP TABLE IF EXISTS `stud_review`;
CREATE TABLE `stud_review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(255) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `teacher_type` varchar(255) DEFAULT NULL,
  `stud_id` int(11) DEFAULT NULL,
  `stud_name` varchar(255) DEFAULT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `course_begin` varchar(255) DEFAULT NULL,
  `course_end` varchar(255) DEFAULT NULL,
  `skill_level` varchar(255) DEFAULT NULL,
  `gt_level` varchar(255) DEFAULT NULL,
  `review_score` varchar(255) DEFAULT NULL,
  `review_content` varchar(255) DEFAULT NULL,
  `review_date` datetime DEFAULT NULL,
  `tj_fx` varchar(255) DEFAULT NULL,
  `tj_com` varchar(255) DEFAULT NULL,
  `tj_gw` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `stud_work`
-- ----------------------------
DROP TABLE IF EXISTS `stud_work`;
CREATE TABLE `stud_work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `com_name` varchar(255) DEFAULT NULL,
  `com_address` varchar(255) DEFAULT NULL,
  `work_content` varchar(255) DEFAULT NULL,
  `in_date` datetime DEFAULT NULL,
  `out_date` datetime DEFAULT NULL,
  `link_man` varchar(255) DEFAULT NULL,
  `com_city` varchar(255) DEFAULT NULL,
  `work_xz` varchar(255) DEFAULT NULL,
  `work_sshy` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `operatedate` datetime DEFAULT NULL,
  `stud_id` int(11) DEFAULT NULL,
  `stud_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `code` varchar(40) NOT NULL COMMENT '系统功能CODE',
  `num` decimal(8,0) DEFAULT NULL COMMENT '菜单排序号',
  `pcode` varchar(40) DEFAULT NULL COMMENT '上级菜单code',
  `pcodes` varchar(255) DEFAULT NULL COMMENT '上级菜单codes',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `icons` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `levels` decimal(8,0) DEFAULT NULL COMMENT '菜单层级',
  `ismenu` varchar(3) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `status` varchar(3) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `isopen` varchar(3) DEFAULT NULL COMMENT '是否打开:    1:打开   0:不打开',
  `handle` varchar(20) DEFAULT NULL COMMENT '操作人',
  `handle_date` datetime DEFAULT NULL COMMENT '操作时间',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统功能表';

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `student_info` VALUES ('5','22','修改','22','男','2018-10-28','22','22','是','22','2018-11-01','22','22',NULL,NULL), ('6','1212','12','12','男','2018-10-29','12','12','是','12','2018-10-28','12','12',NULL,NULL), ('7','11223','测试','','','','','','','','','','',NULL,NULL);
INSERT INTO `stud_interview` VALUES ('1','7','测试','1','1','1','1','1','1','2018-10-28','1','1','1','1','是','1','1','1','是','是','12'), ('2','7','测试','2奥赛得','俺的沙发','俺的沙发','士大夫','第三方的','士大夫','2018-10-29','2','士大夫','阿士大夫','士大夫','是','士大夫','士大夫','士大夫','是','是','是的冯绍峰士大夫 萨芬的'), ('3','5','修改','1324','1234','1234','1324','1234','1432','2018-11-04','12','123','123','1234','是','1324','1234','1234','是','是','1234');
INSERT INTO `stud_learn` VALUES ('1','1212','','12','1','1',NULL,'12',NULL,'12',NULL,'12','2018-01-01','2018-01-31','111','111','1','1'), ('2','1212','12','12',NULL,'12',NULL,'12',NULL,'12',NULL,'12','2018-01-01','2018-01-31','111','111','1','1'), ('3','1212','','12',NULL,'12',NULL,'12',NULL,'12',NULL,'12','2018-01-01','2018-01-21','111','11','1','11'), ('4','7','11223','测试',NULL,'asd',NULL,'asdf',NULL,'adsf',NULL,'adsf','2018-10-30','2018-11-22','333','33','3','3'), ('6','7','11223','测试',NULL,'1',NULL,'1',NULL,'1',NULL,'1','1','1','1','1','1','1'), ('7','1212','','1',NULL,'1',NULL,'1',NULL,'1',NULL,'1','2018-01-01','2018-01-21','1','1','1','1'), ('9','5','22','修改',NULL,'1234',NULL,'1234',NULL,'1234',NULL,'1234','2018-10-30','2018-11-30','1234','1234','1','1234'), ('13','5','22','修改',NULL,'asd',NULL,'as',NULL,'asd',NULL,'asd','2018-10-01','2018-11-01','123','12.12','1','asdffdsadf'), ('14','5','22','修改',NULL,'1123',NULL,'1234',NULL,'1',NULL,'123','2018-10-29','2018-11-30','122','12','1','123'), ('15','7','11223','测试',NULL,'123',NULL,'123',NULL,'123',NULL,'123','2018-10-29','2018-11-30','1','1','1','123');
INSERT INTO `stud_review` VALUES ('1','1',NULL,'辅导员',NULL,'1','','1','2018-10-29','2018-11-30','1','1','1','1','2018-11-18 00:00:00','1','1','1','1'), ('2','1',NULL,'讲师','7','测试','','1','2018-10-29','2018-11-30','1','1','1','1','2018-11-12 00:00:00','1','1','1','1'), ('3','奥赛得',NULL,'讲师','5','修改','','按时','2018-10-28','2018-11-30','奥赛得','奥赛得','asdf','asdf','2018-11-12 00:00:00','asdf','大师傅','asdf','阿士大夫');
INSERT INTO `stud_work` VALUES ('2','3','3','3','2018-08-26 00:00:00','2018-09-29 00:00:00','3','3','3','3','3','sa','2018-11-17 16:48:57','5','修改'), ('3','3','3','3','2018-10-27 00:00:00','2018-12-07 00:00:00','3','3','3','3','3',NULL,NULL,'6','12'), ('4','4','4','4','2018-10-27 00:00:00','2018-12-07 00:00:00','4','4','4','4','4',NULL,NULL,'5','修改'), ('5','123','1234','1231','2018-10-28 00:00:00','2018-11-30 00:00:00','','','','','',NULL,NULL,'6','修改'), ('7','1','','','2018-10-25 00:00:00','2018-11-22 00:00:00','','','','','',NULL,NULL,'5','修改'), ('8','134','1234','',NULL,NULL,'','','','','',NULL,NULL,'6','12'), ('9','2','1','1',NULL,NULL,'','','','','',NULL,NULL,'6','12'), ('10',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1212','12'), ('11','','','',NULL,NULL,'','','','','',NULL,NULL,NULL,'1'), ('12','','','',NULL,NULL,'','','','','',NULL,NULL,NULL,'');
INSERT INTO `sys_menu` VALUES ('1','1','0','0','系统设置',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL), ('10',NULL,'0',NULL,'统计查询',NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL), ('11',NULL,'10',NULL,'学生汇总信息',NULL,'/statistics/studSummary',NULL,NULL,NULL,NULL,NULL,NULL,NULL), ('2','2','1','1','菜单管理',NULL,'/sys/menuInfo',NULL,NULL,NULL,NULL,NULL,NULL,NULL), ('3','3','1','1','用户管理',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL), ('4','4','0','0','学生管理',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL), ('5','5','4','4','学生信息',NULL,'/studentInfo',NULL,NULL,NULL,NULL,NULL,NULL,NULL), ('6',NULL,'4',NULL,'学生工作信息',NULL,'/studentWork',NULL,NULL,NULL,NULL,NULL,NULL,NULL), ('7',NULL,'4',NULL,'学生学习信息',NULL,'/studentLearn',NULL,NULL,NULL,NULL,NULL,NULL,NULL), ('8',NULL,'4',NULL,'学生点评信息',NULL,'/studentReview',NULL,NULL,NULL,NULL,NULL,NULL,NULL), ('9',NULL,'4',NULL,'学生面试信息',NULL,'/studentInterview',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
