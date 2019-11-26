package poli.model;

public class admin {

    private String ADMID;
    private String ADMNAME;
    private String ADMIC;
    private String ADMPHONE;
    private String ADMUSERNAME;
    private String ADMPASSWORD;
    private boolean valid;

    public String getADMID() {
        return ADMID;
    }

    public void setADMID(String ADMID) {
        this.ADMID = ADMID;
    }

    public String getADMNAME() {
        return ADMNAME;
    }

    public void setADMNAME(String ADMNAME) {
        this.ADMNAME = ADMNAME;
    }

    public String getADMIC() { return ADMIC; }

    public void setADMIC(String ADMIC) {
        this.ADMIC = ADMIC;
    }

    public String getADMPHONE() {
        return ADMPHONE;
    }

    public void setADMPHONE(String ADMPHONE) {
        this.ADMPHONE = ADMPHONE;
    }

    public String getADMUSERNAME() {
        return ADMUSERNAME;
    }

    public void setADMUSERNAME(String ADMUSERNAME) {
        this.ADMUSERNAME = ADMUSERNAME;
    }

    public String getADMPASSWORD() {
        return ADMPASSWORD;
    }

    public void setADMPASSWORD(String ADMPASSWORD) {
        this.ADMPASSWORD = ADMPASSWORD;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid (boolean valid) {
        this.valid=valid;
    }
}