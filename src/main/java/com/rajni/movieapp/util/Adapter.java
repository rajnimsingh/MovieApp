package com.rajni.movieapp.util;

public interface Adapter<Source, Target> {

    Target convertFrom(Source source);

}
