package com.example.rafael.finalproject;

public final class SQLSentences {
    public static final String DATABASE_NAME = "Countries";

    public static final String TABLE_USER = "User";
    public static final String TABLE_USER_ID = "id";
    public static final String TABLE_USER_NICKNAME = "nickname";
    public static final String TABLE_USER_PASSWORD = "password";

    public static final String TABLE_COUNTRY = "Country";
    public static final String TABLE_COUNTRY_ID = "id";
    public static final String TABLE_COUNTRY_NAME = "name";

    public static final String TABLE_COUNTRY_USER_REL = "Country_User_Rel";
    public static final String TABLE_COUNTRY_USER_REL_ID = "id";
    public static final String TABLE_COUNTRY_USER_REL_USER_ID = "user_id";
    public static final String TABLE_COUNTRY_USER_REL_COUNTRY_ID = "country_id";
    public static final String TABLE_COUNTRY_USER_REL_VISIT = "visit";
    public static final String TABLE_COUNTRY_USER_REL_VISITED = "visited";

    //Creating tables
    public static final String CREATE_TABLE_USER = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT UNIQUE NOT NULL, " +
                    "%s TEXT NOT NULL)",
            TABLE_USER,
            TABLE_USER_ID,
            TABLE_USER_NICKNAME,
            TABLE_USER_PASSWORD
    );

    public static final String CREATE_TABLE_COUNTRY = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL)",
            TABLE_COUNTRY,
            TABLE_COUNTRY_ID,
            TABLE_COUNTRY_NAME
    );

    public static final String CREATE_TABLE_RELATION = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL, " +
                    "%s INTEGER NOT NULL)",

            TABLE_COUNTRY_USER_REL,
            TABLE_COUNTRY_USER_REL_ID,
            TABLE_COUNTRY_USER_REL_USER_ID,
            TABLE_USER,
            TABLE_USER_ID,
            TABLE_COUNTRY_USER_REL_COUNTRY_ID,
            TABLE_COUNTRY,
            TABLE_COUNTRY_ID,
            TABLE_COUNTRY_USER_REL_VISIT,
            TABLE_COUNTRY_USER_REL_VISITED
    );

    //Filling Tables
    public static final String FILL_USER_TABLE = String.format(
            "INSERT INTO %s (nickname, password) VALUES ('%s', '%s')",
            TABLE_USER,
            "admin",
            "admin"
    );

    public static final String FILL_COUNTRY_TABLE =
            "INSERT INTO Country (name) VALUES ('Afghanistan'), ('Albania'), ('Algeria'), ('Andorra'), " +
                    "('Angola'), ('Antigua and Barbuda'), ('Argentina'), ('Armenia'), ('Australia'), " +
                    "('Austria'), ('Azerbaijan'), ('The Bahamas'), ('Bahrain'), ('Bangladesh'), " +
                    "('Barbados'), ('Belarus'), ('Belgium'), ('Belize'), ('Benin'), ('Bhutan'), ('Bolivia'), " +
                    "('Bosnia and Herzegovina'), ('Botswana'), ('Brazil'), ('Brunei'), ('Bulgaria'), " +
                    "('Burkina Faso'), ('Burundi'), ('Cabo Verde'), ('Cambodia'), ('Cameroon'), ('Canada'), " +
                    "('Central African Republic'), ('Chad'), ('Chile'), ('China'), ('Colombia'), " +
                    "('Comoros'), ('Congo, Democratic Republic of the'), ('Congo, Republic of the'), " +
                    "('Costa Rica'), ('Côte d’Ivoire'), ('Croatia'), ('Cuba'), ('Cyprus'), " +
                    "('Czech Republic'), ('Denmark'), ('Djibouti'), ('Dominica'), ('Dominican Republic'), " +
                    "('East Timor (Timor-Leste)'), ('Ecuador'), ('Egypt'), ('El Salvador'), " +
                    "('Equatorial Guinea'), ('Eritrea'), ('Estonia'), ('Ethiopia'), ('Fiji'), ('Finland'), " +
                    "('France'), ('Gabon'), ('The Gambia'), ('Georgia'), ('Germany'), ('Ghana'), ('Greece'), " +
                    "('Grenada'), ('Guatemala'), ('Guinea'), ('Guinea-Bissau'), ('Guyana'), ('Haiti'), " +
                    "('Honduras'), ('Hungary'), ('Iceland'), ('India'), ('Indonesia'), ('Iran'), ('Iraq'), " +
                    "('Ireland'), ('Israel'), ('Italy'), ('Jamaica'), ('Japan'), ('Jordan'), ('Kazakhstan'), " +
                    "('Kenya'), ('Kiribati'), ('Korea, North'), ('Korea, South'), ('Kosovo'), ('Kuwait'), " +
                    "('Kyrgyzstan'), ('Laos'), ('Latvia'), ('Lebanon'), ('Lesotho'), ('Liberia'), ('Libya'), " +
                    "('Liechtenstein'), ('Lithuania'), ('Luxembourg'), ('Macedonia'), ('Madagascar'), " +
                    "('Malawi'), ('Malaysia'), ('Maldives'), ('Mali'), ('Malta'), ('Marshall Islands'), " +
                    "('Mauritania'), ('Mauritius'), ('Mexico'), ('Micronesia, Federated States of'), " +
                    "('Moldova'), ('Monaco'), ('Mongolia'), ('Montenegro'), ('Morocco'), ('Mozambique'), " +
                    "('Myanmar (Burma)'), ('Namibia'), ('Nauru'), ('Nepal'), ('Netherlands'), " +
                    "('New Zealand'), ('Nicaragua'), ('Niger'), ('Nigeria'), ('Norway'), ('Oman'), " +
                    "('Pakistan'), ('Palau'), ('Panama'), ('Papua New Guinea'), ('Paraguay'), ('Peru'), " +
                    "('Philippines'), ('Poland'), ('Portugal'), ('Qatar'), ('Romania'), ('Russia'), " +
                    "('Rwanda'), ('Saint Kitts and Nevis'), ('Saint Lucia'), " +
                    "('Saint Vincent and the Grenadines'), ('Samoa'), ('San Marino'), " +
                    "('Sao Tome and Principe'), ('Saudi Arabia'), ('Senegal'), ('Serbia'), ('Seychelles'), " +
                    "('Sierra Leone'), ('Singapore'), ('Slovakia'), ('Slovenia'), ('Solomon Islands'), " +
                    "('Somalia'), ('South Africa'), ('Spain'), ('Sri Lanka'), ('Sudan'), ('Sudan, South'), " +
                    "('Suriname'), ('Swaziland'), ('Sweden'), ('Switzerland'), ('Syria'), ('Taiwan'), " +
                    "('Tajikistan'), ('Tanzania'), ('Thailand'), ('Togo'), ('Tonga'), " +
                    "('Trinidad and Tobago'), ('Tunisia'), ('Turkey'), ('Turkmenistan'), " +
                    "('Tuvalu'), ('Uganda'), ('Ukraine'), ('United Arab Emirates'), ('United Kingdom'), " +
                    "('United States'), ('Uruguay'), ('Uzbekistan'), ('Vanuatu'), ('Vatican City'), " +
                    "('Venezuela'), ('Vietnam'), ('Yemen'), ('Zambia'), ('Zimbabwe')";
}
