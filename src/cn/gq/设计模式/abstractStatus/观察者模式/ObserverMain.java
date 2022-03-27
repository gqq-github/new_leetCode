package cn.gq.设计模式.abstractStatus.观察者模式;

/**
 * @author cherry_xx
 * @create 2021/6/28 20:22
 * @update 2021/6/28
 * Description:
 * @since 1.0.0
 */
public class ObserverMain {
    public static void main(String[] args) {
        SubjectNotify subjectNotify = new SubjectNotify();
        Observer observer1 = new Observer1();
        Observer observer2 = new Observer2();
        subjectNotify.add(observer1);
        subjectNotify.add(observer2);
        subjectNotify.notifyObserver();
    }
}
