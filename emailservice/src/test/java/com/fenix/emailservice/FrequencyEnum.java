package com.fenix.emailservice;

public enum FrequencyEnum {
    /**
     * 年
     */
    YEAR("1","Year"),

    /**
     * 季
     */
    QUARTER("2","Quarter"),

    /**
     * 月
     */
    MONTH("3","Month");

    /**
     * 编号
     */
    private String code;

    /**
     * 状态
     */
    private String name;

    FrequencyEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static FrequencyEnum getEnumByCode(String code){
        for (FrequencyEnum category : FrequencyEnum.values()){
            if(category.getCode().equals(code)){
                return category;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
