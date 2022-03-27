package cn.gq.设计模式.abstractStatus.statusimpl;

import cn.gq.设计模式.abstractStatus.ThreadStatus;

/**
 * @author cherry_xx
 * @create 2021/6/27 14:45
 * @update 2021/6/27
 * Description:
 * @since 1.0.0
 */
public
class Stop extends ThreadStatus {
    public Stop() {
        status = "死亡状态";
        System.out.println(status + "线程状态结束");
    }

}