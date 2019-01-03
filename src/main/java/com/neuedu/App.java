package com.neuedu;


import com.neuedu.MybatisUtil.UtilM;
import com.neuedu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    @Test
    public void s1() {
        SqlSession sqlSession = null;

        /*
         * 如果传递的参数是javabean  #{属性名}
         * 如果传递的是一个参数
         * 如果是多个参数 map
         * */
        try {
            sqlSession = UtilM.getsession();

            List<User> lists = sqlSession.selectList("getUsers");
            for (User u : lists) {
                System.out.println(u);
            }
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

//    @Test
//    public void s2() {
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = UtilM.getsession();
//
//            User u = new User();
//            u.setUsername("申翔宇");
//            u.setPassword("22");
//            sqlSession.insert("intertone", u);
//            sqlSession.commit();            //需要手动提交的方法 commit
//        } finally {
//            if (sqlSession != null) {
//                sqlSession.close();
//            }
//        }
//    }

    @Test
    public void s3() {
        SqlSession sqlSession = null;
        try {
            sqlSession = UtilM.getsession();
            sqlSession.delete("deleteone", 82);
            sqlSession.commit();            //需要手动提交的方法 commit
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void s4() {
        SqlSession sqlSession = null;
        try {
            sqlSession = UtilM.getsession();
            Map<String, Object> map = new HashMap<>();
            map.put("a", "80");
            map.put("b", 3);
            sqlSession.delete("deleteandtwo", map);
            sqlSession.commit();            //需要手动提交的方法 commit
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void s5() {
        SqlSession sqlSession = null;
        try {
            sqlSession = UtilM.getsession();
            User u = new User();
            u.setUsername("abc1234");
            u.setPassword("987654321");
            sqlSession.insert("intertone", u);

            sqlSession.commit();            //需要手动提交的方法 commit
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void s6() {
        SqlSession sqlSession = null;
        try {
            sqlSession = UtilM.getsession();
            User u = new User();
            u.setId(1);
            sqlSession.selectOne("getone", u);

            sqlSession.commit();            //需要手动提交的方法 commit
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void s7(){
        SqlSession session=null;
        try{
          session = UtilM.getsession();
            User u=new User();
            u.setId(1);
            u.setUsername("qq");
            u.setPassword("520");
            session.update("updateone",u);
            session.commit();
        }finally {
            if (session != null){
                session.close();
            }
        }
    }
//
//    @Test
//    public void s8(){
//        SqlSession session=null;
//        try{
//          session = UtilM.getsession();
//          User u=new User();
//          u.setUsername("qq");
//        List<User> user = session.selectList("getUsers",u);
//            for ( User list: user
//                 ) {
//                System.out.println(list);
//            }
//            session.commit();
//        }finally {
//            if (session !=null){
//                session.close();
//            }
//        }
//    }

    @Test
    public void s9(){
            SqlSession session=null;
            try{
                session = UtilM.getsession();
                User u=new User();
                u.setUsername("a");
                u.setId(2);
                List<User> user = session.selectList("getUsers",u);
                for ( User list: user
                        ) {
                    System.out.println(list);
                }
                session.commit();
            }finally {
                if (session !=null){
                    session.close();
                }
            }
        }


    @Test
    public void s10() {
        SqlSession sqlSession = null;
        try {
            sqlSession = UtilM.getsession();

            User u = new User();
            u.setUsername("申翔宇");
            u.setPassword("122");
            u.setTele("111");
            sqlSession.insert("intertone", u);
            sqlSession.commit();            //需要手动提交的方法 commit
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
