package cn.gq.设计模式.abstractStatus.观察者模式.Demo;

/**
 * @author cherry_xx
 * @create 2021/6/28 20:55
 * @update 2021/6/28
 * Description:
 * @since 1.0.0
 */
public class DemoMain {
    public static void main(String[] args) {
        // 下课铃
        RingEvent ringEvent = new RingEvent("1");

        EventListener[] eventListeners = {new StudentListener(),new TeacherListener()};

        RingSubjectImpl ringSubject = new RingSubjectImpl(ringEvent);

        ringSubject.addEvertListener(eventListeners);

        ringSubject.notifyListener();

        ringEvent.setRingType("2");

        ringSubject.notifyListener();

    }

}
