package cn.gq.设计模式.abstractStatus.观察者模式.Demo;

/**
 * @author cherry_xx
 * @create 2021/6/28 20:51
 * @update 2021/6/28
 * Description:
 * @since 1.0.0
 */
public class RingSubjectImpl extends RingSubject {
    public RingSubjectImpl(RingEvent ringEvent) {
        super(ringEvent);
    }
    @Override
    protected void notifyListener() {
        eventListeners.forEach(eventListener -> {
            eventListener.doHandler(ringEvent);
        });
    }
}
