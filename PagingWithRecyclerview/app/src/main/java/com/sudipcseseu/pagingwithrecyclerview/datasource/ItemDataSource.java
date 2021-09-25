package com.sudipcseseu.pagingwithrecyclerview.datasource;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.sudipcseseu.pagingwithrecyclerview.RetrofitClient;
import com.sudipcseseu.pagingwithrecyclerview.model.Item;
import com.sudipcseseu.pagingwithrecyclerview.model.StackResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, Item> {

    public static final int PAGE_SIZE = 50;
    private static final int FIRST_PAGE = 1;
    private static final String SITE_NAME = "stackoverflow";

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Item> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getAnswers(FIRST_PAGE, PAGE_SIZE, SITE_NAME)
                .enqueue(new Callback<StackResponse>() {
                    @Override
                    public void onResponse(Call<StackResponse> call, Response<StackResponse> response) {

                        if(response.body() != null){

                            callback.onResult(response.body().getItems(), null, FIRST_PAGE + 1);

                        }

                    }

                    @Override
                    public void onFailure(Call<StackResponse> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getAnswers(params.key, PAGE_SIZE, SITE_NAME)
                .enqueue(new Callback<StackResponse>() {
                    @Override
                    public void onResponse(Call<StackResponse> call, Response<StackResponse> response) {



                        if(response.body() != null){
                            Integer key = (params.key > 1) ? params.key - 1 : null;
                            callback.onResult(response.body().getItems(), key);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackResponse> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getAnswers(params.key, PAGE_SIZE, SITE_NAME)
                .enqueue(new Callback<StackResponse>() {
                    @Override
                    public void onResponse(Call<StackResponse> call, Response<StackResponse> response) {

                        if(response.body() != null){
                            Integer key = response.body().getHasMore() ? params.key + 1 : null;
                            callback.onResult(response.body().getItems(), key);
                        }

                    }

                    @Override
                    public void onFailure(Call<StackResponse> call, Throwable t) {

                    }
                });


    }
}
