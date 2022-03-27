package cn.gq.设计模式.abstractStatus.观察者模式.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cherry_xx
 * @create 2021/6/28 20:44
 * @update 2021/6/28
 * Description:
 * @since 1.0.0
 */
public abstract class RingSubject {
    protected List<EventListener> eventListeners = new ArrayList<>();
    protected RingEvent ringEvent;

    public RingSubject(RingEvent ringEvent) {
        this.ringEvent = ringEvent;
    }
    public void addEvertListener(EventListener... eventListener){
        eventListeners.addAll(Arrays.asList(eventListener));
    }

    protected abstract void notifyListener();
}
