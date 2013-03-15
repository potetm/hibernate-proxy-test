package com.potetm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tpote
 */
@Entity
@Table(name = "parent")
public class Parent implements Serializable {
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

//@OneToMany(
//  fetch              = FetchType.LAZY,
//  cascade            = CascadeType.ALL
//)
//@JoinTable(
//  name               = "child",
//  joinColumns        = @JoinColumn(
//    name             = "parent_id",
//    nullable         = false
//  ) ,
//  inverseJoinColumns = @JoinColumn(
//    name             = "id",
//    nullable         = false
//  )
//)
  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}

