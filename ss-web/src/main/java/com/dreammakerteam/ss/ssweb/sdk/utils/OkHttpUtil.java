package com.dreammakerteam.ss.ssweb.sdk.utils;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpUtil {


    public static String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = CLIENT.newCall(request).execute()) {
            return response.body() != null ? response.body().string() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static <T> T get(String url, Class<T> clazz) {
        String result = get(url);
        return JacksonUtil.nullSafeParse(result, clazz).orElse(null);
    }

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public static final OkHttpClient CLIENT = new OkHttpClient();
    public static byte[] postFormGetBody(String url, Object obj) {
        System.out.println(url);
        String json = JacksonUtil.toJson(obj);
        System.out.println(json);
        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(url)
                .header("Content-type", "application/json; charset=utf-8")
                .post(body)
                .build();
        try (Response response = CLIENT.newCall(request).execute()) {
            System.out.println(response.body().string());
            return response.body() != null ? response.body().bytes() : null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
