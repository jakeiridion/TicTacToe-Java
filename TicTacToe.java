public class TicTacToe{
    enum FIELD{
        X,O,LEER
    }
    
    private FIELD tl,tm,tr,ml,mm,mr,bl,bm,br; 
    
    public TicTacToe(){
        tl = FIELD.LEER; // top-left
        tm = FIELD.LEER; // top-middle
        tr = FIELD.LEER; // top-right
        ml = FIELD.LEER; // middle-left 
        mm = FIELD.LEER; // middle-middle
        mr = FIELD.LEER; // middle-right
        bl = FIELD.LEER; // bottom-left
        bm = FIELD.LEER; // bottom-middle
        br = FIELD.LEER; // bottom-right        
    }
    
    // Returns true if the three parameters are the same. Else returns false.
    private boolean isRowEqual(FIELD f1, FIELD f2, FIELD f3){
        if(f1 == FIELD.X || f1 == FIELD.O){
            if(f1 == f2 && f2 == f3){
                return true;
            }          
        }
        return false;
    }
    
    // Returns enum value depending on passed string.
    private FIELD getValueFromString(String value){
        if(value.equals("X")){
            return FIELD.X;
        }
        else if(value.equals("O")){
            return FIELD.O;
        }
        else{
            return FIELD.LEER;
        }
    }
    
    // Set value of specific field depending on passed string.
    public void setFieldValue(String f, String value){
        if(f == ("tl")){
            tl = getValueFromString(value);
        }
        else if(f.equals("tm")){
            tm = getValueFromString(value);
        }
        else if(f.equals("tr")){
            tr = getValueFromString(value);
        }
        else if(f.equals("ml")){
            ml = getValueFromString(value);
        }
        else if(f.equals("mm")){
            mm = getValueFromString(value);
        }
        else if(f.equals("mr")){
            mr = getValueFromString(value);
        }
        else if(f.equals("bl")){
            bl = getValueFromString(value);
        }
        else if(f.equals("bm")){
            bm = getValueFromString(value);
        }
        else if(f.equals("br")){
            br = getValueFromString(value);
        }
    }
    
    // Returns true if a win is detected.
    public boolean isWin(){
        if(isRowEqual(tl, tm, tr) || isRowEqual(ml, mm, mr) || isRowEqual(bl, bm, br)){
            return true;
        }
        else if(isRowEqual(tl, ml, bl) || isRowEqual(tm, mm, bm) || isRowEqual(tr, mr, br)){
            return true;
        }
        else if(isRowEqual(tl, mm, br) || isRowEqual(tr, mm, bl)){
            return true;
        }
        return false;
    }
    
    // Returns true if a tie is detected.
    public boolean isTie(){
        if(tl != FIELD.LEER && tm != FIELD.LEER && tr != FIELD.LEER
        && ml != FIELD.LEER && mm != FIELD.LEER && mr != FIELD.LEER && bl != FIELD.LEER && 
        bm != FIELD.LEER && br != FIELD.LEER){
            return true;
        }
        return false;
    }
    
    // Resets the field.
    public void reset(){
        tl = FIELD.LEER;
        tm = FIELD.LEER;
        tr = FIELD.LEER;
        ml = FIELD.LEER;
        mm = FIELD.LEER;
        mr = FIELD.LEER;
        bl = FIELD.LEER;
        bm = FIELD.LEER;
        br = FIELD.LEER;
    }
}
