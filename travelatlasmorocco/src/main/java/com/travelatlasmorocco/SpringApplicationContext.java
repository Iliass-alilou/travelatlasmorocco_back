package com.travelatlasmorocco;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
public class SpringApplicationContext implements ApplicationContextAware{

    //mecanisme qui nous permettre d'acceder a tout les context necessaires (garder le Singleton)
    private static ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        CONTEXT = applicationContext;
    }

    //Object Return :

    public static Object getBean(String beanName) {
        return CONTEXT.getBean(beanName);
    }
}
