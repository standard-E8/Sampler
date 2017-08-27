package net.st4ndard.sampler;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.st4ndard.sampler.databinding.ListItemBinding;
import net.st4ndard.sampler.model.Pad;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Pad> items;
    private AudioAttributes audioAttributes;
    private SoundPool soundPool;
    private int Sounds;

    public RecyclerAdapter(List<Pad> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // DataBinding
        ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pad pad = items.get(position);

        // データセット
        holder.binding.setPad(pad);

        audioAttributes = new AudioAttributes.Builder()
                // USAGE_MEDIA
                // USAGE_GAME
                .setUsage(AudioAttributes.USAGE_GAME)
                // CONTENT_TYPE_MUSIC
                // CONTENT_TYPE_SPEECH, etc.
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                // ストリーム数に応じて
                .setMaxStreams(16)
                .build();

        // one.wav をロードしておく
        Sounds = soundPool.load(MainApplication.getInstance().getApplicationContext(), R.raw.atsu, 1);

        holder.binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // play(ロードしたID, 左音量, 右音量, 優先度, ループ,再生速度)
                soundPool.play(Sounds, 1.0f, 1.0f, 0, 0, 1);
            }
        });
        holder.binding.button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.v("button", "Longclicked");
                return true;
            }
        });

        // Viewへの反映を即座に行う
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        final ListItemBinding binding;

        private ViewHolder(ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}