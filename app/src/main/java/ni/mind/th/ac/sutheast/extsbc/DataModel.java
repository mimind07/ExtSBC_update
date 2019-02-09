package ni.mind.th.ac.sutheast.extsbc;

import android.os.Parcel;
import android.os.Parcelable;

public class DataModel implements Parcelable {

    private String address, age, dateBirth, divistion, gender,
            idStudent, level, name, phone, section, surname;

    public DataModel() {
    }

    public DataModel(String address, String age, String dateBirth,
                     String divistion, String gender, String idStudent,
                     String level, String name, String phone,
                     String section, String surname) {
        this.address = address;
        this.age = age;
        this.dateBirth = dateBirth;
        this.divistion = divistion;
        this.gender = gender;
        this.idStudent = idStudent;
        this.level = level;
        this.name = name;
        this.phone = phone;
        this.section = section;
        this.surname = surname;
    }

    protected DataModel(Parcel in) {
        address = in.readString();
        age = in.readString();
        dateBirth = in.readString();
        divistion = in.readString();
        gender = in.readString();
        idStudent = in.readString();
        level = in.readString();
        name = in.readString();
        phone = in.readString();
        section = in.readString();
        surname = in.readString();
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getDivistion() {
        return divistion;
    }

    public void setDivistion(String divistion) {
        this.divistion = divistion;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeString(age);
        dest.writeString(dateBirth);
        dest.writeString(divistion);
        dest.writeString(gender);
        dest.writeString(idStudent);
        dest.writeString(level);
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(section);
        dest.writeString(surname);
    }
}
