package cn.gq.设计模式.abstractStatus.中介者模式;

/**
 * @author cherry_xx
 * @create 2021/6/28 21:46
 * @update 2021/6/28
 * Description:
 * @since 1.0.0
 */
public abstract class Colleague {
    // 中介对象
    protected Mediator mediator;


    protected abstract void receive();

    protected abstract void send();

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

}
class Colleague1 extends Colleague{

    @Override
    protected void receive() {
        System.out.println("同事一收到处理");
    }

    @Override
    protected void send() {
        receive();
        mediator.relay(this);
    }
}

class Colleague2 extends Colleague{

    @Override
    protected void receive() {
        System.out.println("同事二收到处理");
    }

    @Override
    protected void send() {
         receive();
         mediator.relay(this);
    }
}