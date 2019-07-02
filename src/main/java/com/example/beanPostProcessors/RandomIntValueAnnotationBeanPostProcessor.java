package com.example.beanPostProcessors;

import com.example.annotations.RandomIntValue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Configuration
public class RandomIntValueAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            RandomIntValue annotation = field.getAnnotation(RandomIntValue.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                boolean even = annotation.even();
                boolean odd = annotation.odd();
                Integer i;
                if (odd == even && even) throw new ArithmeticException();
                Random random = new Random();
                if (even) {
                    do {
                        i = min + random.nextInt(max - min);
                    } while (!(i % 2 == 0));
                } else {
                    do {
                        i = min + random.nextInt(max - min);
                    } while (!(i % 2 == 1));
                }
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, i);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
