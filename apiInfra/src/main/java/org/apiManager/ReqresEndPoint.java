package org.apiManager;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

    public interface ReqresEndPoint {

    @GET("api/users/{id}")
    Call<ResponseBody> getSingleUser(@Path("id") int userId);
}
