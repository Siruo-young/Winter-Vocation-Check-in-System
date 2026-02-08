/*
 Navicat Premium Data Transfer

 Source Server         : xy
 Source Server Type    : MySQL
 Source Server Version : 80300 (8.3.0)
 Source Host           : localhost:3306
 Source Schema         : activity

 Target Server Type    : MySQL
 Target Server Version : 80300 (8.3.0)
 File Encoding         : 65001

 Date: 08/02/2026 20:29:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for la_activity
-- ----------------------------
DROP TABLE IF EXISTS `la_activity`;
CREATE TABLE `la_activity`  (
  `id` bigint NOT NULL COMMENT '活动id',
  `name` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `banner_msg` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'banner图',
  `cover_msg` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '封面图',
  `introduce_msg` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '介绍图',
  `type` tinyint NULL DEFAULT NULL COMMENT '活动类型：1.打卡',
  `days` tinyint NULL DEFAULT NULL COMMENT '打卡天数',
  `start_time` datetime NULL DEFAULT NULL COMMENT '活动开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '活动结束时间',
  `is_limit` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否限制人数：0限制 1不限制',
  `status` tinyint NULL DEFAULT NULL COMMENT '活动状态',
  `remark` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `button_color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '按钮颜色',
  `background_color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '背景颜色',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint NULL DEFAULT NULL COMMENT '创建人',
  `update_user` bigint NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint NULL DEFAULT NULL COMMENT '是否删除：0未删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of la_activity
-- ----------------------------
INSERT INTO `la_activity` VALUES (2869124625975808, '寒假打卡', 'https://example.com/banner2.png', 'https://example.com/cover2.png', 'https://example.com/introduce2.png', 1, 5, '2025-02-05 08:00:00', '2025-03-05 08:00:00', '2', NULL, NULL, NULL, NULL, '2026-02-05 15:29:00', '2026-02-05 15:29:00', NULL, NULL, 1);
INSERT INTO `la_activity` VALUES (2869180157782528, '争做好少年', 'https://example.com/banner1.png', 'https://example.com/cover1.png', 'https://example.com/introduce1.png', 1, 5, '2025-02-03 08:00:00', '2025-03-03 08:00:00', '2', NULL, NULL, NULL, NULL, '2026-02-05 17:21:58', '2026-02-05 17:21:58', NULL, NULL, 0);

-- ----------------------------
-- Table structure for la_activity_task_relation
-- ----------------------------
DROP TABLE IF EXISTS `la_activity_task_relation`;
CREATE TABLE `la_activity_task_relation`  (
  `id` bigint NOT NULL,
  `task_id` bigint NULL DEFAULT NULL COMMENT '任务id',
  `activity_id` bigint NULL DEFAULT NULL COMMENT '活动id',
  `sort` int NULL DEFAULT NULL COMMENT '排序字段',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint NULL DEFAULT NULL COMMENT '创建人',
  `update_user` bigint NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint NULL DEFAULT NULL COMMENT '是否删除：0未删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of la_activity_task_relation
-- ----------------------------
INSERT INTO `la_activity_task_relation` VALUES (2869124626303488, 2868552743725568, 2869124625975808, NULL, '2026-02-05 15:29:00', '2026-02-05 15:29:00', NULL, NULL, 0);
INSERT INTO `la_activity_task_relation` VALUES (2869124626319872, 2868552854571520, 2869124625975808, NULL, '2026-02-05 15:29:00', '2026-02-05 15:29:00', NULL, NULL, 0);
INSERT INTO `la_activity_task_relation` VALUES (2869124626336256, 2868552958921216, 2869124625975808, NULL, '2026-02-05 15:29:00', '2026-02-05 15:29:00', NULL, NULL, 0);
INSERT INTO `la_activity_task_relation` VALUES (2869180157807104, 2868552743725568, 2869180157782528, NULL, '2026-02-05 17:21:58', '2026-02-05 17:21:58', NULL, NULL, 0);
INSERT INTO `la_activity_task_relation` VALUES (2869180157823488, 2868552854571520, 2869180157782528, NULL, '2026-02-05 17:21:58', '2026-02-05 17:21:58', NULL, NULL, 0);
INSERT INTO `la_activity_task_relation` VALUES (2869180157839872, 2868552958921216, 2869180157782528, NULL, '2026-02-05 17:21:58', '2026-02-05 17:21:58', NULL, NULL, 0);

-- ----------------------------
-- Table structure for la_award
-- ----------------------------
DROP TABLE IF EXISTS `la_award`;
CREATE TABLE `la_award`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '奖品名称',
  `photo` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '图片',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '奖品类型：1勋章2奖品3会员',
  `rights_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '权益名称',
  `num` int NULL DEFAULT NULL COMMENT '数量',
  `is_limit` int NULL DEFAULT NULL COMMENT '是否限制人数：0限制1不限制',
  `status` int NULL DEFAULT NULL COMMENT '状态：1启用2禁用',
  `activity_id` bigint NULL DEFAULT NULL COMMENT '活动id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint NULL DEFAULT NULL COMMENT '创建人',
  `update_user` bigint NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint NULL DEFAULT NULL COMMENT '是否删除：0未删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of la_award
-- ----------------------------

-- ----------------------------
-- Table structure for la_task
-- ----------------------------
DROP TABLE IF EXISTS `la_task`;
CREATE TABLE `la_task`  (
  `id` bigint NOT NULL COMMENT '任务id',
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '任务名称',
  `photo` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '任务图片',
  `type` tinyint NULL DEFAULT NULL COMMENT '任务类型：0打卡',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint NULL DEFAULT NULL COMMENT '创建人',
  `update_user` bigint NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint NULL DEFAULT NULL COMMENT '是否删除：0未删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of la_task
-- ----------------------------
INSERT INTO `la_task` VALUES (2868551159294464, '寒假每日打卡', 'http://example.com/image.png', 0, '2026-02-04 20:02:16', '2026-02-04 20:02:16', NULL, NULL, 1);
INSERT INTO `la_task` VALUES (2868552743725568, '扫地', 'http://example.com/image.png', 0, '2026-02-04 20:05:30', '2026-02-04 20:05:30', NULL, NULL, 0);
INSERT INTO `la_task` VALUES (2868552854571520, '做饭', 'http://example.com/image.png', 0, '2026-02-04 20:05:43', '2026-02-04 20:05:43', NULL, NULL, 0);
INSERT INTO `la_task` VALUES (2868552958921216, '拖地', 'http://example.com/tuodi.png', 0, '2026-02-04 20:05:56', '2026-02-04 20:24:39', NULL, NULL, 0);

-- ----------------------------
-- Table structure for la_user
-- ----------------------------
DROP TABLE IF EXISTS `la_user`;
CREATE TABLE `la_user`  (
  `id` bigint NOT NULL COMMENT '主键',
  `sn` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '编号',
  `avatar` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '头像',
  `real_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '真实姓名',
  `nickname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户昵称',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户账号',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户密码',
  `mobile` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户电话',
  `last_login_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '最后登录时间',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  `delete_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of la_user
-- ----------------------------
INSERT INTO `la_user` VALUES (2866980481985024, 101112001, '', '张三', '张三三', 'zhangsan', '222222', '123456789', '2026-02-02 14:46:43', '2026-02-02 14:46:43', '2026-02-02 15:56:11', '2026-02-02 15:57:19');
INSERT INTO `la_user` VALUES (2866981092862464, 101112001, '', '赵四', '赵四四', 'zhaosi', 'zhaosi', '11111111', '2026-02-02 14:47:58', '2026-02-02 14:47:58', '2026-02-02 14:47:58', '1970-01-01 00:00:00');

-- ----------------------------
-- Table structure for la_user_award_record
-- ----------------------------
DROP TABLE IF EXISTS `la_user_award_record`;
CREATE TABLE `la_user_award_record`  (
  `id` bigint NOT NULL,
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `activity_id` bigint NULL DEFAULT NULL COMMENT '活动id',
  `award_id` bigint NULL DEFAULT NULL COMMENT '奖品id',
  `num` int NULL DEFAULT NULL COMMENT '奖品数量',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint NULL DEFAULT NULL COMMENT '创建人',
  `update_user` bigint NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint NULL DEFAULT NULL COMMENT '是否删除：0未删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of la_user_award_record
-- ----------------------------

-- ----------------------------
-- Table structure for la_user_join
-- ----------------------------
DROP TABLE IF EXISTS `la_user_join`;
CREATE TABLE `la_user_join`  (
  `id` bigint NOT NULL,
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `activity_id` bigint NULL DEFAULT NULL COMMENT '活动id',
  `status` tinyint NULL DEFAULT NULL COMMENT '是否完成：0已完成 1未完成',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint NULL DEFAULT NULL COMMENT '创建人',
  `update_user` bigint NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint NULL DEFAULT NULL COMMENT '是否删除：0未删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of la_user_join
-- ----------------------------
INSERT INTO `la_user_join` VALUES (1, 2866980481985024, 2869124625975808, 0, '2026-02-05 17:17:24', '2026-02-05 17:17:27', 2866980481985024, 2866980481985024, 0);
INSERT INTO `la_user_join` VALUES (2, 2866981092862464, 2869124625975808, 1, '2026-02-05 17:17:55', '2026-02-05 17:17:58', 2866981092862464, 2866981092862464, 0);
INSERT INTO `la_user_join` VALUES (3, 2866980481985024, 2869180157782528, 0, '2026-02-05 17:22:28', '2026-02-05 17:22:31', 2866980481985024, 2866980481985024, 0);

-- ----------------------------
-- Table structure for la_user_task_record
-- ----------------------------
DROP TABLE IF EXISTS `la_user_task_record`;
CREATE TABLE `la_user_task_record`  (
  `id` bigint NOT NULL,
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `activity_id` bigint NULL DEFAULT NULL COMMENT '活动id',
  `task_id` bigint NULL DEFAULT NULL COMMENT '任务id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint NULL DEFAULT NULL COMMENT '创建人',
  `update_user` bigint NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint NULL DEFAULT NULL COMMENT '是否删除：0未删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of la_user_task_record
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
