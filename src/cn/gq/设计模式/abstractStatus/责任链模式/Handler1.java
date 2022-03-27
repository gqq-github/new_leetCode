package cn.gq.设计模式.abstractStatus.责任链模式;

/**
 * @author cherry_xx
 * @create 2021/6/27 15:26
 * @update 2021/6/27
 * Description: 处理del型任务
 * @since 1.0.0
 */
public class Handler1 extends Handler {

    @Override
    protected boolean isSupport(HandlerTask t) {

        return "del".equals(t.getTaskType());
    }

    @Override
    protected void coreHandler(HandlerTask t) {
        System.out.println("执行任务del的业务逻辑");
        t.setSuccess(true);
    }
}
