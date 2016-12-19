package org.firezenk.conceptrouter.sample.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.firezenk.conceptrouter.library.ConceptRouter;
import org.firezenk.conceptrouter.library.Route;
import org.firezenk.conceptrouter.annotations.RoutableActivity;
import org.firezenk.conceptrouter.sample.R;
import org.firezenk.conceptrouter.sample.home.HomeRoute;
//import org.firezenk.conceptrouter.sample.product.ProductViewRoute;
import org.firezenk.conceptrouter.sample.profile.ProfileRoute;

import java.util.Random;

/**
 * Created by Jorge Garrido Oval, aka firezenk on 26/10/16.
 * Project: ConceptRouter
 */
@RoutableActivity({String.class, String.class, Integer.class})
public class DetailActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        final ViewGroup placeholder = (ViewGroup) findViewById(R.id.placeholder);
        final TextView title = (TextView) findViewById(R.id.title);
        final Button nextButton = (Button) findViewById(R.id.next);
        final Button actButton = (Button) findViewById(R.id.act);

        title.setText(getIntent().getStringExtra("string0") + getIntent().getStringExtra("string1") + getIntent().getIntExtra("int2", 0));

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                final Object[] params = new Object[1];
                params[0] = new Random().nextDouble();
                ConceptRouter.get().routeTo(DetailActivity.this, new Route(ProductViewRoute.class, params, placeholder));
            }
        });

        actButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ConceptRouter.get().routeTo(DetailActivity.this, new Route(HomeRoute.class, new Bundle()));
            }
        });

        ConceptRouter.get().routeTo(this, new Route(ProfileRoute.class, new Bundle(), placeholder));
    }

    @Override public void onBackPressed() {
        if (!ConceptRouter.get().back(this))
            super.onBackPressed();
    }
}
