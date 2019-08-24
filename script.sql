create table Authority
(
    ID   int identity
        constraint Authority_pk
            primary key nonclustered,
    name varchar(8) not null
)
go

create unique index Authority_name_uindex
    on Authority (name)
go

create table Member
(
    ID          int identity
        constraint Member_pk
            primary key nonclustered,
    firstName   nvarchar(64),
    lastName    nvarchar(64),
    username    varchar(64) not null,
    password    varchar(60) not null,
    phone       varchar(16),
    email       varchar(32) not null,
    description nvarchar(200),
    createdDate datetime    not null,
    updatedTime datetime    not null
)
go

create table Content
(
    ID          int identity
        constraint Content_pk
            primary key nonclustered,
    authorID    int           not null
        constraint Content_Member_ID_fk
            references Member,
    title       nvarchar(64)  not null,
    brief       nvarchar(512) not null,
    content     ntext         not null,
    createdDate datetime      not null,
    updatedTime datetime      not null
)
go

create unique index Content_title_uindex
    on Content (title)
go

create unique index Member_username_uindex
    on Member (username)
go

create unique index Member_email_uindex
    on Member (email)
go

create table MemberAuthorities
(
    memberID    int not null
        constraint MemberAuthorities_Member_ID_fk
            references Member,
    authorityID int not null
        constraint MemberAuthorities_Authority_ID_fk
            references Authority
)
go

create table persistent_logins
(
    username  varchar(64) not null
        constraint persistent_logins_Member_username_fk
            references Member (username),
    series    varchar(64) not null
        primary key,
    token     varchar(64) not null,
    last_used timestamp   not null
)
go


