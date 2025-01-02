package de.smarthome.smartux.module;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DynamicBeanRegistrar {
    private final ConfigurableApplicationContext context;

    public DynamicBeanRegistrar(ConfigurableApplicationContext context) {
        this.context = context;
    }

    public void registerBean(String beanName, Object bean) {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        beanFactory.registerSingleton(beanName, bean);

        context.getAutowireCapableBeanFactory().autowireBean(bean);
    }

}
