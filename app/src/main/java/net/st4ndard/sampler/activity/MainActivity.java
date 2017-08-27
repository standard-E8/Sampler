package net.st4ndard.sampler.activity;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import net.st4ndard.sampler.R;
import net.st4ndard.sampler.databinding.ActivityMainBinding;
import net.st4ndard.sampler.fragment.PadFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.toolbar.setTitle("熱盛と出てしまいました");
        // DataBindingUtil.bind(binding.navView.getHeaderView(0));

        if (savedInstanceState == null) {
            replaceFragment(PadFragment.newInstance(4,4));
        }

    }

    private void replaceFragment(Fragment fragment) {
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fragment_fade_enter, R.anim.fragment_fade_exit);
        ft.replace(R.id.content_view, fragment, fragment.getClass().getSimpleName());
        ft.addToBackStack(null);
        ft.commit();
    }



}
