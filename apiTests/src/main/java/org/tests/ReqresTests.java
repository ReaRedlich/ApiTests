package org.tests;

import org.apiManager.ReqresApiFunctions;
import org.apiManager.ReqresEndPoint;
import org.apiManager.responses.UserData;
import org.apiHelper.ApiClientFactory;
import org.testng.annotations.Test;

public class ReqresTests {
    private final ReqresApiFunctions reqresApiFunctions = new ReqresApiFunctions();
    private final ApiClientFactory client = new ApiClientFactory();

    @Test
    public void test_happyFlow() throws Exception {
        ReqresEndPoint reqresEndPoint = client.ClientBuilder(ReqresEndPoint.class);
        UserData userData = reqresApiFunctions.getSingleUser(reqresEndPoint, 2);
        assert userData.getData().getId() == 2;
    }
}

