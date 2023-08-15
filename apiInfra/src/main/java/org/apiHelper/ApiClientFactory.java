package org.apiHelper;

import okhttp3.OkHttpClient;
import org.enums.BaseUrl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class ApiClientFactory {

    public <T> T ClientBuilder(Class<T> clientClass) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(60, TimeUnit.SECONDS);
        client.readTimeout(60, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .client(client.build())
                .baseUrl(BaseUrl.REQRES_BASE_URL.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clientClass);
    }
}
