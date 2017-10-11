package id.technomotion;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<AlumnusHolder> {
    private ArrayList<Person> alumnus;

    public RecyclerAdapter(ArrayList<Person> mPhotos) {
        this.alumnus = mPhotos;
    }

    @Override
    public AlumnusHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alumni, parent, false);
        return new AlumnusHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(AlumnusHolder holder, int position) {
        Person person = alumnus.get(position);
        holder.bindAlumni(person);
    }

    @Override
    public int getItemCount() {
        return this.alumnus.size();
    }
}