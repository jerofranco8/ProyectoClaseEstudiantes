package co.edu.uco.crosscuting.util.text;

import static co.edu.uco.crosscuting.util.object.UtilObject.getUtilObject;

public class UtilText {
	public static final String EMPTY ="";
    private UtilText(){
    }
    public boolean isNull(String value){
        return getUtilObject().isNull(value);
    }
    private static String getDefault(String value, String defaultvalue){
        return getUtilObject().getDefault(value,defaultvalue);
    }

    private static UtilText getUtilObject() {
        return UtilText.getUtilObject();
    }

    private static String getDefault(String value){
        return getDefault(value,EMPTY);
    }
    public static String trim(String value){
        return getDefault(value).trim();
    }

}
