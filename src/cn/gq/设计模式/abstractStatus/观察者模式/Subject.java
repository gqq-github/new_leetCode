package cn.gq.设计模式.abstractStatus.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cherry_xx
 * @create 2021/6/28 19:59
 * @update 2021/6/28
 * Description: 抽象类 表示一个抽象主题
 * @since 1.0.0
 */
public abstract  class Subject {
    // 实现观察者的保存
    protected List<Observer> observers = new ArrayList<>();

    public void  add (Observer observer) {
        observers.add(observer);
    }
    protected abstract void notifyObserver();
}
