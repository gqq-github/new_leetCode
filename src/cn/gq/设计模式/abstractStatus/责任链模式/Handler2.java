package cn.gq.设计模式.abstractStatus.责任链模式;

/**
 * @author cherry_xx
 * @create 2021/6/27 15:29
 * @update 2021/6/27
 * Description:
 * @since 1.0.0
 */
public class Handler2 extends Handler {

    @Override
    protected boolean isSupport(HandlerTask t) {
        return "sel".equals(t.getTaskType());
    }

    @Override
    protected void coreHandler(HandlerTask t) {
        System.out.println("处理sel任务");
        t.setSuccess(true);
    }
}
