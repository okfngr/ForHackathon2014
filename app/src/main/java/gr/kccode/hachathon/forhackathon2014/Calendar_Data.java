package gr.kccode.hachathon.forhackathon2014;


import android.text.format.Time;

/**
 * Created by Chris on 11/29/2014.
 */
public class Calendar_Data extends BasicData {
    private int year;
    private int month;
    private int dayOfMonth;
    private int sth;
    private int stm;
    private int endh;
    private int endm;
    private String description;
    private String link;

    public Calendar_Data(int year, int month, int dayOfMonth,int sth,int stm,int endh,int endm, String description, String link){

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year<2000) year=2000;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month<=0||month>12) month=1;
        this.month = month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        if(dayOfMonth<=0||dayOfMonth>31) dayOfMonth=1;
        this.dayOfMonth = dayOfMonth;
    }

    public int getSth() {
        return sth;
    }

    public void setSth(int sth) {
        if(sth<0||sth>=24) sth=0;
        this.sth = sth;
    }

    public int getStm() {
        return stm;
    }

    public void setStm(int stm) {
        if(stm<0||stm>=60) sth=0;
        this.stm = stm;
    }

    public int getEndh() {
        return endh;
    }

    public void setEndh(int endh) {
        if(endh<0||endh>=24) endm=0;
        this.endh = endh;
    }

    public int getEndm() {
        return endm;
    }

    public void setEndm(int endm) {
        if(endm<0||endm>=60) endm=0;
        this.endm = endm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setStartTime(int sth,int stm){
        this.setSth(sth);
        this.setStm(stm);
    }
}
