package cn.gq.设计模式.abstractStatus.观察者模式.Demo;

/**
 * @author cherry_xx
 * @create 2021/6/28 20:41
 * @update 2021/6/28
 * Description:
 * @since 1.0.0
 */
public class RingEvent {
    private String ringType;

    public RingEvent(String ringType) {
        this.ringType = ringType;
    }

    public String getRingType() {
        return ringType;
    }

    public void setRingType(String ringType) {
        this.ringType = ringType;
    }
}
