package com.neuedu.MybatisUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

public class UtilM {
    public static SqlSession getsession() {         SqlSession sqlSession = null;
        {
            try {                                               //将基本配置信息以流的方式读取
                InputStream is = Resources.getResourceAsStream("com/neuedu/dao/mybatis-conf.xml");
                SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
                sqlSession = factory.openSession();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSession;
    }
}