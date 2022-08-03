create database magneto;

create table dna (
	id int not null auto_increment, 
	sequence text not null, 
	is_mutant BOOLEAN not null,
	primary key(Id)
);

