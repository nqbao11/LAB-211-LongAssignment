package Exception;

import java.io.IOException;

public class NotSupportFileType extends IOException{
    private static final long serialVersionUID = 1L;

    public NotSupportFileType(String s){
        super(s);
    }
}