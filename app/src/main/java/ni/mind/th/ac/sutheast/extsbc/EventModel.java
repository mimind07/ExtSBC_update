package ni.mind.th.ac.sutheast.extsbc;

import android.os.Parcel;
import android.os.Parcelable;

public class EventModel implements Parcelable {

    private String Check, Detail, EndDate, Member, Place, RunTime, StartDate, name;

    public EventModel() {
    }

    public EventModel(String check, String detail, String endDate,
                      String member, String place, String runTime,
                      String startDate, String name) {
        Check = check;
        Detail = detail;
        EndDate = endDate;
        Member = member;
        Place = place;
        RunTime = runTime;
        StartDate = startDate;
        this.name = name;
    }

    protected EventModel(Parcel in) {
        Check = in.readString();
        Detail = in.readString();
        EndDate = in.readString();
        Member = in.readString();
        Place = in.readString();
        RunTime = in.readString();
        StartDate = in.readString();
        name = in.readString();
    }

    public static final Creator<EventModel> CREATOR = new Creator<EventModel>() {
        @Override
        public EventModel createFromParcel(Parcel in) {
            return new EventModel(in);
        }

        @Override
        public EventModel[] newArray(int size) {
            return new EventModel[size];
        }
    };

    public String getCheck() {
        return Check;
    }

    public void setCheck(String check) {
        Check = check;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getMember() {
        return Member;
    }

    public void setMember(String member) {
        Member = member;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getRunTime() {
        return RunTime;
    }

    public void setRunTime(String runTime) {
        RunTime = runTime;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Check);
        dest.writeString(Detail);
        dest.writeString(EndDate);
        dest.writeString(Member);
        dest.writeString(Place);
        dest.writeString(RunTime);
        dest.writeString(StartDate);
        dest.writeString(name);
    }
}
