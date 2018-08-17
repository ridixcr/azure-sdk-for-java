/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.language.luis.runtime.implementation;

import com.microsoft.azure.cognitiveservices.language.luis.runtime.models.ResolveOptionalParameter;
import retrofit2.Retrofit;
import com.microsoft.azure.cognitiveservices.language.luis.runtime.Predictions;
import com.google.common.base.Joiner;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.cognitiveservices.language.luis.runtime.models.APIErrorException;
import com.microsoft.azure.cognitiveservices.language.luis.runtime.models.LuisResult;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Predictions.
 */
public class PredictionsImpl implements Predictions {
    /** The Retrofit service to perform REST calls. */
    private PredictionsService service;
    /** The service client containing this operation class. */
    private LuisRuntimeAPIImpl client;

    /**
     * Initializes an instance of PredictionsImpl.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public PredictionsImpl(Retrofit retrofit, LuisRuntimeAPIImpl client) {
        this.service = retrofit.create(PredictionsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Predictions to be
     * used by Retrofit to perform actually REST calls.
     */
    interface PredictionsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.cognitiveservices.language.luis.runtime.Predictions resolve" })
        @POST("apps/{appId}")
        Observable<Response<ResponseBody>> resolve(@Path("appId") String appId, @Body String query, @Query("timezoneOffset") Double timezoneOffset, @Query("verbose") Boolean verbose, @Query("staging") Boolean staging, @Query("spellCheck") Boolean spellCheck, @Query("bing-spell-check-subscription-key") String bingSpellCheckSubscriptionKey, @Query("log") Boolean log, @Header("accept-language") String acceptLanguage, @Header("x-ms-parameterized-host") String parameterizedHost, @Header("User-Agent") String userAgent);

    }


    /**
     * Gets predictions for a given utterance, in the form of intents and entities. The current maximum query size is 500 characters.
     *
     * @param appId The LUIS application ID (Guid).
     * @param query The utterance to predict.
     * @param resolveOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws APIErrorException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the LuisResult object if successful.
     */
    public LuisResult resolve(String appId, String query, ResolveOptionalParameter resolveOptionalParameter) {
        return resolveWithServiceResponseAsync(appId, query, resolveOptionalParameter).toBlocking().single().body();
    }

    /**
     * Gets predictions for a given utterance, in the form of intents and entities. The current maximum query size is 500 characters.
     *
     * @param appId The LUIS application ID (Guid).
     * @param query The utterance to predict.
     * @param resolveOptionalParameter the object representing the optional parameters to be set before calling this API
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<LuisResult> resolveAsync(String appId, String query, ResolveOptionalParameter resolveOptionalParameter, final ServiceCallback<LuisResult> serviceCallback) {
        return ServiceFuture.fromResponse(resolveWithServiceResponseAsync(appId, query, resolveOptionalParameter), serviceCallback);
    }

    /**
     * Gets predictions for a given utterance, in the form of intents and entities. The current maximum query size is 500 characters.
     *
     * @param appId The LUIS application ID (Guid).
     * @param query The utterance to predict.
     * @param resolveOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LuisResult object
     */
    public Observable<LuisResult> resolveAsync(String appId, String query, ResolveOptionalParameter resolveOptionalParameter) {
        return resolveWithServiceResponseAsync(appId, query, resolveOptionalParameter).map(new Func1<ServiceResponse<LuisResult>, LuisResult>() {
            @Override
            public LuisResult call(ServiceResponse<LuisResult> response) {
                return response.body();
            }
        });
    }

    /**
     * Gets predictions for a given utterance, in the form of intents and entities. The current maximum query size is 500 characters.
     *
     * @param appId The LUIS application ID (Guid).
     * @param query The utterance to predict.
     * @param resolveOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LuisResult object
     */
    public Observable<ServiceResponse<LuisResult>> resolveWithServiceResponseAsync(String appId, String query, ResolveOptionalParameter resolveOptionalParameter) {
        if (this.client.endpoint() == null) {
            throw new IllegalArgumentException("Parameter this.client.endpoint() is required and cannot be null.");
        }
        if (appId == null) {
            throw new IllegalArgumentException("Parameter appId is required and cannot be null.");
        }
        if (query == null) {
            throw new IllegalArgumentException("Parameter query is required and cannot be null.");
        }
        final Double timezoneOffset = resolveOptionalParameter != null ? resolveOptionalParameter.timezoneOffset() : null;
        final Boolean verbose = resolveOptionalParameter != null ? resolveOptionalParameter.verbose() : null;
        final Boolean staging = resolveOptionalParameter != null ? resolveOptionalParameter.staging() : null;
        final Boolean spellCheck = resolveOptionalParameter != null ? resolveOptionalParameter.spellCheck() : null;
        final String bingSpellCheckSubscriptionKey = resolveOptionalParameter != null ? resolveOptionalParameter.bingSpellCheckSubscriptionKey() : null;
        final Boolean log = resolveOptionalParameter != null ? resolveOptionalParameter.log() : null;

        return resolveWithServiceResponseAsync(appId, query, timezoneOffset, verbose, staging, spellCheck, bingSpellCheckSubscriptionKey, log);
    }

    /**
     * Gets predictions for a given utterance, in the form of intents and entities. The current maximum query size is 500 characters.
     *
     * @param appId The LUIS application ID (Guid).
     * @param query The utterance to predict.
     * @param timezoneOffset The timezone offset for the location of the request.
     * @param verbose If true, return all intents instead of just the top scoring intent.
     * @param staging Use the staging endpoint slot.
     * @param spellCheck Enable spell checking.
     * @param bingSpellCheckSubscriptionKey The subscription key to use when enabling bing spell check
     * @param log Log query (default is true)
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LuisResult object
     */
    public Observable<ServiceResponse<LuisResult>> resolveWithServiceResponseAsync(String appId, String query, Double timezoneOffset, Boolean verbose, Boolean staging, Boolean spellCheck, String bingSpellCheckSubscriptionKey, Boolean log) {
        if (this.client.endpoint() == null) {
            throw new IllegalArgumentException("Parameter this.client.endpoint() is required and cannot be null.");
        }
        if (appId == null) {
            throw new IllegalArgumentException("Parameter appId is required and cannot be null.");
        }
        if (query == null) {
            throw new IllegalArgumentException("Parameter query is required and cannot be null.");
        }
        String parameterizedHost = Joiner.on(", ").join("{endpoint}", this.client.endpoint());
        return service.resolve(appId, query, timezoneOffset, verbose, staging, spellCheck, bingSpellCheckSubscriptionKey, log, this.client.acceptLanguage(), parameterizedHost, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<LuisResult>>>() {
                @Override
                public Observable<ServiceResponse<LuisResult>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<LuisResult> clientResponse = resolveDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<LuisResult> resolveDelegate(Response<ResponseBody> response) throws APIErrorException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<LuisResult, APIErrorException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<LuisResult>() { }.getType())
                .registerError(APIErrorException.class)
                .build(response);
    }

    @Override
    public PredictionsResolveParameters resolve() {
        return new PredictionsResolveParameters(this);
    }

    /**
     * Internal class implementing PredictionsResolveDefinition.
     */
    class PredictionsResolveParameters implements PredictionsResolveDefinition {
        private PredictionsImpl parent;
        private String appId;
        private String query;
        private Double timezoneOffset;
        private Boolean verbose;
        private Boolean staging;
        private Boolean spellCheck;
        private String bingSpellCheckSubscriptionKey;
        private Boolean log;

        /**
         * Constructor.
         * @param parent the parent object.
         */
        PredictionsResolveParameters(PredictionsImpl parent) {
            this.parent = parent;
        }

        @Override
        public PredictionsResolveParameters withAppId(String appId) {
            this.appId = appId;
            return this;
        }

        @Override
        public PredictionsResolveParameters withQuery(String query) {
            this.query = query;
            return this;
        }

        @Override
        public PredictionsResolveParameters withTimezoneOffset(Double timezoneOffset) {
            this.timezoneOffset = timezoneOffset;
            return this;
        }

        @Override
        public PredictionsResolveParameters withVerbose(Boolean verbose) {
            this.verbose = verbose;
            return this;
        }

        @Override
        public PredictionsResolveParameters withStaging(Boolean staging) {
            this.staging = staging;
            return this;
        }

        @Override
        public PredictionsResolveParameters withSpellCheck(Boolean spellCheck) {
            this.spellCheck = spellCheck;
            return this;
        }

        @Override
        public PredictionsResolveParameters withBingSpellCheckSubscriptionKey(String bingSpellCheckSubscriptionKey) {
            this.bingSpellCheckSubscriptionKey = bingSpellCheckSubscriptionKey;
            return this;
        }

        @Override
        public PredictionsResolveParameters withLog(Boolean log) {
            this.log = log;
            return this;
        }

        @Override
        public LuisResult execute() {
        return resolveWithServiceResponseAsync(appId, query, timezoneOffset, verbose, staging, spellCheck, bingSpellCheckSubscriptionKey, log).toBlocking().single().body();
    }

        @Override
        public Observable<LuisResult> executeAsync() {
            return resolveWithServiceResponseAsync(appId, query, timezoneOffset, verbose, staging, spellCheck, bingSpellCheckSubscriptionKey, log).map(new Func1<ServiceResponse<LuisResult>, LuisResult>() {
                @Override
                public LuisResult call(ServiceResponse<LuisResult> response) {
                    return response.body();
                }
            });
        }
    }

}
