package maxim;

import java.util.Arrays;

class Account {
    private StringBuilder fullName;
    private StringBuilder login;
    private StringBuilder birthDate;
    private String city;
    private String passportSerial;
    private StringBuilder passportInfo;
    private String mobileNumber;
    private String site;
    private String workInfo;
    private String info;
    private char[][] avatar;
    private boolean existsFlag;

    Account() {
        this.existsFlag = false;
    }

    public StringBuilder getFullName() {
        return fullName;
    }

    public void setFullName(StringBuilder fullName) {
        if (fullName != null){
            this.fullName = fullName;
        }
        else{

        }
    }

    public StringBuilder getLogin() {
        return login;
    }

    public void setLogin(StringBuilder login) {
        this.login = login;
    }

    public StringBuilder getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(StringBuilder birthDate) {
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

    public StringBuilder getPassportInfo() {
        return passportInfo;
    }

    public void setPassportInfo(StringBuilder passportInfo) {
        this.passportInfo = passportInfo;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
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
                ", login: '" + login + '\'' +
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
