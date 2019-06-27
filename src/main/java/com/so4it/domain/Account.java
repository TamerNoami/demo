package com.so4it.domain;

import java.util.Objects;

public class Account {
    private Long id;
    private Double balance;
    private String name;

    public Account(Builder builder) {
        this.id = Objects.requireNonNull(builder.id,"id can't be null");
        this.balance = Objects.requireNonNull(builder.balance,"balance can't be null");
        this.name = builder.name;
    }


    public Long getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{

        private Long id;
        private Double balance;
        private String name;

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withBalance(Double balance) {
            this.balance = balance;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return  this;
        }

        public Account build(){
            return new Account(this);
        }
    }
}
