package org.copydays.thinking.spring.configuration.metadata;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.PropertyPathFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * user 元素的 {@link BeanDefinitionParser} 实现
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        setAttributeValue("id", element, builder);
        setAttributeValue("name", element, builder);
        setAttributeValue("city", element, builder);
    }

    private void setAttributeValue(String attributeName, Element element, BeanDefinitionBuilder builder) {
        String attributeValue = element.getAttribute(attributeName);
        if (StringUtils.hasText(attributeValue)) {
            builder.addPropertyValue(attributeName, attributeValue);  // BeanDefinition 定义 id 属性
        }
    }
}

