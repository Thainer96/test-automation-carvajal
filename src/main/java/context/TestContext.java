package context;

import io.restassured.response.Response;

public class TestContext {

    private String environment;
    private String urlBase;
    private String fullUrlByService;
    private String bodyTransaction;

    private Response responseService;

    public Response getResponseService() {
        return responseService;
    }

    public void setResponseService(Response responseService) {
        this.responseService = responseService;
    }

    public String getBodyTransaction() {
        return bodyTransaction;
    }

    public void setBodyTransaction(String bodyTransaction) {
        this.bodyTransaction = bodyTransaction;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getUrlBase() {
        return urlBase;
    }

    public void setUrlBase(String urlBase) {
        this.urlBase = urlBase;
    }

    public String getFullUrlByService() {
        return fullUrlByService;
    }

    public void setFullUrlByService(String fullUrlByService) {
        this.fullUrlByService = fullUrlByService;
    }



}
