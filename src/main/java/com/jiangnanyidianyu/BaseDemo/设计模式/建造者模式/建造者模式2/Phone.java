package com.jiangnanyidianyu.BaseDemo.设计模式.建造者模式.建造者模式2;

/**
 * @ClassName Phone
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 14:36
 */
public class Phone {
    private final String brand;

    private final int memory;

    private final int storage;

    private final String color;

    private final int size;

    private Phone(Builder builder) {
        this.brand = builder.brand;
        this.memory = builder.memory;
        this.storage = builder.storage;
        this.color = builder.color;
        this.size = builder.size;
    }
    // 省略 getter 方法...
    public static class Builder {

        private String brand;

        private int memory;

        private int storage;

        private String color = "black";

        private int size = 8;

        public Phone build() {
            // 将依赖关系校验、约束条件校验、必填参数校验等放到这里面做
            // brand、memory、storage 必填
            if (brand == null || "".equals(brand)) {
                throw new IllegalArgumentException("brand should not be empty");
            }

            if (memory < 0) {
                throw new IllegalArgumentException("memory should not less than 0");
            }

            if (storage < 0) {
                throw new IllegalArgumentException("storage should not less than 0");
            }

            if (memory > storage) {
                throw new IllegalArgumentException("storage should not less than memory");
            }

            return new Phone(this);
        }

        public Builder setBrand(String brand) {
            if (brand == null || "".equals(brand)) {
                throw new IllegalArgumentException("brand should not be empty");
            }
            this.brand = brand;
            return this;
        }

        public Builder setMemory(int memory) {
            if (memory < 0) {
                throw new IllegalArgumentException("memory should not less than 0");
            }
            this.memory = memory;
            return this;
        }

        public Builder setStorage(int storage) {
            if (storage < 0) {
                throw new IllegalArgumentException("storage should not less than 0");
            }
            this.storage = storage;
            return this;
        }

        public Builder setColor(String color) {
            if (color == null || "".equals(color)) {
                throw new IllegalArgumentException("color should not be empty");
            }
            this.color = color;
            return this;
        }

        public Builder setSize(int size) {
            if (size < 0) {
                throw new IllegalArgumentException("size should not less than 0");
            }
            this.size = size;
            return this;
        }
    }
}
