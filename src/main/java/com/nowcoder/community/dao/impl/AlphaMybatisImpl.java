package com.nowcoder.community.dao.impl;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.stereotype.Repository;

@Repository("mybatis")
public class AlphaMybatisImpl implements AlphaDao {
    @Override
    public String select() {
        return "Mybatis";
    }
}
