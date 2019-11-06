package com.excel.com.excel.entity;

import java.util.Objects;

public class SheetField {

    private String month;
    private String day;
    private String pzhs;//凭证号数
    private String zy;//摘要
    private String jf;//借方
    private String df;//贷方
    private String fx;//方向
    private String ye;//余额

    public SheetField(String month, String day, String pzhs, String zy, String jf, String df, String fx, String ye) {
        this.month = month;
        this.day = day;
        this.pzhs = pzhs;
        this.zy = zy;
        this.jf = jf;
        this.df = df;
        this.fx = fx;
        this.ye = ye;
    }

    public SheetField(String pzhs, String zy, String jf, String df) {
        this.pzhs = pzhs;
        this.zy = zy;
        this.jf = jf;
        this.df = df;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SheetField that = (SheetField) o;
        return Objects.equals(pzhs, that.pzhs) &&
                Objects.equals(zy, that.zy) &&
                Objects.equals(jf, that.jf) &&
                Objects.equals(df, that.df);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pzhs, zy, jf, df);
    }
}
