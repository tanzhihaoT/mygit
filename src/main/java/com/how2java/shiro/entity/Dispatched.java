/**
 * 文件名:派公表
 * 版权(c) 2019-雷升公司 crm项目组：
 * 版 本 号： 1.0
 */

package com.how2java.shiro.entity;

/**
 * 派公实体类
 * @author tanzhihao
 * @date 2019-11-27 12:01
 * @Version crm1.0
 */

public class Dispatched {
    /**
     * 任务编号
     */
    private int pkTaskId;
    /**
     *任务名称
     */
    private String dispatchingTaskName;
    /**
     *任务内容
     */
    private String dispatchingTaskContent;
    /**
     *状态
     */
    private String dispatchingState;
    /**
     *优先级
     */
    private String dispatchingPriority;
    /**
     *开始时间
     */
    private String dispatchingStartTime;
    /**
     *结束时间
     */
    private String dispatchingEndTime;
    /**
     *员工id
     */
    private int fkUserId;
    /**
     *投诉编号
     */
    private int fkComId;
    /**
     *修改时间
     */
    private String gtmModified;
    /**
     *修改人
     */
    private String modifier;
    /**
     *创建时间
     */
    private String gmt_create;
    /**
     *创建人
     */
    private String creator;

    /**
     * 打印数据
     * @return
     */
    @Override
    public String toString() {
        return "Dispatched{" +
                "pkTaskId=" + pkTaskId +
                ", dispatchingTaskName='" + dispatchingTaskName + '\'' +
                ", dispatchingTaskContent='" + dispatchingTaskContent + '\'' +
                ", dispatchingState='" + dispatchingState + '\'' +
                ", dispatchingPriority='" + dispatchingPriority + '\'' +
                ", dispatchingStartTime='" + dispatchingStartTime + '\'' +
                ", dispatchingEndTime='" + dispatchingEndTime + '\'' +
                ", fkUserId=" + fkUserId +
                ", fkComId=" + fkComId +
                ", gtmModified='" + gtmModified + '\'' +
                ", modifier='" + modifier + '\'' +
                ", gmt_create='" + gmt_create + '\'' +
                ", creator='" + creator + '\'' +
                '}';
    }
    /**
     * 无参构造
     */
    public Dispatched() {
    }
    /**
     * 有参构造
     * @param pkTaskId
     * @param dispatchingTaskName
     * @param dispatchingTaskContent
     * @param dispatchingState
     * @param dispatchingPriority
     * @param dispatchingStartTime
     * @param dispatchingEndTime
     * @param fkUserId
     * @param fkComId
     * @param gtmModified
     * @param modifier
     * @param gmt_create
     * @param creator
     */
    public Dispatched(int pkTaskId, String dispatchingTaskName, String dispatchingTaskContent, String dispatchingState, String dispatchingPriority, String dispatchingStartTime, String dispatchingEndTime, int fkUserId, int fkComId, String gtmModified, String modifier, String gmt_create, String creator) {
        this.pkTaskId = pkTaskId;
        this.dispatchingTaskName = dispatchingTaskName;
        this.dispatchingTaskContent = dispatchingTaskContent;
        this.dispatchingState = dispatchingState;
        this.dispatchingPriority = dispatchingPriority;
        this.dispatchingStartTime = dispatchingStartTime;
        this.dispatchingEndTime = dispatchingEndTime;
        this.fkUserId = fkUserId;
        this.fkComId = fkComId;
        this.gtmModified = gtmModified;
        this.modifier = modifier;
        this.gmt_create = gmt_create;
        this.creator = creator;
    }


    public int getPkTaskId() {
        return pkTaskId;
    }

    public void setPkTaskId(int pkTaskId) {
        this.pkTaskId = pkTaskId;
    }

    public String getDispatchingTaskName() {
        return dispatchingTaskName;
    }

    public void setDispatchingTaskName(String dispatchingTaskName) {
        this.dispatchingTaskName = dispatchingTaskName;
    }

    public String getDispatchingTaskContent() {
        return dispatchingTaskContent;
    }

    public void setDispatchingTaskContent(String dispatchingTaskContent) {
        this.dispatchingTaskContent = dispatchingTaskContent;
    }

    public String getDispatchingState() {
        return dispatchingState;
    }

    public void setDispatchingState(String dispatchingState) {
        this.dispatchingState = dispatchingState;
    }

    public String getDispatchingPriority() {
        return dispatchingPriority;
    }

    public void setDispatchingPriority(String dispatchingPriority) {
        this.dispatchingPriority = dispatchingPriority;
    }

    public String getDispatchingStartTime() {
        return dispatchingStartTime;
    }

    public void setDispatchingStartTime(String dispatchingStartTime) {
        this.dispatchingStartTime = dispatchingStartTime;
    }

    public String getDispatchingEndTime() {
        return dispatchingEndTime;
    }

    public void setDispatchingEndTime(String dispatchingEndTime) {
        this.dispatchingEndTime = dispatchingEndTime;
    }

    public int getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(int fkUserId) {
        this.fkUserId = fkUserId;
    }

    public int getFkComId() {
        return fkComId;
    }

    public void setFkComId(int fkComId) {
        this.fkComId = fkComId;
    }

    public String getGtmModified() {
        return gtmModified;
    }

    public void setGtmModified(String gtmModified) {
        this.gtmModified = gtmModified;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
