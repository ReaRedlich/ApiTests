package org.apiManager;

import org.apiManager.requests.createUser.CreateUserRequests;
import org.apiManager.responses.createUser.CreateUserResponse;
import org.apiManager.responses.singleUser.UserData;
import okhttp3.ResponseBody;
import org.apiHelper.Deserialization;
import retrofit2.Response;
import java.io.IOException;

public class ReqresApiFunctions {
    private final ReqresApiValidate registerApiManager = new ReqresApiValidate();
    private final Deserialization deserialization = new Deserialization();

    public UserData getSingleUser(ReqresEndPoint reqresEndPoint, int userId) throws IOException {
        Response<ResponseBody> okResponse =  registerApiManager.getSingleUser(reqresEndPoint, userId);
        return deserialization.getObject(okResponse, UserData.class);
    }

    public CreateUserResponse createUser(ReqresEndPoint reqresEndPoint, CreateUserRequests createUserRequests) throws IOException {
        Response<ResponseBody> createdResponse =  registerApiManager.createUser(reqresEndPoint, createUserRequests);
        return deserialization.getObject(createdResponse, CreateUserResponse.class);
    }
}
