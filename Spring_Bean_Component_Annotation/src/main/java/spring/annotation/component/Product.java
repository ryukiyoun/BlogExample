package spring.annotation.component;

import org.springframework.stereotype.Component;

@Component(value = "prod")
public class Product {
    protected String name;
    protected int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
