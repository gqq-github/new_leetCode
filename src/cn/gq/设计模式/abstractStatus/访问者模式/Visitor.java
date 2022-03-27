package cn.gq.设计模式.abstractStatus.访问者模式;

/**
 * @author cherry_xx
 * @create 2021/7/3 12:47
 * @update 2021/7/3
 * Description: 定义访问者接口
 * 弊端增加一个访问元素的时候这个接口就需要新增访问元素具体元素的一个接口
 * @since 1.0.0
 */
public interface Visitor {
    void visit(ConCreateElementA conCreateElementA);

    void visit(ConCreateElementB conCreateElementB);
}

class ConCreateVisitorA implements Visitor{

    @Override
    public void visit(ConCreateElementA conCreateElementA) {
        System.out.println("访问者A访问A元素"+conCreateElementA.option());
    }

    @Override
    public void visit(ConCreateElementB conCreateElementB) {
        System.out.println("访问者A访问B元素"+ conCreateElementB.option());
    }
}

class ConCreateVisitorB implements Visitor{

    @Override
    public void visit(ConCreateElementA conCreateElementA) {
        System.out.println("访问者B访问A元素"+conCreateElementA.option());
    }

    @Override
    public void visit(ConCreateElementB conCreateElementB) {
        System.out.println("访问者B访问B元素"+ conCreateElementB.option());
    }
}