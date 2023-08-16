package org.apiManager;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import com.google.gson.Gson;
import okhttp3.ResponseBody;
import org.apiHelper.ResponseValidations;
import org.apiManager.requests.createUser.CreateUserRequests;
import org.enums.ContentType;
import retrofit2.Call;
import retrofit2.Response;
import java.io.IOException;

public class ReqresApiValidate {
    private final ResponseValidations validations = new ResponseValidations();

    public Response<ResponseBody> getSingleUser(ReqresEndPoint reqresEndPoint, int userId) throws IOException {
        Call<ResponseBody> call = reqresEndPoint.getSingleUser(userId);
        printRequest(call);
        return validations.ok(call);
    }

    public Response<ResponseBody> createUser(ReqresEndPoint reqresEndPoint, CreateUserRequests createUserRequests) throws IOException {
        RequestBody requestBody = createBody(createUserRequests);
        Call<ResponseBody> call = reqresEndPoint.createUser(requestBody);
        printRequest(call);
        return validations.created(call);
    }

    private RequestBody createBody(Object object) {
        return RequestBody.create(MediaType.parse(ContentType.JSON.getContentType()), new Gson().toJson(object));
    }

    private static void printRequest(Call<ResponseBody> call) {
        System.out.println("API REQUEST: [" + call.request().method() + "] " + call.request().url());
    }
}
