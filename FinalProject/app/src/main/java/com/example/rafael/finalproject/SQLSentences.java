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

    public static final String CREATE_TABLE_USER = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL, " +
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
                    "%s INTEGER NOT NULL REFERENCES %s (%s))",

            TABLE_COUNTRY_USER_REL,
            TABLE_COUNTRY_USER_REL_ID,
            TABLE_COUNTRY_USER_REL_USER_ID,
            TABLE_USER,
            TABLE_USER_ID,
            TABLE_COUNTRY_USER_REL_COUNTRY_ID,
            TABLE_COUNTRY,
            TABLE_COUNTRY_ID
    );

    //Filling Tables
    public static final String FILL_USER_TABLE = String.format(
            "INSERT INTO %s (nickname, password) VALUES ('%s', '%s')",
            TABLE_USER,
            "admin",
            "admin"
    );

    public static final String FILL_COUNTRY_TABLE =
            "INSERT INTO Country (name) VALUES ('Andorra, Principality of'), ('United Arab Emirates'), " +
                    "('Afghanistan, Islamic State of'), ('Antigua and Barbuda'), ('Anguilla'), ('Albania'), " +
                    "('Armenia'), ('Netherlands Antilles'), ('Angola'), ('Antarctica'), ('Argentina'), " +
                    "('American Samoa'), ('Austria'), ('Australia'), ('Aruba'), ('Åland Islands'), ('Azerbaijan'), " +
                    "('Bosnia-Herzegovina'), ('Barbados'), ('Bangladesh'), ('Belgium'), ('Burkina Faso'), " +
                    "('Bulgaria'), ('Bahrain'), ('Burundi'), ('Benin'), ('Saint Barthélémy'), ('Bermuda'), " +
                    "('Brunei Darussalam'), ('Bolivia'), ('Bonaire, Sint Eustatius and Saba'), ('Brazil'), " +
                    "('Bahamas'), ('Bhutan'), ('Bouvet Island'), ('Botswana'), ('Belarus'), ('Belize'), " +
                    "('Canada'), ('Cocos (Keeling) Islands'), ('Central African Republic'), ('Congo, Democratic Republic of the'), " +
                    "('Congo'), ('Switzerland'), ('Ivory Coast (Cote D''Ivoire)'), ('Cook Islands'), ('Chile'), " +
                    "('Cameroon'), ('China'), ('Colombia'), ('Costa Rica'), ('Cuba'), ('Cape Verde'), ('Curaçao'), " +
                    "('Christmas Island'), ('Cyprus'), ('Czech Republic'), ('Germany'), ('Djibouti'), ('Denmark'), " +
                    "('Dominica'), ('Dominican Republic'), ('Algeria'), ('Ecuador'), ('Estonia'), ('Egypt'), " +
                    "('Western Sahara'), ('Eritrea'), ('Spain'), ('Ethiopia'), ('Finland'), ('Fiji'), ('Falkland Islands'), " +
                    "('Micronesia'), ('Faroe Islands'), ('France'), ('Gabon'), ('Grenada'), ('Georgia'), ('French Guyana'), " +
                    "('Ghana'), ('Gibraltar'), ('Guernsey'), ('Greenland'), ('Gambia'), ('Guinea'), ('Guadeloupe (French)'), " +
                    "('Equatorial Guinea'), ('Greece'), ('South Georgia and the South Sandwich Islands'), " +
                    "('Guatemala'), ('Guam (USA)'), ('Guinea Bissau'), ('Guyana'), ('Hong Kong'), ('Heard and McDonald Islands'), " +
                    "('Honduras'), ('Croatia'), ('Haiti'), ('Hungary'), ('Indonesia'), ('Ireland'), ('Israel'), " +
                    "('Isle of Man'), ('India'), ('British Indian Ocean Territory'), ('Iraq'), ('Iran'), ('Iceland'), " +
                    "('Italy'), ('Jersey'), ('Jamaica'), ('Jordan'), ('Japan'), ('Kenya'), ('Kyrgyz Republic (Kyrgyzstan)'), " +
                    "('Cambodia, Kingdom of'), ('Kiribati'), ('Comoros'), ('Saint Kitts & Nevis Anguilla'), " +
                    "('North Korea'), ('South Korea'), ('Kuwait'), ('Cayman Islands'), ('Kazakhstan'), ('Laos'), " +
                    "('Lebanon'), ('Saint Lucia'), ('Liechtenstein'), ('Sri Lanka'), ('Liberia'), ('Lesotho'), " +
                    "('Lithuania'), ('Luxembourg'), ('Latvia'), ('Libya'), ('Morocco'), ('Monaco'), ('Moldavia'), " +
                    "('Montenegro'), ('Saint Martin (French part)'), ('Madagascar'), ('Marshall Islands'), " +
                    "('Macedonia, the former Yugoslav Republic of'), ('Mali'), ('Myanmar'), ('Mongolia'), " +
                    "('Macau'), ('Northern Mariana Islands'), ('Martinique (French)'), ('Mauritania'), ('Montserrat'), " +
                    "('Malta'), ('Mauritius'), ('Maldives'), ('Malawi'), ('Mexico'), ('Malaysia'), ('Mozambique'), " +
                    "('Namibia'), ('New Caledonia (French)'), ('Niger'), ('Norfolk Island'), ('Nigeria'), ('Nicaragua'), " +
                    "('Netherlands'), ('Norway'), ('Nepal'), ('Nauru'), ('Neutral Zone'), ('Niue'), ('New Zealand'), " +
                    "('Oman'), ('Panama'), ('Peru'), ('Polynesia (French)'), ('Papua New Guinea'), ('Philippines'), " +
                    "('Pakistan'), ('Poland'), ('Saint Pierre and Miquelon'), ('Pitcairn Island'), ('Puerto Rico'), " +
                    "('Palestinian Territory, Occupied'), ('Portugal'), ('Palau'), ('Paraguay'), ('Qatar'), " +
                    "('Reunion (French)'), ('Romania'), ('Serbia'), ('Russian Federation'), ('Rwanda'), ('Saudi Arabia'), " +
                    "('Solomon Islands'), ('Seychelles'), ('Sudan'), ('Sweden'), ('Singapore'), ('Saint Helena'), " +
                    "('Slovenia'), ('Svalbard and Jan Mayen Islands'), ('Slovakia'), ('Sierra Leone'), ('San Marino'), " +
                    "('Senegal'), ('Somalia'), ('Suriname'), ('South Sudan'), ('Saint Tome (Sao Tome) and Principe'), " +
                    "('El Salvador'), ('Sint Maarten (Dutch part)'), ('Syria'), ('Swaziland'), ('Turks and Caicos Islands'), " +
                    "('Chad'), ('French Southern Territories'), ('Togo'), ('Thailand'), ('Tajikistan'), ('Tokelau'), " +
                    "('Turkmenistan'), ('Tunisia'), ('Tonga'), ('East Timor'), ('Turkey'), ('Trinidad and Tobago'), " +
                    "('Tuvalu'), ('Taiwan'), ('Tanzania'), ('Ukraine'), ('Uganda'), ('United Kingdom'), " +
                    "('USA Minor Outlying Islands'), ('United States'), ('Uruguay'), ('Uzbekistan'), " +
                    "('Holy See (Vatican City State)'), ('Saint Vincent & Grenadines'), ('Venezuela'), " +
                    "('Virgin Islands (British)'), ('Virgin Islands (USA)'), ('Vietnam'), ('Vanuatu'), " +
                    "('Wallis and Futuna Islands'), ('Samoa'), ('Yemen'), ('Mayotte'), ('Yugoslavia'), " +
                    "('South Africa'), ('Zambia'), ('Zaire'), ('Zimbabwe')";
}
