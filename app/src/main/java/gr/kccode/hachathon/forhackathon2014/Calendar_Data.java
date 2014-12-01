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
    this.setYear(year);
        this.setMonth(month);
        this.setDayOfMonth(dayOfMonth);
        this.setSth(sth);
        this.setStm(stm);
        this.setEndh(endh);
        this.setEndm(endm);
        this.setDescription(description);
        this.setLink(link);
    }

    public Calendar_Data() {


    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {

        this.month = month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {

        this.dayOfMonth = dayOfMonth;
    }

    public int getSth() {
        return sth;
    }

    public void setSth(int sth) {

        this.sth = sth;
    }

    public int getStm() {
        return stm;
    }

    public void setStm(int stm) {

        this.stm = stm;
    }

    public int getEndh() {
        return endh;
    }

    public void setEndh(int endh) {

        this.endh = endh;
    }

    public int getEndm() {
        return endm;
    }

    public void setEndm(int endm) {

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

    /**Return true if events exist
     *  in this day else false
     **/
    public boolean equalDay(int day, int month, int year){

        if(day == getDayOfMonth() && month == getMonth() && year == getYear()){
            return true;
        }
        else
            return false;

    }

    public void setEndTime(int i, int i1) {
        this.setEndm(i1);
        this.setEndh(i);
    }

}

