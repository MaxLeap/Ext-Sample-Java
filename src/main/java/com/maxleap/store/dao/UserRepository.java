package com.maxleap.store.dao;

import com.maxleap.store.bean.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User：David Young
 * Date：17/11/07
 */
public interface UserRepository extends JpaRepository<UserJpa, Long> {

  //Spring-data-jpa可以通过解析方法名创建查询
  UserJpa findById(Long id);

  List<UserJpa> findAllByFirstName(String name);

  //使用@Query 注解来创建查询(JPQL语句)，通过类似“:password”来映射@Param指定的参数
  @Query("from test_user u where u.password=:password")
  List<UserJpa> findUsers(@Param("password") String password);
}
