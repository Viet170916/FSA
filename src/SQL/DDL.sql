create table Classes
(
    Id         int IDENTITY (1,1) primary key,
    Code       VARCHAR(6),
    SemesterID int,


);

create table Students
(
    Id        UNIQUEIDENTIFIER DEFAULT newid() primary key,
    Code      VARCHAR(8) UNIQUE NOT NULL,
    Image     VARCHAR(255),
    FirstName NVARCHAR(40),
    LastName  NVARCHAR(40),
    Gender    BIT              DEFAULT 1,
    Email     VARCHAR(255),
    Phone     VARCHAR(40),
    Address   NVARCHAR(255),
    BirthDate DATETIME,
    MajorId   int               NOT NULL,
    UserId    UNIQUEIDENTIFIER  NOT NULL
);

ALTER TABLE Students
    ADD
        FOREIGN KEY (UserId)
            REFERENCES Users (id);
ALTER TABLE Students
    ADD
        FOREIGN KEY (MajorId)
            REFERENCES Majors (id);

CREATE TABLE Users
(
    Id       UNIQUEIDENTIFIER DEFAULT newid() PRIMARY KEY,
    UserName VARCHAR(30) UNIQUE NOT NULL,
    Password VARCHAR(125)       NOT NULL
);

CREATE TABLE Majors
(
    Id          int IDENTITY (1,1) PRIMARY KEY,
    Code        VARCHAR(7) NOT NULL UNIQUE,
    Name        VARCHAR(255),
    Description VARCHAR(3000),

);
CREATE TABLE Semesters
(
    Id        int IDENTITY (1,1) PRIMARY KEY,
    Name      VARCHAR(1),
    StartDate DATETIME,
    EndDate   DATETIME
);

CREATE TABLE Courses
(
    Id          int IDENTITY (1,1) PRIMARY KEY,
    Code        VARCHAR(7) NOT NULL UNIQUE,
    Name        VARCHAR(125),
    Credit      INT,
    Description VARCHAR(3000),

);
CREATE TABLE Professors
(
    Id        UNIQUEIDENTIFIER DEFAULT newid() primary key,
    Code      VARCHAR(20) UNIQUE NOT NULL,
    Image     VARCHAR(255),
    FirstName NVARCHAR(40),
    LastName  NVARCHAR(40),
    Gender    BIT              DEFAULT 1,
    Email     VARCHAR(255),
    Phone     VARCHAR(40),
    Address   NVARCHAR(255),
    BirthDate DATETIME,
    MajorId   int                NOT NULL,
    UserId    UNIQUEIDENTIFIER   NOT NULL,
    FOREIGN KEY (UserId) REFERENCES Users (Id)
);
CREATE TABLE GroupSlot
(
    Id           int IDENTITY (1,1) PRIMARY KEY,
    ClassId      int REFERENCES Classes (Id),
    CourseId     int REFERENCES Courses (Id),
    ProfessorId  UNIQUEIDENTIFIER REFERENCES Professors (Id),
    DepartmentId int REFERENCES Departments (Id),
    Slot         int NOT NULL
);
CREATE TABLE Departments
(
    Id           int IDENTITY (1,1) PRIMARY KEY,
    Name         VARCHAR(4),
    BuildingName VARCHAR(40) NOT NULL,
    Description  VARCHAR(3000)
);
CREATE TABLE Attendances
(
    Id          int IDENTITY (1,1) PRIMARY KEY,
    Description VARCHAR(3000),
    StudentId   UNIQUEIDENTIFIER REFERENCES Students (Id),
    GroupSlotId int REFERENCES GroupSlots (Id)
);
CREATE TABLE SemesterCourse
(
    CourseId   int REFERENCES Courses (Id) ,
    SemesterId int REFERENCES Semesters (Id),
    PRIMARY KEY (CourseId, SemesterId)

);
CREATE TABLE MajorSemester(
                              SemesterId int REFERENCES Semesters(Id),
                              MajorId int REFERENCES Majors(Id)

);
ALTER TABLE MajorSemester
    ALTER COLUMN MajorId int NOT NULL ;

ALTER TABLE MajorSemester
    ADD
        PRIMARY KEY (SemesterId, MajorId);

CREATE TABLE ClassStudent(
                             ClassId int REFERENCES Classes(Id),
                             StudentId UNIQUEIDENTIFIER REFERENCES Students(id),
                             PRIMARY KEY (ClassId, StudentId)
);
--ren new--
create database FSA collate SQL_Latin1_General_CP1_CI_AS
go

use FSA
go

grant connect on database :: FSA to dbo
go

grant view any column encryption key definition, view any column master key definition on database :: FSA to [public]
go

create table dbo.Departments
(
    Id          int identity
        constraint Department_pk
            primary key,
    Name        nvarchar(50),
    Description nvarchar(3000)
)
go

create table dbo.Majors
(
    Id          int identity
        primary key,
    Code        varchar(7) not null
        unique,
    Name        varchar(255),
    Description varchar(3000)
)
go

create table dbo.Professors
(
    Id           uniqueidentifier default newid() not null
        primary key,
    Code         varchar(20)                      not null
        unique,
    DepartmentId int
        constraint Professors_Departments_Id_fk
            references dbo.Departments
)
go

create table dbo.Rooms
(
    Id           int identity
        primary key,
    Name         varchar(4),
    BuildingName varchar(40) not null,
    Description  varchar(3000)
)
go

create table dbo.Semesters
(
    Id        int identity
        primary key,
    Name      varchar(6),
    StartDate datetime,
    EndDate   datetime
)
go

create table dbo.Classes
(
    Id         int identity
        primary key,
    Code       varchar(6),
    SemesterId int
        constraint Classes_Semesters_Id_fk
            references dbo.Semesters
)
go

create table dbo.Major_Semester
(
    SemesterId int not null
        references dbo.Semesters,
    MajorId    int not null
        references dbo.Majors,
    primary key (SemesterId, MajorId)
)
go

create table dbo.Semester_Class
(
    SemesterId int not null
        constraint Semester_Class_Semesters_Id_fk
            references dbo.Semesters,
    ClassId    int not null
        constraint Semester_Class_Classes_Id_fk
            references dbo.Classes,
    constraint Semester_Class_pk
        primary key (SemesterId, ClassId)
)
go

create table dbo.Students
(
    Id      uniqueidentifier default newid() not null
        primary key,
    Code    varchar(8)                       not null
        unique,
    MajorId int
)
go

create table dbo.Class_Student
(
    ClassId   int              not null
        references dbo.Classes,
    StudentId uniqueidentifier not null
        references dbo.Students,
    primary key (ClassId, StudentId)
)
go

create table dbo.Subjects
(
    Code         varchar(40) not null
        constraint Subjects_pk
            unique,
    Name         nvarchar(100),
    DepartmentId int
        constraint Subjects_Department_Id_fk
            references dbo.Departments,
    Id           int identity
        primary key
)
go

create table dbo.Courses
(
    Id          int identity
        primary key,
    Description varchar(3000),
    SubjectId   int
        references dbo.Subjects,
    ProfessorId uniqueidentifier
        constraint Courses_Professors_Id_fk
            references dbo.Professors
)
go

create table dbo.CourseSchedules
(
    ClassId  int
        references dbo.Classes,
    CourseId int
        references dbo.Courses,
    Id       int identity
        constraint CourseSchedules_pk
            primary key,
    constraint CourseSchedules_pk2
        unique (ClassId, CourseId)
)
go

create table dbo.Slot
(
    Slot             int not null,
    CourseScheduleId int not null
        constraint Slot_CourseSchedules_Id_fk
            references dbo.CourseSchedules,
    Id               int identity
        constraint Slot_pk
            primary key,
    constraint Slot_pk2
        unique (CourseScheduleId, Slot)
)
go

create table dbo.CourseSchedule_TeachingDate
(
    CourseScheduleId int  not null
        constraint CourseSchedule_TeachingDate_Slot_Id_fk
            references dbo.Slot,
    TeachingDate     date not null,
    Id               int identity
        constraint CourseSchedule_TeachingDate_pk
            primary key,
    RoomId           int
        constraint CourseSchedule_TeachingDate_Rooms_Id_fk
            references dbo.Rooms,
    constraint CourseSchedule_TeachingDate_pk2
        unique (CourseScheduleId, TeachingDate)
)
go

create table dbo.Attendances
(
    Id                            int identity
        primary key,
    Description                   varchar(3000),
    StudentId                     uniqueidentifier
        references dbo.Students,
    CourseSchedule_TeachingDateId int
        constraint Attendances_CourseSchedule_TeachingDate_Id_fk
            references dbo.CourseSchedule_TeachingDate,
    IsAbsent                      bit default NULL,
    SemesterId                    int
        constraint Attendances_Semesters_Id_fk
            references dbo.Semesters
)
go

create table dbo.Subject_Professor
(
    CourseId    int              not null
        constraint Subject_Professor_Courses_Id_fk
            references dbo.Courses,
    ProfessorId uniqueidentifier not null
        constraint Subject_Professor_Professors_Id_fk
            references dbo.Professors,
    constraint Subject_Professor_pk
        primary key (CourseId, ProfessorId)
)
go

create table dbo.Users
(
    Id          uniqueidentifier default newid() not null
        primary key,
    Password    varchar(125)                     not null,
    Image       varchar(255),
    Gender      bit,
    Email       varchar(255),
    Phone       varchar(15),
    Address     nvarchar(255),
    BirthDate   date,
    LastName    nvarchar(40),
    FirstName   nvarchar(40),
    StudentId   uniqueidentifier
        constraint Users_Students_Id_fk
            references dbo.Students,
    ProfessorId uniqueidentifier
        constraint Users_Professors_Id_fk
            references dbo.Professors,
    Code        varchar(12),
    MidName     nvarchar(40),
    IsAdmin     bit              default 0
)
