package com.potetm.repository;

import com.potetm.domain.Child;
import com.potetm.domain.Parent;

import org.hibernate.proxy.HibernateProxy;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;

/**
 *
 * @author tpote
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class HibernateProxyHelper {
  @PersistenceContext
  private EntityManager   entityManager;
  @Inject
  private ChildRepository childRepository;

  @Test
  @Transactional(readOnly = true)
  @Rollback
  @DirtiesContext
  public void testProxy() {
    PersistenceUnitUtil persistenceUnitUtil = entityManager.getEntityManagerFactory().getPersistenceUnitUtil();
    Child               child               = childRepository.findOne("6a42f09a8cf211e2b9cd1724bac6162a");
    Parent              parentProxy         = child.getParent();

    assertTrue(parentProxy instanceof HibernateProxy);
    assertTrue(entityManager.contains(parentProxy));
    assertFalse(persistenceUnitUtil.isLoaded(parentProxy));
    assertEquals(persistenceUnitUtil.getIdentifier(parentProxy), parentProxy.getId());
  }
}

