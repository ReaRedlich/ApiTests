package org.tests;

import org.apiManager.ReqresApiFunctions;
import org.apiManager.ReqresEndPoint;
import org.apiManager.requests.createUser.CreateUserRequests;
import org.apiManager.responses.createUser.CreateUserResponse;
import org.apiManager.responses.singleUser.UserData;
import org.apiHelper.ApiClientFactory;
import org.testng.annotations.Test;

public class ReqresTests {
    private final ReqresApiFunctions reqresApiFunctions = new ReqresApiFunctions();
    private final ApiClientFactory client = new ApiClientFactory();
    private final ReqresEndPoint reqresEndPoint = client.ClientBuilder(ReqresEndPoint.class);

    @Test
    public void test_getSingleUser() throws Exception {
        UserData userData = reqresApiFunctions.getSingleUser(reqresEndPoint, 2);
        assert userData.getData().getId() == 2;
    }

    @Test
    public void test_createUser() throws Exception {
        CreateUserRequests createUserRequests = new CreateUserRequests("morpheus", "leader");
        CreateUserResponse response = reqresApiFunctions.createUser(reqresEndPoint, createUserRequests);
        assert response.getJob().equals("leader");
    }
}

