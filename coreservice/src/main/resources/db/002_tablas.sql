# creation of database
use marke;
# creation of tables
#Role
create table if not exists marke.role(
idrole int not null auto_increment primary key,
rolename varchar(20)
)engine=innodb;
#User
create table if not exists marke.user(
iduser int not null auto_increment primary key,
username varchar(100) not null unique,
password varchar(20),
idrole int,
status int,
FOREIGN KEY (idrole) REFERENCES marke.role(idrole)
)engine=innodb;
#Client
create table if not exists marke.client(
idclient int not null auto_increment primary key,
iduser int not null,
name varchar(80) not null,
lastname varchar(100) not null,
age int,
phone varchar(10),
FOREIGN KEY(iduser) REFERENCES marke.user(iduser)
)engine=innodb;
#Log
create table if not exists marke.log(
idlog int not null auto_increment primary key,
logdate date,
iduser int,
description varchar(300),
FOREIGN KEY (iduser) REFERENCES marke.user(iduser)
)engine=innodb;
#Payment
create table if not exists marke.payment(
idpymnt int not null auto_increment primary key,
idclient int not null,
pymntdate date not null,
amount decimal(10,2) not null,
type varchar(10),
description varchar(250),
reference varchar(250),
FOREIGN KEY (idclient) REFERENCES marke.client(idclient)
)engine=innodb;
#Bed
create table if not exists marke.bed(
idbed int not null auto_increment primary key,
bednumber int not null
)engine=innodb;

create table if not exists marke.bedavailability(
idbedavail int not null auto_increment primary key,
availabledate date,
availablehour time,
bedsavailable int
)engine=innodb;

create table if not exists marke.booking(
idbooking int not null auto_increment primary key,
creationdate datetime not null,
bookeddate datetime not null,
iduser int not null,
bookingstatus char(10),
FOREIGN KEY (iduser) REFERENCES marke.user(iduser)
)engine=innodb;

create table if not exists marke.instructor(
idinstructor int not null auto_increment primary key,
name varchar(100),
color varchar(10)
)engine=innodb;

create table if not exists marke.schedule(
idschedule int not null auto_increment primary key,
classweekday varchar(10),
classhour time,
idinstructor int,
startdate date not null,
enddate date,
FOREIGN KEY (idinstructor) references marke.instructor(idinstructor)
)engine=innodb;

create table if not exists marke.fee(
	idfee int not null auto_increment primary key,
    idclient int not null,
    creationDate date not null,
    reason varchar(250) not null,
    amount bigint not null,
    FOREIGN KEY (idclient) references marke.client(idclient)
)engine=innodb;


