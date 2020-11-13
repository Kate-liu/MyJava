package org.copydays.thinking.spring.data.binding;

import org.copydays.thinking.spring.ioc.overview.domain.Company;
import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link DataBinder} 示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see DataBinder
 * @since
 */
public class DataBinderDemo {
    public static void main(String[] args) {
        // 创建空白对象
        User user = new User();
        // 创建 DataBinder
        DataBinder dataBinder = new DataBinder(user, "user");

        // 创建 PropertyValues
        Map<String, Object> source = new HashMap<>();
        source.put("id", 1);
        source.put("name", "rmliu");
        // PropertyValues 存在 user 中不存在属性值
        // DataBinder 特性一： 忽略未知的属性
        source.put("age", 19);
        // PropertyValues 存在一个嵌套属性，比如 Company.name
        // DataBinder 特性二： 支持嵌套属性
        // Company company = new Company();
        // user.setCompany = company;
        // source.put("company", new Company());  // 手动添加嵌套路径下的对象
        source.put("company.name", "alibaba");

        PropertyValues propertyValues = new MutablePropertyValues(source);

        // 调整 IgnoreUnknownFields true(默认) -> false
        // age 不存在 user 对象中，会报错
        // dataBinder.setIgnoreUnknownFields(false);

        // 调整 AutoGrowNestedPaths true(默认) -> false
        dataBinder.setAutoGrowNestedPaths(false);

        // 调整 IgnoreInvalidFields false(默认) -> true
        // 默认调整，不变化；需要 调整 AutoGrowNestedPaths true(默认) -> false
        dataBinder.setIgnoreInvalidFields(true);

        // 绑定 必须绑定字段
        dataBinder.setRequiredFields("id", "name", "city");

        dataBinder.bind(propertyValues);

        // 输出 user 内容
        System.out.println(user);

        // 获取绑定结果
        // 结果包含错误文案 code， 不会抛出异常
        BindingResult bindingResult = dataBinder.getBindingResult();
        System.out.println(bindingResult);
    }
}

