package maxim;

import java.util.Arrays;
import java.util.Date;

class Account {

    final String plane = new String("            __/\\__\n" +
            "           `==/\\==`\n" +
            " ____________/__\\____________\n" +
            "/____________________________\\\n" +
            "  __||__||__/.--.\\__||__||__\n" +
            " /__|___|___( >< )___|___|__\\\n" +
            "           _/`--`\\_\n" +
            "          (/------\\)");
    final String bat = new String("              *         *      *         *\n" +
            "          ***          **********          ***\n" +
            "       *****           **********           *****\n" +
            "     *******           **********           *******\n" +
            "   **********         ************         **********\n" +
            "  ****************************************************\n" +
            " ******************************************************\n" +
            "********************************************************\n" +
            "********************************************************\n" +
            "********************************************************\n" +
            " ******************************************************\n" +
            "  ********      ************************      ********\n" +
            "   *******       *     *********      *       *******\n" +
            "     ******             *******              ******\n" +
            "       *****             *****              *****\n" +
            "          ***             ***              ***\n" +
            "            **             *              **");
    final String bart = new String("         ,\\ ,'\\,'\\ ,'\\ ,\\ ,\n" +
            "    ;\\/ \\' `'     `   '  /|\n" +
            "   |\\/                      |\n" +
            "   :                        |\n" +
            "   :                        |\n" +
            "    |                       |\n" +
            "    |                       |\n" +
            "    :               -.     _|\n" +
            "     :                \\     `.\n" +
            "     |         ________:______\\\n" +
            "     :       ,'o       / o    ;\n" +
            "     :       \\       ,'-----./\n" +
            "      \\_      `--.--'        )\n" +
            "     ,` `.              ,---'|\n" +
            "     : `                     |\n" +
            "      `,-'                   |\n" +
            "      /      ,---.          ,'\n" +
            "   ,-'            `-,------'\n" +
            "  '   `.        ,--'\n" +
            "        `-.____/\n" +
            "               \\");
    final String shrek = new String("⢀⡴⠑⡄⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠸⡇⠀⠿⡀⠀⠀⠀⣀⡴⢿⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠑⢄⣠⠾⠁⣀⣄⡈⠙⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⢀⡀⠁⠀⠀⠈⠙⠛⠂⠈⣿⣿⣿⣿⣿⠿⡿⢿⣆⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⢀⡾⣁⣀⠀⠴⠂⠙⣗⡀⠀⢻⣿⣿⠭⢤⣴⣦⣤⣹⠀⠀⠀⢀⢴⣶⣆ \n" +
            "⠀⠀⢀⣾⣿⣿⣿⣷⣮⣽⣾⣿⣥⣴⣿⣿⡿⢂⠔⢚⡿⢿⣿⣦⣴⣾⠁⠸⣼⡿ \n" +
            "⠀⢀⡞⠁⠙⠻⠿⠟⠉⠀⠛⢹⣿⣿⣿⣿⣿⣌⢤⣼⣿⣾⣿⡟⠉⠀⠀⠀⠀⠀ \n" +
            "⠀⣾⣷⣶⠇⠀⠀⣤⣄⣀⡀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠉⠈⠉⠀⠀⢦⡈⢻⣿⣿⣿⣶⣶⣶⣶⣤⣽⡹⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠀⠀⠀⠉⠲⣽⡻⢿⣿⣿⣿⣿⣿⣿⣷⣜⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣷⣶⣮⣭⣽⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠀⠀⣀⣀⣈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠻⠿⠿⠿⠿⠛⠉");
    private StringBuilder fullName;
    private StringBuilder login;
    private Date birthDate;
    private StringBuilder city;
    private String passportSerial;
    private StringBuilder passportInfo;
    private StringBuilder mobileNumber;
    private String site;
    private String workInfo;
    private String info;
    private StringBuilder avatar;
    private boolean existsFlag;

    Account() {
        this.existsFlag = false;
    }

    public StringBuilder getFullName() {
        return fullName;
    }

    public void setFullName(StringBuilder fullName) {
        if (fullName != null) {
            this.fullName = fullName;
        } else {

        }
    }

    public StringBuilder getLogin() {
        return login;
    }

    public void setLogin(StringBuilder login) {
        this.login = login;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public StringBuilder getCity() {
        return city;
    }

    public void setCity(StringBuilder city) {
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

    public StringBuilder getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(StringBuilder mobileNumber) {
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

    public StringBuilder getAvatar() {
        System.out.println(this.avatar);
        return avatar;
    }

    public void setAvatar() {
        System.out.println("Выберите аватар:");
        System.out.println("1.");
        System.out.println(plane);
        System.out.println("2.");
        System.out.println(bat);
        System.out.println("3.");
        System.out.println(bart);
        System.out.println("4.");
        System.out.println(shrek);
        boolean menuExit = true;
        this.avatar.delete(0,this.avatar.length());
        while (avatar.length() < 1) {
            int lvlSet = Console.scanInputMenuSelect();
            switch (lvlSet) {
                case 1:
                    this.avatar.append(plane);
                    break;
                case 2:
                    this.avatar.append(bat);
                    break;
                case 3:
                    this.avatar.append(bart);
                    break;
                case 4:
                    this.avatar.append(shrek);
                    break;
                default:
                    System.out.println("Некорректный пункт! Повторите ввод:");
            }
        }
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
                "Логин: '" + login + '\'' +
                "День рождения: '" + birthDate + '\'' +
                "Город: '" + city + '\'' +
                "Серия и номер пасспорта:'" + passportSerial + '\'' +
                "Кем и когда выдан: '" + passportInfo + '\'' +
                "Моб.телефон: " + mobileNumber +
                "Сайт: '" + site + '\'' +
                "Работа: '" + workInfo + '\'' +
                "О себе: '" + info + '\'' +
                "Аватар: " + avatar +
                '}';
    }
}
