package cn.gq.设计模式.abstractStatus.访问者模式;

/**
 * @author cherry_xx
 * @create 2021/7/3 12:48
 * @update 2021/7/3
 * Description: 定义访问元素接口
 * @since 1.0.0
 */
public interface Element {
    void accept(Visitor visitor);
}

class ConCreateElementA implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public String option() {
        return "具体元素A的操作";
    }
}

class ConCreateElementB implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public String option() {
        return "具体元素B的操作";
    }
}