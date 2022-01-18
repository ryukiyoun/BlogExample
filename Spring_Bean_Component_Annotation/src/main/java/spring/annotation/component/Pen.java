package spring.annotation.component;

import org.springframework.stereotype.Component;

@Component(value = "prodP")
public class Pen extends Product{
    public int length;

    public Pen(){
        super.name = "pen";
        super.count = 12;
        this.length = 20;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
