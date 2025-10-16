package utils;

public class Utils {

    public static boolean isNull(Object obj){
        return obj == null;
    }

    public static boolean isNotNull(Object obj){
        return obj != null;
    }

    public static boolean validateAndThrow(Object obj, String message){
        if(isNull(obj))
            throw new IllegalArgumentException(message);

        return true;
    }
}
