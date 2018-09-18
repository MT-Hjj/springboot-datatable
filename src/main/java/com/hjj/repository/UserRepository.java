package com.hjj.repository;

import com.hjj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @Author: Huangjunjie
 * @Description: 创建接口UserRepository，并继承与JpaRepository
 * @Date: Created in 15:07 2018/9/3
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
