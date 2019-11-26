package poli.model;

public class staff {

    private String STAFFID;
    private String STAFFNAME;
    private String STAFFLASTNAME;
    private String STAFFIC;
    private String STAFFADDRESS;
    private String STAFFPOS;
    private String STAFFDEPT;
    private String STAFFEMAIL;
    private String STAFFPHONE;
    private String STAFFPASSWORD;
    private String REGISTERDATE;
    private String NEWEMAIL;

    private boolean valid;

    public String getSTAFFID() {
        return STAFFID;
    }

    public void setSTAFFID(String STAFFID) {
        this.STAFFID = STAFFID;
    }

    public String getSTAFFNAME() { return STAFFNAME; }

    public void setSTAFFNAME(String STAFFNAME) {
        this.STAFFNAME = STAFFNAME;
    }

    public String getSTAFFLASTNAME() { return STAFFLASTNAME; }

    public void setSTAFFLASTNAME(String STAFFLASTNAME) {
        this.STAFFLASTNAME = STAFFLASTNAME;
    }

    public String getSTAFFIC() { return STAFFIC; }

    public void setSTAFFIC(String STAFFIC) {
        this.STAFFIC = STAFFIC;
    }

    public String getSTAFFADDRESS() {
        return STAFFADDRESS;
    }

    public void setSTAFFADDRESS(String STAFFADDRESS) {
        this.STAFFADDRESS = STAFFADDRESS;
    }

    public String getSTAFFPOS() {
        return STAFFPOS;
    }

    public void setSTAFFPOS(String STAFFPOS) {
        this.STAFFPOS = STAFFPOS;
    }

    public String getSTAFFDEPT() { return STAFFDEPT; }

    public void setSTAFFDEPT(String STAFFDEPT) {
        this.STAFFDEPT = STAFFDEPT;
    }

    public String getSTAFFEMAIL() {
        return STAFFEMAIL;
    }

    public void setSTAFFEMAIL(String STAFFEMAIL) {
        this.STAFFEMAIL = STAFFEMAIL;
    }

    public String getSTAFFPHONE() {
        return STAFFPHONE;
    }

    public void setSTAFFPHONE(String STAFFPHONE) {
        this.STAFFPHONE = STAFFPHONE;
    }

    public String getSTAFFPASSWORD() {
        return STAFFPASSWORD;
    }

    public void setSTAFFPASSWORD(String STAFFPASSWORD) {
        this.STAFFPASSWORD = STAFFPASSWORD;
    }

    public String getNEWEMAIL() {
        return NEWEMAIL;
    }

    public void setNEWEMAIL(String NEWEMAIL) {
        this.NEWEMAIL = NEWEMAIL;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid (boolean valid) {
        this.valid=valid;
    }
}