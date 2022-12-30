package exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.HashMap;

// BEGIN
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, String> inspect = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(CustomBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Inspect inspect = bean.getClass().getAnnotation(Inspect.class);

        if (inspect != null) {
            this.inspect.put(beanName, inspect.level());
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (inspect.containsKey(beanName)) {

            Object misterBean = bean;

            InvocationHandler invocationHandler = (beanObject, method, args) -> {

                    if (inspect.get(beanName).equals("info")) {
                        logger.info("Was called method: {}() with arguments: {}", method.getName(), args);
                    }

                    if (inspect.get(beanName).equals("debug")) {
                        logger.debug("Was called method: {}() with arguments: {}", method.getName(), args);
                    }

                    return method.invoke(misterBean, args);
                };

            bean = Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    invocationHandler);
        }

        return bean;
    }
}
// END
