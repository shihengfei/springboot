package com.qinmei.repositroy;

import com.qinmei.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 操作数据库的接口
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    List<Girl> findByAge(Integer age);
}
