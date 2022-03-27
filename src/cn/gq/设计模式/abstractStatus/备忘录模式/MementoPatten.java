package cn.gq.设计模式.abstractStatus.备忘录模式;

/**
 * @author cherry_xx
 * @create 2021/7/3 14:16
 * @update 2021/7/3
 * Description:
 * @since 1.0.0
 */
public class MementoPatten {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("1");
        Memento memento = originator.createMemento();
        careTaker.setMemento(memento);
        System.out.println("当前状态"+originator.getState());
        originator.setState("2");
        careTaker.setMemento(originator.createMemento());
        System.out.println("当前状态"+originator.getState());
        originator.setState("3");
        careTaker.setMemento(originator.createMemento());
        System.out.println("当前状态"+originator.getState());
        originator.restoreMemento( careTaker.getMemento());
        originator.restoreMemento( careTaker.getMemento());
        System.out.println("当前状态"+originator.getState());
        System.out.println("当前备忘的状态"+careTaker.memento.getState());
    }
}
