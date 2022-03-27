package cn.gq.设计模式.abstractStatus.观察者模式.Demo;

/**
 * @author cherry_xx
 * @create 2021/6/28 20:52
 * @update 2021/6/28
 * Description:
 * @since 1.0.0
 */
public class StudentListener implements EventListener {
    @Override
    public void doHandler(RingEvent event) {
        if("1".equals(event.getRingType())) {
            System.out.println("学生听到下课铃做出的反应");
        }else {
            System.out.println("学生听到上课铃做出的反应");
        }
    }
}
