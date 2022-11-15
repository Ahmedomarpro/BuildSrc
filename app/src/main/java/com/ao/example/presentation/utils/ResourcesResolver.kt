package com.ao.example.presentation.utils

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

interface ResourcesResolver {

    fun getString(@StringRes resId: Int) :String
    fun getString(@StringRes resId: Int, vararg formatArgs: Any?) :String

}