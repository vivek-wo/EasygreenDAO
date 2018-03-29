package vivek.wo.easygreendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by VIVEK-WO on 2018/3/29.
 */
@Entity
public class User {
    @Id
    private String id;
    private int identityType;//证件类型
    private String name;//姓名
    private int gender;//性别
    private String nation;//民族
    private String birthDay;//出生日期
    private String houseAdress;//居住地址
    private String citizenshipNumber;//公民身份号码

    @Generated(hash = 221408061)
    public User(String id, int identityType, String name, int gender, String nation,
                String birthDay, String houseAdress, String citizenshipNumber) {
        this.id = id;
        this.identityType = identityType;
        this.name = name;
        this.gender = gender;
        this.nation = nation;
        this.birthDay = birthDay;
        this.houseAdress = houseAdress;
        this.citizenshipNumber = citizenshipNumber;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdentityType() {
        return this.identityType;
    }

    public void setIdentityType(int identityType) {
        this.identityType = identityType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNation() {
        return this.nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getHouseAdress() {
        return this.houseAdress;
    }

    public void setHouseAdress(String houseAdress) {
        this.houseAdress = houseAdress;
    }

    public String getCitizenshipNumber() {
        return this.citizenshipNumber;
    }

    public void setCitizenshipNumber(String citizenshipNumber) {
        this.citizenshipNumber = citizenshipNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", identityType=" + identityType +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", nation='" + nation + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", houseAdress='" + houseAdress + '\'' +
                ", citizenshipNumber='" + citizenshipNumber + '\'' +
                '}';
    }
}
