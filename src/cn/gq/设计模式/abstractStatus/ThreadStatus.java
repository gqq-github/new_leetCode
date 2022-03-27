package cn.gq.设计模式.abstractStatus;

/**
 * @author cherry_xx
 * @create 2021/6/27 14:04
 * @update 2021/6/27
 * Description: 使用状态模式实现多线程的状态转化
 * @since 1.0.0
 */
public abstract class ThreadStatus {
    /**
     * 表示 描述线程的状态
    */
    protected String status;
    public ThreadStatus () {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    protected boolean isSupport (ThreadContext context) {
        return status.equals(context.currentStatus());
    }
}
