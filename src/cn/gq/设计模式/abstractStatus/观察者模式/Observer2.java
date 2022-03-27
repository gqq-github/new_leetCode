package cn.gq.设计模式.abstractStatus.观察者模式;

/**
 * @author cherry_xx
 * @create 2021/6/28 20:17
 * @update 2021/6/28
 * Description: 观察者2
 * @since 1.0.0
 */
public class Observer2  implements Observer{
    @Override
    public void observerResponse() {
        System.out.println("观察者2做出反应");
    }
}
