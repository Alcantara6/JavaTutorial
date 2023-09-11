package com.yanjing.oo;

/**
 * @author yanjing
 * @date 2023/6/4
 */
// enum隐含地继承了java.lang.Enum
public enum HfjEnum {

    JERRY("lead guitar") {
        public String sings() {
            return "plaintively";
        }
    }, // 特定常量的内容，把他们当做基本enum方法的覆盖

    BOBBY("BASS");

    private String instrument;

    HfjEnum(String instrument) {
        this.instrument = instrument;
    }

    public String getInstrument() {
        return instrument;
    }

    public String sings() {
        return "occasionally";
    }

    public static HfjEnum of(String value) {
        return Enum.valueOf(HfjEnum.class, value);
    }
}
