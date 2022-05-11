package com.nowcoder.community.dao;

import com.nowcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
//不推荐使用了
@Deprecated
public interface LoginTicketMapper {

    @Insert({
            "insert into login_ticket(user_id, ticket, status, expired) ",
            "values(#{userId}, #{ticket}, #{status}, #{expired});"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({
            "select id, user_id, ticket, status, expired",
            "from login_ticket where ticket = #{ticket}"
    })
    LoginTicket selectByTicket(String ticket);
    @Update({
            "<script>",
            "update login_ticket set status = #{status} where ticket = #{ticket}",
            "<if test=\"ticket != null\">",
            "and 1=1",//用于演示注解形式的动态sql，无其他意义。
            "</if>",
            "</script>"
    })
    int updateStatus(String ticket, int status);
}
