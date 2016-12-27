package org.firezenk.conceptrouter.sample.profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import org.firezenk.conceptrouter.library.NotEnoughParametersException;
import org.firezenk.conceptrouter.library.ParameterNotFoundException;
import org.firezenk.conceptrouter.library.Routable;

/**
 * Created by Jorge Garrido Oval, aka firezenk on 26/10/16.
 * Project: ConceptRouter
 */
public class ProfileRoute<C extends Context, B extends Bundle> implements Routable<Context, Bundle> {

    @Override public void route(@NonNull Context context, @NonNull Bundle parameters, @Nullable Object viewParent)
            throws ParameterNotFoundException, NotEnoughParametersException {

        if (viewParent == null)
            throw new ParameterNotFoundException("Need a view parent");

        ((ViewGroup) viewParent).removeAllViews();
        ((ViewGroup) viewParent).addView(new ProfileView(context));
    }
}
