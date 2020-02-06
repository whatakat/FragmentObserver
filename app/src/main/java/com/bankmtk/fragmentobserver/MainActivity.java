package com.bankmtk.fragmentobserver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PublishGetter{
    private Publisher publisher = new Publisher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        MainFragment mainFragment = new MainFragment();

        publisher.subscribe(fragment1);
        publisher.subscribe(fragment2);

        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_main, mainFragment);
        fragmentTransaction.add(R.id.fragment_1, fragment1);
        fragmentTransaction.add(R.id.fragment_2, fragment2);
        fragmentTransaction.commit();
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }
}
