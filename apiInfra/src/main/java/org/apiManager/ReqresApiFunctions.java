package org.apiManager;

import org.apiManager.responses.UserData;
import okhttp3.ResponseBody;
import org.apiHelper.Deserialization;
import retrofit2.Response;
import java.io.IOException;

public class ReqresApiFunctions {
    private final ReqresApiManager registerApiManager = new ReqresApiManager();
    private final Deserialization deserialization = new Deserialization();

    public UserData getSingleUser(ReqresEndPoint reqresEndPoint, int userId) throws IOException {
        Response<ResponseBody> okResponse =  registerApiManager.getSingleUser(reqresEndPoint, userId);
        return deserialization.getObject(okResponse, UserData.class);
    }
}
