public class LookUpResult {

    private boolean httpHasProblem;
    private boolean lookUpHasProblem;

    private String bodyResponse;

    public boolean isSuccess(){ return !httpHasProblem && !lookUpHasProblem; }

    public boolean isHttpHasProblem() { return httpHasProblem; }
    public void setHttpHasProblem(boolean httpHasProblem) { this.httpHasProblem = httpHasProblem; }

    public void setLookUpHasProblem(boolean lookUpHasProblem) { this.lookUpHasProblem = lookUpHasProblem; }
    public boolean isLookUpHasProblem() { return lookUpHasProblem; }

    public String getBodyResponse() { return bodyResponse; }
    public void setBodyResponse(String bodyResponse) { this.bodyResponse = bodyResponse; }

}
