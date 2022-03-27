package cn.gq.设计模式.abstractStatus.观察者模式.Demo;

/**
 * @author cherry_xx
 * @create 2021/6/28 20:54
 * @update 2021/6/28
 * Description:
 * @since 1.0.0
 */
public class TeacherListener implements EventListener {
    @Override
    public void doHandler(RingEvent event) {
        if ("1".equals(event.getRingType())) {
            System.out.println("教师对上课铃做出的反应");
        }else {
            System.out.println("教师对下课铃做出的反应");
        }
    }
}
