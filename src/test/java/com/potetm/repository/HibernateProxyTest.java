package com.potetm.repository;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.fail;

/**
 *
 * @author tpote
 */
public class HibernateProxyTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(HibernateProxyTest.class);

  @Test
  public void runTests() {
    for (int i = 1; i <= 100; i++) {
      Result result = JUnitCore.runClasses(HibernateProxyHelper.class);

      if (!result.wasSuccessful()) {
        LOGGER.debug("Number of tests run: {}", i);

        for (Failure failure : result.getFailures()) {
          LOGGER.debug(failure.getMessage());
        }

        fail();
      }
    }
  }
}

