
object Versions {
    const val KOTLIN = "1.5.21"
    const val COMPILE_SDK = 31
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 31
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"
    const val GSON_VERSION = "2.8.7"
    const val LIFE_CYCLE_VERSION = "2.2.0"
    const val CONSTRAINT_LAYOUT = "2.1.3"
    const val LEGACY_SUPPORT = "1.0.0"
    const val ANDROID_GRADLE_VERSION = "4.0.1"
    const val APP_COMPAT_VERSION = "1.4.1"
    const val CORE_KTX = "1.7.0"
    const val ARCH_CORE_TESTING_VER = "2.1.0"
    const val TEST_RUNNER_VER = "1.1.0"
    const val RULES_VER = "1.1.0"
    const val TRUTH_VER = "1.1.0"
    const val JUNIT_EXT_VER = "1.1.3"
    const val MATERIAL_VERSION = "1.5.0"
    const val MOCKITO = "3.11.2"
    const val MOCKITO_CORE = "3.10.0"
    const val MULTIDEX = "2.0.1"
    const val JACOCO = "0.16.0"
    const val HILT = "2.40.4"
    const val HILT_COMPILER = "2.40.4"
    const val FRAGMENT_KTX = "1.4.0"
    const val RETROFIT_VERSION = "2.7.1"
    const val OKHTTP_LOGGING_INTERCEPTOR_VERSION = "3.12.1"
    const val GSON_CONVERTER = "2.9.0"
    const val ESPRESSO = "3.4.0"
    const val TRUTH = "1.1.2"
    const val COROUTINES_TEST = "1.6.0"
    const val TIMBER = "4.7.1"
    const val SP_VERSION = "1.0.6"
    const val RECYCLERVIEW_VERSION = "1.2.1"
    const val COROUTINES_VERSION = "1.6.0"
    const val VIEW_MODEL_VERSION = "2.4.0"
    const val NAVIGATION_VERSION = "2.3.5"
    const val ACTIVITY_KTX = "1.4.0"
    const val GLIDE = "4.12.0"
    const val POWERMOCK = "1.7.4"
    const val MOCKITO_KOTLIN2 = "2.2.0"
    const val MOCKITO_INLINE = "2.23.0"
    const val zoom = "2.0.0"

}

object BuildPlugins {
    const val androidGradle = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_VERSION}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val jacocoPlugin = "com.vanniktech:gradle-android-junit-jacoco-plugin:${Versions.JACOCO}"
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
}

object Android {
    const val minSDK = Versions.MIN_SDK_VERSION
    const val targetSDK = Versions.TARGET_SDK_VERSION
    const val versionCode = Versions.VERSION_CODE
    const val versionName = Versions.VERSION_NAME
    const val compileSDK = Versions.COMPILE_SDK
    const val applicationId = "com.example.task"
}

object Libs {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
    const val gson = "com.google.code.gson:gson:${Versions.GSON_VERSION}"

    const val coreExt = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    const val material = "com.google.android.material:material:${Versions.MATERIAL_VERSION}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.LEGACY_SUPPORT}"
    const val multidex = "androidx.multidex:multidex:${Versions.MULTIDEX}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-compiler:${Versions.HILT_COMPILER}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
    const val debugImplementation = "androidx.fragment:fragment-testing:${Versions.FRAGMENT_KTX}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP_LOGGING_INTERCEPTOR_VERSION}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.GSON_CONVERTER}"

    const val timber = "com.jakewharton.timber:timber:${Versions.TIMBER}"

    const val sdp = "com.intuit.sdp:sdp-android:${Versions.SP_VERSION}"
    const val ssp = "com.intuit.ssp:ssp-android:${Versions.SP_VERSION}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.RECYCLERVIEW_VERSION}"
    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.VIEW_MODEL_VERSION}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.VIEW_MODEL_VERSION}"
    const val lifecycleLivedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFE_CYCLE_VERSION}"
    const val navigationRuntime =
        "androidx.navigation:navigation-runtime-ktx:${Versions.NAVIGATION_VERSION}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_VERSION}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_VERSION}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
/*
    const val zoomImg = "com.github.chrisbanes:PhotoView:${Versions.zoom}"
*/


}


object TestLibs {
    const val junit = "junit:junit:4.+"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    const val googleTruth = "com.google.truth:truth:${Versions.TRUTH}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES_TEST}"
    const val AndroidTruth = "androidx.test.ext:truth:${Versions.TRUTH_VER}"
    const val archCoreTesting = "androidx.arch.core:core-testing:${Versions.ARCH_CORE_TESTING_VER}"
    const val testRunner = "androidx.test:runner:${Versions.TEST_RUNNER_VER}"
    const val rules = "androidx.test:rules:${Versions.RULES_VER}"
    const val junitExt = "androidx.test.ext:junit:${Versions.JUNIT_EXT_VER}"
    const val mockito = "org.mockito:mockito-core:${Versions.MOCKITO}"
    const val powermockCore = "org.powermock:powermock-core:${Versions.POWERMOCK}"
    const val powermockModuleTestng = "org.powermock:powermock-module-testng:${Versions.POWERMOCK}"
    const val powermockApiMockito2= "org.powermock:powermock-api-mockito2:${Versions.POWERMOCK}"
    const val mockitoKotlin2 = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.MOCKITO_KOTLIN2}"
    const val powermockInline = "org.mockito:mockito-inline:${Versions.MOCKITO_INLINE}"
    const val mockitoAndroid = "org.mockito:mockito-android:${Versions.MOCKITO}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.MOCKITO_CORE}"

    // For instrumentation tests
    const val hiltAndroidTest = "com.google.dagger:hilt-android-testing:${Versions.HILT}"
    const val kaptAndroidTest = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
}