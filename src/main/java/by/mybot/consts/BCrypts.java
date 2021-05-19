package by.mybot.consts;

import org.mindrot.jbcrypt.BCrypt;

public class BCrypts {
    public static final int COUNT_OF_ROUNDS = 12;

    public static String cryptPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(COUNT_OF_ROUNDS));
    }

    public static boolean encryptPassword(String hashed, String password){
        return BCrypt.checkpw(password, hashed);
    }
}
