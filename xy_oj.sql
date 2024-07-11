-- auto-generated definition
create table question
(
    id          bigint auto_increment comment 'id'
        primary key,
    title       varchar(512)                       null comment '标题',
    content     text                               null comment '内容',
    tags        varchar(1024)                      null comment '标签列表（json 数组）',
    answer      varchar(512)                       not null comment '答案',
    userId      bigint                             not null comment '创建用户 Id',
    submitNum   int      default 0                 not null comment '提交人数',
    acceptedNum bigint   default 0                 not null comment '通过人数',
    thumbNum    bigint   default 0                 not null comment '点赞人数',
    favourNum   bigint   default 0                 not null comment '收藏人数',
    judgeCase   text                               not null comment '判题用例',
    judgeConfig text                               not null comment '判题配置',
    createTime  datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete    tinyint  default 0                 not null comment '是否删除'
)
    comment '创建题目' collate = utf8mb4_unicode_ci;

create index idx_userId
    on question (userId);
-- auto-generated definition
create table question_submit
(
    id         bigint auto_increment comment 'id'
        primary key,
    language   varchar(512)                       null comment '编程语言',
    code       text                               null comment '代码内容',
    tags       varchar(1024)                      null comment '标签列表（json 数组）',
    userId     bigint                             not null comment '创建用户 Id',
    questionId bigint                             not null comment '题目 Id',
    status     int      default 0                 not null comment '提交提交的状态',
    judgeInfo  text                               not null comment '判题信息(判题得出的信息结果 eg：编译失败，超时等）',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除'
)
    comment '提交题目' collate = utf8mb4_unicode_ci;

create index idx_questionId
    on question_submit (questionId);

create index idx_userId
    on question_submit (userId);

-- auto-generated definition
create table user
(
    id           bigint auto_increment comment 'id'
        primary key,
    userAccount  varchar(256)                           not null comment '账号',
    userPassword varchar(512)                           not null comment '密码',
    unionId      varchar(256)                           null comment '微信开放平台id',
    mpOpenId     varchar(256)                           null comment '公众号openId',
    userName     varchar(256)                           null comment '用户昵称',
    userAvatar   varchar(1024)                          null comment '用户头像',
    userProfile  varchar(512)                           null comment '用户简介',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
)
    comment '用户' collate = utf8mb4_unicode_ci;

create index idx_unionId
    on user (unionId);


