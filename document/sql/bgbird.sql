/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1_3306
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : 127.0.0.1:3306
 Source Schema         : bgbird

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 23/04/2019 18:11:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ams_active
-- ----------------------------
DROP TABLE IF EXISTS `ams_active`;
CREATE TABLE `ams_active`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '活动名称',
  `active_time` datetime(0) NOT NULL COMMENT '活动开启时间',
  `active_title` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动标题',
  `active_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动介绍图片',
  `is_enable` int(1) NULL DEFAULT NULL COMMENT '是否启用:0->否,1->是',
  `integration` int(5) NULL DEFAULT NULL COMMENT '获得的积分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '活动信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ams_active_comment
-- ----------------------------
DROP TABLE IF EXISTS `ams_active_comment`;
CREATE TABLE `ams_active_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active_id` int(11) NOT NULL COMMENT '活动id',
  `user_id` varchar(38) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `avartal_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `comment_content` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `show_status` int(1) NULL DEFAULT 1 COMMENT '是否显示在手机端:0->否,1->是',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `active_id_index`(`active_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '活动评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ams_active_detail
-- ----------------------------
DROP TABLE IF EXISTS `ams_active_detail`;
CREATE TABLE `ams_active_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active_id` int(11) NOT NULL COMMENT '活动id',
  `active_introduce` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '活动介绍',
  `active_detail_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动详情图片',
  `active_date` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动日期',
  `active_time_interval` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动时间区间',
  `active_address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动地点',
  `recommend_people` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '推荐人群,多个以 / 分隔',
  `welfare` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '福利奖品',
  `apply_need_know` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '报名须知,多个以 | 分隔',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `active_id_index`(`active_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '活动详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ams_active_user_apply
-- ----------------------------
DROP TABLE IF EXISTS `ams_active_user_apply`;
CREATE TABLE `ams_active_user_apply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active_id` int(11) NOT NULL COMMENT '活动id',
  `user_id` varchar(38) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `apply_time` datetime(0) NULL DEFAULT NULL COMMENT '报名时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `active_id_index`(`active_id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户报名活动表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cms_shuffling
-- ----------------------------
DROP TABLE IF EXISTS `cms_shuffling`;
CREATE TABLE `cms_shuffling`  (
  `shuffing_id` int(11) NOT NULL AUTO_INCREMENT,
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '轮播图',
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`shuffing_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '轮播图表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_cart
-- ----------------------------
DROP TABLE IF EXISTS `oms_cart`;
CREATE TABLE `oms_cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `product_attr_value_id` int(11) NULL DEFAULT NULL COMMENT '参数表id',
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `delete_status` tinyint(1) NULL DEFAULT 0 COMMENT '删除状态:0->否，1->是',
  `buy_count` int(6) NOT NULL COMMENT '购买数量',
  `spec_desc` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格描述,多个以逗号分隔',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '购物车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_order
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `coupon_id` bigint(20) NULL DEFAULT NULL COMMENT '优惠券id',
  `order_id` bigint(20) NOT NULL COMMENT '订单编号',
  `total_amount` int(11) NOT NULL COMMENT '订单总金额',
  `pay_amount` int(11) NOT NULL COMMENT '实际支付金额',
  `freight_amount` int(11) NULL DEFAULT NULL COMMENT '运费金额',
  `promotion_amount` int(11) NULL DEFAULT NULL COMMENT '促销优惠金额',
  `coupon_amount` int(11) NULL DEFAULT NULL COMMENT '优惠券抵扣金额',
  `pay_type` int(1) NULL DEFAULT 0 COMMENT '支付方式:0->未支付,1->微信支付,2->支付宝支付',
  `source_type` int(1) NULL DEFAULT 0 COMMENT '订单来源:0->app订单,1->PC订单',
  `order_status` int(1) NULL DEFAULT 0 COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `order_type` int(1) NULL DEFAULT 0 COMMENT '订单类型：0->正常订单；1->秒杀订单',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `integration` int(6) NULL DEFAULT NULL COMMENT '获得的积分',
  `promotion_info` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动信息',
  `notes` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单备注',
  `receiver_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人',
  `receiver_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人联系电话',
  `receiver_address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人地址',
  `delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `receive_time` datetime(0) NULL DEFAULT NULL COMMENT '确认收货时间',
  `comment_time` datetime(0) NULL DEFAULT NULL COMMENT '评价时间',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_status` int(1) NOT NULL DEFAULT 0 COMMENT '删除状态:0->否，1->是',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id_index`(`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oms_order
-- ----------------------------
INSERT INTO `oms_order` VALUES (1, 1, 'xxx', 423, 44444222, 4324, 34, 43, 434, 54, 0, 0, 0, 0, NULL, NULL, NULL, NULL, 'fssf', '111111111', 'dddddd', NULL, NULL, NULL, '2019-04-23 18:04:08', NULL, 0);

-- ----------------------------
-- Table structure for oms_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_detail`;
CREATE TABLE `oms_order_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `product_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `price` int(11) NOT NULL COMMENT '商品销售价格，单位分',
  `buy_count` int(8) NOT NULL COMMENT '购买数量',
  `promotion_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品促销名称',
  `promotion_amount` int(11) NULL DEFAULT NULL COMMENT '商品促销分解金额，单位分',
  `coupon_amount` int(11) NULL DEFAULT NULL COMMENT '优惠券分解金额，单位分',
  `real_amount` int(11) NULL DEFAULT NULL COMMENT '该商品经过优惠后的分解金额',
  `gift_integration` int(8) NULL DEFAULT NULL COMMENT '获得的积分',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id_index`(`order_id`) USING BTREE,
  INDEX `product_id_index`(`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单详细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_product_comment
-- ----------------------------
DROP TABLE IF EXISTS `oms_product_comment`;
CREATE TABLE `oms_product_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `user_id` varchar(38) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `avartal_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `comment_content` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `comment_star` int(1) NULL DEFAULT NULL COMMENT '评价星级: 1-5颗星',
  `show_status` int(1) NULL DEFAULT 1 COMMENT '是否显示在手机端:0->否,1->是',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id_index`(`product_id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_product
-- ----------------------------
DROP TABLE IF EXISTS `pms_product`;
CREATE TABLE `pms_product`  (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_category_id` int(11) NOT NULL COMMENT '商品分类id',
  `product_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `product_introduce` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品介绍',
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品正文图',
  `pictute_detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品详情图',
  `delete_status` tinyint(1) NULL DEFAULT 0 COMMENT '删除状态：0->未删除；1->已删除',
  `publish_status` int(1) NULL DEFAULT NULL COMMENT '上架状态：0->下架；1->上架',
  `hot_status` int(1) NULL DEFAULT 0 COMMENT '热销状态: 0->否;1->是',
  `exchange_status` int(1) NULL DEFAULT 0 COMMENT '兑换状态:0->否;1->是',
  `sale_amount` int(11) NULL DEFAULT NULL COMMENT '销量',
  `price` int(11) NULL DEFAULT NULL COMMENT '原价，单位分',
  `current_price` int(11) NULL DEFAULT NULL COMMENT '现价，单位分',
  `gift_point` int(11) NULL DEFAULT NULL COMMENT '赠送的积分',
  `stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `product_category_id_index`(`product_category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product
-- ----------------------------
INSERT INTO `pms_product` VALUES (100001, 0, 'string', 'string', 'string', 'string', 1, 1, 1, 1, 0, 0, 0, 0, 9999, '2019-04-22 16:46:51', NULL);
INSERT INTO `pms_product` VALUES (100002, 0, 'string', 'string', 'string', 'string', 1, 1, 1, 1, 0, 0, 0, 0, 0, '2019-04-23 08:53:27', '2019-04-23 08:53:27');
INSERT INTO `pms_product` VALUES (100006, 0, 'string', 'string', 'string', 'string', 1, 0, 0, 0, 0, 0, 0, 0, 0, '2019-04-23 16:31:17', '2019-04-23 16:31:17');
INSERT INTO `pms_product` VALUES (100007, 0, 'string', 'string', 'string', 'string', 1, 0, 0, 0, 0, 0, 0, 0, 0, '2019-04-23 16:52:02', '2019-04-23 16:52:02');
INSERT INTO `pms_product` VALUES (100008, 0, 'string', 'string', 'string', 'string', 1, 0, 0, 0, 0, 0, 0, 0, 0, '2019-04-23 16:53:16', '2019-04-23 16:53:16');
INSERT INTO `pms_product` VALUES (100009, 0, 'string', 'string', 'string', 'string', 1, 0, 0, 0, 0, 0, 0, 0, 0, '2019-04-23 17:04:12', '2019-04-23 17:04:12');
INSERT INTO `pms_product` VALUES (100010, 0, 'string', 'string', 'string', 'string', 1, 0, 0, 0, 0, 0, 0, 0, 0, '2019-04-23 17:04:12', '2019-04-23 17:04:12');
INSERT INTO `pms_product` VALUES (100011, 0, 'string', 'string', 'string', 'string', 1, 0, 0, 0, 0, 0, 0, 0, 0, '2019-04-23 17:04:12', '2019-04-23 17:04:12');

-- ----------------------------
-- Table structure for pms_product_attribute
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute`;
CREATE TABLE `pms_product_attribute`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attr_category_id` int(11) NOT NULL COMMENT '属性分类表id',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性名称',
  `input_list` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '可选值列表，以逗号分隔',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序，值越小越靠前',
  `attr_type` int(1) NULL DEFAULT NULL COMMENT '属性的类型；0->规格；1->参数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性参数表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product_attribute
-- ----------------------------
INSERT INTO `pms_product_attribute` VALUES (2, 3, '新消息', '水电费', 2, 1);

-- ----------------------------
-- Table structure for pms_product_attribute_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute_category`;
CREATE TABLE `pms_product_attribute_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品类型名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product_attribute_category
-- ----------------------------
INSERT INTO `pms_product_attribute_category` VALUES (1, '水雷');
INSERT INTO `pms_product_attribute_category` VALUES (2, '阿顶顶顶顶');
INSERT INTO `pms_product_attribute_category` VALUES (4, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (5, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (6, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (7, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (8, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (9, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (10, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (11, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (12, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (13, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (14, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (15, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (16, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (17, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (18, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (19, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (20, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (21, '双方各');
INSERT INTO `pms_product_attribute_category` VALUES (22, '双方各');

-- ----------------------------
-- Table structure for pms_product_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute_value`;
CREATE TABLE `pms_product_attribute_value`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `product_attribute_id` int(11) NOT NULL COMMENT '商品属性参数表id',
  `value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性参数值',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id_index`(`product_id`) USING BTREE,
  INDEX `product_attribute_id_index`(`product_attribute_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性参数信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product_attribute_value
-- ----------------------------
INSERT INTO `pms_product_attribute_value` VALUES (1, 0, 0, 'string');
INSERT INTO `pms_product_attribute_value` VALUES (2, 0, 0, 'string');
INSERT INTO `pms_product_attribute_value` VALUES (3, 0, 0, 'string');
INSERT INTO `pms_product_attribute_value` VALUES (4, 0, 0, 'string');
INSERT INTO `pms_product_attribute_value` VALUES (5, 0, 0, 'string');
INSERT INTO `pms_product_attribute_value` VALUES (6, 0, 0, 'string');

-- ----------------------------
-- Table structure for pms_product_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_category`;
CREATE TABLE `pms_product_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序，值越小越靠前',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `show_status` int(1) NULL DEFAULT NULL COMMENT '是否显示:0->否，1->是',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品分类目录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product_category
-- ----------------------------
INSERT INTO `pms_product_category` VALUES (5, '饮料', 1, '测试目录', 1);
INSERT INTO `pms_product_category` VALUES (7, 'string', 0, 'string', 1);
INSERT INTO `pms_product_category` VALUES (8, 'string', 0, 'string', 1);
INSERT INTO `pms_product_category` VALUES (9, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (10, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (11, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (12, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (13, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (14, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (15, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (16, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (17, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (18, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (19, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (20, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (21, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (22, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (23, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (24, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (25, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (26, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (27, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (28, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (29, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (30, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (31, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (32, 'string', 3, 'string', 0);
INSERT INTO `pms_product_category` VALUES (33, 'string', 3, 'string', 0);

-- ----------------------------
-- Table structure for pms_sku_stock
-- ----------------------------
DROP TABLE IF EXISTS `pms_sku_stock`;
CREATE TABLE `pms_sku_stock`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `current_price` int(11) NULL DEFAULT NULL COMMENT '现价，单位分',
  `price` int(11) NULL DEFAULT NULL COMMENT '产品价格，单位分',
  `stock` int(10) NOT NULL COMMENT '库存',
  `sp1` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品属性1',
  `sp2` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品属性2',
  `sp3` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品属性3',
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品属性图',
  `sale_count` int(10) NULL DEFAULT 0 COMMENT '销量',
  `sku_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'sku编码',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id_index`(`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'sku库存表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_sku_stock
-- ----------------------------
INSERT INTO `pms_sku_stock` VALUES (1, 0, 0, 0, 0, 'string', 'string', 'string', 'string', 0, 'string');
INSERT INTO `pms_sku_stock` VALUES (2, 0, 0, 0, 0, 'string', 'string', 'string', 'string', 0, 'string');
INSERT INTO `pms_sku_stock` VALUES (3, 0, 0, 0, 0, 'string', 'string', 'string', 'string', 0, 'string');
INSERT INTO `pms_sku_stock` VALUES (4, 0, 0, 0, 0, 'string', 'string', 'string', 'string', 0, 'string');

-- ----------------------------
-- Table structure for ums_user
-- ----------------------------
DROP TABLE IF EXISTS `ums_user`;
CREATE TABLE `ums_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `openid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信用户openid',
  `wechat_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信账号',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '微信头像',
  `tell_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户联系电话',
  `gender` int(1) NULL DEFAULT NULL COMMENT '性别：0->未知；1->男；2->女',
  `city` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `birthday` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生日',
  `act_status` int(1) NULL DEFAULT NULL COMMENT '账号启用状态：0->禁用,1->启用',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_user
-- ----------------------------
INSERT INTO `ums_user` VALUES (1, '111', '阿萨德', '发达', '发斯蒂芬', '安抚', NULL, NULL, NULL, NULL, NULL, '2019-04-16 15:48:06');
INSERT INTO `ums_user` VALUES (2, '222', '阿斯顿发', '安抚', '阿斯顿发', '阿斯顿发', NULL, NULL, NULL, NULL, NULL, '2019-04-16 15:48:19');

-- ----------------------------
-- Table structure for ums_user_member
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_member`;
CREATE TABLE `ums_user_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(38) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `card_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员卡id',
  `member_level_id` int(11) NOT NULL COMMENT '用户等级id',
  `integration` int(11) NULL DEFAULT NULL COMMENT '积分',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_user_member_level
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_member_level`;
CREATE TABLE `ums_user_member_level`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '等级名称',
  `growth_point` int(11) NULL DEFAULT NULL COMMENT '等级所需积分',
  `default_status` int(1) NULL DEFAULT NULL COMMENT '是否为默认等级:0->否,1->是',
  `priviledge_birthday` int(1) NULL DEFAULT NULL COMMENT '是否有生日特权:0->否,1->是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员等级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_user_receive_address
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_receive_address`;
CREATE TABLE `ums_user_receive_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `receiver_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人名称',
  `receiver_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人电话',
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `default_status` int(1) NULL DEFAULT NULL COMMENT '默认地址：0->否，1->是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户收货地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_user_recharge_over
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_recharge_over`;
CREATE TABLE `ums_user_recharge_over`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(38) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `money_over` int(11) NOT NULL COMMENT '余额，单位分',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户余额表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_user_recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_recharge_record`;
CREATE TABLE `ums_user_recharge_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(38) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `money` int(11) NOT NULL COMMENT '金额,单位分',
  `change_type` int(1) NOT NULL COMMENT '金额变动类型:0->消费,1->充值',
  `recharge_status` int(1) NULL DEFAULT NULL COMMENT '充值状态:0->失败，1->成功',
  `recharge_no` varchar(38) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '充值编码',
  `transactionid` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信交易流水号',
  `change_reason` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '金额变动原因',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '充值消费记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_user_sign_log
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_sign_log`;
CREATE TABLE `ums_user_sign_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(38) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `sign_time` datetime(0) NULL DEFAULT NULL COMMENT '签到时间',
  `integration` int(5) NULL DEFAULT NULL COMMENT '获得的积分',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户签到记录表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
