package com.github.mininalisticclient.app

import android.content.Context
import androidx.startup.Initializer
import com.github.mininalisticclient._di.data.dataModules
import com.github.mininalisticclient._di.domain.domainModules
import com.github.mininalisticclient._di.presenter.presenterModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class AppInitializer: Initializer<Unit> {
    override fun create(context: Context) {
        startKoin {
            androidContext(context)
            val moduleList = ArrayList<Module>()
            moduleList.addAll(dataModules)
            moduleList.addAll(presenterModules)
            moduleList.addAll(domainModules)
            modules(moduleList)
        }
    }

    override fun dependencies() = emptyList<Class<out Initializer<*>>>()

}
