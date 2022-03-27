package cn.gq.设计模式.abstractStatus.观察者模式;

/**
 * @author cherry_xx
 * @create 2021/6/28 20:19
 * @update 2021/6/28
 * Description: 通知观察者
 * @since 1.0.0
 */
public class SubjectNotify extends Subject {
    @Override
    protected void notifyObserver() {
        observers.forEach(Observer::observerResponse);
    }
}
