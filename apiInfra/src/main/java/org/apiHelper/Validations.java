package org.apiHelper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import java.io.IOException;
import static java.net.HttpURLConnection.HTTP_OK;

public class Validations {

    /**
     * Validate if status code 200 return
     */
    public Response<ResponseBody> ok(Call<ResponseBody> call) throws IOException {
        return validationResponse(call, HTTP_OK);
    }

    /**
     * Method to validate response - check the response code
     */
    private Response<ResponseBody> validationResponse(Call<ResponseBody> call, int expectedCode) throws IOException {
        Response<ResponseBody> response = call.execute();
        checkCode(response, expectedCode);
        return response;
    }

    /**
     * ethod for checking if return correct response code
     */
    private void checkCode(Response<ResponseBody> response, int expectedCode) {
        int actualCode = response.raw().code();
        System.out.println("Response Code: " + actualCode);
        if(actualCode != expectedCode) {
            throw new RuntimeException(String.format("api " + response.raw().request().url().encodedPath() + " failed, Expected response code %d, Actual code %d", expectedCode, actualCode));
        }
    }
}
