package com.just.learn.spring.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-18 15:14
 **/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("testBean");
        if (beanDefinition.hasPropertyValues()) {
            MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
            mutablePropertyValues.addPropertyValue("change", "修改");
        }
        beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);

    }
}
