package cn.gq.设计模式.abstractStatus.责任链模式;

/**
 * @author cherry_xx
 * @create 2021/6/27 15:24
 * @update 2021/6/27
 * Description:
 * @since 1.0.0
 */
public class HandlerMain {
    public static void main(String[] args) {
        HandlerTask<String> stringHandlerTask = new HandlerTask<>("sel","haha",false);
        Handler handler1 = new Handler1();
        Handler handler2 = new Handler2();
        handler1.setNext(handler2);
        handler1.doHandler(stringHandlerTask);
    }
}
