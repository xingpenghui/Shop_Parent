create database db_ljb;
use db_ljb;
#1、用户表
create table user(id int primary key AUTO_INCREMENT,phone varchar(11) unique not null comment '手机号',password varchar(50) comment '密码 密文',flag int comment '标记位');
#2、用户详情表
create table userdetail(id int primary key AUTO_INCREMENT,
uid int comment '用户表的主键',nickname varchar(20) unique comment '昵称',
birthday date comment '生日',createtime datetime comment '创建日期',
sex SMALLINT comment '性别 1 女 2男',headurl varchar(200) comment '头像路径');

#3、用户积分表
create table userpoints(id int primary key AUTO_INCREMENT,uid int comment '用户表的主键',totalscore int comment '总积分',currscore int comment '可用积分');
#4、积分记录表
create table points(id BIGINT primary key AUTO_INCREMENT,uid int comment '用户积分表的主键',score int comment '积分',info varchar(50) comment '备注信息',startdate date comment '开始日期',enddate date comment '结束日期',flag SMALLINT comment '标记位 1 有效 2 提醒 ');
#5、用户日志表
create table userlog(id bigint primary key AUTO_INCREMENT,uid int comment '用户表的主键',flag int comment '标记位 1注册 2登录',createtime datetime comment '创建时间',content varchar(50) comment '日志内容');
#6、购物车表
create table cart(id int primary key AUTO_INCREMENT,uid int comment '用户表的主键',maxcount int comment '上限',currcount int comment '当前的商品数量');


