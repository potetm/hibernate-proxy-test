package com.potetm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tpote
 */
@Entity
@Table(name = "child")
public class Child implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(
    name                                     = "id",
    unique                                   = true,
    nullable                                 = false
  )
  private String            id;
  @Column(
    name     = "name",
    unique   = false,
    nullable = false
  )
  private String            name;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name     = "parent_id",
    nullable = false
  )
  private Parent            parent;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Parent getParent() {
    return parent;
  }
}

