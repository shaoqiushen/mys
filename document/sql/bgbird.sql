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

 Date: 30/04/2019 18:03:04
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
  `begin_time` datetime(0) NOT NULL COMMENT '活动开启时间',
  `active_introduce` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动简介',
  `active_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动介绍图片',
  `is_enable` int(1) NULL DEFAULT NULL COMMENT '是否启用:0->否,1->是',
  `integration` int(5) NULL DEFAULT NULL COMMENT '获得的积分',
  `end_time` datetime(0) NOT NULL COMMENT '活动结束时间',
  `delete_status` int(1) NOT NULL DEFAULT 0 COMMENT '删除标志:0->否,1->是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `active_title` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动标题',
  `active_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '活动内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '活动信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ams_active
-- ----------------------------
INSERT INTO `ams_active` VALUES (1, 'string', '2019-04-24 12:12:12', 'string', 'string', 0, 1, '2019-04-28 12:12:12', 1, '2019-04-24 10:45:38', NULL, NULL);
INSERT INTO `ams_active` VALUES (2, 'string', '2019-04-24 12:12:12', 'string', 'string', 0, 0, '2019-04-28 12:12:12', 0, '2019-04-24 10:46:06', NULL, NULL);
INSERT INTO `ams_active` VALUES (3, 'string', '2019-04-24 12:12:12', 'string', 'string', 0, 0, '2019-04-28 12:12:12', 0, '2019-04-24 14:31:50', NULL, NULL);
INSERT INTO `ams_active` VALUES (4, 'string', '2019-04-24 12:12:12', 'string', 'string', 1, 0, '2019-04-28 12:12:12', 0, '2019-04-24 16:04:37', 'string', 'string');

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '活动评价表' ROW_FORMAT = Dynamic;

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
  `active_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '活动详情内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `active_id_index`(`active_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '活动详情表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户报名活动表' ROW_FORMAT = Dynamic;

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
  `sort` int(10) NOT NULL COMMENT '轮播顺序',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '外链地址',
  `type` int(1) NOT NULL DEFAULT 0 COMMENT '0->App首页，1->PC首页',
  `status` int(1) NULL DEFAULT 0 COMMENT '上线状态:0->下线,1->上线',
  PRIMARY KEY (`shuffing_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '轮播图表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_shuffling
-- ----------------------------
INSERT INTO `cms_shuffling` VALUES (1, 'xxx', 10004, '2019-04-25 10:09:29', NULL, 1, 'xcggggg', 0, 1);

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
  `delete_status` int(1) NULL DEFAULT 0 COMMENT '删除状态:0->否，1->是',
  `buy_count` int(6) NOT NULL COMMENT '购买数量',
  `spec_desc` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格描述,多个以逗号分隔',
  `sp1` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '销售属性1',
  `sp2` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '销售属性2',
  `sp3` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '销售属性3',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '购物车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oms_cart
-- ----------------------------
INSERT INTO `oms_cart` VALUES (1, 100044, NULL, '111', NULL, 0, 1, NULL, 'string', 'string', 'string');

-- ----------------------------
-- Table structure for oms_order
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `coupon_id` bigint(20) NULL DEFAULT NULL COMMENT '优惠券id',
  `order_id` bigint(20) NOT NULL COMMENT '订单编号',
  `total_amount` int(11) NOT NULL COMMENT '订单总金额',
  `pay_amount` int(11) NOT NULL COMMENT '实际支付金额',
  `freight_amount` int(11) NULL DEFAULT 0 COMMENT '运费金额',
  `promotion_amount` int(11) NULL DEFAULT NULL COMMENT '促销优惠金额（促销价、满减、阶梯价）',
  `coupon_amount` int(11) NULL DEFAULT NULL COMMENT '优惠券抵扣金额',
  `pay_type` int(1) NULL DEFAULT 0 COMMENT '支付方式:0->未支付,1->微信支付,2->支付宝支付',
  `source_type` int(1) NULL DEFAULT 0 COMMENT '订单来源:0->app订单,1->PC订单',
  `order_status` int(1) NULL DEFAULT 0 COMMENT '订单状态：0->待付款；1->已支付，待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
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
  `confirm_status` int(1) NOT NULL COMMENT '确认收货:0->否，1->是',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id_index`(`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单详细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_order_settting
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_settting`;
CREATE TABLE `oms_order_settting`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flash_order_overtime` int(5) NULL DEFAULT NULL COMMENT '秒杀订单超时关闭时间(分)',
  `normal_order_overtime` int(5) NULL DEFAULT NULL COMMENT '正常订单超时时间(分)',
  `confirm_overtime` int(5) NULL DEFAULT NULL COMMENT '发货后自动确认收货时间（天）',
  `finish_overtime` int(5) NULL DEFAULT NULL COMMENT '自动完成交易时间，不能申请售后（天）',
  `comment_overtime` int(5) NULL DEFAULT NULL COMMENT '订单完成后自动好评时间（天）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单设置表' ROW_FORMAT = Dynamic;

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
  `comment_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `comment_star` int(1) NULL DEFAULT NULL COMMENT '评价星级: 1-5颗星',
  `show_status` int(1) NULL DEFAULT 1 COMMENT '是否显示在手机端:0->否,1->是',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `product_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `comment_picture` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评价图片',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id_index`(`product_id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oms_product_comment
-- ----------------------------
INSERT INTO `oms_product_comment` VALUES (1, 100044, 'dxx', 'x\'x\'x', 'fsadf', 'cvvvvvvvvvvvvvvvvvvvvvvvvvvvv', 4, 1, '2019-04-25 14:53:11', '', NULL);

-- ----------------------------
-- Table structure for oms_product_comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `oms_product_comment_reply`;
CREATE TABLE `oms_product_comment_reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) NOT NULL COMMENT '评价id',
  `reply_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回复内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `comment_id_index`(`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '店家评价回复表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_product
-- ----------------------------
DROP TABLE IF EXISTS `pms_product`;
CREATE TABLE `pms_product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_category_id` int(11) NOT NULL COMMENT '商品分类id',
  `product_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `product_introduce` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品介绍',
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品正文图',
  `pictute_detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品详情图',
  `delete_status` int(1) NULL DEFAULT 0 COMMENT '删除状态：0->未删除；1->已删除',
  `publish_status` int(1) NULL DEFAULT NULL COMMENT '上架状态：0->下架；1->上架',
  `hot_status` int(1) NULL DEFAULT 0 COMMENT '热销状态: 0->否;1->是',
  `exchange_status` int(1) NULL DEFAULT 0 COMMENT '兑换状态:0->否;1->是',
  `sale_amount` int(11) NULL DEFAULT NULL COMMENT '销量',
  `price` int(11) NULL DEFAULT NULL COMMENT '原价，单位分',
  `promotion_price` int(11) NULL DEFAULT NULL COMMENT '促销价，单位分',
  `gift_point` int(11) NULL DEFAULT NULL COMMENT '赠送的积分',
  `stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `promotion_start_time` datetime(0) NULL DEFAULT NULL COMMENT '商品促销开始时间',
  `promotion_end_time` datetime(0) NULL DEFAULT NULL COMMENT '商品促销结束时间',
  `promotion_type` int(1) NULL DEFAULT 0 COMMENT '促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购',
  `promotion_per_limit` int(5) NULL DEFAULT NULL COMMENT '活动限购数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_category_id_index`(`product_category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100045 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product
-- ----------------------------
INSERT INTO `pms_product` VALUES (100043, 0, 'string', 'string', 'string', 'string', 0, 1, 0, 0, 0, 0, 0, 0, 0, '2019-04-29 18:00:08', '2019-04-29 18:00:08', '2019-04-29 18:00:08', '2019-04-29 18:00:08', 0, 0);
INSERT INTO `pms_product` VALUES (100044, 37, '原味奶茶', '一杯会说话的奶茶', 'xxx.png', 'sss.png', 0, 1, 0, 0, 0, 1000, NULL, 0, 9999, NULL, NULL, NULL, NULL, 0, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性参数表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product_attribute
-- ----------------------------
INSERT INTO `pms_product_attribute` VALUES (2, 23, '大小', '', 2, 0);
INSERT INTO `pms_product_attribute` VALUES (3, 23, '温度', NULL, 3, 0);
INSERT INTO `pms_product_attribute` VALUES (13, 23, '主料', NULL, 1, 1);
INSERT INTO `pms_product_attribute` VALUES (14, 23, '保质期', NULL, 2, 1);

-- ----------------------------
-- Table structure for pms_product_attribute_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute_category`;
CREATE TABLE `pms_product_attribute_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品类型名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product_attribute_category
-- ----------------------------
INSERT INTO `pms_product_attribute_category` VALUES (23, '奶茶');
INSERT INTO `pms_product_attribute_category` VALUES (33, '类型1');

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
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性参数信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product_attribute_value
-- ----------------------------
INSERT INTO `pms_product_attribute_value` VALUES (17, 100043, 0, 'string');
INSERT INTO `pms_product_attribute_value` VALUES (18, 100044, 2, '大杯,中杯,小杯');
INSERT INTO `pms_product_attribute_value` VALUES (19, 100044, 3, '加冰,常温,加热');
INSERT INTO `pms_product_attribute_value` VALUES (20, 100044, 13, '咖啡/水');
INSERT INTO `pms_product_attribute_value` VALUES (21, 100044, 13, '当天饮用');

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
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品分类目录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product_category
-- ----------------------------
INSERT INTO `pms_product_category` VALUES (34, '热销', 1, NULL, 1);
INSERT INTO `pms_product_category` VALUES (35, '兑换', 2, NULL, 1);
INSERT INTO `pms_product_category` VALUES (36, '咖啡', 3, NULL, 1);
INSERT INTO `pms_product_category` VALUES (37, '奶茶', 4, NULL, 1);
INSERT INTO `pms_product_category` VALUES (38, '新鲜果汁', 5, NULL, 1);
INSERT INTO `pms_product_category` VALUES (39, '下午茶', 6, NULL, 1);
INSERT INTO `pms_product_category` VALUES (40, '西点', 7, NULL, 1);
INSERT INTO `pms_product_category` VALUES (41, '凤飞飞', 1, '飞飞', 1);
INSERT INTO `pms_product_category` VALUES (42, '这是一个名字很长的分类', 1, '这是一个名字很长的分类', 1);

-- ----------------------------
-- Table structure for pms_product_full_reduction
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_full_reduction`;
CREATE TABLE `pms_product_full_reduction`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `full_price` int(11) NULL DEFAULT NULL COMMENT '满金额，单位分',
  `reduce_price` int(11) NULL DEFAULT NULL COMMENT '减金额，单位分',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id_index`(`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品满减表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product_full_reduction
-- ----------------------------
INSERT INTO `pms_product_full_reduction` VALUES (11, 100043, 0, 0);
INSERT INTO `pms_product_full_reduction` VALUES (12, 100044, 1500, 300);

-- ----------------------------
-- Table structure for pms_product_member_price
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_member_price`;
CREATE TABLE `pms_product_member_price`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `member_level_id` int(11) NOT NULL COMMENT '会员级别id',
  `member_level_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员级别名称',
  `member_price` int(11) NULL DEFAULT NULL COMMENT '会员价格',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id_index`(`product_id`) USING BTREE,
  INDEX `member_level_id_index`(`member_level_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员价格表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product_member_price
-- ----------------------------
INSERT INTO `pms_product_member_price` VALUES (10, 100043, 0, 'string', 0);
INSERT INTO `pms_product_member_price` VALUES (11, 100044, 1, '白金', 800);

-- ----------------------------
-- Table structure for pms_sku_stock
-- ----------------------------
DROP TABLE IF EXISTS `pms_sku_stock`;
CREATE TABLE `pms_sku_stock`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `promotion_price` int(11) NULL DEFAULT NULL COMMENT '现价，单位分',
  `price` int(11) NULL DEFAULT NULL COMMENT '产品价格，单位分',
  `stock` int(10) NOT NULL COMMENT '库存',
  `sp1` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品属性1',
  `sp2` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品属性2',
  `sp3` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品属性3',
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品属性图',
  `sale_count` int(10) NULL DEFAULT 0 COMMENT '销量',
  `sku_code` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'sku编码',
  `lock_stock` int(10) NULL DEFAULT 0 COMMENT '锁定库存(即买多少锁多少，取消的时候还原)',
  `attribute_value_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code_index`(`sku_code`) USING BTREE,
  INDEX `product_id_index`(`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'sku库存表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_sku_stock
-- ----------------------------
INSERT INTO `pms_sku_stock` VALUES (12, 100043, 0, 0, 0, 'string', 'string', 'string', 'string', 0, 'string', 0, NULL);
INSERT INTO `pms_sku_stock` VALUES (13, 100044, NULL, 1000, 9999, '大杯', '常温', NULL, 'hh.png', 0, '20190429100044001', 6, NULL);
INSERT INTO `pms_sku_stock` VALUES (14, 100044, NULL, 1000, 9999, '大杯', '加冰', NULL, 'xx', 0, '4444444444', 0, NULL);

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `account_status` int(1) NULL DEFAULT 0 COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account_index`(`account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员账号信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
INSERT INTO `ums_admin` VALUES (3, 'admin', '123456', NULL, NULL, '2019-04-28 17:45:32', 1);

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
  `user_status` int(1) NOT NULL DEFAULT 0 COMMENT '0->普通用户,1->会员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_user
-- ----------------------------
INSERT INTO `ums_user` VALUES (1, '111', '阿萨德', '发达', '发斯蒂芬', '安抚', NULL, NULL, NULL, NULL, NULL, '2019-04-16 15:48:06', 0);
INSERT INTO `ums_user` VALUES (2, '222', '阿斯顿发', '安抚', '阿斯顿发', '阿斯顿发', NULL, NULL, NULL, NULL, NULL, '2019-04-16 15:48:19', 0);

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
-- Records of ums_user_member
-- ----------------------------
INSERT INTO `ums_user_member` VALUES (1, '111', 'xxx', 1, 1000, '2019-04-24 16:06:57');

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
-- Records of ums_user_member_level
-- ----------------------------
INSERT INTO `ums_user_member_level` VALUES (1, '白金', 888, 0, NULL);

-- ----------------------------
-- Table structure for ums_user_receive_address
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_receive_address`;
CREATE TABLE `ums_user_receive_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `receiver_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人名称',
  `receiver_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人电话',
  `address_area` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所在区域',
  `default_status` int(1) NULL DEFAULT NULL COMMENT '默认地址：0->否，1->是',
  `address_detail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户收货地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_user_receive_address
-- ----------------------------
INSERT INTO `ums_user_receive_address` VALUES (3, '11111', '哈哈', '13457689259', '广西北海西南达到', 0, NULL);
INSERT INTO `ums_user_receive_address` VALUES (4, '11111', 'string', 'string', 'string', 0, NULL);
INSERT INTO `ums_user_receive_address` VALUES (5, '11111', 'string', 'string', 'string', 0, NULL);
INSERT INTO `ums_user_receive_address` VALUES (6, 'string', 'string', 'string', 'string', 0, NULL);
INSERT INTO `ums_user_receive_address` VALUES (7, '11111', '神', 'string', '国际控股可根据', 1, NULL);
INSERT INTO `ums_user_receive_address` VALUES (8, '11111', 'ssq', 'string', '灌灌灌灌', 0, NULL);
INSERT INTO `ums_user_receive_address` VALUES (9, '11111', 'ssq', 'string', '哈哈哈哈哈是', 0, NULL);
INSERT INTO `ums_user_receive_address` VALUES (10, 'x0x', '外星人', '15844445555', '小行星带', 0, '谷神星');
INSERT INTO `ums_user_receive_address` VALUES (19, 'shinratensei', '邯郸发达纺织招待处', '18744441746', '陕西省,西安市,新城区', 0, '89号');
INSERT INTO `ums_user_receive_address` VALUES (24, 'shinratensei', '张仁兵', '11455557444', '河北省,邢台市,邢台县', 1, '尔雅居');

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户余额表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_user_recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_recharge_record`;
CREATE TABLE `ums_user_recharge_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(38) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `money` int(11) NOT NULL COMMENT '金额,单位分(消费为负数)',
  `change_type` int(1) NOT NULL COMMENT '金额变动类型:0->消费,1->充值',
  `recharge_status` int(1) NULL DEFAULT NULL COMMENT '充值状态:0->失败，1->成功',
  `recharge_no` varchar(38) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '充值编码',
  `transactionid` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信交易流水号',
  `change_reason` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '金额变动原因',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `order_id` int(11) NULL DEFAULT NULL COMMENT '消费订单号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '充值消费记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_user_recharge_record
-- ----------------------------
INSERT INTO `ums_user_recharge_record` VALUES (1, '111', 100000, 1, 1, 'xxxxx', NULL, '充值钱哇', '2019-04-26 17:48:17', NULL);

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户签到记录表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
