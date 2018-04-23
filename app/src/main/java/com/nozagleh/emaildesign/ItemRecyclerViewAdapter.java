package com.nozagleh.emaildesign;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.nozagleh.emaildesign.ListFragment.OnListFragmentInteractionListener;
import com.nozagleh.emaildesign.dummy.DummyContent.DummyItem;

import java.net.URL;
import java.util.List;

import io.bloco.faker.Faker;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;
    private View view;

    public ItemRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_mail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.msubjectView.setText(mValues.get(position).details);
        holder.mEmailView.setText(mValues.get(position).id);

        /*Faker faker = new Faker();
        String imgUrl = faker.avatar.image();
        Glide.with(view).asBitmap().load(imgUrl).into(new SimpleTarget<Bitmap>() {

            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                holder.mAvatar.setImageBitmap(resource);
                holder.mAvatar.setScaleType(ImageView.ScaleType.FIT_XY);
            }
        });*/

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mAvatar;
        public final TextView mEmailView;
        public final TextView msubjectView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mAvatar = view.findViewById(R.id.imageView);
            mEmailView = view.findViewById(R.id.email);
            msubjectView = (TextView) view.findViewById(R.id.textView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + msubjectView.getText() + "'";
        }
    }
}
