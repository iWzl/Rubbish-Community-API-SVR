/*
 Leo Wang rubbish_community

 Source Server         : rubbish_community
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : rubbish_community_core

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 30/07/2019 22:26:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rbc_answer
-- ----------------------------
DROP TABLE IF EXISTS `rbc_answer`;
CREATE TABLE `rbc_answer`  (
  `id` bigint(16) NOT NULL,
  `question_id` bigint(16) NOT NULL,
  `uid` int(8) NOT NULL,
  `choose` int(1) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rbc_dynamic
-- ----------------------------
DROP TABLE IF EXISTS `rbc_dynamic`;
CREATE TABLE `rbc_dynamic`  (
  `id` bigint(16) NOT NULL COMMENT 'ID',
  `content` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '动态内容',
  `images` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '动态图片',
  `uid` int(8) NOT NULL COMMENT '文章所有人ID',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `status` int(1) NOT NULL COMMENT '文章状态',
  `type` int(1) NOT NULL COMMENT '文章类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rbc_dynamic_comment
-- ----------------------------
DROP TABLE IF EXISTS `rbc_dynamic_comment`;
CREATE TABLE `rbc_dynamic_comment`  (
  `id` bigint(16) NOT NULL,
  `publish_id` bigint(16) NOT NULL,
  `for` int(8) NOT NULL COMMENT '评论对象 0 文章 uid',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  `status` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rbc_library
-- ----------------------------
DROP TABLE IF EXISTS `rbc_library`;
CREATE TABLE `rbc_library`  (
  `id` int(8) NOT NULL,
  `key` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `value` int(1) NOT NULL,
  `form` bigint(16) NOT NULL,
  `status` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rbc_like
-- ----------------------------
DROP TABLE IF EXISTS `rbc_like`;
CREATE TABLE `rbc_like`  (
  `id` bigint(16) NOT NULL,
  `publish_id` bigint(16) NOT NULL,
  `uid` int(8) NOT NULL,
  `type` int(1) NOT NULL COMMENT '好 / 坏',
  `time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rbc_profile
-- ----------------------------
DROP TABLE IF EXISTS `rbc_profile`;
CREATE TABLE `rbc_profile`  (
  `uid` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户唯一ID',
  `id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户ID',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'MD5 加密的用户密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户邮箱',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `status` int(2) NOT NULL DEFAULT 0 COMMENT '用户状态\r\n0 未校验用户\r\n1 普通用户\r\n2 中级用户\r\n3 高级用户\r\n4 异常用户\r\n5 黑名单\r\n6 注销用户\r\n',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户地址',
  `work` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户工作',
  `age` int(11) NOT NULL COMMENT '用户年龄',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户宣言',
  `create_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '用户创建时间',
  `gender` int(1) NOT NULL DEFAULT 2 COMMENT '0 女 1 男  2 未知 3 保密',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10001 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rbc_publish
-- ----------------------------
DROP TABLE IF EXISTS `rbc_publish`;
CREATE TABLE `rbc_publish`  (
  `id` bigint(16) NOT NULL COMMENT '发布ID',
  `uid` int(8) NOT NULL COMMENT '用户ID',
  `content_id` bigint(16) NULL DEFAULT NULL,
  `type` int(1) NULL DEFAULT NULL COMMENT '发表类型 转载/原创',
  `location_street` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '街道',
  `location_district` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区县',
  `location_city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市',
  `location_province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省份',
  `location_country` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '国家',
  `time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rbc_question
-- ----------------------------
DROP TABLE IF EXISTS `rbc_question`;
CREATE TABLE `rbc_question`  (
  `id` bigint(16) NOT NULL,
  `time` datetime(0) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `uid` int(8) NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rbc_question_comment
-- ----------------------------
DROP TABLE IF EXISTS `rbc_question_comment`;
CREATE TABLE `rbc_question_comment`  (
  `id` bigint(16) NOT NULL,
  `question_id` bigint(16) NOT NULL,
  `for` int(8) NOT NULL COMMENT '评论对象 0 文章 uid',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  `status` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rbc_role
-- ----------------------------
DROP TABLE IF EXISTS `rbc_role`;
CREATE TABLE `rbc_role`  (
  `id` int(4) NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `update_by` int(8) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_by` int(8) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
