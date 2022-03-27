package cn.gq.设计模式.abstractStatus.责任链模式;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author cherry_xx
 * @create 2021/6/27 15:16
 * @update 2021/6/27
 * Description:
 * @since 1.0.0
 */
public class HandlerTask<T> {
    private String taskType;
    private T t;
    private Boolean success;

    public HandlerTask(T t) {
        this.t = t;
    }

    public HandlerTask(String taskType, T t, Boolean success) {
        this.taskType = taskType;
        this.t = t;
        this.success = success;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
