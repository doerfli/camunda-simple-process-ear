package com.adcubum.process;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDelegate implements JavaDelegate {

   private final Logger log = LoggerFactory.getLogger(this.getClass());

   @Override
   public void execute(DelegateExecution execution) throws Exception {
      log.info(String.format("logging this (%s/%s)", execution.getCurrentActivityId(), execution.getCurrentActivityName()));
      log.info("log more");
   }

}
