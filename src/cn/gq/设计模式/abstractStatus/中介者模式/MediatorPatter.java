package cn.gq.设计模式.abstractStatus.中介者模式;

/**
 * @author cherry_xx
 * @create 2021/6/28 22:04
 * @update 2021/6/28
 * Description:
 * @since 1.0.0
 */
public class MediatorPatter {
    public static void main(String[] args) {
        ConcreteMediator concreteMediator = new ConcreteMediator();
        Colleague colleague1 = new Colleague1();
        Colleague colleague2 = new Colleague2();
        concreteMediator.register(colleague1);
        concreteMediator.register(colleague2);
        colleague1.send();
        colleague2.send();
    }
}
