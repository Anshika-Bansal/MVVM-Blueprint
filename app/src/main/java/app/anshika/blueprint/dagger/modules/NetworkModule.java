package app.anshika.blueprint.dagger.modules;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import app.anshika.blueprint.BuildConfig;
import app.anshika.blueprint.dagger.scopes.AppScope;
import app.anshika.blueprint.networking.RxErrorHandlingCallAdapterFactory2;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @AppScope
    OkHttpClient provideOkHttpClientInstance(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);
       /* builder.addInterceptor(new AuthenticationInterceptor(context));
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);*/
        return builder.build();
    }


    @Provides
    @AppScope
    Retrofit provideRetrofitInstance(OkHttpClient okHttpClient) {

       /* GsonBuilder gsonBuilder = new GsonBuilder();
        CustomizedObjectTypeAdapter adapter = new CustomizedObjectTypeAdapter();
        Gson gson = gsonBuilder.registerTypeAdapter(Map.class, adapter)
                .registerTypeAdapter(List.class, adapter).setLenient().create();


                */

        //addConverterFactory(GsonConverterFactory.create(gson)).

        Retrofit.Builder builder = new Retrofit.Builder().
                client(okHttpClient).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxErrorHandlingCallAdapterFactory2.create())
                .baseUrl(BuildConfig.BaseUrl);

        return builder.build();
    }

}