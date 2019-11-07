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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPzhs() {
        return pzhs;
    }

    public void setPzhs(String pzhs) {
        this.pzhs = pzhs;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getJf() {
        return jf;
    }

    public void setJf(String jf) {
        this.jf = jf;
    }

    public String getDf() {
        return df;
    }

    public void setDf(String df) {
        this.df = df;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getYe() {
        return ye;
    }

    public void setYe(String ye) {
        this.ye = ye;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SheetField that = (SheetField) o;
        return Objects.equals(pzhs, that.pzhs) &&
                Objects.equals(zy, that.zy) && (
                Objects.equals(jf, that.jf) ||
                Objects.equals(df, that.df));
    }

    @Override
    public int hashCode() {

        return Objects.hash(pzhs, zy, jf, df);
    }

    /*@Override
    public String toString() {
        return "SheetField{" +
                "pzhs='" + pzhs + '\'' +
                ", zy='" + zy + '\'' +
                ", jf='" + jf + '\'' +
                ", df='" + df + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return "SheetField{" +
                "month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", pzhs='" + pzhs + '\'' +
                ", zy='" + zy + '\'' +
                ", jf='" + jf + '\'' +
                ", df='" + df + '\'' +
                ", fx='" + fx + '\'' +
                ", ye='" + ye + '\'' +
                '}';
    }
}
