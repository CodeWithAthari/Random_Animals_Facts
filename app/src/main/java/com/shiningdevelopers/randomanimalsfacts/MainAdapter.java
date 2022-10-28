package com.shiningdevelopers.randomanimalsfacts;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.shiningdevelopers.randomanimalsfacts.databinding.RvmainBinding;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.security.cert.CertificateException;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.holder> {
    ArrayList<MainModel> list;
    Context context;


    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MainAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new holder(LayoutInflater.from(context).inflate(R.layout.rvmain, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.holder holder, int position) {
        MainModel model = list.get(position);
        RvmainBinding binding = holder.binding;

        binding.rvName.setText(model.getName());
        binding.rvLatinName.setText(model.getLatin_name());
        binding.rvType.setText(model.getAnimal_type());
        binding.rvActiveTime.setText(model.getActive_time());
        binding.rvMinLength.setText(model.getLength_min());
        binding.rvMaxLength.setText(model.getLength_max());
        binding.rvMinWeight.setText(model.getWeight_min());
        binding.rvMaxWeight.setText(model.getWeight_max());
        binding.rvLifeSpan.setText(model.getLifespan());
        binding.rvHabitat.setText(model.getHabitat());
        binding.rvDiet.setText(model.getDiet());
        binding.rvGeoRange.setText(model.getGeo_range());

  loadLogo(model.getImage_link(),binding.imageView);

//        Glide.with(context)
//
//                .load(model.getImage_link())
//                .listener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        log("image","Failed To Load Image "+e);
//
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                        log("image","Done Loading Image");
//
//                        return false;
//                    }
//                })
//                .into(binding.imageView);

log("image",model.getImage_link());
    }
    void log(String tag,String msg){
        Log.d(tag,msg);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        RvmainBinding binding;

        public holder(@NonNull View itemView) {
            super(itemView);
            binding = RvmainBinding.bind(itemView);
        }
    }



    public static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loadLogo(String url, ImageView view) {
        if (url != null && !url.isEmpty()) {
            OkHttpClient picassoClient = getUnsafeOkHttpClient();
            Picasso picasso = new Picasso.Builder(context).downloader(new OkHttp3Downloader(picassoClient)).build();
            picasso.setLoggingEnabled(true);
            picasso.load(url)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(view);
        }
    }


}