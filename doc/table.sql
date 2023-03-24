DROP TABLE IF EXISTS `component`;
CREATE TABLE `component`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `name`        varchar(500)  DEFAULT NULL COMMENT '名称',
    `description` varchar(2000) DEFAULT NULL COMMENT '描述',
    `websites`    varchar(2000) NOT NULL COMMENT '网站',
    `image_path`  varchar(2000) DEFAULT NULL COMMENT '图片路径',
    `pdf_path`    varchar(2000) DEFAULT NULL COMMENT 'pdf路径',
    `categories`  varchar(100)  DEFAULT NULL COMMENT '硬件类型',
    `status_info` int(11) DEFAULT NULL COMMENT '1正常 2禁用  3 其他',
    `createTime`  datetime      DEFAULT CURRENT_TIMESTAMP,
    `updateTime`  datetime      DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='组件详情表';

DROP TABLE IF EXISTS `component_inventory`;
CREATE TABLE `component_inventory`
(
    `serial_number`  varchar(256) NOT NULL COMMENT '组件标号',
    `component_id`   bigint(20) NOT NULL COMMENT '组件id',
    `component_name` varchar(256) NOT NULL COMMENT '组件名称',
    `status_info`    int(11) DEFAULT NULL COMMENT '1-在库 2-借出 3-丢失 4-删除',
    `createTime`     datetime DEFAULT CURRENT_TIMESTAMP,
    `updateTime`     datetime DEFAULT NULL,
    PRIMARY KEY (`serial_number`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='组件库存表';


DROP TABLE IF EXISTS `component_reservation`;
CREATE TABLE `component_reservation`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT,
    `component_id`   bigint(20) NOT NULL COMMENT '组件id',
    `component_name` varchar(256) DEFAULT NULL COMMENT '组件名称',
    `serial_number`  varchar(256) DEFAULT NULL COMMENT '组件编号',
    `user_id`        bigint(20) NOT NULL COMMENT '用户id',
    `user_name`      varchar(200) NOT NULL COMMENT '用户名称 ',
    `user_school`    varchar(200) NOT NULL COMMENT '用户学校',
    `user_email`     varchar(200) NOT NULL COMMENT '用户email',
    `status_info`    int(11) DEFAULT NULL COMMENT '1-申请 2-同意 3-拒绝 4-借出中 5-回收 6-删除',
    `due_date`       varchar(200)     DEFAULT NULL COMMENT '计划归还时间',
    `return_date`    varchar(200)     DEFAULT NULL COMMENT '实际归还时间',
    `createTime`     datetime     DEFAULT CURRENT_TIMESTAMP,
    `updateTime`     datetime     DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='组件预定表';



DROP TABLE IF EXISTS `component_proposal`;
CREATE TABLE `component_proposal`
(
    `id`                bigint(20) NOT NULL AUTO_INCREMENT,
    `name`              varchar(500)  DEFAULT NULL COMMENT '名称',
    `description`       varchar(2000) DEFAULT NULL COMMENT '描述',
    `websites`          varchar(2000) NOT NULL COMMENT '网站',
    `image_path`        varchar(2000) DEFAULT NULL COMMENT '图片路径',
    `pdf_path`          varchar(2000) DEFAULT NULL COMMENT 'pdf路径',
    `categories`        varchar(100)  DEFAULT NULL COMMENT '硬件类型',
    `status_info`       int(11) DEFAULT NULL COMMENT '1-申请 2-同意 3-拒绝 6-删除',
    `user_id`           bigint(20) NOT NULL COMMENT '用户id',
    `user_name`         varchar(200)  NOT NULL COMMENT '用户名称 ',
    `user_school`       varchar(200)  NOT NULL COMMENT '用户学校',
    `user_email`        varchar(200)  NOT NULL COMMENT '用户email',
    `cost`              varchar(100)  DEFAULT NULL COMMENT '成本',
    `qty`               varchar(100)  DEFAULT NULL COMMENT '数量',
    `student_programme` varchar(100)  DEFAULT NULL COMMENT '学生方案',
    `createTime`        datetime      DEFAULT CURRENT_TIMESTAMP,
    `updateTime`        datetime      DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='组件建议表';


DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_name`   varchar(24)  DEFAULT NULL COMMENT '用户名',
    `account`     varchar(24) NOT NULL COMMENT '账号',
    `person_id`   varchar(24) NOT NULL COMMENT '学生id',
    `password`    varchar(60)  DEFAULT NULL COMMENT '密码',
    `school`      varchar(200) DEFAULT NULL COMMENT '用户学校',
    `email`       varchar(200) DEFAULT NULL COMMENT '用户email',
    `role_id`     int(11) DEFAULT NULL COMMENT '当前角色使用的角色id',
    `status_info` int(11) DEFAULT NULL COMMENT '1正常 2禁用  3 其他',
    `login_ip`    varchar(24)  DEFAULT NULL COMMENT '登录ip',
    `login_time`  datetime     DEFAULT NULL COMMENT '登录时间',
    `remark`      varchar(256) DEFAULT NULL COMMENT '备注',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户基本信息表';



DROP TABLE IF EXISTS `component_user_cart`;
CREATE TABLE `component_user_cart`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`      bigint(20) NOT NULL COMMENT '用户id',
    `component_id` bigint(20) NOT NULL COMMENT '组件',
    `create_time`  datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='组件用户收藏关联表';