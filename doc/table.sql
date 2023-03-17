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
    `component_id`   varchar(256) NOT NULL COMMENT '组件id',
    `component_name` varchar(256) NOT NULL COMMENT '组件名称',
    `status_info`    int(11) DEFAULT NULL COMMENT '1-在库 2-借出 3-丢失 4-删除',
    `createTime`     datetime     DEFAULT CURRENT_TIMESTAMP,
    `updateTime`     datetime     DEFAULT NULL,
    PRIMARY KEY (`serial_number`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='组件库存表';


DROP TABLE IF EXISTS `component_reservation`;
CREATE TABLE `component_reservation`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT,
    `component_id`   varchar(256) DEFAULT NULL COMMENT '组件id',
    `component_name` varchar(256) DEFAULT NULL COMMENT '组件名称',
    `serial_number`  varchar(256) DEFAULT NULL COMMENT '组件编号',
    `user_id`        bigint(20) NOT NULL COMMENT '用户id',
    `user_name`      varchar(200) NOT NULL COMMENT '用户名称 ',
    `user_school`    varchar(200) NOT NULL COMMENT '用户学校',
    `user_email`     varchar(200) NOT NULL COMMENT '用户email',
    `status_info`    int(11) DEFAULT NULL COMMENT '1-申请 2-同意 3-拒绝 4-借出中 5-回收 6-删除',
    `due_date`       datetime     DEFAULT NULL COMMENT '计划归还时间',
    `return_date`    datetime     DEFAULT NULL COMMENT '实际归还时间',
    `createTime`     datetime     DEFAULT CURRENT_TIMESTAMP,
    `updateTime`     datetime     DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='组件预定表';
