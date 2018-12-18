package cn.qc.com.mytest9activity.bee;

import java.util.List;

/**
 * Created by ASUS on 2018/12/17.
 */

public class Result {
    private List<Data> data;
    private String stat;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
