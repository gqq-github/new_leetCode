package cn.gq.设计模式.abstractStatus.访问者模式;

/**
 * @author cherry_xx
 * @create 2021/7/3 13:09
 * @update 2021/7/3
 * Description:
 * @since 1.0.0
 */
public class VisitorPatten {
    public static void main(String[] args) {
        ConCreateElementA conCreateElementA = new ConCreateElementA();
        ConCreateElementB conCreateElementB = new ConCreateElementB();
        ObjectStructure objectStructure = new ObjectStructure(conCreateElementA, conCreateElementB);
        ConCreateVisitorA conCreateVisitorA = new ConCreateVisitorA();
        ConCreateVisitorB conCreateVisitorB = new ConCreateVisitorB();
        objectStructure.accept(conCreateVisitorA);
        objectStructure.accept(conCreateVisitorB);
    }
}
