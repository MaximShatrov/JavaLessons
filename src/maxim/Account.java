package maxim;

import java.util.Arrays;

class Account {
    private String fullName;
    private String eMail;
    private String birthDate;
    private String city;
    private String passportSerial;
    private String passportInfo;
    private int mobileNumber;
    private String site;
    private String workInfo;
    private String info;
    private char[][] avatar;
    private boolean existsFlag;

    Account() {
        this.existsFlag = false;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public String getPassportInfo() {
        return passportInfo;
    }

    public void setPassportInfo(String passportInfo) {
        this.passportInfo = passportInfo;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(String workInfo) {
        this.workInfo = workInfo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public char[][] getAvatar() {
        return avatar;
    }

    public void setAvatar(char[][] avatar) {
        this.avatar = avatar;
    }

    public boolean isExistsFlag() {
        return existsFlag;
    }

    public void setExistsFlag(boolean existsFlag) {
        this.existsFlag = existsFlag;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ФИО: '" + fullName + '\'' +
                ", eMail: '" + eMail + '\'' +
                ", ДР: '" + birthDate + '\'' +
                ", Город: '" + city + '\'' +
                ", Серя,номер пасспорта:'" + passportSerial + '\'' +
                ", Кем выдан: '" + passportInfo + '\'' +
                ", Моб.телефон: " + mobileNumber +
                ", Сайт: '" + site + '\'' +
                ", Работа: '" + workInfo + '\'' +
                ", О себе: '" + info + '\'' +
                ", Аватар: " + Arrays.toString(avatar) +
                ", existsFlag=" + existsFlag +
                '}';
    }
}
