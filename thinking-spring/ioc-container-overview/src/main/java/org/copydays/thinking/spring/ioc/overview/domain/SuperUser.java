package org.copydays.thinking.spring.ioc.overview.domain;

import org.copydays.thinking.spring.ioc.overview.annotation.Super;

/**
 * 超级用户
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
@Super
public class SuperUser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}

