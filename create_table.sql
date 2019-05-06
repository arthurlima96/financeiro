CREATE TABLE `alunos` (
  `idalunos` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `matricula` int(11) DEFAULT NULL,
  `curso` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idalunos`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;

CREATE TABLE `mensalidades` (
  `idmensalidades` int(11) NOT NULL AUTO_INCREMENT,
  `numero_parcela` varchar(45) DEFAULT NULL,
  `semestre` varchar(45) DEFAULT NULL,
  `vencimento` varchar(45) DEFAULT NULL,
  `valor` varchar(45) DEFAULT NULL,
  `situacao` varchar(45) DEFAULT NULL,
  `aluno_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmensalidades`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
