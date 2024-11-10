package io.renren.common.github.http2.interceptor;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

import java.io.IOException;

/**
 * 响应解压缩拦截器
 *
 * @author zhang.rx
 * @since 2024/4/11
 */
public class ResponseCompressionInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        // 响应头的Content-Encoding中包含gzip，说明响应需要解压
        if ("gzip".equalsIgnoreCase(originalResponse.header("Content-Encoding"))) {
            return originalResponse.newBuilder()
                    .body(gzip(originalResponse))
                    .build();
        }
        return originalResponse;
    }

    private ResponseBody gzip(Response response) throws IOException {
        BufferedSource source = Okio.buffer(new GzipSource(response.body().source()));
        return ResponseBody.create(response.body().contentType(), response.body().contentLength(), source);
    }
}
