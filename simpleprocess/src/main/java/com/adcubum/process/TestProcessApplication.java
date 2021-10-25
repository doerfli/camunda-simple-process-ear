package com.adcubum.process;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.ProcessApplicationInterface;
import org.camunda.bpm.application.impl.EjbProcessApplication;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@ProcessApplication(name = "Partner", deploymentDescriptors = "bpmn/processes.xml")
@Local(ProcessApplicationInterface.class)
public class TestProcessApplication extends EjbProcessApplication {

   @PostConstruct
   public void start() {
      deploy();
   }

   @PreDestroy
   public void stop() {
      undeploy();
   }

}
