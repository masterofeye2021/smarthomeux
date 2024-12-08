package de.smarthome.smartux.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DynamicBeanRegistrar {
    private final ConfigurableApplicationContext context;

    @Autowired
    public DynamicBeanRegistrar(ConfigurableApplicationContext context) {
        this.context = context;
    }

    public void registerBean(String beanName, Object bean) {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        beanFactory.registerSingleton(beanName, bean);

        context.getAutowireCapableBeanFactory().autowireBean(bean);
    }

}