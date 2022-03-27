package cn.gq.设计模式.abstractStatus;

import cn.gq.设计模式.abstractStatus.statusimpl.Blocker;
import cn.gq.设计模式.abstractStatus.statusimpl.NewStatus;
import cn.gq.设计模式.abstractStatus.statusimpl.Runnable;
import cn.gq.设计模式.abstractStatus.statusimpl.Running;

/**
 * @author cherry_xx
 * @create 2021/6/27 14:11
 * @update 2021/6/27
 * Description: 线程的上线文
 * @since 1.0.0
 */
public class ThreadContext {
    private ThreadStatus threadStatus;

    private ThreadContext () {
        threadStatus = new NewStatus();
    }
    public ThreadStatus getThreadStatus() {
        return threadStatus;
    }

    public void setThreadStatus(ThreadStatus threadStatus) {
        this.threadStatus = threadStatus;
    }
    public String currentStatus() {
        return getThreadStatus().getStatus();
    }

    public void  start () {
        ((NewStatus)threadStatus).start(this);
    }

    public void getCpu() {
        ((Runnable)threadStatus).getCpu(this);
    }

    public void suspend() {
        ((Running)threadStatus).suspend(this);
    }
    public void stop() {
        ((Running)threadStatus).stop(this);
    }
    public void resume(){
        ((Blocker)threadStatus).resume(this);
    }

    public static void main(String[] args) {
        ThreadContext context = new ThreadContext();
        context.start();
        context.getCpu();
        context.suspend();
        context.resume();
        context.getCpu();
        context.stop();
    }
}
