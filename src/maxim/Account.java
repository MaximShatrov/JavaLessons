package maxim;

import java.text.SimpleDateFormat;
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
        StringBuilder empty = new StringBuilder("EMPTY");
        this.setLogin(empty);
        this.avatar = empty;
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
        boolean selection = false;
        this.avatar.delete(0,this.avatar.length());
        while (!selection) {
            int lvlSet = Console.scanInputMenuSelect();
            switch (lvlSet) {
                case 1:
                    this.avatar.append(plane);
                    selection = true;
                    break;
                case 2:
                    this.avatar.append(bat);
                    selection = true;
                    break;
                case 3:
                    this.avatar.append(bart);
                    selection = true;
                    break;
                case 4:
                    this.avatar.append(shrek);
                    selection = true;
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

    public boolean equals(StringBuilder id) {
        return this.login == id;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return "Аккаунт " + login + "\n" +
                "ФИО: " + fullName + "\n" +
                "День рождения: " + format.format(birthDate) + "\n" +
                "Город: " + city + "\n" +
                "Серия и номер пасспорта: " + passportSerial + "\n" +
                "Кем и когда выдан: " + passportInfo + "\n" +
                "Моб.телефон: " + mobileNumber + "\n" +
                "Сайт: " + site + "\n" +
                "Работа: " + workInfo + "\n" +
                "О себе: " + info + "\n" +
                "Аватар: "+ "\n"  + avatar;
    }
}
