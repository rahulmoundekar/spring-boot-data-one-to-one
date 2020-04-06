# spring-boot-data-one-to-one
spring-boot-data-one-to-one swagger implementaion

Database SQL
    
      DROP TABLE IF EXISTS `springboot`.`person`;
      CREATE TABLE  `springboot`.`person` (
        `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
        `name` varchar(45) NOT NULL,
        `mobile` varchar(45) NOT NULL,
        PRIMARY KEY (`id`)
      ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
      
      DROP TABLE IF EXISTS `springboot`.`license`;
      CREATE TABLE  `springboot`.`license` (
        `id` int(10) unsigned NOT NULL,
        `license_number` varchar(45) NOT NULL,
        `issue_date` date NOT NULL,
        `expiry_date` date NOT NULL,
        PRIMARY KEY (`id`),
        CONSTRAINT `FK_license_1` FOREIGN KEY (`id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
      ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

Swagger :
      run :
          http://localhost:8080/swagger-ui.html
