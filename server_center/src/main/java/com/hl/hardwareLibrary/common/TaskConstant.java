package com.hl.hardwareLibrary.common;

public interface TaskConstant {

    /**
     * 任务状态
     */
    public enum taskStatusInfoEnum {
        IN_PROGRESS(1, "任务下发进行中"),
        CHECK(2, "待审核"),
        NO_PASS(3, "不通过"),
        DRAFT(4, "草稿"),
        DELETE(5, "删除"),
        OFFICE_TO_CHECK(6,"待办公室审核"),
        PASS(7, "通过待下发"),
        DELAY(8, "已延期"),
        OVERDUE(9, "已逾期"),
        FINISH(10, "已完成"),
        FILE(11, "已归档"),
        NO_PASS_ONE(20, "办公室审核不通过"),

        //21-办结中 22-领导办结中 23-公示 24-归档
        COMPLETE(21, "办结中"),
        LEADER_COMPLETE(22, "领导办结中"),
        PUBLIC(23, "公示"),
        ALLOCATE(24, "待分配"),
        POSTPONEING(25, "延期申请中"),
        NO_POSTPONE(26, "延期申请不通过"),
        NO_FILE(27, "办结不通过(办公室)"),
        TO_BREAK_DOWN(28, "待分解"),
        BREAK_DOWN_TO_CHECK(29, "分解待审核"),
        BREAK_DOWN_FAIL(30, "分解待审核不通过");



        int code;
        String name;

        taskStatusInfoEnum(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }
    }


    /**
     * 操作行为
     */
    public enum operationEnum {
        CREATE(1, "创建"),
        APPLY(2, "申请"),
        CHECK(3, "审核"),
        UPDATE(4, "修改"),
        DELAY(5, "延期"),
        END(6, "结束"),
        OFFICE_TO_CHECK(7, "待办公室审核"),
        ISSUE(8, "下发"),
        DELETE(9, "删除"),
        FILE(10, "归档");

        int code;
        String name;

        operationEnum(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }
    }


    /**
     * 审批结果
     */
    public enum approvalResultEnum {
        TO_APPROVAL(2, "待审批"),
        PASS(1, "通过"),
        PUBLIC(3, "公式"),
        NO_PASS(0, "不通过");

        int code;
        String name;

        approvalResultEnum(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }
    }


    /**
     * 任务来源、任务类型 code 枚举
     */
    public enum taskSourceTypeCodeEnum {
        SOURCE("PA001", "来源"),
        TYPE("PA002", "类型"),
        FL("PA003", "分类");

        String code;
        String name;

        taskSourceTypeCodeEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }
    }


    /**
     * 任务类型
     */
    public enum taskTypeEnum {
        TASK(1, "任务"),
        PLAN(2, "计划");

        int code;
        String name;

        taskTypeEnum(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }
    }


    /**
     * 任务部门类型
     */
    public enum taskDeptTypeEnum {
        LEADER_DEPT(1, "牵头部门"),
        COOPERATE_DEPT(2, "配合部门");

        int code;
        String name;

        taskDeptTypeEnum(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }
    }


    /**
     * 用户关注监督类型
     */
    public enum taskUserFlgEnum {
        FOLLOW(1, "关注"),
        SUPERVISE(2, "监督");

        int code;
        String name;

        taskUserFlgEnum(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }
    }


    /**
     * 反馈类型
     */
    public enum taskFeedbackTypeEnum {
        LEADER_DEPT(1, "牵头部门"),
        COOPERATE_DEPT(2, "配合部门"),
        OTHER(3, "其他"),
        EXECUTOR(4, "执行人"),
        COOPERATOR(5, "配合人");

        int code;
        String name;

        taskFeedbackTypeEnum(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }
    }

    /**
     * 任务类型
     */
    public enum taskStyleEnum {
        STRESS_TASK(1, "重点任务"),
        WORK_TASK(2, "工作任务");

        int code;
        String name;

        taskStyleEnum(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }
    }

}
