use db_MatheusMRC;

create table Acessorios (
	idAcessorio int not null auto_increment,
    descricaoAcessorio varchar(100) not null,
    marcaAcessorio varchar(30) not null,
    valorAcessorio decimal(10, 2) not null,
    categoria varchar(30) not null,
    primary key (idAcessorio)
    );
    
create table CaixasSom (
	idCaixaSom int not null auto_increment,
    descricaoCaixaSom varchar(100) not null,
    marcaCaixaSom varchar(30) not null,
    valorCaixaSom decimal(10, 2) not null,
    potenciaSaida int,
    tipoAltoFalante varchar(30),
    qtdAltoFalantes int,
    configCanais varchar(30),
    primary key (idCaixaSom)
    );
    
create table Instrumentos (
	idInstrumento int not null auto_increment,
    descricaoInstrumento varchar(100) not null,
    marcaInstrumento varchar(30) not null,
    valorInstrumento decimal(10, 2) not null,
    categoria varchar(30) not null,
    primary key (idInstrumento)
    );
    
create table Microfones (
	idMicrofone int not null auto_increment,
    descricaoMicrofone varchar(100) not null,
    marcaMicrofone varchar(30) not null,
    valorMicrofone decimal(10, 2) not null,
    formato varchar(30),
    tipo varchar(30),
    frequenciaMin varchar(10),
    padraoPolar varchar(30),
    primary key (idMicrofone)
    );