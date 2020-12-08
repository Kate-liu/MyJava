package org.copydays.thinking.java.jvm.core.technology.jvm.advanced.override;

interface Customer {
    boolean isVIP();
}

class Merchant<T extends Customer> {
    public double actionPrice(double price, T customer) {
        //    ...
        return 3.0d;
    }
}

class VIPOnlyMerchant extends Merchant<Customer> {
    @Override
    public double actionPrice(double price, Customer customer) {
        //    ...
        return 2.0d;
    }
}
