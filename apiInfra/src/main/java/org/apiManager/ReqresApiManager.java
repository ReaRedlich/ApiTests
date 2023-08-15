package org.apiManager;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import com.google.gson.Gson;
import okhttp3.ResponseBody;
import org.apiHelper.Validations;
import org.enums.ContentType;
import retrofit2.Call;
import retrofit2.Response;
import java.io.IOException;

public class ReqresApiManager {
    private final Validations validations = new Validations();

    public Response<ResponseBody> getSingleUser(ReqresEndPoint reqresEndPoint, int userId) throws IOException {
        Call<ResponseBody> call = reqresEndPoint.getSingleUser(userId);
        System.out.println("Api: [" + call.request().method() + "] " + call.request().url());
        return validations.ok(call);
    }

    public RequestBody createBody(Object object) {
        return RequestBody.create(MediaType.parse(ContentType.JSON.getContentType()), new Gson().toJson(object));
    }
}
