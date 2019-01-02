package com.neuedu;


import com.neuedu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class App {
   @Test
    public void s1(){

       try {
           InputStream   is = Resources.getResourceAsStream("com/neuedu/dao/mybatis-conf.xml");
           //将xml文件读成 '流',结果初始化转为输入流类型的is
           SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(is);
           //SqlSessionFactoryBuilder的build方法将is流装进来,创建一个工厂赋值给factory()
           SqlSession sqlSession =factory.openSession();
           /*打开一个会话   (SqlSession 完全包含了面向数据库执行 SQL 命令所需的所有方法。
           可以通过sqlSession直接执行已映射的 SQL 语句)*/
           List<User> lists = sqlSession.selectList("getUsers");
                //sqlSession执行查找方法使用这条sql语句, 再利用List集合做接收
           for (User u:lists
                   ) {
               System.out.println(u);   //foreach循环打印输出内容
           }
       } catch (IOException e) {
           e.printStackTrace();
       }


   }
}
