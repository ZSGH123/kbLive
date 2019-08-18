package com.kblive.usersystem.web.config;

import com.kblive.usersystem.dao.user.KbliveUserDAO;
import com.kblive.usersystem.services.user.KbliveUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * title: AppConfig
 * projectName kbLive
 * description: 应用的配置类
 * author 2671242147@qq.com
 * date 2019-08-17 17:07
 ***/
//①将一个POJO标注为定义Bean的配置类
@Configuration
public class AppConfig {
    ///②以下方法定义了Bean，以提供了Bean的实例化逻辑
    @Bean(name = "AppConfigDao")
    public KbliveUserDAO kbliveUserDAO() {
        System.out.println("AppConfig配置类提供Daobean");
        return new KbliveUserDAO();
    }

    @Bean(name = "AppConfigService")
    public KbliveUserService getKbliveUserService() {
        System.out.println("AppConfig配置类提供Servicebean");
        KbliveUserService kbliveUserService = new KbliveUserService();
        kbliveUserService.setKbliveUserDAO(kbliveUserDAO());
        return kbliveUserService;
    }

//    ①处在APPConf类的定义处标注了@Configuration注解，说明这个类可用于为Spring提供Bean的定义信息。类的方法处可以标注@Bean注解，
//    Bean的类型由方法返回值类型决定，名称默认和方法名相同，也可以通过入参显示指定Bean名称，如@Bean(name="userDao").
//    直接在@Bean所标注的方法中提供Bean的实例化逻辑。
//
//    在②处userDao()和logDao()方法定义了一个UserDao和一个LogDao的Bean，它们的Bean名称分别是userDao和logDao。
//    在③处，又定义了一个logonService Bean，并且在④处注入②处所定义的两个Bean。
//
//    因此，以上的配置和以下XML配置时等效的：
//
//    <bean id="userDao" class="com.baobaotao.anno.UserDao"/>
//     <bean id="logDao" class="com.baobaotao.anno.LogDao"/>
//     <bean id="logService" class="com.baobaotao.conf.LogonService" p:logDao-ref="logDao" p:userDao-ref="userDao"/>
//    基于java类的配置方式和基于XML或基于注解的配置方式相比，前者通过代码的方式更加灵活地实现了Bean的实例化及Bean之间的装配，
//    但后面两者都是通过配置声明的方式，在灵活性上要稍逊一些，但是配置上要更简单一些。
}
