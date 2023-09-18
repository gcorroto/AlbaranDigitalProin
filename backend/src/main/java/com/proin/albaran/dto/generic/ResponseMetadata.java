package com.proin.albaran.dto.generic;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMetadata<T,M> {

	private List<M> metadata;

    /**
     * response data.
     */
    private T data;

    /**
     * response success result wrapper.
     *
     * @param <T> type of data class
     * @return response result
     */
    public static <T, M> ResponseMetadata<T, M> success() {
        return success(null, null);
    }

    /**
     * response success result wrapper.
     *
     * @param data response data
     * @param <T>  type of data class
     * @return response result
     */
    public static <T, M> ResponseMetadata<T, M> success(T data, List<M> metas) {
        return ResponseMetadata.<T,M>builder().data(data)
                .metadata(metas)
                .build();
    }
    
    /**
     * response error result wrapper.
     *
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T extends Serializable, M extends Serializable> ResponseMetadata<T,M> fail(String message) {
        return fail(null, message);
    }

    /**
     * response error result wrapper.
     *
     * @param data    response data
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T,M> ResponseMetadata<T,M> fail(T data, String message) {
        return ResponseMetadata.<T,M>builder().data(data)
                // .message(message)
                // .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                // .timestamp(System.currentTimeMillis())
                .build();
    }
}