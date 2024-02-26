-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: 172.17.0.1    Database: target_finder
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `target`
--

DROP TABLE IF EXISTS `target`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `target` (
  `uuid` binary(16) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `whatsapp_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `target`
--

LOCK TABLES `target` WRITE;
/*!40000 ALTER TABLE `target` DISABLE KEYS */;
INSERT INTO `target` VALUES (_binary '&6v\'ΜO��;`��\�T\�','Home - Veloz Desentupimento','https://velozdesentupimento.com.br/?gclid=EAIaIQobChMIp6--lJekhAMV7WFIAB23VQcFEAAYASABEgJJNvD_BwE','5562999959532'),(_binary '&G��]�K\'�~\�\n�\�','Athenas Desentupidora e Dedetizadora - ATHENAS','https://athenasdesentupimento.com.br/','5562993532065'),(_binary '5\�\�Y�F������y','Desentupimento - Amil Desentupidora e Dedetizadora - Goiânia','https://www.google.com/aclk?sa=l&ai=DChcSEwiCsqq4oKSEAxXNYkgAHaQBAn8YABAVGgJjZQ&ae=2&gclid=EAIaIQobChMIgrKquKCkhAMVzWJIAB2kAQJ_EAAYAiALEgJodfD_BwE&sig=AOD64_2dbqbKOhE3-5bkVkXMCm00awRtNg&q=&ved=2ahUKEwiaiqO4oKSEAxWUl5UCHdSlDLEQh78CegQIDBAB&adurl=','5562986090307'),(_binary 'G��\�\�O\Z�\�O��\�\�','Limpmil | – Desentupidora e Dedetizadora em Goiânia e Região','https://limpmil.com.br/','5562998422863'),(_binary 'RS\\��&Ek��\�2���\�','Início - Inova dedetização 24 horas','https://inova24horas.com/','5562996373350'),(_binary 'U_\n\��IÂ\�:�j,-','Rocha Dedetização','https://www.rochadedetizacao.com.br/','5562999195845'),(_binary 'W\��z�N\�\�\�\�?<','Desentupidora – ADS Desentupidora','https://adsdesentupidora.com.br/','5562993622381'),(_binary 'Zc�\�\�A��L\�\Z\�2','Larclean | Saúde ambiental','https://larclean.com/?gad_source=1&gclid=EAIaIQobChMI1e_-5fmjhAMVtWJIAB16UA2oEAAYASAKEgLGa_D_BwE','5562999834109'),(_binary '[����K��P\"�2�','Goiânia Desentupidora – Desentupidora em Goiânia 24h','https://goianiadesentupidora24h.com.br/','5562996204143'),(_binary 's>; �Bs����m��L','Desentupidora Service 24 hr GO','https://desentupidoragruposaabigo.com.br/','5562994673511'),(_binary '�i\�4m�D����׶\n5x','Bonner Desentupidora em Goiânia','https://desentupidoragoiania24h.com.br/','5562998738279'),(_binary '�\�\�*Bo��r]�(ھ','Home Dedetização – BioSolv Goiânia','https://guiaprestadoresdeservicos.com.br/biosolv/','5562996863054'),(_binary '��MX�_M��{�\�,\n`e','Home - Ligerim Desentupidora e Dedetização','https://ligerimdesentupidoraededetizadora.com/','5562999968313'),(_binary '�8�o\\@´���>\�@','Truly Nolen – Controle de Pragas e Sanitização','https://trulynolengoias.com.br/','556239223334'),(_binary 'ʿ����OK	\�\�\�','Limpmil Desentupidora – Limpmil |','https://limpmil.com.br/limpmil-desentupidora-goiania/','5562998422863'),(_binary '\�h�\��\�C\n�o��\\\�o','Sobre Nós - Amil Desentupidora e Dedetizadora - Goiânia','https://amilgoiania.com.br/sobre-nos/','5562986090307'),(_binary '\��\�B �S\"���\�','Cometa Dedetizadora','https://www.cometadedetizadora.com.br/','556232413001'),(_binary '޼\�%\�\�J\�4E�R\�}�','Serviços e controle de pragas - Naturize','https://naturizeambiental.net.br/','5562982284135'),(_binary '\��in�N��>,\�\�[','Matabem','https://www.matabemmais.com/','5562982042400'),(_binary '\�䄣\�0G8���\�\r�\�','Desentupidora 24hrs - Desentupidora em Goiânia | Goiânão','https://desentupidoragoianao.com.br/','5562997019486');
/*!40000 ALTER TABLE `target` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-25 22:55:24
