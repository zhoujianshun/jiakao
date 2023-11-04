/*
 Navicat Premium Data Transfer

 Source Server         : course
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : jiakao

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 29/01/2021 23:14:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dict_item
-- ----------------------------
DROP TABLE IF EXISTS `dict_item`;
CREATE TABLE `dict_item`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '数据字典条目',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `value` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '值',
  `sn` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '序号',
  `type_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '类型',
  `disabled` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否禁用',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `AK_uk_value`(`value`, `type_id`) USING BTREE,
  UNIQUE INDEX `AK_uk_name`(`name`, `type_id`) USING BTREE,
  INDEX `FK_Reference_16`(`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据字典条目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict_item
-- ----------------------------
INSERT INTO `dict_item` VALUES (5, '程序员', 'coder', 0, 2, 0);
INSERT INTO `dict_item` VALUES (6, '5345', '543543', 0, 3, 0);
INSERT INTO `dict_item` VALUES (7, 'ttre', 'treter', 0, 3, 0);
INSERT INTO `dict_item` VALUES (8, 'sdff', 'fsdfsd', 0, 3, 0);

-- ----------------------------
-- Table structure for dict_type
-- ----------------------------
DROP TABLE IF EXISTS `dict_type`;
CREATE TABLE `dict_type`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `value` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '值',
  `intro` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '简介',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `AK_uk_name`(`name`) USING BTREE,
  UNIQUE INDEX `AK_uk_value`(`value`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据字典类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict_type
-- ----------------------------
INSERT INTO `dict_type` VALUES (2, '职业', 'job', '一份工作');
INSERT INTO `dict_type` VALUES (3, '用户类型', 'user-type', '啦啦啦');

-- ----------------------------
-- Table structure for exam_place
-- ----------------------------
DROP TABLE IF EXISTS `exam_place`;
CREATE TABLE `exam_place`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `province_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '考场是哪个省份的',
  `city_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '考场是哪个城市的',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '考场的具体地址',
  `latitude` decimal(10, 7) NOT NULL DEFAULT 0.0000000 COMMENT '纬度',
  `longitude` decimal(10, 7) NOT NULL DEFAULT 0.0000000 COMMENT '经度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '考场' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_place
-- ----------------------------
INSERT INTO `exam_place` VALUES (1, '梅县考场', 1, 36, '广东省梅州市梅县', 0.0000000, 0.0000000);
INSERT INTO `exam_place` VALUES (2, '海边考场', 9, 42, '', 0.0000000, 0.0000000);

-- ----------------------------
-- Table structure for exam_place_course
-- ----------------------------
DROP TABLE IF EXISTS `exam_place_course`;
CREATE TABLE `exam_place_course`  (
  `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '价格',
  `type` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '课程类型：0是课程合集，2是科目2，3是科目3',
  `intro` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `video` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '视频',
  `cover` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '封面',
  `place_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '考场',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '考场课程' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_place_course
-- ----------------------------
INSERT INTO `exam_place_course` VALUES (1, '2020-12-15 20:42:12', '倒车入库', 99.99, 3, 'kkkk', '', 'upload/img/214fa192-fb3b-4f6c-835a-f0caa8f5cc93.png', 2);
INSERT INTO `exam_place_course` VALUES (2, '2021-01-04 20:32:16', '直角转弯', 95.68, 2, '', '', 'upload/img/474c0a8a-9991-42ba-9507-6ddf0690d7fb.jpeg', 1);

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uri` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `owner_id` int(10) UNSIGNED NOT NULL COMMENT '拥有者的id',
  `type` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '拥有者的类型，比如考场、驾校',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (1, 'upload/img/dce72e64-62e8-4b0f-b6aa-9130c9097f37.jpg', 1, 1);
INSERT INTO `image` VALUES (2, 'upload/img/b6498619-a266-45f5-b139-d60a7df75177.png', 1, 1);

-- ----------------------------
-- Table structure for plate_region
-- ----------------------------
DROP TABLE IF EXISTS `plate_region`;
CREATE TABLE `plate_region`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `parent_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父区域',
  `plate` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '车牌，比如省份是粤、琼、赣，城市是A、B、C、D',
  `pinyin` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '拼音',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `AK_uk_name`(`parent_id`, `name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '省份、城市' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plate_region
-- ----------------------------
INSERT INTO `plate_region` VALUES (1, '广东', 0, '粤', 'GUANG_DONG');
INSERT INTO `plate_region` VALUES (2, '山东', 0, '鲁', 'SHAN_DONG');
INSERT INTO `plate_region` VALUES (3, '湖南', 0, '湘', 'HU_NAN');
INSERT INTO `plate_region` VALUES (4, '四川', 0, '川', 'SI_CHUAN');
INSERT INTO `plate_region` VALUES (5, '重庆', 0, '渝', 'ZHONG_QING');
INSERT INTO `plate_region` VALUES (6, '福建', 0, '闽', 'FU_JIAN');
INSERT INTO `plate_region` VALUES (7, '广西', 0, '桂', 'GUANG_XI');
INSERT INTO `plate_region` VALUES (8, '湖北', 0, '鄂', 'HU_BEI');
INSERT INTO `plate_region` VALUES (9, '海南', 0, '琼', 'HAI_NAN');
INSERT INTO `plate_region` VALUES (10, '河南', 0, '豫', 'HE_NAN');
INSERT INTO `plate_region` VALUES (11, '安徽', 0, '皖', 'AN_HUI');
INSERT INTO `plate_region` VALUES (12, '河北', 0, '冀', 'HE_BEI');
INSERT INTO `plate_region` VALUES (13, '黑龙江', 0, '黑', 'HEI_LONG_JIANG');
INSERT INTO `plate_region` VALUES (14, '辽宁', 0, '辽', 'LIAO_NING');
INSERT INTO `plate_region` VALUES (15, '吉林', 0, '吉', 'JI_LIN');
INSERT INTO `plate_region` VALUES (16, '浙江', 0, '浙', 'ZHE_JIANG');
INSERT INTO `plate_region` VALUES (17, '江苏', 0, '苏', 'JIANG_SU');
INSERT INTO `plate_region` VALUES (18, '北京', 0, '京', 'BEI_JING');
INSERT INTO `plate_region` VALUES (19, '上海', 0, '沪', 'SHANG_HAI');
INSERT INTO `plate_region` VALUES (20, '新疆', 0, '新', 'XIN_JIANG');
INSERT INTO `plate_region` VALUES (21, '西藏', 0, '西', 'XI_ZANG');
INSERT INTO `plate_region` VALUES (22, '青海', 0, '青', 'QING_HAI');
INSERT INTO `plate_region` VALUES (23, '天津', 0, '津', 'TIAN_JIN');
INSERT INTO `plate_region` VALUES (24, '内蒙古', 0, '蒙', 'NEI_MENG_GU');
INSERT INTO `plate_region` VALUES (25, '宁夏', 0, '宁', 'NING_XIA');
INSERT INTO `plate_region` VALUES (26, '山西', 0, '晋', 'SHAN_XI');
INSERT INTO `plate_region` VALUES (27, '江西', 0, '赣', 'JIANG_XI');
INSERT INTO `plate_region` VALUES (28, '贵州', 0, '贵', 'GUI_ZHOU');
INSERT INTO `plate_region` VALUES (29, '云南', 0, '云', 'YUN_NAN');
INSERT INTO `plate_region` VALUES (30, '陕西', 0, '陕', 'SHAN_XI');
INSERT INTO `plate_region` VALUES (32, '广州', 1, 'A', 'GUANG_ZHOU');
INSERT INTO `plate_region` VALUES (33, '梅州', 1, 'M', 'MEI_ZHOU');
INSERT INTO `plate_region` VALUES (34, '合肥', 11, 'A', 'HE_FEI');
INSERT INTO `plate_region` VALUES (35, '珠海', 1, 'C', 'ZHU_HAI');
INSERT INTO `plate_region` VALUES (36, '深圳', 1, 'B', 'SHEN_ZHEN');
INSERT INTO `plate_region` VALUES (37, '厦门', 6, 'J', 'SHA_MEN');
INSERT INTO `plate_region` VALUES (38, '南宁', 7, 'A', 'NAN_NING');
INSERT INTO `plate_region` VALUES (39, '成都', 4, 'A', 'CHENG_DOU');
INSERT INTO `plate_region` VALUES (40, '贵阳', 28, 'A', 'GUI_YANG');
INSERT INTO `plate_region` VALUES (41, '海口', 9, 'A', 'HAI_KOU');
INSERT INTO `plate_region` VALUES (42, '三亚', 9, 'B', 'SAN_YA');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `uri` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '链接地址',
  `permission` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限标识',
  `type` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '资源类型（0是目录，1是菜单，2是目录）',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图标',
  `sn` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '序号',
  `parent_id` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父资源id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sys_resource_parent_id_name_uindex`(`parent_id`, `name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES (1, '系统', '', '', 0, 'fa fa-lock', 0, 0);
INSERT INTO `sys_resource` VALUES (2, '元数据', '', '', 0, 'fa fa-newspaper-o', 1, 0);
INSERT INTO `sys_resource` VALUES (3, '考试', '', '', 0, 'fa fa-mortar-board', 2, 0);
INSERT INTO `sys_resource` VALUES (4, '客户', '', '', 0, 'fa fa-users', 3, 0);
INSERT INTO `sys_resource` VALUES (5, '用户', 'page/sys/user/list.html', '', 1, 'fa fa-user-circle', 0, 1);
INSERT INTO `sys_resource` VALUES (6, '角色', 'page/sys/role/list.html', '', 1, 'fa fa-user', 1, 1);
INSERT INTO `sys_resource` VALUES (7, '资源', 'page/sys/resource/list.html', '', 1, 'fa fa-key', 2, 1);
INSERT INTO `sys_resource` VALUES (8, '省份', 'page/metadata/province/list.html', '', 1, 'fa fa-map-marker', 0, 2);
INSERT INTO `sys_resource` VALUES (9, '城市', 'page/metadata/city/list.html', '', 1, 'fa fa-location-arrow', 1, 2);
INSERT INTO `sys_resource` VALUES (10, '数据字典类型', 'page/metadata/dictType/list.html', '', 1, 'fa fa-cube', 2, 2);
INSERT INTO `sys_resource` VALUES (11, '数据字典条目', 'page/metadata/dictItem/list.html', '', 1, 'fa fa-cubes', 3, 2);
INSERT INTO `sys_resource` VALUES (12, '考场', 'page/exam/examPlace/list.html', '', 1, 'fa fa-car', 0, 3);
INSERT INTO `sys_resource` VALUES (13, '科1科4', 'page/exam/k1k4/list.html', '', 1, 'fa fa-pencil', 1, 3);
INSERT INTO `sys_resource` VALUES (14, '科2科3', 'page/exam/examPlaceCourse/list.html', '', 1, 'fa fa-video-camera', 2, 3);
INSERT INTO `sys_resource` VALUES (15, '交易', '', '', 0, 'fa fa-money', 4, 0);
INSERT INTO `sys_resource` VALUES (16, '驾校', 'page/customer/school/list.html', '', 1, 'fa fa-university', 0, 4);
INSERT INTO `sys_resource` VALUES (17, '教练', 'page/customer/coach/list.html', '', 1, 'fa fa-male', 1, 4);
INSERT INTO `sys_resource` VALUES (18, '学员', 'page/customer/student/list.html', '', 1, 'fa fa-child', 2, 4);
INSERT INTO `sys_resource` VALUES (19, '提现', 'page/deal/withdraw/list.html', '', 1, 'fa fa-cny', 0, 15);
INSERT INTO `sys_resource` VALUES (20, '订单', 'page/deal/order/list.html', '', 1, 'fa fa-ticket', 1, 15);
INSERT INTO `sys_resource` VALUES (21, '查询', '', 'sysUser:list', 2, '', 0, 5);
INSERT INTO `sys_resource` VALUES (22, '添加', '', 'sysUser:add', 2, '', 0, 5);
INSERT INTO `sys_resource` VALUES (23, '修改', '', 'sysUser:update', 2, '', 0, 5);
INSERT INTO `sys_resource` VALUES (24, '删除', '', 'sysUser:remove', 2, '', 0, 5);
INSERT INTO `sys_resource` VALUES (25, '查询', '', 'sysRole:list', 2, '', 0, 6);
INSERT INTO `sys_resource` VALUES (26, '添加', '', 'sysRole:add', 2, '', 0, 6);
INSERT INTO `sys_resource` VALUES (27, '修改', '', 'sysRole:update', 2, '', 0, 6);
INSERT INTO `sys_resource` VALUES (28, '删除', '', 'sysRole:remove', 2, '', 0, 6);
INSERT INTO `sys_resource` VALUES (29, '查询', '', 'sysResource:list', 2, '', 0, 7);
INSERT INTO `sys_resource` VALUES (30, '添加', '', 'sysResource:add', 2, '', 0, 7);
INSERT INTO `sys_resource` VALUES (31, '修改', '', 'sysResource:update', 2, '', 0, 7);
INSERT INTO `sys_resource` VALUES (32, '删除', '', 'sysResource:remove', 2, '', 0, 7);
INSERT INTO `sys_resource` VALUES (33, '查询', '', 'province:list', 2, '', 0, 8);
INSERT INTO `sys_resource` VALUES (34, '添加', '', 'province:add', 2, '', 0, 8);
INSERT INTO `sys_resource` VALUES (35, '修改', '', 'province:update', 2, '', 0, 8);
INSERT INTO `sys_resource` VALUES (36, '删除', '', 'province:remove', 2, '', 0, 8);
INSERT INTO `sys_resource` VALUES (37, '查询', '', 'city:list', 2, '', 0, 9);
INSERT INTO `sys_resource` VALUES (38, '添加', '', 'city:add', 2, '', 0, 9);
INSERT INTO `sys_resource` VALUES (39, '修改', '', 'city:update', 2, '', 0, 9);
INSERT INTO `sys_resource` VALUES (40, '删除', '', 'city:remove', 2, '', 0, 9);
INSERT INTO `sys_resource` VALUES (41, '查询', '', 'dictType:list', 2, '', 0, 10);
INSERT INTO `sys_resource` VALUES (42, '添加', '', 'dictType:add', 2, '', 0, 10);
INSERT INTO `sys_resource` VALUES (43, '修改', '', 'dictType:update', 2, '', 0, 10);
INSERT INTO `sys_resource` VALUES (44, '删除', '', 'dictType:remove', 2, '', 0, 10);
INSERT INTO `sys_resource` VALUES (45, '查询', '', 'dictItem:list', 2, '', 0, 11);
INSERT INTO `sys_resource` VALUES (46, '添加', '', 'dictItem:add', 2, '', 0, 11);
INSERT INTO `sys_resource` VALUES (47, '修改', '', 'dictItem:update', 2, '', 0, 11);
INSERT INTO `sys_resource` VALUES (48, '删除', '', 'dictItem:remove', 2, '', 0, 11);
INSERT INTO `sys_resource` VALUES (49, '查询', '', 'examPlace:list', 2, '', 0, 12);
INSERT INTO `sys_resource` VALUES (50, '添加', '', 'examPlace:add', 2, '', 0, 12);
INSERT INTO `sys_resource` VALUES (51, '修改', '', 'examPlace:update', 2, '', 0, 12);
INSERT INTO `sys_resource` VALUES (52, '删除', '', 'examPlace:remove', 2, '', 0, 12);
INSERT INTO `sys_resource` VALUES (53, '查询', '', 'examPlaceCourse:list', 2, '', 0, 14);
INSERT INTO `sys_resource` VALUES (54, '添加', '', 'examPlaceCourse:add', 2, '', 0, 14);
INSERT INTO `sys_resource` VALUES (55, '修改', '', 'examPlaceCourse:update', 2, '', 0, 14);
INSERT INTO `sys_resource` VALUES (56, '删除', '', 'examPlaceCourse:remove', 2, '', 0, 14);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sys_role_name_uindex`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '总经理');
INSERT INTO `sys_role` VALUES (5, '技术总监');
INSERT INTO `sys_role` VALUES (6, '测试员5435');
INSERT INTO `sys_role` VALUES (3, '财务总监');
INSERT INTO `sys_role` VALUES (4, '销售经理');

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource`  (
  `role_id` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色id',
  `resource_id` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '资源id',
  PRIMARY KEY (`resource_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色-资源' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nickname` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `username` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录用的用户名',
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录用的密码',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建的时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次登录的时间',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '账号的状态，0是正常，1是锁定',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sys_user_username_uindex`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户（可以登录后台系统的）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '大狗8888', 'mj999', 'c5e6f101402e8903804aae431ed68917', '2020-12-15 21:25:34', NULL, 1);
INSERT INTO `sys_user` VALUES (3, 'mj111', 'mj111', '1b1bd3989ff3e61223c7228c13eebff7', '2020-12-16 10:51:06', '2021-01-22 20:20:47', 0);
INSERT INTO `sys_user` VALUES (4, '狗子', 'ddd', '77963b7a931377ad4ab5ad6a9cd718aa', '2020-12-16 11:11:36', '2021-01-27 20:20:56', 0);
INSERT INTO `sys_user` VALUES (14, 'jk666', 'jk666', '19e30fe6447ed73d8ef000930acd8867', '2020-12-21 16:12:23', NULL, 1);
INSERT INTO `sys_user` VALUES (15, 'mj6789', 'mj6789', '07972d8f2ee2c808b169c1daf1ede8e3', '2021-01-04 15:37:08', NULL, 0);
INSERT INTO `sys_user` VALUES (16, 'abc', 'abc', '900150983cd24fb0d6963f7d28e17f72', '2021-01-13 21:42:53', '2021-01-29 20:10:55', 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `role_id` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色id',
  `user_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户id',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (4, 1);
INSERT INTO `sys_user_role` VALUES (1, 3);
INSERT INTO `sys_user_role` VALUES (1, 4);
INSERT INTO `sys_user_role` VALUES (3, 4);
INSERT INTO `sys_user_role` VALUES (4, 4);
INSERT INTO `sys_user_role` VALUES (5, 4);
INSERT INTO `sys_user_role` VALUES (6, 4);
INSERT INTO `sys_user_role` VALUES (1, 14);
INSERT INTO `sys_user_role` VALUES (4, 14);
INSERT INTO `sys_user_role` VALUES (1, 15);
INSERT INTO `sys_user_role` VALUES (3, 15);
INSERT INTO `sys_user_role` VALUES (4, 15);
INSERT INTO `sys_user_role` VALUES (6, 16);

SET FOREIGN_KEY_CHECKS = 1;
