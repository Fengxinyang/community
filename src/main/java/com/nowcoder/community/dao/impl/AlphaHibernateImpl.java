package com.nowcoder.community.dao.impl;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.stereotype.Repository;

@Repository("hibernate")
public class AlphaHibernateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
