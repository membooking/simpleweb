package com.enet.io.lppage.webapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ImportResource({"classpath:applicationContext-dao.xml"})
public class HibernateXMLConf {
    //
}
